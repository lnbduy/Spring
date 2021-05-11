# Spring boot
- Auto configuration
@EnableAutoConfiguration - included in @SpringbootApplication
- Conditional loading: @ConditionalOnClass, @ConditionalOnBean, @ConditionalOnProperty, @ConditionalOnMissingBean
- Properties: preconfigued default properties for auto-configuration classes.
- Property based configurations:
 application.properties or applicatio.yml
 Environment variables
 Command-line parameters
 Cloud configuration (config server)
- Bean configuration
 Add beans to default application class
 Add beans to separate configuration classes.
 Impor XML-based configurations
 Component scanning
- Profiles:
 Flex configuration based on environment profile
 Valuable in real world, multi-environment deployment
