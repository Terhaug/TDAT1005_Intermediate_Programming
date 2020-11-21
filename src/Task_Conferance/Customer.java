package Task_Conferance;

public class Customer {
    private final String name;
    private final String tlf;

    public Customer(String name, String tlf) {
        if(name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Missing name");
        }
        if(tlf == null || tlf.trim().equals("")){
            throw new IllegalArgumentException("Missing number");
        }
        this.name = name.trim();
        this.tlf = tlf.trim();
    }

    public String getName() {
        return name;
    }

    public String getTlf() {
        return tlf;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", tlf='" + tlf + '\'';
    }
}
