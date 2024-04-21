# Address Book Project 📇

## Introduction
The Address Book project is a command-line application developed in Java that allows users to manage their contacts efficiently. It utilizes Java database connectivity (JDBC) to interact with a MySQL database, enabling users to add, view, update, and delete contacts.

## Project Schema 📋
The database schema for the project consists of a single table named `Contacts` with the following fields:
- `id`: Auto-incremented integer serving as the primary key.
- `name`: Variable-length string storing the name of the contact.
- `phone_number`: Variable-length string storing the phone number of the contact.
- `email`: Variable-length string storing the email address of the contact.

## How It Works ⚙️
The Address Book project functions as a command-line interface (CLI) application, providing users with a menu-driven interface to perform various operations on their contacts. Here's how it works:
1. **Adding Contacts**: Users can add new contacts by entering their name, phone number, and email address.
2. **Viewing Contacts**: Users can view all contacts, search for contacts by name, or retrieve contacts by their unique ID.
3. **Updating Contacts**: Users can update existing contacts by modifying their name, phone number, or email address.
4. **Deleting Contacts**: Users can delete contacts either by their unique ID or remove all contacts from the address book.

## Changes to Make 🛠️
To adapt the project to your environment and preferences, you need to make the following changes:
- **Database Configuration**: Update the database connection URL, username, and password in the `App.java` file to connect to your MySQL database.
- **Project Customization**: Customize the project according to your requirements, such as modifying the database schema, refining the user interface, or adding additional functionalities.

## Getting Started 🚀
To run the Address Book project on your local machine, follow these steps:
1. Clone the repository to your local machine.
2. Import the project into your preferred Java IDE.
3. Ensure that you have MySQL installed and running on your system.
4. Create a new database named `Your_Database_Name` and execute the provided SQL script to create the `Contacts` table:- 
`CREATE TABLE Contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15),
    email VARCHAR(255)
);`

5. Update the database connection details in the `App.java` file.
6. Build and run the project from your IDE.

## Feedback and Contributions 📢
Your feedback and contributions are highly appreciated! If you encounter any issues, have suggestions for improvements, or want to contribute to the project, feel free to open an issue or submit a pull request.

Happy managing your contacts with the Address Book project! 🎉
