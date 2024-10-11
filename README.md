# E-Commerce-Console-App
This project simulates a console-based e-commerce platform built using Java. It includes features for admins like product management, inventory management, and access orders, as well as features for customers like product browsing, cart management, and order history.

## Table of Contents

- [Features](#features)
- [Collaboration and Development Process](#collaboration-and-development-process)
- [System Design and Architecture](#system-design-and-architecture)
- [Design Patterns, Code Quality, and Principles](#design-patterns-code-quality-and-principles)
- [Project Structure](#project-structure)
- [Version Control and Collaboration Strategy](#version-control-and-collaboration-strategy)
- [Installation](#installation)
- [Demo](#demo)
- [Authors](#authors)

## Features:
 ##### For Admins: 
- Product Management :
  - Login with email and password.
  - Add product: he is able to link products to their respective categories.
  - Update product information like price, stock, or description.
  - Manage inventory of products.
- View orders : all orders from customers.
##### For Customers: 
- Customer registration and login.
- Product browsing: categories and products.
- Cart Management:
    - Add product to cart
    - modify cart
    - checkout
    - Payment Processing
- Order History

## Collaboration and Development Process:
This project was a collaborative effort between Roqia, and me (Mohamed Khalaf). We worked together from the initial idea generation to determining functional requirements, and features, and implementing the solution. Throughout the project, we solved various challenges, shared feedback, and handled conflicts. We used the Git Flow methodology for version control and collaboration on GitHub.

## System Design and Architecture:
- UML (Class Diagram):
> [!TIP]
> for high-quality diagram here is a pdf file:
[E-Commerce-Console-App3.drawio (2).pdf](https://github.com/user-attachments/files/17340382/E-Commerce-Console-App3.drawio.2.pdf)

  ![E-Commerce-Console-App3 drawio (3)](https://github.com/user-attachments/assets/74e5d7e8-6762-4aa2-89bc-e1b3355c0f85)

## Design Patterns, Code Quality, and Principles: 
 Throughout the development of this project, we focused on writing clean, maintainable, and scalable code by applying **MVC** as architectural pattern and design patterns and adhering to **SOLID principles** and Object-Oriented Programming (OOP) 
 concepts. This approach ensured that our code was easy to extend, modify, and maintain as the project grew.
 - **Design patterns:**
   
     - Factory Method Pattern: We used Factory method pattern to handel the creation of Users based on their role (customer or admin), payment method (credit or depit), controller (admin controller or customer 
       controller) based on the type of the User (customer or admin).
     - Singleton Pattern: The Singleton pattern was applied to manage the ProductService and OrderService to ensure only one instance of these classes exists across the application. This avoided redundant 
       object creation and ensured centralized management of application-wide resources.
- **OOP Concepts:**
  
   We heavily relied on core Object-Oriented Programming (OOP) concepts to ensure maintainability and modularity:
   - Encapsulation: : Data and methods were encapsulated within their respective classes to protect the state of objects and prevent unintended interference.
   - Inheritance: We used inheritance to reuse common functionality, such as inheriting from the base UserModel class for both Customer and Admin , Admin Controller and Customer Controller from the 
   BaseController.
   - Polymorphism: Polymorphism was utilized to allow different payment method types to be handled uniformly through the PaymentMethod interface and different run() function in different controllers called 
   uniformly through BaseController abstract class ...etc .
   - Abstraction: Was utilized by showing the most important context and also polymorphism is a mechanism for abstraction.

 - **Clean Code Practices:**
   
    We followed clean code practices throughout the project, ensuring that the code was easy to read, maintain, and extend. Some of the practices we followed included:
    - Writing descriptive method and variable names.
    - Keeping functions short and focused on a single task.
    - Organizing the code into separate packages based on functionality (e.g., service, model, view, factory, controller).

>[!NOTE]
 Code quality and applying best practices and principles require many iterations of refactoring. It is a great way to apply knowledge later as we learn.

## Project Structure:

```bash
src
└── main
    └── java
        ├── controller     # Contains classes responsible for controlling the flow of the application
        ├── service        # Contains business logic, like customer and product services
        ├── model          # Contains data models (e.g., User, Product, Cart)
        ├── factory        # Implements factory design patterns for object creation
        ├── view           # Handles user interaction, such as CustomerView and AdminView
        ├── payment        # Manages different payment methods and processing
        └── org
            └── example    # Root package containing main application entry point and utilities.
```
## Version Control and Collaboration Strategy:

In this project, we followed the **Git Flow** methodology to manage version control and ensure smooth collaboration. Here's how we organized our branches and workflow:

##### Branching Strategy
- **Main Branch (`main`)**: This branch acts as our production-ready branch. Only stable releases are merged into `main`, ensuring that it always contains the latest production version.
- **Development Branch (`develop`)**: This branch is used for ongoing development. All features, bug fixes, and improvements are merged into `develop` after review, making it the central place for the latest development work.

##### Workflow
1. **Feature Branches**: For each new task, whether it's a feature or a refactor, we created a dedicated branch from `develop`. These branches were named according to the specific task.
2. **Pull Requests and Code Review**: Once a feature was completed, we opened a pull request (PR) to merge the changes into `develop`. All pull requests were reviewed by team members to ensure code quality or any potential issues.
3. **Merging to Develop**: After a successful review and passing all necessary tests, the feature branch was merged into the `develop` branch, ensuring it contained the latest changes.
4. **Release Branches**: When we were ready for a new version of the application, we created a **release branch** from `develop`. This branch was used to prepare for the final version, including any necessary last-minute fixes or improvements.
5. **Merging to Main**: Once everything was finalized in the release branch, we merged it into the `main` branch, marking the release of a new stable version of the application.

##### Versioning and New Features
- **New Features and Refactoring**: Whenever we needed to add a new feature or refactor part of the code, we created a new branch from `develop`. After completing the task, we followed the same process: pull request, code review, and merging back into `develop`.
- **Release and Deployment**: Once enough features or updates were completed, a new release branch was created, tested, and merged into `main`, representing a new version of the application.

This strategy allowed us to work on features in parallel, maintain code quality through reviews, and keep `main` stable for production, while `develop` acted as our main development playground.

## Installation:

To run this Java console application, you'll need to have the **Java Development Kit (JDK)** installed on your machine and set up properly. Follow these steps to install and configure the JDK and run the application.

##### Step 1: Install the JDK
  
1. **Download the JDK**:  
   Visit the official [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://jdk.java.net/) to download the latest version of the JDK for your operating 
   system.
2. **Install the JDK**:  
   - **Windows**:  
     Run the installer and follow the installation prompts. By default, it will install JDK in the `C:\Program Files\Java\jdk-<version>` directory.
3. **Verify the Installation**:  
   After installation, verify that JDK is installed correctly by running the following command in your terminal or command prompt:
   ```bash
   java -version
   ```

##### Step 2: Set Up JDK (Make it Visible to Terminal)

1. **For Windows : Set Environment Variables**:  
   - Go to `Control Panel` → `System` → `Advanced system settings`.
   - Click on `Environment Variables`.
   - Under `System variables`, find the `PATH` variable and click `Edit`.
   - Add the path to the `bin` directory of your JDK installation (e.g., `C:\Program Files\Java\jdk-<version>\bin`).
   - Click OK and restart your terminal.

##### Step 3: Clone the Repository
 
1. **Clone the GitHub Repository**:  
   If you haven't already, clone the repository to your local machine using the following command:
   ```bash
   git clone https://github.com/mohamed-khalaf9/E-Commerce-Console-App.git
   ```
2. **Navigate into the Project Directory:**
   ```bash
   cd your-repo-name
   ```

##### Step 4: Compile and Run the Application

1. **Compile and run the Application**:  
   Open your terminal and navigate to the project's `src` folder. Run the following command to compile the application:
   ```bash
   cd src/main/java
   javac Main.java
   java org.example.Main
   ```
## Demo: 
 - in progress..........
   
## Authors

- **Mohamed Khalaf** - [GitHub Profile Link](https://github.com/mohamed-khalaf9)
- **Roqia Medhat** - [GitHub Profile Link](https://github.com/roqia-med7at)

We collaborated on the development of this project, sharing ideas, features, and coding tasks throughout the process.


   


   

   









  
