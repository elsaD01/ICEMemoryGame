import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Cards {

   String [] card1 = new String[15];
   String [] card2 = new String[20];
   String [] card3 = new String [30];

   //public getMatch () {
      //return getMatch;

   public static void main (String[] args){
     File file = new File("Card1.csv");
     try {
        Scanner inputStream = new Scanner(file);
        while (inputStream.hasNext()) {
            String data = inputStream.next();
            System.out.println(data + "");
                    }
        inputStream.close();
     } catch (FileNotFoundException e) {
        e.printStackTrace();
     }


   }



}



