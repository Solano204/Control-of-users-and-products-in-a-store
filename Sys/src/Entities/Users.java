package Entities;
public class Users {
    
    private final String idUser;
    private final String passWord;
    private final String typeUser;
    private final String name;
    private final String telephone;
    private final String email;
    private final String date;
    private final String idClave;

    public Users(String idUser, String passWord, String typeUser, String name, String telephone, String email, String date, String idClave) {
        this.idUser = idUser;
        this.passWord = passWord;
        this.typeUser = typeUser;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.date = date;
        this.idClave = idClave;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getIdClave() {
        return idClave;
    }

    
    
    
    
}
