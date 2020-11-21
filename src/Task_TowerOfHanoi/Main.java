package Task_TowerOfHanoi;

public class Main {

    static void towerOfHanoi(int N, String from, String to, String via) {
        if (N == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
        } else{
            towerOfHanoi(N - 1, from, via, to);
            System.out.println("Move disk " + N + " from " + from + " to " + to);
            towerOfHanoi(N - 1, via, to, from);
        }
    }
    public static void main(String[] args) {
        int N  = 4;
        towerOfHanoi(N, "A", "C" , "B");
    }
}
