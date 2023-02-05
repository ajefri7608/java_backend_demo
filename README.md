# Spring Boot CRUD Project

This project is a basic implementation of a CRUD (Create, Read, Update, and Delete) application with JWT (JSON Web Token) based authentication and authorization in Spring Boot.


## API Reference

#### Get all items

```http
  GET /api/items
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get item

```http
  GET /api/items/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |


## Quick Start

To get started, follow these steps:

Clone the project

```bash
  git clone https://github.com/ajefri7608/java_backend_demo.git
```

Go to the project directory

```bash
  cd java_backend_demo
```

Build the project using Maven

```bash
  mvn clean install
```

Run the application

```bash
  spring-boot:run "-Dspring-boot.run.jvmArguments= -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -D"
```
