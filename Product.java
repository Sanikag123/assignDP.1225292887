public class Product extends Object{

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
