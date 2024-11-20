package santander.com.example.models.entities.objects

import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import santander.com.example.models.entities.TareaDetalle
import santander.com.example.models.entities.Usuario
import santander.com.example.models.entities.Tarea

object TareaDetalles : Table<TareaDetalle>("tarea_detalle") {
    val usuarioId = int("usuario_id").primaryKey().bindTo { it.usuarioId }
    val tareaId = int("tarea_id").primaryKey().bindTo { it.tareaId }
    val finalizado = boolean("finalizado").bindTo { it.finalizado }
}