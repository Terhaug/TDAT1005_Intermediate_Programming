package Task_Student;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        taskManager.regNewStud("Kari");

        System.out.println(taskManager.toString());
        taskManager.regNewStud("Ole");
        System.out.println(Arrays.toString(taskManager.getAllNames()));
        System.out.println(taskManager.getAmStud());
        taskManager.increaseTasks("Kari", 2);
        System.out.println(taskManager.toString());
        taskManager.increaseTasks("Kari", 1);
        System.out.println(taskManager.toString());
    }
}
