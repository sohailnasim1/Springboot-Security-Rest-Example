# Springboot-Security Json Web Token (JWT) example
Contributor: **Sohail Nasim**

This project was developed in [Spring Tool Suite](http://spring.io/tools/sts)

## Database

**H2  Embedded (Local) file based Database**

Schema and 'USERS' table is generated when Springboot application starts

URL: (http://localhost:8888/h2)

DB Name: useradmindb

Username: sa

Password:


## How to run it
1. You need JDK 1.8 to run this project.
2. Make sure you have [Apache Maven](https://maven.apache.org/download.cgi) installed. Add the bin directory to your PATH.
3. Install the [Git Bash](https://git-scm.com/download) and clone the repository
 from Git Bash
 
```
git clone https://github.com/sohailnasim1/Springboot-Security-Rest-Example.git
 
```

 or download the repository zip file and unzip it to local folder.

Run following command to compile and to create the jar file:

```
cd Springboot-Security-Rest-Example
mvn package

```

How to run Springboot microservices locally:

```
java -jar target/UserAdmin-0.0.1-SNAPSHOT.jar
```

## API documentation for Rest service
http://localhost:8888/swagger-ui.html

## Token Generation
The token given in the examples below is valid for 10 years. 

You can also use following project to genererate JWT token

[Springboot-Token-Generation-Example](https://github.com/sohailnasim1/Springboot-Token-Generation-Example)



## Examples

* GET: http://localhost:8888/users

**Header:**

```
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZG9lIiwicm9sZXMiOlsiYWRtaW4iXSwiZXhwIjoxODY3Mjc3Njg5LCJpYXQiOjE1NTE2NTg0ODksImp0aSI6IjEzZmM4NTA2LTc5ZTMtNDhmNi1hZjA1LTBkMmFkNjQyZDNmNSJ9.RQKJa1DqRbRHQq_LAK4jYJGnSZ33_pDQ4KuGAzhQJiu9WGqdZXXHx5A3W1BcveN1LHWl8aAyx0FSf4RO3ByWPg
```

* POST: http://localhost:8888/users

**Header:**

```
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZG9lIiwicm9sZXMiOlsiYWRtaW4iXSwiZXhwIjoxODY3Mjc3Njg5LCJpYXQiOjE1NTE2NTg0ODksImp0aSI6IjEzZmM4NTA2LTc5ZTMtNDhmNi1hZjA1LTBkMmFkNjQyZDNmNSJ9.RQKJa1DqRbRHQq_LAK4jYJGnSZ33_pDQ4KuGAzhQJiu9WGqdZXXHx5A3W1BcveN1LHWl8aAyx0FSf4RO3ByWPg
```

**Request:**

Content-Type: application/json

Body:

```
{
  "username": "jdoe",
  "password": "password",
  "firstName": "John",
  "lastName": "Doe",
   "emailAddress": "jdoe@youremaildomain.com"
}
```

* GET: http://localhost:8888/users/jdoe

**Header:**

```
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZG9lIiwicm9sZXMiOlsiYWRtaW4iXSwiZXhwIjoxODY3Mjc3Njg5LCJpYXQiOjE1NTE2NTg0ODksImp0aSI6IjEzZmM4NTA2LTc5ZTMtNDhmNi1hZjA1LTBkMmFkNjQyZDNmNSJ9.RQKJa1DqRbRHQq_LAK4jYJGnSZ33_pDQ4KuGAzhQJiu9WGqdZXXHx5A3W1BcveN1LHWl8aAyx0FSf4RO3ByWPg
```

**Response:**
	
```
{
    "username": "jdoe",
    "firstName": "John",
    "lastName": "Doe",
    "emailAddress": "jdoe@youremaildomain.com",
    "active": "Y"
}
```

* DELETE: http://localhost:8888/users/jdoe

**Header:**

```
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZG9lIiwicm9sZXMiOlsiYWRtaW4iXSwiZXhwIjoxODY3Mjc3Njg5LCJpYXQiOjE1NTE2NTg0ODksImp0aSI6IjEzZmM4NTA2LTc5ZTMtNDhmNi1hZjA1LTBkMmFkNjQyZDNmNSJ9.RQKJa1DqRbRHQq_LAK4jYJGnSZ33_pDQ4KuGAzhQJiu9WGqdZXXHx5A3W1BcveN1LHWl8aAyx0FSf4RO3ByWPg
```


* PATCH: http://localhost:8888/users/jdoe

**Header:**

```
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZG9lIiwicm9sZXMiOlsiYWRtaW4iXSwiZXhwIjoxODY3Mjc3Njg5LCJpYXQiOjE1NTE2NTg0ODksImp0aSI6IjEzZmM4NTA2LTc5ZTMtNDhmNi1hZjA1LTBkMmFkNjQyZDNmNSJ9.RQKJa1DqRbRHQq_LAK4jYJGnSZ33_pDQ4KuGAzhQJiu9WGqdZXXHx5A3W1BcveN1LHWl8aAyx0FSf4RO3ByWPg
```


**Request:**

Content-Type: application/json

Body:

```
{
  "firstName": "John",
  "lastName": "Doe",
   "emailAddress": "jdoe@youremaildomain.com"
}

```