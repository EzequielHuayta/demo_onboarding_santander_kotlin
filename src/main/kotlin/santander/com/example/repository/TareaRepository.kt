package santander.com.example.repository

import santander.com.example.models.entities.TareaDetalle

interface TareaRepository {

    fun findByUsuarioId (idUsuario : Int): List<TareaDetalle>
}