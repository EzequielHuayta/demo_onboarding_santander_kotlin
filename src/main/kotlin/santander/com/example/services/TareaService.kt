package santander.com.example.services

import santander.com.example.dto.TareaDTO
import santander.com.example.dto.UsuarioDTO

interface TareaService {

    suspend fun findTareasByUserId(usuarioDTO: UsuarioDTO) : List<TareaDTO>
}