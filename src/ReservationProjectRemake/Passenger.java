package ReservationProjectRemake;

import java.util.ArrayList;

public class Passenger {

    private final String name;
    private final String phoneNumber;
    private final String adress;
    private final int accountID;

    private Password password;
    private ArrayList<Reservation> listOfReservation;

    public Passenger(String name, String adress, String phoneNumber, int password) {
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.password = new Password(password);
        this.accountID = (int) (Math.random() * 1000000);
        this.listOfReservation = new ArrayList<>();

        System.out.println("Your account ID is: " + this.accountID);
    }

    @Override
    public String toString() {
        return "Name : " + name + "\nPhone number : " + phoneNumber + "\nAdress : " + adress
                + "\nPassword : " + password;
    }

    public boolean Login(String password) {
        int pwd = Integer.valueOf(password);
        return this.password.checkPassword(pwd);
    }

    public String AddReservation(String typeOfSeats, int numberOfSeats) {

        if (typeOfSeats.equals("Regular")) {

            if (Reservation.getTotalRegularSeats() - numberOfSeats > 0) {
                Reservation regular = new Reservation(numberOfSeats, typeOfSeats);
                listOfReservation.add(regular);
                int seatLeft = (Reservation.getTotalRegularSeats() - numberOfSeats);
                System.out.println(seatLeft + " regular seats left.");
                Reservation.setTotalRegularSeats(seatLeft);
                return "Your reservation code is : " + regular.getReservationCode();
            }
        }

        if (typeOfSeats.equals("FirstClass")) {

            if (Reservation.getTotalFirstClassSeats()- numberOfSeats > 0) {
                Reservation firstClass = new Reservation(numberOfSeats, typeOfSeats);
                listOfReservation.add(firstClass);
                int seatLeft = (Reservation.getTotalFirstClassSeats() - numberOfSeats);
                System.out.println(seatLeft + " first class seats left.");
                Reservation.setTotalFirstClassSeats(seatLeft);
                return "Your reservation code is : " + firstClass.getReservationCode();
            }
        }
        return "Not enough seats left.";
    }

    public void DisplayReservation(int reservationCode) {
        for (int i = 0; i < listOfReservation.size(); i++) {
            if (listOfReservation.get(i).getReservationCode() != reservationCode) {
                System.out.println(listOfReservation.get(i).toString());
                break;
            }
        }
    }

    public void CancelReservation(int reservationCode) {
        for (int i = 0; i < listOfReservation.size(); i++) {
           if (listOfReservation.get(i).getReservationCode() != reservationCode) {
                listOfReservation.get(i).cancelMe();
                break;
            }
        }
    }
    
    public int getAccountID() {
        return accountID;
    }
    
    public ArrayList<Reservation> getListOfReservation() {
        return listOfReservation;
    }
}
