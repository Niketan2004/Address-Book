import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class addContact {
     public void addContacts(Scanner sc, Connection con) {
          Query q = new Query();
          LoadingAnimation.animation();
          System.out.println();
          System.out.println("------------Adding Contact Details--------------");

          int generatedId = -1;

          // Consume any leftover newline characters
          sc.nextLine();

          System.out.println("Enter the name: ");
          String name = sc.nextLine(); // Read the name

          System.out.println("Enter Phone Number: ");
          long num = sc.nextLong();
          sc.nextLine(); // Consume newline character

          System.out.println("Enter email id: ");
          String email = sc.nextLine();
          LoadingAnimation.animation();
          try (PreparedStatement ps = con.prepareStatement(q.insert, PreparedStatement.RETURN_GENERATED_KEYS)) {
               ps.setString(1, name);
               ps.setLong(2, num);
               ps.setString(3, email);
               ps.executeUpdate();
               ResultSet rs = ps.getGeneratedKeys();
               if (rs.next()) {
                    generatedId = rs.getInt(1); // Retrieve the generated ID correctly
                    System.out.println("Contact details entered successfully! Contact ID: " + generatedId);
               }
               rs.close(); // Close the ResultSet
          } catch (SQLException e) {
               System.out.println("Error occurred while inserting data: " + e.getMessage());
          }
     }
}
