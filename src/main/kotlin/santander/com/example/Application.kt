package santander.com.example

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.plugin.Koin
import santander.com.example.di.appModule
import santander.com.example.exceptions.configureExceptionHandling

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseManager.connect()

    install(Koin) {
        modules(appModule)
    }
    configureSerialization()
    configureRouting()
    configureExceptionHandling()

}
