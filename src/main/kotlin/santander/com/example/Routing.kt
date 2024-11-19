package santander.com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import santander.com.example.repository.RandomUserRepository
import santander.com.example.repository.impl.RandomUserRepositoryImpl
import santander.com.example.routes.randomUserRoutes
import santander.com.example.services.RandomUserService
import santander.com.example.services.impl.RandomUserServiceImpl

fun Application.configureRouting() {

    val randomUserRepository = RandomUserRepositoryImpl()
    val randomUserService = RandomUserServiceImpl(randomUserRepository)


    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        randomUserRoutes(randomUserService)
    }
}
