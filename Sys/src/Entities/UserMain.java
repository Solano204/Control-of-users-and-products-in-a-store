// Class when get the data of main User
package Entities;
public class UserMain {
    
    private final char idUser;
    private final char passWordUser;

    public UserMain(char idUser, char passWordUser) {
        this.idUser = idUser;
        this.passWordUser = passWordUser;
    }
    public char getIdUser() {
        return idUser;
    }

    public char getPassWordUser() {
        return passWordUser;
    }
    
    
    
}
