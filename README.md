# CBMapp
### Contact Book Manager Application
Application for managing Contacts in web platform, as well as export/import contacts to/from JSON format file with attributes __Name, Surname, Nickname, Birthday, Company, Emails__ _[Email],_ __Mobiles__ _[PhoneNumber]_...
This project has written in Java Programming Language with Spring framework(Spring boot, Spring security, Spring JPA).

In order to run program in your computer or server, make your setting in application.properties file in the directory `src/main/resources/application.properties`

```
# ===============================
# = DATA SOURCE - local
# ===============================
spring.datasource.url=jdbc:mysql://localhost:3306/<yourdatabasename> 

#If your mysql server has set on remote computer/server
#spring.datasource.url=jdbc:mysql://<ip and port of mysql server>/<yourdatabasename> 

spring.datasource.name = <yourdatabasename>
spring.datasource.username = <mysqlusername>
spring.datasource.password = <password>
spring.datasource.testWhileIdle = true
spring.datasource.validationQuery = SELECT 1

# ===============================
# = JPA / HIBERNATE
# ===============================
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = create
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```

As well as the java file in the path `/src/main/java/kg/apps/CBMapp/controller/UserDataLoader.java` has created for developers in order to test the application. So this file creates first demo users: `username: spring ; password:springspring`, `username:spring2; password:springspring` with some demo contacts. If you are going to install the application for using purpose, you can delete it and disable/delete embadded apache server dependency with `<artifactId>tomcat-embed-jasper</artifactId>` in `pom.xml` maven file if you are going to setup application to your own apche-server. 
