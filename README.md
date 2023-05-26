# hicham_regoug_bcj18exz

## School Management API

School Management RESTful API using spring boot secured using JWT token and Spring security.

## Resources
* The offciel guide of spring: https://docs.spring.io/
* Using java-jwt library for token manegement: https://github.com/auth0/java-jwt
* Source code of previous experience projects.

## Endpoints

### URL

http://localhost:8089

### Registration of new user

`POST /users/register`

    {
    "username":"test",
    "password": "123456",
    "email": "test@gmail.com",
    "role": "ROLE_STUDENT"
    }

### Response

    HTTP/1.1 200 OK
    Date: Thu, 26 May 2023 12:36:30 GMT
    Status: 200 OK

    {
    "username": "test",
    "email": "test@gmail.com",
    "role": "ROLE_STUDENT"
}

### Login / get jwt token

`POST /users/login`

    {
    "username": "test",
    "password": "123456"
    }

### Response

    HTTP/1.1 200 OK
    Date: Thu, 26 May 2023 12:36:30 GMT
    Status: 200 OK
    Jwt-Token: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9...

    {
    "username": "test",
    "email": "test@gmail.com",
    "role": "ROLE_STUDENT"
    }

### Search students by classroom name / teacher name:

`GET /classrooms/students?filter=classroomName`

Authorization: Bearer your_token


### Response

    HTTP/1.1 200 OK
    Date: Thu, 26 May 2023 12:36:30 GMT
    Status: 200 OK

    "content": [
    {
    "id": 1,
    "firstName": "test",
    "lastName": "test"
    }
    ]
