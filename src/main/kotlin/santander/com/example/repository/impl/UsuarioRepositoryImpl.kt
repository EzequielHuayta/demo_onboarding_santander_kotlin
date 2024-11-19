package santander.com.example.repository.impl

import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import santander.com.example.models.entities.Usuario
import santander.com.example.models.entities.objects.Usuarios
import santander.com.example.repository.UsuarioRepository

class UsuarioRepositoryImpl(private val database: Database) : UsuarioRepository {
    override fun findByLegajo(legajo: String): Usuario? {
        return database.sequenceOf(Usuarios).find { it.legajo eq legajo }
    }
}