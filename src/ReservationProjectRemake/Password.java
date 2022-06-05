package ReservationProjectRemake;

import java.util.Scanner;

public class Password {

    private int realPass;

    public Password(int realPass) {
        if (passwordValidate(realPass)) {
            this.realPass = realPass;
        } else {
            int randomPass = generateRandomPass();

            while (!passwordValidate(randomPass)) {
                randomPass = generateRandomPass();
            }

            this.realPass = randomPass;
            System.out.println("Your new random password is : " + getRealPass());
        }
    }
    public boolean passwordValidate(int password) {

        if (password / 100000 == 0) {
            return false;
        }
        if (password % 100000 == 0) {
            return false;
        }

        return true;
    }

    public boolean checkPassword(int password) {
        return this.realPass == password;
    }

    public int generateRandomPass() {

        int randomPass = (int) (Math.random() * 1000000);
        return randomPass;
    }

    public void resetPassword() {
        Scanner A = new Scanner(System.in);
        System.out.print("Enter your new password : ");
        int newPass = A.nextInt();

        boolean temp = true;

        while (temp) {
            if (passwordValidate(newPass)) {
                this.realPass = newPass;
                System.out.println("Password has been uptaded. New password is : " + this.realPass);
            }
            if (temp) {
                System.out.println("Enter a valid password.");
                newPass = A.nextInt();
            }
        }
    }

    public int getRealPass() {
        return realPass;
    }

}
