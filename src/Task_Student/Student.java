package Task_Student;

public class Student {
    private String name;
    private int amTask;

    public Student(String name) {
        this.name = name;
        this.amTask = 0;
    }

    public String getName() {
        return name;
    }

    public int getAmTask() {
        return amTask;
    }

    public void setAmTask(int amTask) {
        if(amTask > 0 ){
            this.amTask += amTask;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", antOpg=" + amTask +
                '}';
    }
}
