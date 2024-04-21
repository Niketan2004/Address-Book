import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateContact {
     public void updateContacts(Scanner sc, Connection con) {
          LoadingAnimation.animation();
          System.out.println("--------------Update Contact----------------");
          {
               // Prompt user for contact ID
               System.out.print("Enter contact ID to update: ");
               int contactId = sc.nextInt();
               LoadingAnimation.animation();
               // Display options to the user
               System.out.println("Choose fields to update:");
               System.out.println("1. Name");
               System.out.println("2. Phone Number");
               System.out.println("3. Email");
               System.out.println("4. All");

               // Read user's choice
               System.out.print("Enter your choice: ");
               int choice = sc.nextInt();
               LoadingAnimation.animation();
               // Variables to store updated values
               String newName = null;
               String newPhoneNumber = null;
               String newEmail = null;

               // Depending on user's choice, prompt for new values
               switch (choice) {
                    case 1:
                         System.out.print("Enter new name: ");
                         newName = sc.next();
                         break;
                    case 2:
                         System.out.print("Enter new phone number: ");
                         newPhoneNumber = sc.next();
                         break;
                    case 3:
                         System.out.print("Enter new email: ");
                         newEmail = sc.next();
                         break;
                    case 4:
                         System.out.print("Enter new name: ");
                         newName = sc.next();
                         System.out.print("Enter new phone number: ");
                         newPhoneNumber = sc.next();
                         System.out.print("Enter new email: ");
                         newEmail = sc.next();
                         break;
                    default:
                         System.out.println("Invalid choice!");
                         return;
               }

               // Prepare SQL query based on user's choice
               String updateQuery = "";
               if (choice == 4) {
                    updateQuery = "UPDATE Contacts SET name = ?, phone_number = ?, email = ? WHERE id = ?";
               } else if (choice == 1) {
                    updateQuery = "UPDATE Contacts SET name = ? WHERE id = ?";
               } else if (choice == 2) {
                    updateQuery = "UPDATE Contacts SET phone_number = ? WHERE id = ?";
               } else if (choice == 3) {
                    updateQuery = "UPDATE Contacts SET email = ? WHERE id = ?";
               }

               // Create PreparedStatement
               try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
                    // Set updated values
                    int parameterIndex = 1;
                    if (newName != null) {
                         preparedStatement.setString(parameterIndex++, newName);
                    }
                    if (newPhoneNumber != null) {
                         preparedStatement.setString(parameterIndex++, newPhoneNumber);
                    }
                    if (newEmail != null) {
                         preparedStatement.setString(parameterIndex++, newEmail);
                    }
                    preparedStatement.setInt(parameterIndex, contactId);

                    // Execute the update query
                    int rowsAffected = preparedStatement.executeUpdate();

                    // Check if the update was successful
                    if (rowsAffected > 0) {
                         LoadingAnimation.animation();
                         System.out.println("Contact updated successfully.");
                    } else {
                         System.out.println("Failed to update contact. Contact ID may not exist.");
                    }
               } catch (SQLException e) {
                    e.printStackTrace();

               }
          }
     }
}
