package se.activout.kronslott.objectmapper

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.dropwizard.ConfiguredBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

data class ObjectMapperSettings(val writeDatesAsTimestamps: Boolean = false)


interface ObjectMapperConfig {
    var objectMapperSettings: ObjectMapperSettings
}


class ObjectMapperBundle<C : ObjectMapperConfig> : ConfiguredBundle<C> {
    override fun initialize(bootstrap: Bootstrap<*>) {
        // deliberately empty
    }

    override fun run(configuration: C, environment: Environment) {
        val settings = configuration.objectMapperSettings
        environment.objectMapper.apply {
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, settings.writeDatesAsTimestamps);
            registerModule(KotlinModule())
        }
    }
}