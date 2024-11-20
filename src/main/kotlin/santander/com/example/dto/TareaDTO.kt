package santander.com.example.dto

import kotlinx.serialization.Serializable
import kotlinx.datetime.LocalDate


@Serializable
data class TareaDTO(

    val descripcion: String,
    val finalizado: Boolean,
    val fechaFin: LocalDate?

)