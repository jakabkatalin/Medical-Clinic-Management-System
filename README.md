Medical Clinic Management System

Project Overview
This represents my first comprehensive implementation of a Client-Server application using Java and relational databases. The system manages medical clinic operations, including patient registration, doctor scheduling, and medical record persistence. It was designed to transition theoretical Object-Oriented Programming (OOP) concepts into a functional, data-driven software solution.

Technical Milestones
As a junior developer, this project served as a practical application of several advanced concepts:

TCP/IP Networking: Established stable communication between a multi-threaded server and multiple concurrent clients using Java Sockets.

N-Tier Architecture: Organized the codebase into distinct layers (Model, DAO, Service, Server, Client) to ensure clear separation of concerns.

Database Persistence: Integrated a PostgreSQL database via JDBC to replace volatile in-memory storage with persistent data.

Design Patterns & Principles
Singleton Pattern: Implemented in ConexiuneDataBase to manage a single, efficient database connection throughout the application lifecycle.

DAO (Data Access Object) Pattern: Decoupled low-level data access logic from high-level business services for better maintainability.

Multithreading: Utilized a ClientHandler thread for each connection, allowing the server to process multiple requests simultaneously.

OOP Core: Leveraged inheritance (User base class), encapsulation (private attributes with getters/setters), and polymorphism (role-specific logic).

Key Functionalities
Authentication Layer: Secure Login/Register system for Doctors and Patients, including logic to prevent duplicate email registrations.

Role-Based Access Control:

Patients: Can request appointments, view history, and update personal details.

Doctors: Authorized to provide diagnostics, prescribe treatments, and filter daily schedules.

Comprehensive Records: Management of medical histories, including allergies and previous treatments. 

Setup Instructions
1. Ensure a PostgreSQL instance is running and create a database named clinica.

2. Update the connection credentials in ConexiuneDataBase.java.

3. Compile the project using Maven (pom.xml).

4. Launch Server.java to begin listening for clients.

5. Launch Client.java to interact with the system.
