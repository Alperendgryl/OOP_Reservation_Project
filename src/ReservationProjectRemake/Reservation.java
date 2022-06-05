package ReservationProjectRemake;

import java.util.Date;

public class Reservation {

    private static int totalRegularSeats = 500;
    private static int totalFirstClassSeats = 50;

    private String typeOfReservation = "Regular";
    private int reservationCode;

    private int numberOfSeats = 1;

    private final String from = "A";
    private final String to = "B";
    private final Date reservationDate;

    public Reservation() {
        this.reservationDate = new Date("June 13, 2021 16:00:00");
        this.reservationCode = createReservationCode();
    }

    public Reservation(int numberOfSeats, String typeOfReservation) {
        
        this.reservationCode = createReservationCode();
        this.reservationDate = new Date("June 13, 2021 16:00:00");
        
        this.numberOfSeats = numberOfSeats;
        
        if(typeOfReservation.equals("Regular") || typeOfReservation.equals("FirstClass")){
            this.typeOfReservation = typeOfReservation;
        }
    }

    private int createReservationCode() {
        int rc = (int) (Math.random() * 100000);
        System.out.println("Reservation code is : " + rc);
        return rc;
    }
    
    public void cancelMe() {
        
        if(typeOfReservation.equals("Regular")){
            setTotalRegularSeats(getTotalRegularSeats() + numberOfSeats);
            System.out.println(getTotalRegularSeats()+" Regular seats left.");
        }
        
        if(typeOfReservation.equals("FirstClass")){
            setTotalFirstClassSeats(getTotalFirstClassSeats()+ numberOfSeats);
            System.out.println(getTotalFirstClassSeats()+" First Class seats left.");
        }
    }

    @Override
    public String toString() {
        return "From : " + this.from + "\nTo : " + this.to + 
                "\nReservation Date : " + this.reservationDate + 
                "\nNumber of seats : " + this.numberOfSeats + 
                "\nSeat type : " + this.typeOfReservation + 
                "\nReservation Code : " + this.reservationCode;
    }

    public static void setTotalRegularSeats(int totalRegularSeats) {
        Reservation.totalRegularSeats = totalRegularSeats;
    }

    public static int getTotalRegularSeats() {
        return totalRegularSeats;
    }

    public static void setTotalFirstClassSeats(int totalFirstClassSeats) {
        Reservation.totalFirstClassSeats = totalFirstClassSeats;
    }

    public static int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }
    
    public int getReservationCode() {
        return reservationCode;
    }
}
