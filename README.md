# product-service

A microservice for managing products, categories, and suppliers in the Smart Inventory system.

---

## 🚀 Prerequisites
Make sure you have installed:
- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- [PostgreSQL 14+](https://www.postgresql.org/)

---

## ⚙️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/Yohana248/product-service.git
cd product-service
```

### 2. Configure the database
- Create a PostgreSQL database:
  ```sql
  CREATE DATABASE productsdb;
  ```
- Update `src/main/resources/application.yml` with your DB credentials:
  ```yaml
  spring:
    datasource:
      url: jdbc:postgresql://localhost:5432/productsdb
      username: postgres
      password: yourpassword
  ```

### 3. Build the project
```bash
mvn clean package
```

### 4. Run the service
```bash
mvn spring-boot:run
```
or
```bash
java -jar target/product-service-0.0.1-SNAPSHOT.jar
```

---

## 📡 Category API Endpoints

Base URL: `/api/v1/categories`

| Method | Endpoint          | Description              | Request Body Example |
|--------|------------------|--------------------------|----------------------|
| GET    | `/`              | Get all categories       | – |
| GET    | `/{id}`          | Get category by ID       | – |
| POST   | `/`              | Create new category      | `{ "name": "Books" }` |
| PUT    | `/{id}`          | Update category by ID    | `{ "name": "Updated Books" }` |
| DELETE | `/{id}`          | Delete category by ID    | – |

---

## 📡 Supplier API Endpoints

Base URL: `/api/v1/suppliers`

| Method | Endpoint          | Description           | Request Body Example                                         |
|--------|------------------|-----------------------|--------------------------------------------------------------|
| GET    | `/`              | Get all suppliers     | –                                                            |
| GET    | `/{id}`          | Get supplier by ID    | –                                                            |
| POST   | `/`              | Create new supplier   | `{ "name": "supplier1", "email": "s1@gmail.com" }`           |
| PUT    | `/{id}`          | Update supplier by ID | `{ "email": "supplier1@gmail.com", "phone": "01234567890" }` |
| DELETE | `/{id}`          | Delete supplier by ID | –                                                            |

---

## 📂 Project Structure
```
src/main/java/com/smartinventory/product
 ├── entity/        # JPA entities
 ├── dto/           # Request/response DTOs
 ├── repository/    # Spring Data JPA repositories
 ├── service/       # Business logic
 └── controller/    # REST controllers
```

---

## 📝 Notes
- The database is seeded with sample data from `src/main/resources/data.sql`.
- If you restart the app multiple times, you may want to truncate tables
---