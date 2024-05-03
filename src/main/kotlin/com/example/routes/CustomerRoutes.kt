package com.example.routes

import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/ping") {
        get {
            if (mensajeGuardado == null) {
                call.respondText("No hay mensaje", status = HttpStatusCode.NotFound)
            } else {
                call.respond(mensajeGuardado!!)
            }
        }

        post {
            val mensaje = call.receive<Mensaje>()
            if (mensaje.mensaje == "ping") {
                call.respond(Mensaje("pong"))
            } else {
                call.respondText("Mensaje no reconocido", status = HttpStatusCode.BadRequest)
            }
        }
    }
}