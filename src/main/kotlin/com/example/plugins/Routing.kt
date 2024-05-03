package com.example.plugins

import com.example.models.Mensaje
import com.example.routes.customerRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        customerRouting()
        get("/") {
            call.respondText("Hello World!")
        }
    }

    val customerStorage = mutableListOf<Mensaje>()
}
