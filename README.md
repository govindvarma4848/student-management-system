# 🎓 Student Management System

A full-stack Java web application that performs Student CRUD (Create, Read, Update, Delete) operations with Login Authentication using JSP, Servlets, JDBC, MySQL, Apache Tomcat, Docker, Railway MySQL, and Render deployment.

---

## 🚀 Live Demo

🔗 https://student-management-system-7y4q.onrender.com

---

## ✨ Features

- 🔐 User Login Authentication
- ➕ Add Student
- 📋 View Student Details
- ✏️ Update Student
- 🗑 Delete Student
- ☁️ Cloud MySQL Database (Railway)
- 🌐 Online Deployment using Render
- 🐳 Dockerized Application

---

## 🛠 Technologies Used

- Java
- JSP
- Servlets
- JDBC
- MySQL
- Apache Tomcat 9
- Eclipse IDE
- Git & GitHub
- Railway MySQL
- Docker
- Render

---

## 📂 Project Structure

```
studentmanagement/
│
├── src/
│   └── com.myapp/
│       ├── DBConnection.java
│       ├── LoginValidator.java
│       ├── AddStudent.java
│       ├── UpdateStudent.java
│       └── DeleteStudent.java
│
├── WebContent/
│   ├── Login.jsp
│   ├── home.jsp
│   ├── students.jsp
│   ├── addstudent.jsp
│   ├── updatestudent.jsp
│   ├── deletestudent.jsp
│   └── WEB-INF/
│
├── database/
│   ├── studentdb_users.sql
│   └── studentdb_students.sql
│
├── Dockerfile
└── README.md
```

---

## 🗄 Database Tables

### Users Table

| Username | Password |
|----------|----------|
| admin | admin123 |

---

### Students Table

| ID | Name | Gmail | Branch |
|----|------|--------|--------|
|101|Devara|devara@gmail.com|AIML|
|102|Gopi|gopi@gmail.com|CSE|

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/govindvarma4848/student-management-system.git
```

Open the project in Eclipse.

Configure Apache Tomcat Server.

Import the SQL files into MySQL.

Update database credentials in `DBConnection.java`.

Run the project.

---

## ☁️ Deployment

### Application

- Render

### Database

- Railway MySQL

---

## 📸 Screenshots

### Login Page

- User Login Authentication

### Home Page

- Student Management Dashboard

### Student Details

- View All Students

### Add Student

- Insert New Student

### Update Student

- Modify Existing Student

### Delete Student

- Remove Student

---

## 📌 Future Improvements

- Spring Boot
- Hibernate / JPA
- REST APIs
- Bootstrap UI
- Role-Based Authentication
- Pagination
- Search Students
- Email Notifications

---

## 👨‍💻 Author

**Govind Varma**

GitHub:
https://github.com/govindvarma4848

---

## ⭐ If you like this project

Give this repository a ⭐ on GitHub.

---

## 📄 License

This project is developed for educational and learning purposes.
