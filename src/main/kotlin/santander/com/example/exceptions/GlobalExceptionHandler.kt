package santander.com.example.exceptions

import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.http.*
import io.ktor.server.response.*
import org.slf4j.LoggerFactory
import santander.com.example.dto.response.ErrorResponse

fun Application.configureExceptionHandling() {
    val logger = LoggerFactory.getLogger("GlobalExceptionHandler")

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            logger.error("Error de servidor:" + cause.message)

            call.respond(ErrorResponse(message = cause.message, statusCode = HttpStatusCode.InternalServerError.value))
        }

        exception<UsuarioNotFoundException> { call, cause ->
            logger.error(cause.message)
            call.respond(ErrorResponse(message = cause.message, statusCode = HttpStatusCode.NotFound.value))
        }
    }
}