package santander.com.example.dto.response

import kotlinx.serialization.Serializable


@Serializable
data class ErrorResponse (
    val message: String?,
    val statusCode: Int
)