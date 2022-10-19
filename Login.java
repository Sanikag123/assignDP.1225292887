import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    String userName;
    String password;
    static Facade facade = new Facade();

    public static boolean loginScreen(int userType, Person person) {
        String record = null;
        FileReader in = null;
        try {
            if(userType == 1) {
                in = new FileReader("src/SellerInfo.txt");
            }
            else
                in = new FileReader("src/BuyerInfo.txt");

            BufferedReader br = new BufferedReader(in);
            Scanner scan = new Scanner(System.in);

            System.out.print("Username: ");
            String user = scan.nextLine();

            System.out.print("Password: ");
            String pass = scan.nextLine();
            String credentials = user + ":" + pass;
            while ((record = br.readLine()) !=null) {

                if (credentials.equals(record)) {
                    System.out.println("Credentials matching");
                    person.setUserName(user);
                    return true;

                } else {
                    System.out.println("________----Error----________\n press 'Enter' to continue...");
                    scan.nextLine();
                    //checkInput();
                }
            }
        } catch (IOException e) {
            e.getCause();
        }

        return false;
    }

}
