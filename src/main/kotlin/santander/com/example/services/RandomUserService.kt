package santander.com.example.services

import santander.com.example.models.entities.RandomUserResponse.Result
interface RandomUserService {


    suspend fun obtenerAmigos(): List<Result>

}