import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    String userName;
    String password;
    static Facade facade = new Facade();

    /**
     * This method will validate if the login credentials are valid or invalid
     * @param userType
     * @param userInfoItem
     * @return
     */
    public static UserInfoItem loginScreen(int userType, UserInfoItem userInfoItem) {
        String record = null;
        FileReader in = null;
        int flag = 0;

        try {
            if (userType == 1) {
                in = new FileReader("SellerInfo.txt");
            } else
                in = new FileReader("BuyerInfo.txt");


            BufferedReader br = new BufferedReader(in);
            Scanner scan = new Scanner(System.in);

            System.out.print("Username: ");
            String user = scan.nextLine();

            System.out.print("Password: ");
            String pass = scan.nextLine();
            String credentials = user + ":" + pass;
            while ((record = br.readLine()) != null) {

                if (credentials.equals(record)) {
                    System.out.println("Credentials matching");
                    userInfoItem.setUserName(user);
                    userInfoItem.setUserType(userType);
                    flag = 1;
                    break;

                }
            }


        }
            catch (IOException e) {
            e.getCause();
        }
        if (flag == 0) {
            System.out.println("Credentials not matching.");
            return null;
            //loginScreen(userType, userInfoItem);
            //checkInput();
        }
        return userInfoItem;
    }

}
