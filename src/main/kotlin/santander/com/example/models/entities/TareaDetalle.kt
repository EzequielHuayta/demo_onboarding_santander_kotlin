package santander.com.example.models.entities

import org.ktorm.entity.Entity

interface TareaDetalle : Entity<TareaDetalle> {

    val usuarioId: Int
    val tareaId: Int
    val finalizado: Boolean
    var tarea: Tarea
}