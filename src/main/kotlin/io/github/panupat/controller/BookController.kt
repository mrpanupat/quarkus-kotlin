package io.github.panupat.controller

import io.github.panupat.model.Book
import jakarta.validation.Valid
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/book")
class BookController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun hello(@Valid request: Book.Request): Book.Response {
        return Book.Response(
            id = request.id,
            name = "This is a book",
            bananaName = "Monkey"
        )
    }
}