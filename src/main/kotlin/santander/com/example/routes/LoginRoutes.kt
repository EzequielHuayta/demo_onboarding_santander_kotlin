package santander.com.example.routes


import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory
import santander.com.example.dto.UsuarioDTO
import santander.com.example.dto.response.ResponseDTO
import santander.com.example.services.UsuarioService

fun Route.loginRoutes(usuarioService: UsuarioService) {

    val logger = LoggerFactory.getLogger("LoginRoutes")

    route("/auth") {
        post("/login") {
            val headers = call.request.headers
            val legajo = headers["legajo"]
            val password = headers["password"]

            logger.debug("Llamando al SERVICIO de login - legajo: {}", legajo)

            //Necesario porque sino me tira en legajo y en contrasenia Required: String Found: String?
            if (legajo == null || password == null) {
                val msg = "Falta legajo o contraseña en los headers"
                logger.warn(msg)
                call.respond(HttpStatusCode.BadRequest, msg)
                return@post
            }

            val usuarioDTO = UsuarioDTO.fromLogin(
                legajo = legajo,
                contrasenia = password,
            )

            val data: ResponseDTO<UsuarioDTO> = ResponseDTO(data = usuarioService.autenticarUsuario(usuarioDTO))

            if (data.data != null) {
                logger.info("legajo: {} logueado con éxito", legajo)
                call.respond(HttpStatusCode.OK, data)
            } else {
                logger.warn("legajo: {} usuario no autenticado", legajo)
                call.respond(HttpStatusCode.Unauthorized, data)
            }
        }
    }
}