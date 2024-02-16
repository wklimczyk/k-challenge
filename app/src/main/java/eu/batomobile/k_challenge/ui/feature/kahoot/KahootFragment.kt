package eu.batomobile.k_challenge.ui.feature.kahoot

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import eu.batomobile.domain.entity.Question
import eu.batomobile.k_challenge.R
import eu.batomobile.k_challenge.databinding.FragmentKahootBinding
import eu.batomobile.k_challenge.databinding.ItemChoiceBinding
import eu.batomobile.k_challenge.ui.feature.base.BaseFragmentWithVM
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class KahootFragment :
    BaseFragmentWithVM<FragmentKahootBinding, KahootViewAction, KahootViewState, KahootViewModel>() {
    override val binding by lazy { FragmentKahootBinding.inflate(layoutInflater) }
    override fun getViewModelClass() = KahootViewModel::class.java
    private val args: KahootFragmentArgs by navArgs()

    private val kahootSharedViewModel: KahootSharedViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val questionIndex = args.questionIndex
        super.onViewCreated(view, savedInstanceState)

        getQuestions()?.get(questionIndex)?.let {
            viewModel.onViewAction(KahootViewAction.Init(it))
        } //else show error

        binding.btnContinue.setOnClickListener {
            if (questionIndex == getQuestionsCount() - 1) {
                binding.btnContinue.isInvisible = true
                //TODO show results
            } else {
                navigateToNextQuestion(questionIndex)
            }
        }
    }

    private fun navigateToNextQuestion(questionIndex: Int) {
        findNavController().navigate(
            KahootFragmentDirections.actionNextQuestion(
                questionIndex + 1
            )
        )
    }

    override fun onState(viewState: KahootViewState) {
        when (viewState) {
            is KahootViewState.Choices -> showChoices(viewState)
            is KahootViewState.Answers -> showAnswers(viewState)
            is KahootViewState.Complete -> showResults(viewState)
        }
    }

    private fun showChoices(viewState: KahootViewState.Choices) {
        initChoices()
        showQuestion(viewState.question)
        val time = TimeUnit.MILLISECONDS.toSeconds(viewState.time).toInt()
        binding.progressbar.initProgressBar(time)
    }

    private fun TextRoundCornerProgressBar.initProgressBar(time: Int) {
        setMax(time)
        setProgress(time)
        setProgressText("$time")
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                for (i in time downTo 0) {
                    if (i == 0) {
                        binding.progressbar.isVisible = false
                        viewModel.onViewAction(KahootViewAction.ChoiceSelected(null))
                    } else {
                        setProgress(i)
                        setProgressText("$i")
                        delay(1000)
                    }
                }
            }
        }

    }

    private fun getQuestions() =
        kahootSharedViewModel.getCurrentKahoot()?.questions

    private fun getQuestionsCount() = getQuestions()?.size ?: 0

    private fun showResults(viewState: KahootViewState.Complete) {
        //TODO("Not yet implemented")
    }

    private fun showAnswers(viewState: KahootViewState.Answers) {
        with(binding) {
            if (viewState.selectedChoice?.correct != true) {
                scoreBar.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red_2))
                scoreBarTitle.text = resources.getString(R.string.fragment_kahoot__answer_wrong)
            }
            scoreBar.isVisible = true
            viewState.question.choices.forEachIndexed { index, choice ->
                when (index) {
                    0 -> choice1
                    1 -> choice2
                    2 -> choice3
                    3 -> choice4
                    else -> null
                }?.let { choiceView ->
                    if (choice.correct) {
                        choiceView.styleAsCorrect()
                    } else {
                        choiceView.styleAsIncorrect(choice == viewState.selectedChoice)
                    }
                }
            }
            progressbar.isVisible = false
            btnContinue.isVisible = true
        }
    }

    private fun initChoices() {
        with(binding) {
            choice1.initStyleForChoice(
                R.drawable.ic_triangle,
                R.color.red_2
            )
            choice2.initStyleForChoice(
                R.drawable.ic_diamond,
                R.color.blue_2
            )
            choice3.initStyleForChoice(
                R.drawable.ic_circle,
                R.color.yellow_3
            )
            choice4.initStyleForChoice(
                R.drawable.ic_square,
                R.color.green_2
            )
        }
    }

    private fun ItemChoiceBinding.initStyleForChoice(
        @DrawableRes drawable: Int,
        @ColorRes color: Int
    ) {
        choiceSymbol.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                drawable
            )
        )
        choiceContainer.setCardBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                color
            )
        )
    }

    private fun ItemChoiceBinding.styleAsIncorrect(wasSelected: Boolean) {
        initStyleForResult(
            R.drawable.wrong,
            if (wasSelected) R.color.red_2 else R.color.pink
        )
    }

    private fun ItemChoiceBinding.styleAsCorrect() {
        initStyleForResult(
            R.drawable.correct,
            R.color.green_3
        )
    }

    private fun ItemChoiceBinding.initStyleForResult(
        @DrawableRes drawable: Int,
        @ColorRes color: Int
    ) {
        root.isClickable = false
        choiceSymbol.isVisible = false
        resultSymbol.isVisible = true
        resultSymbol.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                drawable
            )
        )
        choiceContainer.setCardBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                color
            )
        )
    }

    private fun showQuestion(question: Question?) {
        question ?: return
        //Show some error

        with(binding) {
            questionNumber.text = resources.getString(
                R.string.fragment_kahoot__counter_format,
                args.questionIndex + 1,
                getQuestionsCount()
            )
            showImage(question.image)
            questionText.text = Html.fromHtml(question.question, Html.FROM_HTML_MODE_COMPACT)

            mapOf(
                choice1 to question.choices.getOrNull(0),
                choice2 to question.choices.getOrNull(1),
                choice3 to question.choices.getOrNull(2),
                choice4 to question.choices.getOrNull(3),
            ).let {
                it.forEach { (choiceView, choice) ->
                    choiceView.root.isVisible = choice != null
                    choiceView.choiceText.text = choice?.answer
                    choiceView.root.setOnClickListener {
                        viewModel.onViewAction(KahootViewAction.ChoiceSelected(choice))
                    }
                }
            }
        }
    }

    private fun showImage(imageUrl: String?) {
        Glide.with(this).load(imageUrl).into(binding.questionImage)
    }
}