package santander.com.example.repository.impl

import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import santander.com.example.models.entities.TareaDetalle
import santander.com.example.models.entities.objects.TareaDetalles
import santander.com.example.models.entities.objects.Tareas
import santander.com.example.repository.TareaRepository

class TareaRepositoryImpl(private val database: Database) : TareaRepository {
    override fun findByUsuarioId(idUsuario: Int): List<TareaDetalle> {
        return database.sequenceOf(TareaDetalles)
            .filter { it.usuarioId eq idUsuario }
            .map { tareaDetalle ->
                tareaDetalle.apply {
                    this.tarea = database.sequenceOf(Tareas).find { it.id eq this.tareaId }!!
                }
            }
    }
}