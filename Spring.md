# Spring overview 
  ## What is Spring?
  - Open source (power of community)
  - Enterprise and internet support
  - Lightweight
  - Unobtrusive
  - Spring in enterprise
    - No need for heavy application servers
    - Provides abstractions for enterprise systems
    - Focus on business logic
  - Dependency managment
    - Spring manages runtime dependencies
    - Configure or create them once and then you are done
  ## Inversion of control
  - Container maintains your class dependencies
  - Object injected at runtime or starup time
  - An object accepts the dependencies contructions instead of constructing them
  - Traditional Dependency Management vs IoC Dependency Management
  - Benefits of dependency injection
    - Reduces noise in your code
    - Reduces object coupling
    - Reduces defects arise from incorrect construction
    - Focus on API contract (allow interface instead of concrete implementation)
# Application Context
  ## Application context overview
  - Acts as the heart of SpringApplication
  - Encapsulate the BeanFactory
  - Provide metadata for bean creation
  - Provide mechanisim for creation of beans in correct order
  - Inversion of control container
    - Provides all the facilities for injection of beans at startup and run time
    - Most of the utilizing Spring, is actually configuring the IoC container
    - BeanFactory handles all singleton beans
  - Multiple application context: A Spring application can have one or more ApplicationContext objects
  - Web container always have multiple
  - Parent context can interact with childrent but not the otheway around.
  ## Configuration of Spring with Java
  - Java based config
    - Native language syntax
    - Compile time checking of configuration
    - Easier IDE integration
  ## Environment
  - Populated by default by environment variables
  - Supplement with properties file, among other things
  - Powerful construct with cloud native and traditional applications
  ## Profiles
  ## Spring Expression Language
  ## Bean scopes
  - Singletons
    - The default scope of every bean is singleton
    - One instance per context definition
    - Be careful with state data
  - Prototype
    - New instinace everytime it is referenced
    - Definition is stored in IoC, instances are not
    - Very useful for transient data or types that flex based on application state
  - Session
    - Applies to web environment only
    - One instance of bean per user session
    - Definition is stored in IoC, instance is not
  - Reequest
    - Applies to web environment only
    - One instance per request
    - Definition is stored in IoC, instance is not
  ## Proxies
  - Everything is s proxy
    - Since Spring 4.0
    - Proxies add behaviour to your class
    - Spring uses JDK and CGLib based proxies
  - Consideration
    - Behaviir added to classes only impacted by call through proxy
    - Private methods (don't get exposed via proxy)
    - Interal call (don't get proxy behavior)
    - Source of bugs transactional rollbacks
# Component Scanning
  ## @Component
  - Indicates that a class should be loaded into the BeanFactory
  - @Component and stereotype
  - Component scanning scans a base package and loads configuration automatically for each bean it finds
  ## DI with component scanning
  - Dependency injection is achieved through the @Autowire annotation
  - @Qualifier is used when multiple implementations of an interfaced are needed
  - Properties injected with @Value
  ## Starting Component Scanning
  - Requires a Java or XML configuration
  - Base package is defined in this configuration
  - Scanning occurs during startup
  ## Lifecycle methods
  - Using Spring during startup/ shutdown
    - Spring proxies not always available
    - Construction phase
    - Destruction phase
  - Post Construction
    - @PostConstruct
    - Called after property setting
  - Pre Destroy
    - @PreDestroy
    - Executed when ApplicationContext closes
# The Bean Lifecycle
  
 
  
     
    
  
