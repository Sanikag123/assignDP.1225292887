public class Facade {

	private static int UserType; // The type of the user: Buyer: 0, Seller 1

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private static Person thePerson = new Person();



	public static boolean login() {
		UserType = 1;
		new Login().loginScreen(UserType,thePerson);
		return false;
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

	public void createUser(UserInfoItem userInfoitem) {

	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
