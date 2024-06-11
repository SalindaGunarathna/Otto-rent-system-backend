#	Vehicle Rent System
My Contribution:  Back-End development
## Overview
The Vehicle Rent System is a real-world application designed to manage the rental of vehicles. This project leverages modern technologies and follows best practices to deliver a robust, scalable, and secure system. The system includes features such as CRUD operations for all entities, data validation, authentication, authorization, notifications, auto-trigger functionality, a search system, and vehicle suggestions.
# Technologies Used
- Spring Boot: Application framework
-	PostgreSQL: Database management
-	JPA (Java Persistence API): Data persistence
-	Spring Security: Security framework
-	Lombok: Java library for boilerplate code reduction
-	JWT (JSON Web Token): Secure token-based authentication
-	Docker: Containerization
-	JUnit: Unit testing framework
-	Jenkins: CI/CD pipeline
-	AWS: Deployment and testing
# Project Features
## Core Features
-	CRUD Operations: Create, read, update, and delete operations for all entities in the system.
-	Data Validation: Ensures the correctness of data throughout the system.
-	Authentication & Authorization: Secures endpoints and manages user roles using JWT tokens.
-	Notification System: Notifies users of important events via email.
-	Auto-Trigger Functionality: Scheduled tasks to trigger notifications for vehicle maintenance, license, and insurance updates.
-	Search System: Allows users to search for vehicles based on various criteria.
-	Vehicle Suggestions: Recommends vehicles based on user preferences and history.
-	SSO (Single Sign-On) System: Enables users to sign in with a single set of credentials.

## Special Features
-	Trigger Functionality:
-	Uses scheduled tasks to monitor vehicle requirements.
-	Sends email notifications for upcoming license renewals, service requirements, and insurance updates 7 days in advance.
-	Notification System:
-	Notifies users and owners about new orders and order status changes.
-	Ensures users receive timely confirmations and updates.
-	Authorization:
-	Custom annotations for securing endpoints.
- JWT tokens for managing user sessions securely.
# Project Architecture
-	Layered Architecture: Separation of concerns with distinct layers for controllers, services, repositories,dto and models .
-	OOP Concepts: Utilizes object-oriented programming principles.
-	SOLID Principles: Ensures code is maintainable and scalable.
-	Design Patterns: Implements the Factory design pattern for object creation.

# Development Process
-	Agile Methodology: Iterative development with regular feedback and continuous improvement.
-	Project Management: Managed using Jira.
-	Version Control: Code is maintained in a GitHub repository.
## Unit Testing
-	JUnit: Comprehensive unit tests to ensure code reliability and correctness.
# Containerization & Deployment(developing) - Current state
-	Docker: Application is containerized for consistent environments across development and production.
-	CI/CD Pipeline: Jenkins is used to automate the deployment process.
-	AWS: The system is tested and deployed on AWS for scalability and reliability

# Getting Started
## Prerequisites
-	Java 11 or higher
-	Docker
-	PostgreSQL
-	Maven
