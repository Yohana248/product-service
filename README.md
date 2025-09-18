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

## 📂 Project Structure
```
src/main/java/com/smartinventory/product
 ├── entity/        # JPA entities
 ├── repository/    # Spring Data JPA repositories
```

---

## 📝 Notes
- The database is seeded with sample data from `src/main/resources/data.sql`.
- If you restart the app multiple times, you may want to truncate tables
---