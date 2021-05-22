# Spring Security
  ## Security layers
    - Hardware and media
    - Network
    - Operating system
    - Applications (Where spring comes to play)
    - Spring security:
      	- Provide J2EE application security services
      	- Designed for enterprise applications and internet-facing applications
	- Provide authentication and authorization
  ## Authentication
  	- Determination of who. If a principal is who they say they are
  	- Principal can be humans or machines
  	- Support
	  - HTTP basic, digest, x509, form-based authentication
	  - LDAP and Active directory
	  - OpenID, Jasig CAS (Central Authentication Service), JAAS
	  - Kerberos and SAML
  ## Authorization
    	- Determine what the principal can or cannot do
	  - Authorization is based on authentication
	  - Authorization is often call accessc control
	  - Support: 
	  	- Web request based
	  	- Method invocation
	  	- Domain object instance access control
  ## Spring Security project
    	- spring-security-core
  	- spring-security-config
  	- spring-security-web
  	- spring-security-test
  	- spring-security-ldap
  	- spring-security-oauth2-core
  	- spring-security-oauth2-client
  	- spring-security-openid
  	- spring-security-oauth2-jose
  	- spring-security-remoting
  	- spring-security-cas
  	- spring-security-acl
  ## Password rules: 
    - Never store plaintext
    - Never encrypt
    - SHA-256 is considered crackable
    - bcrypt it the best option today
  
