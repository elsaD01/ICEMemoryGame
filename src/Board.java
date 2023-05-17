import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Board {
    ArrayList <String> Cards = new ArrayList <String> ();


    public Board() {

    }

        public int levelOne()  {
            long start = System.currentTimeMillis();

            //arrays with the parameters from card class.
            Scanner scanner = new Scanner(System.in);
            Card [] cards1 = new Card[12];
            cards1[0]=new Card("002_The_lion_king_Snyggve_in_the_Serengeti_National_Park_Photo_by_Giles_Laurent.jpg","lion");
            cards1[1]=new Card("002_The_lion_king_Snyggve_in_the_Serengeti_National_Park_Photo_by_Giles_Laurent.jpg","lion");

            cards1[2]=new Card("14552305_max.jpg","pig");
            cards1[3]=new Card("14552305_max.jpg","pig");

            cards1[4]=new Card("download (3).jpg","Sheep");
            cards1[5]=new Card("download (3).jpg","Sheep");

            cards1[6]=new Card("download (2).jpg","dogs");
            cards1[7]=new Card("download (2).jpg","dogs");

            cards1[8]=new Card("download (1).jpg","cat");
            cards1[9]=new Card("download (1).jpg","cat");
            cards1[10]=new Card("download","cow");
            cards1[11]=new Card("download", "cow");

            // this is doring random of the cards
            Collections.shuffle(Arrays.asList(cards1));

            // board is use for what can you se on the board
            String[] pictures = new String[cards1.length];
            String[] board = new String[cards1.length];


            int pairsFound = 0;     // tælle variable der tjekker om der er stik

            while (pairsFound < (cards1.length/2)) {
                printBoard(board);

                // This tjek if the first number is allowed. and it turns around the first card.
                int firstTry = getCardIndex(scanner, cards1, "Enter index of first card to flip:");
                board[firstTry] = cards1[firstTry].getDescription();
                cards1[firstTry].cardFlipped = true;
                printBoard(board);

                // This tjek if the second number is allowed. and it turns around the second card.
                int secondTry = getCardIndex(scanner, cards1, "Enter index of second card to flip:");
                board[secondTry] = cards1[secondTry].getDescription();
                cards1[secondTry].cardFlipped = true;
                printBoard(board);

                // tjek if the first card and the second card match
                if ( cards1[firstTry].getDescription().equals( cards1[secondTry].getDescription() ) ) {
                    System.out.println("You found a pair!");
                    pairsFound++;

                } else {
                    System.out.println("Sorry, those cards don't match."); // if they don't match, it turns it back
                    board[firstTry] = "    ";
                    board[secondTry] = "    ";
                    cards1[firstTry].cardFlipped = false;
                    cards1[secondTry].cardFlipped = false;
                }
            }
            // win
            System.out.println("Congratulations, you won!");
            // this it the timer - it counts in seconds
            long finish = System.currentTimeMillis();
            long timeElapsed = (finish - start)/1000;

            System.out.println(timeElapsed + " Seconds");
            return (int) timeElapsed;

        }
        public static int getCardIndex(Scanner scanner, Card[] cards, String prompt)
        {     // this metode tjeks if the number the user input is vallid
            int index;
            while (true) {
                System.out.println(prompt);
                index = scanner.nextInt();
                if (index < 0 || index >= cards.length) {
                    System.out.println(
                            "Invalid index, try again.");
                }
                else if (cards[index].cardFlipped) {
                    System.out.println(
                            "Card already flipped, try again.");
                }
                else {
                    break;
                }
            }
            return index;
        }

        //It prints cards description of the picture
        public static void printBoard(String[] board)
        {
            for (int i = 0; i < board.length; i++) {
                System.out.print("| " + board[i] + " ");
            }
            System.out.println("|");
        }
    }


