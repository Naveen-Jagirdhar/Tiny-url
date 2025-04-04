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

### 1. 📩 `POST /api/v1/short-url`
Shortens a long URL.

#### Request
```json
{
  "longURL": "https://github.com/Naveen-Jagirdhar/book-my-show/tree/master/src/main/java/com/learnings/bookmyshow/enums"
}
```

#### Response
```json
{
    "shortURL": "localhost:8080/api/v1/short-url/nNcQ3Z"
}
```

### 2.`GET /api/v1/short-url/{shortCode}`
Redirects to the original URL.

#### Request
```
localhost:8080/api/v1/short-url/nNcQ3
```
Redirects to
```
https://github.com/Naveen-Jagirdhar/book-my-show/tree/master/src/main/java/com/learnings/bookmyshow/enums
```
