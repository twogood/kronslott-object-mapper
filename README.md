*Project Kronslott*
# DropWizard ObjectMapper configuration
DropWizard bundle to configure the Jackson ObjectMapper

Use this only if you want to make Jackson ObjectMapper settings configurable
in your DropWizard configuration. Otherwise you could just hardcode the values
you want!

From start, there is only one configuration option available: 
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

## Adding this library to your project

This project is not yet available from Maven Central Repository, but it's 
available via
[JitPack.io](https://jitpack.io/#twogood/kronslott-object-mapper).
