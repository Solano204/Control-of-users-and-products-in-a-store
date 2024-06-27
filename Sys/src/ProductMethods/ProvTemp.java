package ProductMethods;
public class ProvTemp {
    private final String DniProv;
    private final String nameProv;

    
    // THIS CLASSS IS SERVE LIKE A OBJECT TEMPORAL TO SAVE THE INFORMATION FROM ALL PROVIDERS(Dni,Name) to them save in the cbx
    public ProvTemp(String DniProv, String nameProv) {
        this.DniProv = DniProv;
        this.nameProv = nameProv;
    }

    public String getDniProv() {
        return DniProv;
    }

    public String getNameProv() {
        return nameProv;
    }

    @Override // it´ll to show information in the cbxPriversProduc5t
    public String toString() {
        return nameProv;
    }
    
    
    
}
