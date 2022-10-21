import java.util.ArrayList;

/**
 * This class is a part of iterator design pattern. It is used to iterate over the offering objects provided by the seller
 */
public class OfferingIterator implements ListIterator {

	private Product selectedProduct;
	private OfferingList offeringList;
	int position = 0;


	OfferingIterator(OfferingList offeringList, Product selectedProduct){
		this.offeringList = offeringList;
		this.selectedProduct = selectedProduct;
	}

	public boolean hasNext() {

		while(position < offeringList.size()) {
			return true;

		}
		return false;
	}

	public Offering Next() {
		Offering o = (Offering) offeringList.get(position);

			ArrayList price = new ArrayList();
			String offeringProduct = o.getProductOffering().trim();
			String buyerRequest = selectedProduct.getProduct().trim();
			if (offeringProduct.equals(buyerRequest)) {
				position++;
				return o;

			}
			position++;
		return null;
	}

	public void MoveToHead() {

	}

	public void Remove() {

	}

}
