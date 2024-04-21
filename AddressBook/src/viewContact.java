import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class viewContact {

     public void viewContacts(Connection con, Scanner sc) {
          // Query q = new Query();
          LoadingAnimation.animation();
          System.out.println("---------------Displaying Contacts-------------");
          boolean istrue = false;
          do {
               System.out.println("1.Display All \n 2.Display By name \n 3.Display by ID \n 4.Exit");
               System.out.println("Enter your Choice :- ");
               int choice = sc.nextInt();

               switch (choice) {
                    case 1 -> viewAll(con);
                    case 2 -> viewbyName(con, sc);
                    case 3 -> viewbyId(con, sc);
                    case 4 -> {
                         LoadingAnimation.exitAnimation();

                         istrue = true;
                    }
               }

          } while (!istrue);

     }

     private void viewAll(Connection con) {
          try (PreparedStatement ps = con.prepareStatement(Query.Display)) {
               ResultSet resultset = ps.executeQuery();
               LoadingAnimation.animation();
               System.out.println("+-------------------------------------------------------------------------------+");
               System.out.printf("| %-3s | %-20s | %-15s | %-30s |\n", "ID", "Name", "Phone Number", "Email");
               System.out.println("+-------------------------------------------------------------------------------+");
               while (resultset.next()) {
                    int id = resultset.getInt("id");
                    String name = resultset.getString("name");
                    String phoneNumber = resultset.getString("phone_number");
                    String email = resultset.getString("email");
                    System.out.printf("| %-3d | %-20s | %-15s | %-30s |\n", id, name, phoneNumber, email);
               }
               System.out.println("+-------------------------------------------------------------------------------+");

          } catch (Exception e) {
               System.out.println("Error Occured while retrieving data ! " + e);
          }
     }

     private void viewbyId(Connection con, Scanner sc) {
          LoadingAnimation.animation();
          System.out.println("Enter the Contact Id: ");
          int id = sc.nextInt();
          // Consume newline character
          sc.nextLine();
          LoadingAnimation.animation();
          try (PreparedStatement ps = con.prepareStatement(Query.FindbyId)) {
               ps.setInt(1, id);
               ResultSet resultset = ps.executeQuery();
               System.out.println("+-------------------------------------------------------------------------------+");
               System.out.printf("| %-3s | %-20s | %-15s | %-30s |\n", "ID", "Name", "Phone Number", "Email");
               System.out.println("+-------------------------------------------------------------------------------+");
               while (resultset.next()) {
                    String name = resultset.getString("name");
                    String phoneNumber = resultset.getString("phone_number");
                    String email = resultset.getString("email");
                    System.out.printf("| %-3d | %-20s | %-15s | %-30s |\n", id, name, phoneNumber, email);
               }
               System.out.println("+-------------------------------------------------------------------------------+");
          } catch (Exception e) {
               System.out.println("Error Occurred while retrieving data: " + e);
          }
     }

     private void viewbyName(Connection con, Scanner sc) {
          LoadingAnimation.animation();
          try (PreparedStatement ps = con.prepareStatement(Query.FindbyName)) {
               // Prompt user for name to search
               // Scanner scanner = new Scanner(System.in);
               sc.nextLine();
               System.out.print("Enter name to search: ");
               String name = sc.nextLine();

               // Set the name parameter in the PreparedStatement
               ps.setString(1, name);

               // Execute the query
               ResultSet resultset = ps.executeQuery();
               LoadingAnimation.animation();
               // Display the results
               System.out.println("+-------------------------------------------------------------------------------+");
               System.out.printf("| %-3s | %-20s | %-15s | %-30s |\n", "ID", "Name", "Phone Number", "Email");
               System.out.println("+-------------------------------------------------------------------------------+");
               while (resultset.next()) {
                    int id = resultset.getInt("id");
                    String contactName = resultset.getString("name");
                    String phoneNumber = resultset.getString("phone_number");
                    String email = resultset.getString("email");
                    System.out.printf("| %-3d | %-20s | %-15s | %-30s |\n", id, contactName, phoneNumber, email);
               }
               System.out.println("+-------------------------------------------------------------------------------+");
          } catch (Exception e) {
               System.out.println("Error occurred while retrieving data: " + e.getMessage());
          }
     }

}
