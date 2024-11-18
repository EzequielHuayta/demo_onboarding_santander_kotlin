package santander.com.example

import org.ktorm.database.Database

object DatabaseManager {
    private lateinit var database: Database

    fun connect() {
        database = Database.connect(
            url = "jdbc:mysql://localhost:3306/santander",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "admin"
        )
    }

    fun getDatabase(): Database {
        if (!this::database.isInitialized) {
            throw IllegalStateException("La base de datos no fue inicializada")
        }
        return database
    }
}