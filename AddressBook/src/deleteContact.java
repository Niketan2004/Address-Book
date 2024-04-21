import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteContact {
     public void deleteContacts(Connection con, Scanner sc) throws SQLException {
          LoadingAnimation.animation();
          System.out.println("---------------Delete Contact-------------");
          // Display options to the user
          System.out.println("Choose an option:");
          System.out.println("1. Delete contact by ID");
          System.out.println("2. Delete all contacts");

          // Read user's choice
          System.out.print("Enter your choice: ");
          int choice = sc.nextInt();
          LoadingAnimation.animation();
          if (choice == 1) {
               // Delete contact by ID
               System.out.print("Enter contact ID to delete: ");
               int contactId = sc.nextInt();
               deleteContactById(con, contactId);
          } else if (choice == 2) {
               // Delete all contacts
               deleteAllContacts(con);
          } else {
               System.out.println("Invalid choice!");
          }
          // System.out.println("Enter the Contact id :-");
          // int id = sc.nextInt();

     }

     // Method to delete contact by ID
     private static void deleteContactById(Connection connection, int contactId) throws SQLException {
          // Create PreparedStatement
          try (PreparedStatement preparedStatement = connection.prepareStatement(Query.Deletebyid)) {
               // Set contact ID parameter
               preparedStatement.setInt(1, contactId);

               // Execute the delete query
               int rowsAffected = preparedStatement.executeUpdate();

               // Check if the deletion was successful
               if (rowsAffected > 0) {
                    System.out.println("Contact deleted successfully.");
               } else {
                    System.out.println("Failed to delete contact. Contact ID may not exist.");
               }
          }
     }

     // Method to delete all contacts
     private static void deleteAllContacts(Connection connection) throws SQLException {
          // Create PreparedStatement
          try (PreparedStatement preparedStatement = connection.prepareStatement(Query.deleteAllQuery)) {
               // Execute the delete query
               int rowsAffected = preparedStatement.executeUpdate();

               // Check if the deletion was successful
               if (rowsAffected > 0) {
                    System.out.println("All contacts deleted successfully.");
               } else {
                    System.out.println("Failed to delete contacts. No contacts found.");
               }
          }
     }
}
