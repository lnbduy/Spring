# Design Patterns and Spring
  ## Design Pattern
  - What are Design Patterns?
  - Gang of Four
    - Creational patterns
        - They create objects for you
        - Abstract Factory and Factory
        - Builder
        - Singleton and Prototype
    - Behavioral patterns
        - Command, Interpreter, Mediator, Iterator, Observer
        - Chain of Responsibility and Visitor
        - Memento, State, Strategy, Template
    - Structural patterns
        - Focus on object composition and interfaces
        - Adapter, Bridge, Composite
        - Decorator and Flyweight
        - Facade and Proxy    
  ## Patterns in Spring
  - Inversion of Control (IoC) pattern
    - This is the big one
    - The entire runtime of the framework is based on IoC
    - Improves testability, decreases coupling, enforces coding to an interface
  - Proxy pattern
    - Since 4.0, involved in every object managed by Spring
    - Brings some major caveats to the operation of Spring
    - Allows addition of behaviors that we leverage throughout the framework
  - Factory pattern
    - IoC container is a factory
    - Heavily leveraged in startup and runtime operation of Spring
    - First class support for factories in your code 
  - Singleton and Prototype patterns
    - Most of your objects configured for Spring leverage these two patterns
    - Singleton is most popular
    - Not a traditional singleton implementation but works the same
  - Template pattern
    - Used widely in remote calls
    - JDBC and REST are the most popular situations
    - Also implemented by third parties to remove boilerplate code for using their tooling
  - Model-View-Controller pattern
    - Entire web framework is based on this
    - Traditional web pages as well as RESTful services
    - Not a classic pattern, but very important in Spring
  ## Inversion of Control
  - What is IoC? 
    - Not a Gang of Four design pattern
    - Architectural pattern for relegating control of dependencies to the container instead of the developer
    - Often called Dependency Injection, though that is one flavor of IoC
  - How does it work?
    - Central container constructs and maintains all object references
    - Hands them to other objects when needed at runtime (or startup)
    - Centralized control and management (for all objects at runtime)     
  - IoC in Spring
    - Spring manages your dependencies
    - Objects injected at runtime, not compile time
    - An object accepts the dependencies for construction instead of you constructing them
  - Benefits of IoC
    - Reduces noise in your code
    - Reduces object coupling 
    - Reduces defects that arise from incorrect construction
  - ApplicationContext
    - Spring: ApplicationContext is the IoC container
    - Another pattern : BeanFactory
    - Leverage the configuration to create the beans and manage dependency injection        
# Creational Patterns in Spring
  ## The Factory Pattern
  - BeanFactory
  - FactoryBean
  - Leveraged heavily in the framework
  ## The Builder Pattern
  - Each method returns the object reference it's called from
  - Build method returns a fully constructed method
  - Functionality can be combined into one class
  - Why? 
    - Useful when object creation has many parameters
    - Become increasingly more useful when soem or all parameters are optional
    - Can make code easier to read because of reduced lines of construction when compared with setters
  ## The Singleton Pattern
  - Every bean by default is a singleton
  - Not a classic singleton, but behaves the same
  - Beans must be thread safe
  - Class stores reference to instance of itself
  - Constructor is private
  - Static getInstance() method returns the reference of self instance, or if not constructed it construct in thread safe manner
  - The new command is never called on the class outside of the getInstance() method
  - Why use this pattern:
    - Expensive object creation
    - Control concurrency associated shared resources
    - Storing static state for multiple parts of the application
  ## The Prototype pattern
  - Beans marked prototype are treated as such
  - In Spring, the bean configuration is used as prototype
  - New instances are created, not cloned, when needed by runtime
  - Instance is cloned at runtime to give new instances that are not the prototype, but act the same and have the same state
  - In Java, this is usually clone with the Cloneable interface
  - Prototypes are usually deep clones of objects to maintain safety (thread safety eg)
  - Why?
    - Very useful when object creation is expensive, but wrapper needs to be unique
    - Useful with objects that must act thread safe, but need to store state
    - Provide cost saving on object creation
  ## The Adapter Pattern
  - Used often in Spring integration whean dealing with Channel Adapters for communication with different systems
  - Used in internal operations of AspectJ and used during load
  - Two different interfaces share a common operation
  - Adapter is a wrapper class that is created that holds an instance of one interface and implements the other
  - The shared operation of the wrapper interface is implemented to call the shared operation of the wrapped interface
  - Why?
    - Legacy of third party code needs to fit into your code
    - Shared functionality on disparate objects to reduce code
    - Coding to interfaces in routine workflows and leveraging adapters reduces code while improving readability
    
  
        
    
  
