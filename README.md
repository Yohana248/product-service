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

Got it 👍 — let’s extend your README to include the **Product API Endpoints** section, in the same style you already used for Categories and Suppliers. Since you’ve implemented CRUD plus category/price‑filtered pagination, here’s how it could look:

---

## 📡 Product API Endpoints

Base URL: `/api/v1/products`

| Method | Endpoint                        | Description                                      | Request Body Example                                                                 |
|--------|---------------------------------|--------------------------------------------------|--------------------------------------------------------------------------------------|
| GET    | `/`                             | Get all products (non‑paginated)                 | –                                                                                    |
| GET    | `/{id}`                         | Get product by ID                                | –                                                                                    |
| GET    | `/category/{categoryId}`        | Get products by category with optional price range and pagination | – <br> Example: `/api/v1/products/category/2?minPrice=100&maxPrice=500&page=0&size=10` |
| POST   | `/`                             | Create new product                               | `{ "name": "Laptop", "sku": "SKU123", "price": 1200.00, "description": "Gaming laptop", "categoryId": 2, "supplierId": 1 }` |
| PUT    | `/{id}`                         | Update product by ID                             | `{ "name": "Updated Laptop", "price": 1100.00, "description": "Discounted model" }`  |
| DELETE | `/{id}`                         | Delete product by ID                             | –                                                                                    |

---

### Example Paginated Response
```json
{
  "items": [
    { "id": 1, "name": "Wireless Mouse", "price": 25.99, "categoryId": 2, "supplierId": 1 },
    { "id": 2, "name": "Keyboard", "price": 49.99, "categoryId": 2, "supplierId": 1 }
  ],
  "page": 0,
  "size": 10,
  "totalElements": 42,
  "totalPages": 5,
  "last": false
}
```
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