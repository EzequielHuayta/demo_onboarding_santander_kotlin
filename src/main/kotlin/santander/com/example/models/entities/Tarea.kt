package santander.com.example.models.entities

import org.ktorm.entity.Entity
import java.time.LocalDate
import java.util.*

interface Tarea: Entity<Tarea> {
    val id: Int
    val descripcion: String
    val fechaFin: LocalDate?
    val tareaDetalles: Set<TareaDetalle>


}
