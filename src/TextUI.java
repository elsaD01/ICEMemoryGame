import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TextUI {

    DatabaseUserIO databaseUserIO;

 public TextUI(DatabaseUserIO databaseUserIO){
     this.databaseUserIO= databaseUserIO;
 }

    public static void pickMenu(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Welcome to Memory Game ");
        System.out.println("Press 1 to login or press 2 to sign up");
        scanner.nextLine();
    }

   public void pickLevel(){//(ArrayList<Cards> cards){

        System.out.println("Choose level: ");

        Scanner scan = new Scanner(System.in);
        System.out.println("1-Easy");
        System.out.println("2-Medium");
        System.out.println("3-Hard");
        int input = scan.nextInt();

        if(input == 1){
            System.out.println("You chose level easy");
            Board board = new Board();
            int timeScore = board.levelOne();
            databaseUserIO.saveTimeScore(timeScore);

            //from array cards1
        } else if (input == 2) {
            System.out.println("You chose level medium");
            //from array cards2

        } else if (input == 3) {
            System.out.println("You chose level hard");
            //from array cards3

        }
    }


    public String getUserInput(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Hello. Would you like to: " + "\n" + "1) Log in or" + "\n" + "2) Create user?" + "\n" + "Please write 1 or 2 and press Enter:");
        return scanner.nextLine();
    }



    public void loginMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        String id = "";
        if(databaseUserIO.login(userName, password, id)){
            System.out.println("Welcome " + userName);
        }
        else{
            System.out.println("Sorry, the username or password is incorrect");
            loginMenu();
        }

    }


    public void createUserMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter a username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter a password: ");
        String password = scanner.nextLine();
        String id = "";
        if(databaseUserIO.createUser(userName, password, id)){
            System.out.println("Welcome " + userName);

        }
        else{
            System.out.println("Sorry, the username or password can not be used try agin:");
            createUserMenu();
        }
    }














}
