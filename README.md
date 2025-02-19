# Banking System Microservices

## 🏦 Overview
`banking-system-microservices` is a **cloud-native microservices-based banking system** built using **Spring Boot**, **Spring Cloud**, **Docker**, and **Kubernetes**. This project simulates core banking functionalities, such as **customer management, account management, and transaction processing**.

It follows best practices in microservices architecture, including **service discovery, centralized configuration, API gateway, and inter-service communication**.

## 📌 Project Structure
This monorepo contains multiple microservices:

```
banking-system-microservices/
│— accounts-service/   # Manages user accounts & transactions
│— customer-service/   # Handles customer onboarding & details
│— transaction-service/ # Processes deposits, withdrawals & transfers
│— api-gateway/        # Manages routing, authentication, and security
│— config-server/      # Centralized configuration management
│— discovery-server/   # Eureka service registry
│— docker-compose.yml  # Docker setup for local development
│— k8s/                # Kubernetes manifests for cloud deployment
```

## 🚀 Technologies Used
- **Spring Boot 3** (Microservices framework)
- **Spring Cloud** (Eureka, Config Server, API Gateway)
- **Spring Data JPA** (Hibernate ORM)
- **H2 Database** (In-memory development database)
- **PostgreSQL** (Production-ready database)
- **Docker & Docker Compose** (Containerization)
- **Kubernetes (K8s)** (For container orchestration)
- **Feign Client** (Inter-service communication)
- **Resilience4J** (Circuit breaker for fault tolerance)
- **Lombok** (Reduces boilerplate code)

## 📦 Microservices Overview
| Service            | Description |
|--------------------|-------------|
| **Accounts Service** | Manages customer accounts, balances, and transactions. |
| **Customer Service** | Handles customer onboarding, authentication, and profile management. |
| **Transaction Service** | Manages deposits, withdrawals, and fund transfers. |
| **API Gateway** | Handles routing, authentication, and rate-limiting. |
| **Config Server** | Centralized configuration management for all microservices. |
| **Discovery Server** | Eureka-based service discovery mechanism. |

## 🔧 Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/banking-system-microservices.git
cd banking-system-microservices
```

### 2️⃣ Start the Services Locally
Run each microservice individually:
```bash
cd accounts-service && mvn spring-boot:run
cd ../customer-service && mvn spring-boot:run
cd ../transaction-service && mvn spring-boot:run
```

OR run all services using **Docker Compose**:
```bash
docker-compose up --build
```

### 3️⃣ Deploy on Kubernetes
If you have Kubernetes configured (e.g., Minikube, GKE, EKS):
```bash
kubectl apply -f k8s/
```

## 🛠️ API Endpoints
| Service           | Endpoint |
|------------------|----------|
| **Accounts Service** | `http://localhost:8081/api/accounts` |
| **Customer Service** | `http://localhost:8082/api/customers` |
| **Transaction Service** | `http://localhost:8083/api/transactions` |
| **API Gateway** | `http://localhost:8080/api/` |

## 📝 Environment Variables
Create a `.env` file in the root directory:
```ini
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/banking_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=secret
```

## 🔥 Features & Next Steps
👉 Microservices-based **banking architecture**  
👉 Centralized configuration with **Spring Cloud Config**  
👉 Service discovery with **Eureka**  
👉 Secure communication via **API Gateway**  
👉 Scalable deployments using **Docker & Kubernetes**  

🚀 **Next Steps**:  
- Implement **JWT authentication** for security 🔒  
- Add **Kafka for event-driven communication** 📨  
- Deploy in **AWS/GCP Kubernetes clusters** ☁️  

## 📜 License
This project is for educational purposes and follows the Udemy course **"Master Microservices with Spring Boot, Docker, Kubernetes"**.

---

📢 **Need Help?** Open an **issue** or reach out! 🚀  

