package io.github.panupat.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.NotNull

class Book {

    data class Request(
        @field:NotNull
        val id: Long? = null
    )

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class Response(
        val id: Long? = null,
        val name: String? = null,
        val bananaName: String? = null
    )
}