package santander.com.example.models.entities

import org.ktorm.entity.Entity

interface Usuario : Entity<Usuario> {
    val id: Int
    val nombre: String
    val apellido: String
    val legajo: String
    val contrasenia: String
}