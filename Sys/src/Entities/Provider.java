package Entities;

public class Provider {
    
    private String dni;
    private String name;
    private String telephone;
    private String countryOrigin;
    private String registrationDate;

    public Provider(String dni, String name, String telephone, String countryOrigin, String registrationDate) {
        this.dni = dni;
        this.name = name;
        this.telephone = telephone;
        this.countryOrigin = countryOrigin;
        this.registrationDate = registrationDate;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    
}
