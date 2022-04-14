package fr.androidmakers.workshop

enum class Method {
    GET, POST
}

data class Request(
    val method: Method,
    val url: String,
    val headers: Map<String, String>,
    val body: String?,
)

data class Response(
    val status: Int,
    val headers: Map<String, String>,
    val body: String?,
)

interface RequestHandler {
    fun handleRequest(request: Request): Response
}