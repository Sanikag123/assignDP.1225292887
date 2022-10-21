import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Facade {

	private static int UserType; // The type of the user: Buyer: 0, Seller 1

	private static Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private static Person thePerson ;
	private static UserInfoItem userInfoItem = new UserInfoItem();

	ArrayList arr = new ArrayList();



	public static boolean login() {

		System.out.println("Enter if buyer or seller. Enter 0 for buyer and 1 for seller");

		Scanner scan = new Scanner(System.in);
		int person = scan.nextInt();

		UserInfoItem validate =  new Login().loginScreen(person,userInfoItem);
		if (validate != null) {
			createUser(validate);
			if (person == 1) {
				System.out.println("Person is a seller");
				Seller seller = new Seller(userInfoItem);

				seller.CreateProductMenu();
				seller.showMenu();
			}
			else {
				System.out.println("Person is a buyer");
				Buyer buyer = new Buyer(userInfoItem);


				buyer.showMenu();
				buyer.CreateProductMenu();
				createProductList();
				discussBidding();

			}
		}
	return true;
	}

	public static void addTrading(Offering o) {
		System.out.println("Following trade has been finalised");
		System.out.println("Buyer name: " + userInfoItem.user);
		System.out.println("Seller name: " + o.getSellerName());
		System.out.println("Product name: " + o.getProductOffering());

	}

	public void viewTrading() {

	}

	public static void decideBidding() {

	}

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

	public static void submitBidding(OfferingList finalOfferingList) {
		System.out.println("Select the offering from the seller: ");
		for (int i=0;i<finalOfferingList.size();i++) {
			System.out.println( i+1 +": Seller Name: " + ((Offering) (finalOfferingList.get(i))).getSellerName()
					+ " Price offered: " + ((Offering) (finalOfferingList.get(i))).getPrice()
					+ " Product name: " + ((Offering) (finalOfferingList.get(i))).getProductOffering());
		}

		Scanner sc = new Scanner(System.in);
		int selectOffering = sc.nextInt();

		addTrading ((Offering) finalOfferingList.get(selectOffering-1));

	}

	public void remind() {

	}

	public static void createUser(UserInfoItem userInfoitem) {
		UserType = userInfoitem.getUserType();

	}

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

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
