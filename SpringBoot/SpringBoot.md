# Spring Boot basic
 ## Auto configuration
 - @EnableAutoConfiguration - included in @SpringbootApplication
   - Allow for configuration classes to be scanned dynamically
   - Often based off JARs loaded on class path
   - Driven of sprint.factories
   - @AutoConfigureBefore, @AutoConfigureAfter 
 - Conditional loading
   - @ConditionalOnClass
   - @ConditionalOnBean
   - @ConditionalOnProperty
   - @ConditionalOnMissingBean
 - Properties: preconfigued default properties for auto-configuration classes.
## Configuration in Spring Boot
 - Property based configurations:
   - application.properties or application.yml
   - Environment variables
   - Command-line parameters
   - Cloud configuration (config server)
 - Bean configuration
   - Add beans to default application class
   - Add beans to separate configuration classes.
   - Import XML-based configurations
   - Component scanning
## Profiles:
- Flex configuration based on environment profile
- Valuable in real world, multi-environment deployment
## Spring Boot dependencies
- web apps and services are the same
- Both use spring-boot-starter-web
- Default included Tomcat server, can use other app servers if desired
- Default configuration
- JSON marshaller
  - Spring web starter brings Jackson, used for RESTful web services
  - Automatic marshalling/unmarshalling
- Logging
  - SLFJ
  - Built in logger
  - Logback logging
- Spring libraries
  - Spring Boot auto configuration
  - Starters for Tomcat, logging, and Boot
  - Spring libraries include AOP, beans, core, context and others
  - Spring Web, Spring Webmvc
  - SnakeYaml
  - Testing 
## Configuring Embedded Tomcat
- Servlet, filter, listener beans
- Property based
- Session based configs (cookies, timeouts..)
- Compression server.compression.enabled=true
- TLS
  - Native TLS support via properties
  - Most common embedded servlet change
  - Requrie Java keystore contains the certificate
  
# Spring Boot web
# Spring Boot Command Line
  - Simple and effective
    - We don't always need web
    - We just need to do some work
    - Think of admin tasks and batch operations    
# Spring Boot Data
# Spring Boot extra topics
- Spring security
- Spring messaging
- Spring actuator
