package santander.com.example.services

import santander.com.example.dto.UsuarioDTO

interface UsuarioService {
    suspend fun autenticarUsuario(usuarioDTO: UsuarioDTO): UsuarioDTO
}