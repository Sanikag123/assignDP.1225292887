import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MeatProductMenu implements ProductMenu {
	UserInfoItem userInfoItem;
	public MeatProductMenu(UserInfoItem userInfoItem) {
		this.userInfoItem = userInfoItem;

	}

	public void showMenu(Person Person) {
		if (Person instanceof Buyer ) {
			System.out.println("Displaying the meat products available for buyer");

			String record = null;
			FileReader in = null;

			try {
				in = new FileReader("ProductInfo.txt");
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
			BufferedReader reader;
			try {
				reader = new BufferedReader(in);
				String line = reader.readLine();
				ArrayList arr = new ArrayList();
				while (line != null) {
					String[] l = line.split(":",0);
					if(l[0].equalsIgnoreCase("Meat")) {
						arr.add(l[1]);
					}

					// read next line
					line = reader.readLine();
				}
				System.out.println(arr);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else {
			//Display offering for seller
			System.out.println("Displaying the current meat products for the seller: " + userInfoItem.user);
			try {
				FileReader in = new FileReader("SellerOfferings");
				BufferedReader br = new BufferedReader(in);
				String line = br.readLine();
				while(line != null) {
					if((line.split(":")[0]).equals(userInfoItem.user)) {
						System.out.println(line);

					}
					line = br.readLine();
				}
 			}
			catch (Exception e) {

			}

			System.out.println("Do you want to add new products: (Enter YES/NO)" );
			Scanner sc = new Scanner(System.in);
			String ans = sc.next();
			if (ans.equalsIgnoreCase("YES")) {
				showAddButton();
			}
			else
				return;






		}



	}

	public void showAddButton() {
		//seller uses this for adding offering
		System.out.println("Enter what offerings you want to add : \n1. Beef\n2. Pork \n3. Mutton (Enter the product name for. eg- Beef)");
		Scanner product = new Scanner(System.in);
		String prod = product.next();
		System.out.println("Enter what price for this product");
		Scanner price = new Scanner(System.in);
		String pr = price.next();
		try {
		FileWriter fw = new FileWriter("SellerOfferings",true);
		BufferedWriter bw = new BufferedWriter(fw);
		    bw.write("");
			bw.write(userInfoItem.user);
			bw.write(":");
			bw.write(prod);
			bw.write(":");
			bw.write(pr);
			bw.newLine();
			bw.close();
			System.out.println("Contents added to the file");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Do you want to add more products: ");
		Scanner sc = new Scanner(System.in);
		String ans = sc.next();
		if (ans.equalsIgnoreCase("YES")) {
			showAddButton();
		}
		else
			return;
	}

	@Override
	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showComboxes() {

	}

}
