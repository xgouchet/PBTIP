package fr.androidmakers.workshop

class RemoteDataSource(
    val requestHandler: RequestHandler,
) {

    fun logIn(
        email: String,
        password: String,
    ): Result<Boolean> {
        TODO()
    }
}