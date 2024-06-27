package Entities;
public class Sale {
    private final int IdVenta;
    private final String DniCustomer;
    private  int paymentMethod;
    private float totalBuy;
    private String date;
    private String namePayment ;

    public Sale(int IdVenta, String DniCustomer, int paymentMethod, String date) {
        this.IdVenta = IdVenta;
        this.DniCustomer = DniCustomer;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public Sale(int IdVenta, String DniCustomer, float totalBuy, String date, String namePayment) {
        this.IdVenta = IdVenta;
        this.DniCustomer = DniCustomer;
        this.totalBuy = totalBuy;
        this.date = date;
        this.namePayment = namePayment;
    }

    public String getNamePayment() {
        return namePayment;
    }

    
    

    public float getTotalBuy() {
        return totalBuy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public int getIdVenta() {
        return IdVenta;
    }

    public String getDniCustomer() {
        return DniCustomer;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }
    
            
            
}
