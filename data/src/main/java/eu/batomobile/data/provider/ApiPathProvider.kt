package eu.batomobile.data.provider

internal abstract class ApiPathProvider {
    abstract fun getApiPath(): String
}

internal class ProdApiPathProviderImpl : ApiPathProvider() {
    override fun getApiPath() = "https://create.kahoot.it/rest/"
}