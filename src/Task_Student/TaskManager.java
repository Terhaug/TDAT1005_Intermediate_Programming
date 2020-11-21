package Task_Student;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Student> students = new ArrayList<Student>();

    public boolean regNewStud(String name){
        for(int i = 0; i < students.size(); i++){
            if(name.equals(students.get(i).getName())){
                return false;
            }
        }
        students.add(new Student(name));
        return true;
    }

    public int getAmStud(){
        return students.size();
    }

    public int getAmTaskStud(String name){
        for(int i = 0; i<students.size(); i++){
            if(name.equals(students.get(i).getName())){
                return students.get(i).getAmTask();
            }
        }
        return -1;
    }

    public void increaseTasks(String name, int amTasks){
        for(int i = 0; i<students.size(); i++){
            if(name.equals(students.get(i).getName())){
                students.get(i).setAmTask(amTasks);
            }
        }
    }

    public String[] getAllNames(){
        String[] tab = new String[students.size()];
        for(int i = 0; i < students.size(); i++){
            tab[i] = students.get(i).getName();
        }
        return tab;
    }

    public String toString(){
        String res = "";
        for(int i = 0; i<students.size(); i++){
            res += "\n" + students.get(i).toString();
        }
        return res;
    }



}
