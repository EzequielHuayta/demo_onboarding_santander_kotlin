package santander.com.example.models.entities.objects

import org.ktorm.schema.Table
import org.ktorm.schema.date
import java.util.Date
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import santander.com.example.models.entities.Tarea

object Tareas : Table<Tarea>("DDS_TAREAS") {
    val id = int("id").primaryKey().bindTo { it.id }
    val descripcion = varchar("descripcion").bindTo { it.descripcion }
    val fecha_fin = date("fecha_fin").bindTo { it.fechaFin }
}