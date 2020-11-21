package Task_Conferance;

public class ResTime implements Comperable {
    private final long time;

    public ResTime(long time) {
        this.time = time;
    }

    public long getResTime() {
        return time;
    }

    public String toString() {
        int date = (int) (time / 10000);
        int atHour = (int) (time % 10000);
        int year = date / 10000;
        int monthDay = date % 10000;
        int month = monthDay / 100;
        int day = monthDay % 100;

        String time = "";
        if (day < 10) {
            time += "0";
        }
        time += day + "-";
        if (month < 10) {
            time += "0";
        }
        time += month + "-" + year + " at ";
        if (atHour < 1000) {
            time += "0";
        }
        time += atHour;
        return time;
    }


    public int compareTo(ResTime theSecond){
        if(time < theSecond.time){
            return -1;
        }else if(time > theSecond.time){
            return 1;
        }else {
            return 0;
        }
    }

    //Testing:

    public static void main(String[] args) {
        System.out.println("Total amount of tests: 2");
        ResTime t1 = new ResTime(200301201200L);
        ResTime t2 = new ResTime(200301070230L);
        ResTime t3 = new ResTime(200301070230L);

        if(t1.compareTo(t2) > 0 &&
            t2.compareTo(t1) < 0 &&
            t3.compareTo(t2) == 0 &&
            t2.compareTo(t3) == 0){
            System.out.println("ResTime: test 1 successfull");
        }
        if(t1.toString().equals("20-01-2003 at 1200") &&
            t2.toString().equals("07-01-2003 at 0230") &&
            t3.toString().equals("07-01-2003 at 0230")){
            System.out.println("ResTime: Test 2 successfull");
        }
    }
}
