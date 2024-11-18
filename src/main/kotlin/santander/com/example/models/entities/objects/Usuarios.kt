package santander.com.example.models.entities.objects

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import santander.com.example.models.entities.Usuario

object Usuarios : Table<Usuario>("DDS_USUARIOS") {
    val id = int("id").primaryKey().bindTo { it.id }
    val nombre = varchar("nombre").bindTo { it.nombre }
    val apellido = varchar("apellido").bindTo { it.apellido }
    val legajo = varchar("legajo").bindTo { it.legajo }
    val contrasenia = varchar("contrasenia").bindTo { it.contrasenia }
}