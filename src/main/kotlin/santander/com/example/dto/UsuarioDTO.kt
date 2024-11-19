package santander.com.example.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class UsuarioDTO (
    val nombre: String = "",
    val apellido: String = "",
    @Transient val contrasenia: String = "",
    val legajo: String,
    val id: Int = 0
) {
    companion object {
        fun fromLogin(legajo: String, contrasenia: String): UsuarioDTO {
            return UsuarioDTO(
                legajo = legajo,
                contrasenia = contrasenia
            )
        }

        fun fromTarea(legajo: String): UsuarioDTO {
            return UsuarioDTO(
                legajo = legajo
            )
        }
    }
}