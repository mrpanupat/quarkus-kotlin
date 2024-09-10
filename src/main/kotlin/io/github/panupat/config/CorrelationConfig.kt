package io.github.panupat.config

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.container.ContainerRequestContext
import java.util.UUID
import org.jboss.logging.MDC
import org.jboss.resteasy.reactive.server.ServerRequestFilter


@ApplicationScoped
class CorrelationConfig {

    @Inject
    @field:Default
    lateinit var appConfig: AppConfig

    @ServerRequestFilter(priority = Int.MIN_VALUE, preMatching = true)
    fun preMatchingFilter(requestContext: ContainerRequestContext) {
        val correlationId =
            requestContext.headers["X-Correlation-Id"]?.first() ?: generateCorrelationId(appConfig.prefix)
        MDC.put("X-Correlation-Id", correlationId)
    }

    private fun generateCorrelationId(prefix: String?): String {
        return (prefix?.let { "$it-" } ?: "") + UUID.randomUUID().toString().replace("-", "")
    }

}