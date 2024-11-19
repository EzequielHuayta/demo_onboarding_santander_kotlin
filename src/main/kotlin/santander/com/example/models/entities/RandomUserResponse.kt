package santander.com.example.models.entities

import kotlinx.serialization.Serializable

@Serializable
data class RandomUserResponse(
    val results: List<Result>
) {
    @Serializable
    data class Result(
        val name: Name,
        val email: String
    )

    @Serializable
    data class Name(
        val title: String,
        val first: String,
        val last: String
    )
}