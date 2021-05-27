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
# Structural Patterns in Spring       
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
   ## The Decorator Pattern
   - Add responsibilities to an object dynamically at runtime
   - Composition instead of inheritance
   - Inherited base classes compose new behavior and responsibility by becoming additive or decorated
   - Allows an object to be open for extension and closed for modification while still adding responsibilities
   - Why?
    - Composition over inheritance
    - Add behavior without code modifications, support non breaking changes
    - Can also remove behavior through encapsulation vid decoration 
  ## The Proxy Pattern
  - Use of a intermediary object in place of a real object
  - Intermediary protects the real object
  - Intermediary controls the instantiation of the real object
  - Intermediary can add behavior to real object
  - Why?
    - Expensive operations needed to be protected and only called when needed
    - Behaviors needs to be added to a method when it is called in specific situations
    - Remote object access
    - Creation strategy
      - Start with an interface
      - Create real object to extend the interface
      - Create proxy object to extend the interface and keep and handle the real object
      - Create the object, add behavior, other protections as needed
# Operational Patterns in Spring
  ## The Repository Pattern
  - Was introduced in Domain-Driven Design by Eric Evans
  - Simple operations of an entity or business object without knowledge of other entities (as in DAO)
  - Under the abstraction, the data access operations are hidden
  - Why?
    - Databases have become the bottleneck 
    - Prevent data access logic from leaking into your business logic
    - Provide layer of abstraction to hide internals
    - Focus on single business objects at a time
  - Creation strategy
    - Start with Repository interface in Spring Data or create your own interface using generics
    - Define common data access methods
    - Apply your business object to a Repository instance, and leverage data access logic under the hood
  ## The Template Pattern
   - Used in Spring for remote system calls
   - Provides common behavior that span across concrete implementations of remote calls
   - Share similar behavior acress remote callss as well through the way the templates are structured
   - JDBC, JMS, REST, and more
   - Common boilerplate operations are hidden in a base class
   - Common flows are captured in overarching algorithms with abstract default methods for the variant code
   - Concrete implementations handle the variant code and extend the base class
   - Why? 
     - Often common code paths lead to code replication, template encourage DRY and reuse
     - Error prone code can be solved once and reused
     - Common task semantics can be templatized to reduce costs of implementing new versions of same pathway
  ## The Model View Controller Pattern
   - Core pattern for all Spring web activity
   - Used for RESTful web services
   - Used for traditional HTML pages
   - Why?
     - Improve developer efficiencies by separating responsibilities 
     - Dynamic and multiple view selection with the same controller/model
     - View can be modified without modification to the business logic
     - Model returns raw data, unformatted, for future consumption
# Other Framework Patterns in Spring
  ## The Observer Pattern
  - ApplicationListener interface observes the ApplicationContext for changes
  - JMS message listener can be looked as an observer
  - An object called subject maintains a list of observers
  - Notification is sent to observer when state change occurs in subject
  - Observer(s) can act on notification if it applies to them or throw it out
  - Why?
    - Reduce coupling in code paths, especially in one-to-many dependency situations
    - Object state changes have downstream effects that need to be decoupled from main flow
    - Need to dynamically register that downstream observers exist
  ## The Command Pattern
  - Often in Runnable instances
  - AbstractCommandController in MVC
  - Provide abstraction layer on request processing scenarios
  - Processing calling actions gets a common interface instead of underlying implementations
  - Allow implementations to be changed without calling code making a change
  - Provides a structured processing layer without tight coupling
  - Why?
    - Reduce coupling during command processing
    - Allows behavior to be added without modifying the calling code
    - Allow multiple implementations of the command to exist without modification to the caller
  ## The Mediator Pattern
  - DispachServlet in Spring MVC
  - Often used as well when setting state of various components at once
  - Why?
    - Reduces the exponential growth of inter-object communication
    - Reduces tight coupling between interacting objects
    - Makes interaction flows between objects more resistant to changes
  ## The Interpreter Pattern
  - Used in Spring: Spring Expression Language 
  - Use cases are limited, most often with user input
  - Input is parsed and converted into specific commands or functions
  - Expressions are deemed terminal or non-terminal to determine future parsing
  - Why? 
    - Provides a way to interpret user input in a variety of formats
    - Prevents the ultimate commands from becoming littered with expression determining logic
    - Context aware interprets can mix and match to call an end result based on situation
           
          
    
  
