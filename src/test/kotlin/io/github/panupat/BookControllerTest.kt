package io.github.panupat

import io.github.panupat.model.Book
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class BookControllerTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .contentType(ContentType.JSON)
            .body(Book.Request(id = 1))
            .`when`().post("/book")
            .then()
            .statusCode(200)
            .body(`is`("""{"id":1,"name":"This is a book","banana_name":"Monkey"}"""))
    }

}