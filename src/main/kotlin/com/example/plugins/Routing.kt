package com.example.plugins

import com.example.models.Mensaje
import com.example.routes.customerRouting
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        get("/") {
            call.respondText("Ping Pong Activitat ktor")
        }
        post("/ping") {
            val request = call.receive<Mensaje>()
            if (request.mensaje == "ping") {
                call.respond(Mensaje("pong"))
            } else {
                call.respondText("Mensaje no reconocido")
            }
        }
    }
}
