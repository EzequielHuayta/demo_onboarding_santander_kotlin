package santander.com.example.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import santander.com.example.services.RandomUserService

fun Route.randomUserRoutes(randomUserService: RandomUserService) {
    route("/api") {
        get("/amigos") {
            val amigos = randomUserService.obtenerAmigos()
            call.respond(amigos)
        }
    }
}