# Spring boot
- Auto configuration
@EnableAutoConfiguration - included in @SpringbootApplication
- Conditional loading: @ConditionalOnClass, @ConditionalOnBean, @ConditionalOnProperty, @ConditionalOnMissingBean
- Properties: preconfigued default properties for auto-configuration classes.
- Property based configurations:
  - application.properties or application.yml
  - Environment variables
  - Command-line parameters
  - Cloud configuration (config server)
- Bean configuration
  - Add beans to default application class
  - Add beans to separate configuration classes.
  - Import XML-based configurations
 Component scanning
- Profiles:
  - Flex configuration based on environment profile
  - Valuable in real world, multi-environment deployment
- Spring Boot dependencies
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
- Configuring Embedded Tomcat
  - Servlet, filter, listener beans
  - Property based
  - Session based configs (cookies, timeouts..)
  - Compression server.compression.enabled=true
  - TLS
    - Native TLS support via properties
    - Most common embedded servlet change
    - Requrie Java keystore contains the certificate
    - 
    
  