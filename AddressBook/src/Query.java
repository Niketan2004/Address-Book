public class Query {
   // inserting data into database
   String insert = "INSERT INTO Contacts (name, phone_number, email) VALUES (?, ?, ?)";

   // Update contact by ID
   public static final String UpdatebyId = "UPDATE Contacts SET name = ?, phone_number = ?, email = ? WHERE id = ?";
   public static String deleteAllQuery = "DELETE FROM Contacts";
   // Find contact by name
   public static final String FindbyName = "SELECT * FROM Contacts WHERE name = ?";

   // Find contact by ID
   public static final String FindbyId = "SELECT * FROM Contacts WHERE id = ?";

   // Display all contacts
   public static final String Display = "SELECT * FROM Contacts";

   // Delete contact by ID
   public static final String Deletebyid = "DELETE FROM Contacts WHERE id = ?";

}
