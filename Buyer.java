import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is a part of bridge and factory design pattern as it will be used to load menu according to a buyer and seller.
 */
public class Buyer extends Person {

	ProductMenu produceProductMenu;
	UserInfoItem userInfoItem;
	public Buyer(UserInfoItem userInfoItem) {
		this.userInfoItem = userInfoItem;
	}

	/**
	 This is a part of bridge pattern which decides menu based on the buyer or seller
	 */
	public void showMenu() {
		System.out.println("Showing Buyer menu ");
		System.out.println("Select Product type: \n1. Meat \n2. Produce");
		Scanner scan  = new Scanner(System.in);
		int input = scan.nextInt();
		if (input == 1) {
			System.out.println("Meat product menu ");
			produceProductMenu = new MeatProductMenu(userInfoItem);
			produceProductMenu.showMenu(this);

		}
		else  {
			System.out.println("Produce product menu ");
			produceProductMenu = new ProduceProductMenu(userInfoItem);
			produceProductMenu.showMenu(this);


		}


	}

	/**
	 * This method is specific to creating product menu only for BUYER.
	 * @return
	 */
	public ProductMenu CreateProductMenu() {

		System.out.println("Add the products you want to add: (Enter name of product for eg. Tomato)");
		Scanner scan  = new Scanner(System.in);
		String product = scan.next();
		System.out.println("Add the bidding price for the same: ");
		scan = new Scanner(System.in);
		String price = scan.next();
		FileWriter fw = null;
		try {
			fw = new FileWriter("BuyerProductCart", true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		BufferedWriter bw;

		try {
			bw = new BufferedWriter(fw);

			bw.write(product);
			bw.write(":");

			bw.write(price);
			bw.newLine();
			bw.close();
			System.out.println("Contents added to the file");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		return null;
	}

}
