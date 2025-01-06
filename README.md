# MindtreeBank Customer Management System

**MindtreeBank Customer Management System** is a Java-based application that provides a comprehensive solution for managing customer data in a banking context. It demonstrates the implementation of core Java features, JDBC for database interaction, and a multi-tier architecture.

## Features
- **Add Customer**: Register new customers with complete details such as name, city, contact number, occupation, and date of birth.
- **View All Customers**: Retrieve and display the details of all registered customers.
- **Get Customer by ID**: Fetch details of a specific customer using their unique ID.
- **Update Customer**: Modify customer details using their unique ID or other identifiers.
- **Delete Customer**: Remove customer records from the system by ID.

## Project Architecture
- **Business Layer (BO)**: Contains business logic and acts as an intermediary between the DAO and the application interface.
- **Data Access Layer (DAO)**: Handles direct interactions with the database using JDBC.
- **Database Configuration (DBUtil)**: Provides utility methods for establishing database connections.
- **Presentation Layer**: Includes a simple console-based user interface for user input and output.

## Technologies Used
- **Java**: Core programming language.
- **MySQL**: Database for storing customer data.
- **JDBC**: Database connectivity and query execution.
- **Multi-Tier Architecture**: Separation of concerns across BO, DAO, and utility classes.

## Getting Started
1. Clone the repository to your local machine.
2. Import the project into your IDE (e.g., Eclipse or IntelliJ IDEA).
3. Update the database credentials in the `DBUtil` class if necessary.
4. Run the `BankMain` class to interact with the system.
