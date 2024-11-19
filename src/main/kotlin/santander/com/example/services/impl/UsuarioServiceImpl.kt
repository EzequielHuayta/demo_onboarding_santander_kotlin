package santander.com.example.services.impl

import santander.com.example.dto.UsuarioDTO
import santander.com.example.exceptions.UsuarioNotFoundException
import santander.com.example.repository.UsuarioRepository
import santander.com.example.services.UsuarioService

class UsuarioServiceImpl(private val usuarioRepository: UsuarioRepository) : UsuarioService {
    override suspend fun autenticarUsuario(usuarioDTO: UsuarioDTO): UsuarioDTO {
        val legajo = usuarioDTO.legajo
        val password = usuarioDTO.contrasenia

        val usuario = usuarioRepository.findByLegajo(legajo)
            ?: throw UsuarioNotFoundException("Usuario no encontrado")

        if (usuario.contrasenia != password) {
            throw UsuarioNotFoundException("Contrasenia incorrecta")
        }

        return UsuarioDTO(
            legajo = usuario.legajo,
            nombre = usuario.nombre,
            apellido = usuario.apellido
        )

    }
}