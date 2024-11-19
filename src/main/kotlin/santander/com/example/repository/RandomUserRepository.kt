package santander.com.example.repository

import santander.com.example.models.entities.RandomUserResponse.Result
interface RandomUserRepository {
    suspend
    fun fetchRandomUsers(url: String): List<Result>


}