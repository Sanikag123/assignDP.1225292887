import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MeatProductMenu implements ProductMenu {

	public void showMenu(Object Person) {
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
			System.out.println("Displaying the meat products for the seller");

		}



	}

	public void showAddButton() {


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
