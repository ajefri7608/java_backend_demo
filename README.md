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


## Installation

Install my-project with npm

```bash
  $ git clone https://github.com/java_backend_demo.git
  $ cd java_backend_demo
  $ mvn clean install
```
