package santander.com.example.services.impl

import santander.com.example.models.entities.RandomUserResponse
import santander.com.example.repository.RandomUserRepository
import santander.com.example.services.RandomUserService

class RandomUserServiceImpl(private val randomUserRepository: RandomUserRepository) : RandomUserService {


    override suspend fun obtenerAmigos(): List<RandomUserResponse.Result> {
        val url = "https://randomuser.me/api/?results=2&inc=name,email&nat=es"
        val response = randomUserRepository.fetchRandomUsers(url)
        return response
    }
}