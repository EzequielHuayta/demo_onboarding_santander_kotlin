package santander.com.example.repository.impl

import santander.com.example.models.entities.RandomUserResponse
import santander.com.example.repository.RandomUserRepository
import santander.com.example.models.entities.RandomUserResponse.Result

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class RandomUserRepositoryImpl : RandomUserRepository {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun fetchRandomUsers(url: String): List<Result> {
        val response: RandomUserResponse = client.get(url).body()
        return response.results
    }
}