package Task_Conferance;

public class Reservation {
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
