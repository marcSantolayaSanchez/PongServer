package com.example.routes

import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/customer") {
        get {
            if (mensajeGuardado == null) {
                call.respondText("No hay mensaje", status = HttpStatusCode.NotFound)
            } else {
                call.respond(mensajeGuardado!!)
            }
        }

        post {
            val mensaje = call.receive<Mensaje>()
            mensajeGuardado = mensaje
            call.respondText("Mensaje stored correctly", status = HttpStatusCode.Created)
        }
    }
}