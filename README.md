# Kronslott Project: ObjectMapper configuration
DropWizard bundle to configure the Jackson ObjectMapper

Use this only if you want to make Jackson ObjectMapper settings configurable
in your DropWizard configuration. Otherwise you could just hardcode the values
you want!

From start, there is only one configuration option available, 
writeDatesAsTimestamps. 


## Usage

### example.yml

```yaml
objectMapper:
  writeDatesAsTimestamps: false
```

### example.kt

```kotlin
class ExampleConfig : Configuration(), ObjectMapperConfig {
    @Valid
    @JsonProperty("objectMapper")
    override var objectMapperSettings: ObjectMapperSettings = ObjectMapperSettings()
   
    // ...
}

class ExampleApp : Application<ExampleConfig>() {

    override fun initialize(bootstrap: Bootstrap<ExampleConfig>) {
        bootstrap.addBundle(ObjectMapperBundle<ExampleConfig>())
        // ...
    }
    
    // ...
}    
```

