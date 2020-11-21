package Task_Zoo;

public interface ScandinavianPredators {
    String getName();
    int getFdate();
    int getAge();
    String getAddresse();
    void move(String newAddresse);
    String writeInfo();
    int getAmLitter();
    void addLitter(int amount);
}
