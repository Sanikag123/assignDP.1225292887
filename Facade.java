import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the facade design pattern. The façade class object provides a single interface to the more
 * general facilities of other subsystems.
 */
public class Facade {

	private static int UserType; // The type of the user: Buyer: 0, Seller 1

	private static Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private static Person thePerson ;
	private static UserInfoItem userInfoItem = new UserInfoItem();

	ArrayList arr = new ArrayList();


	/**
	 * This method is used for login and validating login credentials
	 * @return
	 */
	public static boolean login() {

		System.out.println("Enter if buyer or seller. Enter 0 for buyer and 1 for seller");

		Scanner scan = new Scanner(System.in);
		int person = scan.nextInt();

		UserInfoItem validate =  new Login().loginScreen(person,userInfoItem);
		if (validate != null) {
			createUser(validate);

			/**
			 * This represents the funtionality of Factory pattern, it depends on the login user which user type to instantiate
			 */
			if (person == 1) {
				System.out.println("Person is a seller");
				Person seller = new Seller(userInfoItem);

				seller.CreateProductMenu();
				seller.showMenu();
			}
			else {
				System.out.println("Person is a buyer");
				Person buyer = new Buyer(userInfoItem);


				buyer.showMenu();
				buyer.CreateProductMenu();
				createProductList();
				discussBidding();

			}
		}
	return true;
	}

	/**
	 * This method is the final result of which trade is finalised between buyer and the seller
	 * @param o
	 */
	public static void addTrading(Offering o) {
		System.out.println("Following trade has been finalised");
		System.out.println("Buyer name: " + userInfoItem.user);
		System.out.println("Seller name: " + o.getSellerName());
		System.out.println("Product name: " + o.getProductOffering());
//Clear the contents of the buyer product file
		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(Paths.get("BuyerProductCart"));
			writer.write("");
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}

	/**
	 * This method is used for discussing which bid to finalise from the options of trades available.
	 */
	public static void discussBidding() {

		OfferingList allOfferings = new OfferingList();
		Offering offering ;
		BufferedReader br;
		FileReader in = null;

		try {
			in = new FileReader("SellerOfferings");
			br = new BufferedReader(in);
			String line = br.readLine();
			while ( line != null) {

					offering = new Offering();
					offering.setSellerName(line.split(":")[0]);
					offering.setProductOffering(line.split(":")[1]);
					//offering.setPrice(Integer.parseInt(line.split(":")[2]));
					allOfferings.add(offering);
					line = br.readLine();

			}
			/**
			 * This is a part of iterator design pattern implementation.
			 */
			OfferingIterator offeringIterator = new OfferingIterator(allOfferings,theSelectedProduct);
			OfferingList finalOfferingList = new OfferingList();
			while(offeringIterator.hasNext()){
				Offering of = offeringIterator.Next();
				if (of != null)
					finalOfferingList.add(of);

			}
			submitBidding(finalOfferingList);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method is used for finalising the bid and adding the trade
	 * @param finalOfferingList
	 */
	public static void submitBidding(OfferingList finalOfferingList) {
		if(finalOfferingList.size() > 0) {
			System.out.println("Select the offering from the seller: (Enter the serial no.) ");
			for (int i = 0; i < finalOfferingList.size(); i++) {
				System.out.println(i + 1 + ": Seller Name: " + ((Offering) (finalOfferingList.get(i))).getSellerName()
						+ " Price offered: " + ((Offering) (finalOfferingList.get(i))).getPrice()
						+ " Product name: " + ((Offering) (finalOfferingList.get(i))).getProductOffering());
			}
		}
		else {
			System.out.println("No offering found. (Login with seller to add prodcuts and then try again) ");
			return;
		}


		Scanner sc = new Scanner(System.in);
		int selectOffering = sc.nextInt();

		addTrading ((Offering) finalOfferingList.get(selectOffering-1));

	}


	public static void createUser(UserInfoItem userInfoitem) {
		UserType = userInfoitem.getUserType();

	}

	/**
	 * This method is used to add a selected product which the buyer enters and desires to buy
	 */
	public static void createProductList() {
		try {
			theSelectedProduct = new Product();
			//theSelectedProduct.getProduct();

			FileReader in = null;

		if (UserType == 0) {
				in = new FileReader("BuyerProductCart");
				BufferedReader br = new BufferedReader(in);
					String line = br.readLine();
					theSelectedProduct.setProductNameWhichBuyerReuired(line.split(":")[0]);
					theSelectedProduct.setPriceBuyerBidded(line.split(":")[1]);

				// Print the string
		}
		} catch (IOException e ) {
			throw new RuntimeException(e);
		}


	}


}
