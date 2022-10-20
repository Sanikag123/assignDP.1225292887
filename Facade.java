import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Facade {

	private static int UserType; // The type of the user: Buyer: 0, Seller 1

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private static Person thePerson ;
	private static UserInfoItem userInfoItem = new UserInfoItem();



	public static boolean login() {

		System.out.println("Enter if buyer or seller");

		Scanner scan = new Scanner(System.in);
		int person = scan.nextInt();



		UserInfoItem validate =  new Login().loginScreen(person,userInfoItem);
		if (validate != null) {
			createUser(validate);
			if (person == 1) {
				System.out.println("Person is a seller");
				Seller seller = new Seller();
				seller.showMenu();
				seller.CreateProductMenu();
			}
			else {
				System.out.println("Person is a buyer");
				Buyer buyer = new Buyer();
				buyer.showMenu();
				buyer.CreateProductMenu();
			}
		}
return true;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public static void createUser(UserInfoItem userInfoitem) {
		UserType = userInfoitem.getUserType();

	}

	public void createProductList() {
		try {
			String record = null;
			FileReader in = null;
			ArrayList arr = new ArrayList();
		if (UserType == 0) {
				in = new FileReader("BuyerProductCart");
				BufferedReader br = new BufferedReader(in);
				while ( br.readLine() != null)
					arr.add(br.readLine());
				// Print the string

		}
		System.out.println(arr);


		} catch (IOException e ) {
			throw new RuntimeException(e);
		}


	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
