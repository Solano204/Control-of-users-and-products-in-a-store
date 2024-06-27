package Entities;

public class DetailSale { 

    private final String codeProduct;
    private final int amountSell;
    private final float price;
    private final float totalBuy;
    private final int IdVenta;

    public DetailSale( String codeProduct, int amountSell, float price, float totalBuy, int IdVenta) {
        this.codeProduct = codeProduct;
        this.amountSell = amountSell;
        this.price = price;
        this.totalBuy = totalBuy;
        this.IdVenta = IdVenta;
    }


    public String getCodeProduct() {
        return codeProduct;
    }

    public int getAmountSell() {
        return amountSell;
    }

    public float getPrice() {
        return price;
    }

    public float getTotalBuy() {
        return totalBuy;
    }

    public int getIdVenta() {
        return IdVenta;
    }
    
    
}
