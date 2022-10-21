/**
 * This class is a part of bridge design pattern as it will help to differentiate between buyer and seller and
 * load menu accordingly.
 */
public abstract class Person {

	private ProductMenu theProductMenu;

	private ProductMenu productMenu;

	public abstract void showMenu();

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public abstract ProductMenu CreateProductMenu();

}
