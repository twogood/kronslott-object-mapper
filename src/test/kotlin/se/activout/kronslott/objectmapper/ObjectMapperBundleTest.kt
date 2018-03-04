package se.activout.kronslott.objectmapper

import com.example.mockito.MockitoExtension
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.dropwizard.Configuration
import io.dropwizard.setup.Environment
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock

class TestConfiguration() : Configuration(), ObjectMapperConfig {
    override var objectMapperSettings: ObjectMapperSettings = ObjectMapperSettings()
}

@ExtendWith(MockitoExtension::class)
class ObjectMapperBundleTest {

    @Mock
    lateinit var objectMapper: ObjectMapper

    @Mock
    lateinit var environment: Environment

    private lateinit var bundle: ObjectMapperBundle<TestConfiguration>

    private lateinit var config: TestConfiguration

    @BeforeEach
    fun before() {
        whenever(environment.objectMapper).thenReturn(objectMapper)

        bundle = ObjectMapperBundle()
        config = TestConfiguration()
    }

    @Test
    fun testWriteDatesAsTimestampsTrue() {
        // given
        config.objectMapperSettings = ObjectMapperSettings(writeDatesAsTimestamps = true)

        // when
        bundle.run(config, environment)

        // then
        verify(environment.objectMapper).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
    }

    @Test
    fun testWriteDatesAsTimestampsFalse() {
        // given
        config.objectMapperSettings = ObjectMapperSettings(writeDatesAsTimestamps = false)

        // when
        bundle.run(config, environment)

        // then
        verify(environment.objectMapper).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    }
}