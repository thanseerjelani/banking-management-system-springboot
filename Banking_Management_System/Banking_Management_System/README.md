# 🏦 Banking Management System

A backend application built using **Spring Boot** that simulates core banking operations such as managing customers, accounts, branches, loans, cards, and ATM services.

---

## 🚀 Tech Stack

| Technology | Purpose |
|---|---|
| Java 24 | Core Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | Data Access |
| Hibernate | ORM |
| PostgreSQL | Database |
| Maven | Build Tool |
| Swagger (OpenAPI) | API Documentation |
| Postman | API Testing |

---

## 🧩 Architecture

This project follows a clean **layered architecture**:

```
Controller → Service → DAO → Repository → Database
```

| Layer | Responsibility |
|---|---|
| **Controller** | Handles REST API requests |
| **Service** | Contains business logic |
| **DAO** | Handles persistence operations |
| **Repository** | Uses JPA for database interaction |
| **Entity** | Maps Java classes to database tables |

---

## 🗂️ Features

- ✅ Customer Management
- ✅ Account Management
- ✅ Bank & Branch Management
- ✅ ATM Management
- ✅ Loan Management
- ✅ Card Management
- ✅ Employee & Manager Handling
- ✅ Relationship Mapping between entities

---

## 🔗 Entity Relationships

```
Bank ──────────── Branch     (@OneToMany)
Bank ──────────── ATM        (@OneToMany)
Bank ──────────── Manager    (@OneToOne)
Branch ─────────── Customer  (@OneToMany)
Customer ────────── Account  (@OneToMany)
Customer ────────── Loan     (@OneToMany)
Customer ────────── Card     (@OneToMany)
```

---

## ⚙️ Database

- **PostgreSQL** is used as the primary database
- **Hibernate** automatically generates tables using JPA annotations
- Configure connection in `src/main/resources/application.properties`

---

## 📌 API Endpoints

### 🏦 Account
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/saveAccount` | Create a new account |
| `GET` | `/fetchAccountById` | Fetch account by ID |
| `GET` | `/fetchAllAccounts` | Fetch all accounts |
| `PUT` | `/updateAccountById` | Update account by ID |
| `DELETE` | `/deleteAccountById` | Delete account by ID |

### 👤 Customer
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/saveCustomer` | Create a new customer |
| `GET` | `/fetchCustomerById` | Fetch customer by ID |
| `PUT` | `/addExistingAccountToExistingCustomer` | Link existing account to customer |
| `PUT` | `/addNewAccountToExistingCustomer` | Add new account to customer |

### 🏢 Bank
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/saveBank` | Create a new bank |
| `PUT` | `/addExistingBranchToExistingBank` | Link existing branch to bank |
| `PUT` | `/addNewBranchToExistingBank` | Add new branch to bank |

> Similar CRUD endpoints are available for: **Address**, **ATM**, **Branch**, **Card**, **Loan**, **Employee**, **Manager**, and **Owner**.

---

## 🧪 API Testing

All APIs were tested using **Postman**.

### Example — Create Customer

**Request:**
```json
{
  "customerName": "Amit",
  "customerPhone": 9999999999,
  "customerEmail": "amit@gmail.com",
  "customerAge": 28,
  "customerGender": "Male"
}
```

**Response:**
```json
{
  "statusCode": 200,
  "message": "Success",
  "data": {
    "customerId": 1,
    "customerName": "Amit",
    "customerEmail": "amit@gmail.com"
  }
}
```

---

## 📦 Standard Response Structure

All API responses follow a consistent format:

```json
{
  "statusCode": 200,
  "message": "Success",
  "data": {}
}
```

---

## ⚠️ Exception Handling

- Implemented using `@RestControllerAdvice`
- Handles all exceptions **globally**
- Returns **consistent error responses** across all endpoints

---

## 🔥 Key Highlights

- ⚡ Used **JPA with Hibernate** for ORM
- 🏗️ Implemented clean **layered architecture**
- 🔗 Managed entity relationships using **JPA annotations**
- 🛠️ **Automatic table generation** via Hibernate
- 📐 Clean and consistent **API response structure**
- 🛡️ **Global exception handling** with `@RestControllerAdvice`

---

## ▶️ How to Run

### Prerequisites
- Java 24
- Maven
- PostgreSQL running locally

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/thanseerjelani/banking-management-system-springboot.git
   cd banking-management-system-springboot
   ```

2. **Configure PostgreSQL** in `src/main/resources/application.properties`
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/banking_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

---

## 📷 Swagger UI

Once the application is running, access the API documentation at:

```
http://localhost:8080/swagger-ui.html
```

---

## 👨‍💻 Author

**Thanseer Jelani**

[![Email](https://img.shields.io/badge/Email-thanseerjelani%40gmail.com-red?style=flat&logo=gmail)](mailto:thanseerjelani@gmail.com)
[![GitHub](https://img.shields.io/badge/GitHub-thanseerjelani-black?style=flat&logo=github)](https://github.com/thanseerjelani)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-thanseer--jelani-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/thanseer-jelani-520768255/)

---

> ⭐ If you found this project helpful, consider giving it a star on [GitHub](https://github.com/thanseerjelani/banking-management-system-springboot)!