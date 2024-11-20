package santander.com.example.services.impl

import santander.com.example.dto.TareaDTO
import santander.com.example.dto.UsuarioDTO
import santander.com.example.exceptions.UsuarioNotFoundException
import santander.com.example.repository.TareaRepository
import santander.com.example.repository.UsuarioRepository
import santander.com.example.services.TareaService
import org.slf4j.LoggerFactory
import kotlinx.datetime.toKotlinLocalDate

class TareaServiceImpl(
    private val usuarioRepository: UsuarioRepository,
    private val tareaRepository: TareaRepository
) : TareaService {

    private val logger = LoggerFactory.getLogger(TareaServiceImpl::class.java)


    override suspend fun findTareasByUserId(usuarioDTO: UsuarioDTO): List<TareaDTO> {
        logger.info("Encontrando tareas para el legajo: {}", usuarioDTO.legajo)
        val usuario = usuarioRepository.findByLegajo(usuarioDTO.legajo) ?: throw UsuarioNotFoundException("Usuario no encontrado")

        val tareaDetalles = usuario.let { tareaRepository.findByUsuarioId(it.id) }

        val listTareaDTO = arrayListOf<TareaDTO>()

        tareaDetalles.forEach { tareaDetalle ->
            val tarea = tareaDetalle.tarea
            val tareaDTO = TareaDTO(
                descripcion = tarea.descripcion,
                fechaFin = tarea.fechaFin?.toKotlinLocalDate(),
                finalizado = tareaDetalle.finalizado
            )
            listTareaDTO.add(tareaDTO)
        }

        return listTareaDTO
    }
}