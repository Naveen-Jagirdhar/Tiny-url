# 🔗 Tiny-url

A lightweight, scalable URL shortening service built with **Spring Boot** and **MySQL**, with support for **rate limiting** to protect against abuse.

---
## 📌 Features

- 🔁 Shorten any long URL to a short code
- 🚀 Redirect using short URLs
- ⏳ Set 1-day expiration time for short URLs
- 📊 Track access count
- 🛡️ IP-based Rate Limiting using Bucket4j (10 req/min per IP)
- ☕ Built with Spring Boot + MySQL

---

## 🧱 Tech Stack

| Layer         | Tech                            |
|---------------|----------------------------------|
| Backend       | Spring Boot (Java 17)           |
| Database      | MySQL                           |
| Rate Limiting | Bucket4j                        |
| Build Tool    | Gradle                          |
| CI/CD         | GitHub Actions                  |

---

## 🔧 APIs

### 1. 📩 `POST /shorten`
Shortens a long URL.

#### Request
```json
{
  "longUrl": "https://example.com/my-blog-post"
}
