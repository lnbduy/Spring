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
  - Object injected at runtime or startup time
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
  ## Overview
  - The three phases of the lifecycle: Initialization -> Use -> Destruction
  - Initialization
    - Begins with creation of ApplicationContext
    - BeanFactory initialization phase
    - Bean initialization and instantiation
  ## Init phase: loading bean definition
  - Bean definition sources
    - Java configuration
    - XML configuration
    - Component scanning and auto configuraiton
  - Priming the Factory
    - The bean definitions are loaded to the BeanFactory from all sources
    - Id is used to created index for the factory
    - BeanFactory only contains references at this point
  - Phase completed
    - All beans have been loaded into the BeanFactory
    - Beans are just references and metadata at this point
    - No object instantiation of your code has occured
  ## Init: Post-Process Bean Definitions
  - BeanFactory Post-Processor
    - Perform work on the entire BeanFactory
    - Can modify or transform any bean in the factory prior instantiation
    - Most familiar example is the PropertySourcesPlaceHolderConfigurer
  - Phase completed:
    - BeanFactory is loaded dwith references
    - BeanFactory and all beans in it are configured    - 
    - All system level work is completed in Spring at this point
  ## Init: Instantiation Phase
  - Construction:
    - Beans are instantiated in the factory using the constructors
    - Done in the correct order to ensure dependencies are created first
    - Handle to class instance remains in the bean factory for the lifecycle of the application for singletons
    - Eager vs Lazy:
      - By default all beans are instantiated eagerly
      - To truly be lazy, there can be nothing that depends on them
      - Lazy beans can be specified as lazy, but the ApplicationContext reserves the right to ignore
  - Phase completed:
    - Bean pointer is still referenced in BeanFactory
    - Objects have bean constructed
    - Not available for use yet
  ## Init: Setters
  - Post initialization Dependency Injection
    - After all bean have been instantiated
    - Setters are called
    - Autowiring occurs (non-constructor based)
    - JavaConfig behaves differently
  - Phase completed: 
    - Bean are fully initialized
    - All init dependencies are injected
    - Beans still not ready for use
  ## Init: Bean Post Processing
  - Bean Post-Processing
    - Final point of configuration manipulation
    - Each bean may have additional behaviours added
    - Two type of extensible and generic processing: before and after initializer
  - Initializer:
    - Second BeanPostProcessor aciton
    - Special case
    - @PostConstruct methods called here
    - Framwork provides many of these
  - Phase completed:
    - Beans have bean instantiated and initialized
    - Dependencies have bean injected
    - Beans are finally ready to use
  ## Initialization Differences
  - Java configuration
    - Instantiation and setters are merged
    - Each method with @Bean annotation is executed in proper order
  - Auto configuration
    - Instantiation of all bean scanned
    - @Autowires constructors
    - Then during setter injection, autowired setters and fields
  - XML configuration
    - Instantiation of all beans and constructor arg injection
    - Property injection
  ## Use phase
  - Most of the time spent in this phase
  - ApplicationContext serves proxies to the original class
  - ApplicationContext maintains handle to each bean (singleton)
  - Context-aware Beans
    - Spring provides interface ApplicationContextAware
    - Give your class a handle to the ApplicationContext
  ## Destruction phase
  - Begin when close is called on ApplicationContext
  - Any @PreDestroy method is called
  - Beans are not destroyed
  - Caveats
    - Context cannot be reused again
    - Prototype beans are not impacted
    - Only garbage collection actually destroys bean instanaces
 # Aspect Oriented Programming
  ## Common Applications of Aspect
  - Logging
  - Transaction managment (Spring provide @Transactional)
  - Caching
  - Security
  ## Why?
  - Code duplication 
  - Mixing of concerns
  - Maintain application logic
  ## Spring Aspects
  - Leverage AspectJ for aspecting
  - Byte code modification (runtime interweaving)
  - Dynamic proxi-based
  ## Parts of Spring Aspect
  - Join Point (your code)
  - Pointcut (what selects your code)
  - Advice: the code then is applied to the join point when selected by the pointcut
  - Aspect
  ## Pointcut
  - Syntax: 
    - designator ("r p.c.m(arg)")
    - r is return type
    - p is package
    - c is class
    - m is method
    - arg is args 
  - Common designators
    - execution: expression for matching method expression
    - within: expression for matching within certain types
    - target: expression for matching a specific type
    - @annotation expression for matching a specific annotation
  - AOP advices:
    - Before
    - After (Returning, Throwing)
    - Around
    
  
 
  
     
    
  
