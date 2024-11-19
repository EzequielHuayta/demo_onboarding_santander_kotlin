package santander.com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import santander.com.example.routes.randomUserRoutes
import santander.com.example.services.RandomUserService
import santander.com.example.routes.loginRoutes
import santander.com.example.services.UsuarioService

fun Application.configureRouting() {

    val randomUserService: RandomUserService by inject()
    val usuarioService: UsuarioService by inject()

    routing {
        randomUserRoutes(randomUserService)
        loginRoutes(usuarioService)
    }
}
