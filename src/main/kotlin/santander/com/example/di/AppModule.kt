package santander.com.example.di

import org.koin.dsl.module
import org.ktorm.database.Database
import santander.com.example.DatabaseManager
import santander.com.example.repository.RandomUserRepository
import santander.com.example.repository.TareaRepository
import santander.com.example.repository.UsuarioRepository
import santander.com.example.repository.impl.RandomUserRepositoryImpl
import santander.com.example.repository.impl.TareaRepositoryImpl
import santander.com.example.repository.impl.UsuarioRepositoryImpl
import santander.com.example.services.UsuarioService
import santander.com.example.services.RandomUserService
import santander.com.example.services.TareaService
import santander.com.example.services.impl.UsuarioServiceImpl
import santander.com.example.services.impl.RandomUserServiceImpl
import santander.com.example.services.impl.TareaServiceImpl

val appModule = module {
    single<Database> { DatabaseManager.getDatabase() }

    single<RandomUserRepository> { RandomUserRepositoryImpl() }
    single<RandomUserService> { RandomUserServiceImpl(get()) }

    single<UsuarioRepository> { UsuarioRepositoryImpl(get()) }
    single<UsuarioService> { UsuarioServiceImpl(get()) }

    single<TareaRepository> { TareaRepositoryImpl(get()) }
    single<TareaService> { TareaServiceImpl(get(), get()) }
}