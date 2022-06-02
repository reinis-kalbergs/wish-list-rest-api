# Search person RestAPI

REST API that implements a wish-list REST API.

## With the following endpoints

```
localhost:8080/wish-list/add [PUT]
```

```
localhost:8080/wish-list/udpate [PUT]
```

```
localhost:8080/wish-list/delete/{uuid} [DELETE]
```

```
localhost:8080/wish-list/get/{uuid} [GET]
```

```
localhost:8080/wish-list/get/all [GET]
```

As well as an endpoint for combining user list names:

```
localhost:8080/user-api/get-names [GET]
```

## SET-UP

The application can be run in 2 modes:

- with H2 database
- with PostgreSQL

With the default settings application will start with H2 database.

### H2 Database

To start the API with H2 database, you must set the following setting in application.properties to:

```
wishlist.database-used=H2Database
```

When the API is running, you can connect to the database at:

```
localhost:8080/h2-console/
```

With the following settings:

![h2 console](https://user-images.githubusercontent.com/21221917/170947321-92a2d745-2fa7-4f4b-bcb6-f9f14cf7108f.PNG)

### PostgreSQL

To start the API with PostgreSQL database, you must set the following settings in application.properties to:

```
wishlist.database-used=PostgreSQL
```

As well as the following settings have to be configured to use the database of your choice:

```
wishlist.datasource.username
```

```
wishlist.datasource.password
```

```
wishlist.datasource.url
```

## Running

To run the API Java 17 and Maven has to be installed.

```console
mvnw spring-boot:run
```
