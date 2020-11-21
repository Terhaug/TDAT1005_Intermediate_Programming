package Task_Zoo;

import java.time.LocalDate;

public abstract class Individual  extends Animal implements ScandinavianPredators{
    private final String name;
    private final int fDate;
    private final boolean male;
    private final boolean dangerous;

    public Individual(String norName, String latName, int arrivalDate, String addresse, String name, int fDate, boolean male, boolean dangerous) {
        super(norName, latName, arrivalDate, addresse);
        this.name = name;
        this.fDate = fDate;
        this.male = male;
        this.dangerous = dangerous;
    }

    public String getName() {
        return name;
    }

    public int getFdate(){
        return fDate;
    }


    public boolean isMale() {
        return male;
    }

    public boolean isDangerous() {
        return dangerous;
    }
    @Override
    public int getAge(){
        int fDate = Integer.parseInt(Integer.toString(getFdate()).substring(0,4));
        return LocalDate.now().getYear() - fDate;
    }
    @Override
    public void move(String newAddresse){
        setAddresse(newAddresse);
    }
    @Override
    public String writeInfo(){
        return toString();
    }


    @Override
    public String toString() {
        return "Individual{" +
                "name='" + name + '\'' +
                ", fDate=" + fDate +
                ", male=" + male +
                ", dangerous=" + dangerous +
                '}';
    }
}
