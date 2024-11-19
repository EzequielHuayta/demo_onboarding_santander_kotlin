package santander.com.example.repository

import santander.com.example.models.entities.Usuario

interface UsuarioRepository {

    fun findByLegajo(legajo: String): Usuario?

}