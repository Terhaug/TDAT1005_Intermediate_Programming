package Task_Conferance;

import java.util.ArrayList;

public class Room {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int roomNr;
    private int amPeople;

    public Room(int roomNr, int amPeople) {
        this.roomNr = roomNr;
        this.amPeople = amPeople;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public int getAmPeople(){
        return amPeople;
    }

    public boolean reserveRoom(Reservation theReservation, int amPersons){
        for(int i = 0; i<reservations.size(); i++){
            if(reservations.get(i).checkDoubleRes(theReservation.getFromTime(), theReservation.getToTime())){
                return false;
            }
        }
        reservations.add(theReservation);
        return true;
    }

    public String toString(){
        return "Room number: " + roomNr + " has room for " + amPeople + " people.";
    }

    public String retReservations(){
        String res = "";
        for(int i = 0; i<reservations.size(); i++){
            res += reservations.get(i).toString();
        }
        return res;
    }

    //Test for room:
    public static void main(String[] args) {
        System.out.println("Testing room class:");
        Room r1 = new Room(1, 1);
        Room r2 = new Room(2, 5);
        Room r3 = new Room(3, 3);
        Room r4 = new Room(4, 4);

        if ((r1.toString().equals("Room number: 1 has room for 1 people.")) && (r2.toString().equals("Room number: 2 has room for 5 people.")) && (r3.toString().equals("Room number: 3 has room for 3 people.")) && r4.toString().equals("Room number: 4 has room for 4 people.")) {
            System.out.println("Test successfull");
        }
    }
}
