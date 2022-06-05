package ReservationProjectRemake;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    private static ArrayList<Passenger> passengerList;
    private static Passenger currentPassenger = null;
    private final static Scanner A = new Scanner(System.in);

    public static void main(String[] args) {

        passengerList = new ArrayList<>();
        System.out.println("1) Add a new passenger"
                + "\n2) Add a reservation for an existing passenger"
                + "\n3) Display a reservation\n4) Cancel a reservation\n5) Login\n6) Quit");

        while (true) {

            System.out.print("\nSelect an option : ");
            int option = A.nextInt();

            switch (option) {
                case 1:
                    addNewPassenger();
                    break;
                case 2:
                    if (currentPassenger != null) {
                        addReservation();
                    } else {
                        if (login()) {
                            addReservation();
                        }
                    }
                    break;

                case 3:
                    displayReservation();
                    break;
                case 4:
                    if (currentPassenger != null) {
                        cancelReservation();
                    } else {
                        if (login()) {
                            cancelReservation();
                        }
                    }

                    break;
                case 5:
                    login();
                    break;
                case 6:
                    System.out.println("Quitting...");
                    System.exit(0);

                default:
                    System.out.println("Wrong option.. Please select valid option.");
                    break;
            }
        }
    }

    public static void addNewPassenger() {

        System.out.print("Name : ");
        String name = A.next();
        System.out.print("Adress : ");
        String adress = A.next();
        System.out.print("Phone : ");
        String phone = A.next();
        System.out.print("Password : ");
        int password = A.nextInt();

        Passenger newPassenger = new Passenger(name, adress, phone, password);
        passengerList.add(newPassenger);
    }

    public static void addReservation() {
        System.out.print("Choose your seat type : ");
        String typeOfSeats = A.next();

        System.out.print("How many seats do you want to reserve : ");
        int numberOfSeats = A.nextInt();

        System.out.println(currentPassenger.AddReservation(typeOfSeats, numberOfSeats));
    }

    public static void displayReservation() {
        System.out.print("Enter your ID : ");
        int ID = A.nextInt();

        for (int i = 0; i < passengerList.size(); i++) {
            if (passengerList.get(i).getAccountID() == ID) {
                Passenger p = passengerList.get(i);

                ArrayList<Reservation> passengerReservation = p.getListOfReservation();
                for (Reservation reservation : passengerReservation) {
                    if (reservation != null) {
                        System.out.println(reservation.toString());
                    }
                }
            }
        }
    }

    public static void cancelReservation() {
        System.out.print("Enter your reservation code in order to display your reservation : ");
        int reservationCode = A.nextInt();
        boolean temp = true;

        for (int i = 0; i < currentPassenger.getListOfReservation().size(); i++) {

            if (currentPassenger.getListOfReservation().get(i) != null) {
                currentPassenger.getListOfReservation().get(i).cancelMe();
                currentPassenger.getListOfReservation().set(i, null);
                temp = false;
                break;
            }
        }
        if (temp) {
            System.out.println("It is not valid reservation code...");
        }
    }

    public static boolean login() {
        System.out.print("Enter your ID : ");
        int id = A.nextInt();
        System.out.print("Enter your password : ");
        String password = A.next();

        for (int i = 0; i < passengerList.size(); i++) {
            if (passengerList.get(i).getAccountID() == id) {
                if (passengerList.get(i).Login(password)) {
                    currentPassenger = passengerList.get(i);
                    System.out.println("You have logged in...");
                    return true;
                }
            }
        }
        System.out.println("Your ID or Password is not correct...");
        return false;
    }
}
