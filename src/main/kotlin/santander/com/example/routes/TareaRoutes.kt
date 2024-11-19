package santander.com.example.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory
import santander.com.example.dto.TareaDTO
import santander.com.example.dto.UsuarioDTO
import santander.com.example.dto.response.ResponseDTO
import santander.com.example.services.TareaService

fun Route.tareRoutes(tareaService: TareaService) {
    route("/home") {
        get("/tareas") {

            val logger = LoggerFactory.getLogger("LoginRoutes")
            val headers = call.request.headers
            val legajo = headers["legajo"]
            logger.debug("Llamando al SERVICIO de tareas para el legajo {}")

            if (legajo == null) {
                throw IllegalArgumentException("Falta legajo en los headers")
            }

            val usuarioDTO = UsuarioDTO.fromTarea(
                legajo = legajo
            )

            val tareas: List<TareaDTO> = tareaService.findTareasByUserId(usuarioDTO)
            val data: ResponseDTO<List<TareaDTO>> = ResponseDTO(data = tareas)
            
            call.respond(HttpStatusCode.OK, data)
        }
    }
}