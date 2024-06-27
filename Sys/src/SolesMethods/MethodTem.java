/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SolesMethods;
public class MethodTem { // This class will like object to save all methods to pay 
    
    private final int IdPayment;
    private final String namePayment;

    public MethodTem(int IdPayment, String namePayment) {
        this.IdPayment = IdPayment;
        this.namePayment = namePayment;
    }

    public int getIdPayment() {
        return IdPayment;
    }

    public String getNamePayment() {
        return namePayment;
    }

    @Override
    public String toString() {
        return namePayment;
    }
    
    
    
    
    
    
}
