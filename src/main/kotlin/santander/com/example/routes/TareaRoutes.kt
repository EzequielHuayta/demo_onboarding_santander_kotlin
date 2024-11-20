package santander.com.example.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory
import santander.com.example.dto.TareaDTO
import santander.com.example.dto.UsuarioDTO
import santander.com.example.dto.response.ResponseDTO
import santander.com.example.services.TareaService

fun Route.tareaRoutes(tareaService: TareaService) {
    route("/home") {
        get("/tarea") {
            val logger = LoggerFactory.getLogger("TareaRoutes")
            val headers = call.request.headers
            val legajo = headers["legajo"]
            logger.debug("Llamando al SERVICIO de tareas para el legajo {}", legajo)

            if (legajo == null) {
                call.respond(HttpStatusCode.BadRequest, "Falta legajo en los headers")
                return@get
            }

            val usuarioDTO = UsuarioDTO.fromTarea(legajo = legajo)
            val tareas: List<TareaDTO> = tareaService.findTareasByUserId(usuarioDTO)
            val data: ResponseDTO<List<TareaDTO>> = ResponseDTO(data = tareas)

            call.respond(HttpStatusCode.OK, data)
        }
    }
}