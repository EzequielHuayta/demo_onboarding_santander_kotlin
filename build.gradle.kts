val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.21"
    id("io.ktor.plugin") version "3.0.1"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.21"
}

group = "santander.com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:3.0.1")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:3.0.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:3.0.1")
    implementation("io.ktor:ktor-server-netty-jvm:3.0.1")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml-jvm:3.0.1")
    testImplementation("io.ktor:ktor-server-test-host-jvm:3.0.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    //CORS
    implementation("io.ktor:ktor-server-cors-jvm:3.0.1")

    // database mysql
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("org.ktorm:ktorm-core:3.4.0")
    implementation("org.ktorm:ktorm-support-mysql:3.4.0")

    // ktor client
    implementation("io.ktor:ktor-client-core-jvm:3.0.1")
    implementation("io.ktor:ktor-client-cio-jvm:3.0.1")
    implementation("io.ktor:ktor-client-json-jvm:3.0.1")
    implementation("io.ktor:ktor-client-serialization-jvm:3.0.1")
    implementation("io.ktor:ktor-client-content-negotiation:3.0.1")


    // Dependency Injection (Koin)
    implementation("io.insert-koin:koin-core:3.3.1")
    implementation("io.insert-koin:koin-ktor:3.3.1")

    //Logging
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("ch.qos.logback:logback-classic:1.4.11")

    //status pages para manejo de errores
    implementation("io.ktor:ktor-server-status-pages:3.0.1")

    //Para serializable date
    implementation("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.5.0")


}