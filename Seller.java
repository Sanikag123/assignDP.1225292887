import java.util.Scanner;

public class Seller extends Person {
	ProductMenu productMenu;
	UserInfoItem userInfoItem = new UserInfoItem();

	public Seller(UserInfoItem userInfoItem) {
		this.userInfoItem = userInfoItem;
	}

	public void showMenu() {
		System.out.println("Enter if you want to add or view the offerings: \n1. View\n 2. Add");
		Scanner scan = new Scanner(System.in);
		if (scan.nextInt() == 1 ) {
			this.productMenu.showMenu(this);
		}
		else
			this.productMenu.showAddButton();
	}

	public ProductMenu CreateProductMenu() {
		System.out.println("Enter what offeringgs you want to add : \n1. Meat\n2. Produce ");
		Scanner scan = new Scanner(System.in);
		if (scan.nextInt() == 1 ) {
			this.productMenu = new MeatProductMenu(userInfoItem);

		}
		else
			this.productMenu = new ProduceProductMenu(userInfoItem);

		return this.productMenu;
	}



}
