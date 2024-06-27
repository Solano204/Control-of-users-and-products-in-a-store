package Entities;


public class Customer {
    private String dni;
    private String name;
    private String telephone;
    private String addres;
    private String registrationDate;

    public Customer(String dni, String name, String telephone, String addres, String registrationDate) {
        this.dni = dni;
        this.name = name;
        this.telephone = telephone;
        this.addres = addres;
        this.registrationDate = registrationDate;
    }

    public String getAddres() {
        return addres;
    }

    public String getTelephone() {
        return telephone;
    }

   
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    
    
            
    
    
}
