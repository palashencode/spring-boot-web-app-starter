# POC
standalone deployable web application using spring-boot 

# Use Cases
- starter for a quick dockerised web application with login.
- can act as a web UI for any desktop utility.

# Login creds

user - jack
pass - manage
role - user

user - jane
pass - manage
role - admin

# Run
locally within ide 
`mvn spring-boot:run`

create wars:
mvn package

# Docker
docker build --tag=spring-boot-web-starter:latest .

docker run -p8080:8080 spring-boot-web-starter:latest

# API endpoints
http://localhost:8080/status
http://localhost:8080/home
http://localhost:8080/login
http://localhost:8080/dashboard
http://localhost:8080/logout

developer notes : 
a. making jstl to work was a real pain 
- https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/view/JstlView.html
- https://www.codeproject.com/Articles/5249193/Spring-Boot-Web-Application-Development-using-JSTL
- http://www.masterspringboot.com/?view=article&id=120:using-jstl-with-spring-boot-applications&catid=23

