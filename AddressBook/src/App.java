import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/Database_name"; // Here you have replace Your_Database_name
                                                                      // with name of the database that you have
                                                                      // given.
        final String userName = "SQL_Username"; // replace this with your username of mysql workbench
        final String password = "SQL_Password"; // replace this with passworf of your mysql workbench.
        addContact ac = new addContact();
        deleteContact dc = new deleteContact();
        updateContact uc = new updateContact();
        viewContact vc = new viewContact();

        System.out.println("-------------------------WELCOME TO ADDRESS BOOK----------------------");

        try (Connection con = DriverManager.getConnection(url, userName, password)) {
            boolean validChoice = false;
            Scanner sc = new Scanner(System.in);
            do {
                System.out
                        .println("1.Add Contact \n 2.View Contacts \n 3.Update Contact \n 4.Delete Contact \n 5.Exit ");
                System.out.println("Enter you choice :-");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> ac.addContacts(sc, con);
                    case 2 -> vc.viewContacts(con, sc);
                    case 3 -> uc.updateContacts(sc, con);
                    case 4 -> dc.deleteContacts(con, sc);
                    case 5 -> {
                        LoadingAnimation.exitAnimation();
                        System.out.println("Thanks for Using App!...We are Waiting for you :)");
                        validChoice = true;
                    }
                }

            } while (!validChoice);
            sc.close();
        } catch (Exception e) {
            System.out.println("Some error Occured!" + e.getMessage());
        }

    }
}
