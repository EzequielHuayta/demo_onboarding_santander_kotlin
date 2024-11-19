package santander.com.example.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDTO<T> (
    var data: T? = null
)