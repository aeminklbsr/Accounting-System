## Accounting System

### Overview

The Accounting System project aims to digitize and streamline accounting processes for businesses, making them more efficient, secure, and effective. This system allows users to manage customer information, create and track invoices, and record payment transactions.

### Project Purpose

The primary goal of the Accounting System is to enhance the management of accounting tasks by providing a digital platform. This will enable businesses to have better control over their financial processes and make strategic decisions based on accurate data.

### Project Scope

The Accounting System offers a comprehensive platform to manage various accounting tasks such as user registration and login, customer management, invoice creation and tracking, and payment recording. The system aims to digitize accounting processes, thereby improving efficiency and effectiveness in business operations.

### Technologies Used

#### Programming Languages and Frameworks

- **Java**: The core programming language used for the application. Java is a robust and platform-independent language with extensive library support.
- **Spring Boot**: A framework that facilitates the easy and rapid development of Java-based applications. Spring Boot enables the creation of standalone, production-ready Spring applications.

#### Database Management System

- **MySQL**: Used as the database management system for the application. MySQL is a fast, reliable, and scalable system that adheres to SQL standards.

#### Tools and Libraries

- **Maven**: Used for project management and dependency management. Maven helps in compiling, packaging, and managing project dependencies.
- **Postman**: Utilized for testing and validating APIs. Postman allows sending HTTP requests and analyzing responses.
- **IntelliJ IDEA**: The Integrated Development Environment (IDE) used during the development of the application. IntelliJ IDEA offers features that accelerate the coding process.

### Project Structure

#### Controller Layer

- **CustomerController.java**: Manages customer-related operations such as adding, fetching, updating, and deleting customer details.
- **InvoiceController.java**: Handles invoice-related operations including creating, fetching, updating, and deleting invoices.
- **PaymentController.java**: Manages payment-related operations such as adding, fetching, updating, and deleting payment records.
- **UserController.java**: Handles user registration and login operations.

#### Repository Layer

- **CustomerRepository.java**: Manages database operations for customer data.
- **InvoiceRepository.java**: Manages database operations for invoice data.
- **PaymentRepository.java**: Manages database operations for payment data.
- **UserRepository.java**: Manages database operations for user data.

#### Config Layer

- **SecurityConfig.java**: Contains security configurations, including user authentication and authorization, and password encryption using BCrypt.

#### Model Layer

- **Customer.java**: Represents customer data including name, address, email, phone number, and tax number.
- **Invoice.java**: Represents invoice data such as amount, date, description, customer info, and due date.
- **Payment.java**: Represents payment data including amount, date, and related invoice info.
- **User.java**: Represents user data including username and password.

#### Service Layer

- **CustomerService.java**: Performs customer-related operations.
- **InvoiceService.java**: Performs invoice-related operations.
- **PaymentService.java**: Performs payment-related operations.
- **UserService.java**: Manages user-related operations and authentication.

### Functional Requirements

#### User Management

- **User Registration**: Allows users to register by providing a username and password.
- **User Login**: Allows registered users to log in using their credentials.

#### Customer Management

- **Add Customer**: Enables adding new customer details.
- **Update Customer**: Allows updating existing customer details.
- **Delete Customer**: Enables deleting customer records.
- **List Customers**: Provides a list of all registered customers.

#### Invoice Management

- **Create Invoice**: Allows adding new invoice details.
- **Update Invoice**: Enables updating existing invoice details.
- **Delete Invoice**: Allows deleting invoice records.
- **List Invoices**: Provides a list of all created invoices.

#### Payment Management

- **Create Payment**: Allows adding new payment details.
- **Update Payment**: Enables updating existing payment details.
- **Delete Payment**: Allows deleting payment records.
- **List Payments**: Provides a list of all recorded payments.

### Technical Requirements

#### Database Design

- **Entity-Relationship Diagram (ERD)**
  - **User**: Represents system users with attributes such as id, username, and password.
  - **Customer**: Represents customers with attributes like id, name, address, email, phone number, and tax number.
  - **Invoice**: Represents invoices with attributes such as id, amount, date, description, customer_id, due date, and issue date.
  - **Payment**: Represents payments with attributes like id, amount, date, invoice_id, and payment date.

- **Table Definitions and Relationships**
  - **Customer and Invoice**: One-to-many relationship where one customer can have multiple invoices.
  - **Invoice and Payment**: One-to-many relationship where one invoice can have multiple payments.

### Security

- **Authentication**: Verifies user identities during login using username and password combinations. Implemented using Spring Security.
- **Authorization**: Determines user permissions for accessing and performing operations within the system.

### Conclusion and Evaluation

#### Project Success

The Accounting System successfully implements core functionalities such as user registration and login, customer management, invoice management, and payment management. These features were tested using Postman and integrated effectively.

#### Challenges Faced

- **Database Integration**: Establishing and testing database relationships using Hibernate presented challenges.
- **Security**: Implementing secure user authentication and authorization required careful integration of Spring Security.
- **API Testing**: Ensuring correct API endpoint functionality required meticulous testing with Postman.

#### Future Work

- **Website Development**: Developing a user-friendly web interface.
- **Mobile Application**: Creating a mobile app for on-the-go access to accounting functionalities.
- **Reporting and Analysis Tools**: Adding features for financial analysis and reporting.
- **Automation**: Implementing modules for automating invoice and payment processes.

