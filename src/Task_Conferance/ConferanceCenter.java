package Task_Conferance;

import java.util.ArrayList;

public class ConferanceCenter {
    private ArrayList<Room> rooms = new ArrayList<>();

    public boolean registerRoom(int roomNr, int amPeople){
        for(int i = 0; i<rooms.size(); i++){
            if(roomNr == rooms.get(i).getRoomNr()){
                return false;
            }
        }
        rooms.add(new Room(roomNr, amPeople));
        return true;
    }

    public int getAmRooms(){
        return rooms.size();
    }

    public Room findRoomWithIndex(int index){
        if(index >= rooms.size() || index < 0){
            return null;
        }else{
            return rooms.get(index);
        }
    }

    public Room findRoomWithNumber(int number){
        Room theRoom = null;
        for(int i = 0; i<rooms.size(); i++ ){
            if(rooms.get(i).getRoomNr() == number){
                theRoom = rooms.get(i);
            }
        }
        return theRoom;
    }
    //Remake this method
    public boolean reserveRoom(ResTime startTime, ResTime endTime, int amPeople, String name, String tlf) {
        Customer theCustomer = new Customer(name, tlf);
        Task_Conferance.Reservation theReservation = new Task_Conferance.Reservation(startTime, endTime, theCustomer);
        if (name == null || tlf == null || name.trim().isEmpty() || tlf.trim().isEmpty()) {
            throw new IllegalArgumentException("Name or phone number cannot be null or empty.");
        }
        for (Room r : rooms) {
            if (r.getAmPeople() == amPeople) {
                if (r.reserveRoom(theReservation, amPeople))  return true;
            }
        }
        return true;
    }


    public String allReservations(){
        String res = "";
        for(int i=0; i<rooms.size(); i++){
            res += "Room number: " + rooms.get(i).getRoomNr() + "\n" + rooms.get(i).retReservations();
        }
        return res;
    }

    public static class Reservation {
        private final ResTime fromTime;
        private final ResTime toTime;
        private final Customer customer;

        public Reservation(ResTime fromTime, ResTime toTime, Customer customer){
            if(fromTime == null || toTime == null){
                throw new IllegalArgumentException("From-time and/or to-time is null");
            }
            if(fromTime.compareTo(toTime) >= 0){
                throw new IllegalArgumentException("FromTime is the same or after to-time");
            }
            if(customer == null){
                throw new IllegalArgumentException("Customer is null");
            }
            this.fromTime = fromTime;
            this.toTime = toTime;
            this.customer = customer;
        }

        public ResTime getFromTime(){
            return fromTime;
        }

        public ResTime getToTime(){
            return toTime;
        }

        public boolean checkDoubleRes(ResTime checkFromTime, ResTime checkToTime){
            return (checkToTime.compareTo(fromTime) > 0 && checkFromTime.compareTo(toTime) < 0);
        }

        public String toString(){
            return "Kustomer: " + customer.getName() + ", tlf: " + customer.getTlf() + ", from " + fromTime.toString() + ", to " + toTime.toString();
        }
    }
}
