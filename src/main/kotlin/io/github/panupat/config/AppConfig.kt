package io.github.panupat.config

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty

@ApplicationScoped
data class AppConfig(
    @ConfigProperty(name = "correlation.prefix")
    val prefix: String?,
)