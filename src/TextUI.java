import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    Scanner scanner;

    public String pickMenu(){
        System.out.println("Welcome to Memory Game ");
        System.out.println("Press 1 to login or press 2 to sign up");
        return scanner.nextLine();
    }

    public void pickLevel(ArrayList<Cards> cards){

        System.out.println("Choose level: ");

        Scanner scan = new Scanner(System.in);
        System.out.println("1-Easy");
        System.out.println("2-Medium");
        System.out.println("3-Hard");
        int input = scan.nextInt();

        if(input == 1){
            System.out.println("You chose level easy");
            //from array cards1
        } else if (input == 2) {
            System.out.println("You chose level medium");
            //from array cards2

        } else if (input == 3) {
            System.out.println("You chose level hard");
            //from array cards3

        }
    }

}
