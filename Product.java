/**
 * This class is used to store the object which the byer wishes to buy and the bidprice
 */
public class Product {

    String productBuyerRequested;
    String bidPrice;
    public String getProduct() {
        return this.productBuyerRequested;

    }

    public void setProductNameWhichBuyerReuired(String s) {
        this.productBuyerRequested = s;
    }

    public void setPriceBuyerBidded(String s) {
        this.bidPrice = s;
    }
}
