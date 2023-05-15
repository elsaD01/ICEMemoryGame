import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Cards {
   public static void main(String[] args) {

     // String[] card1 = new String[10]; //dyr & natur
      String[] card2 = new String[20]; //frugter & grøntsager
      String[] card3 = new String[30]; //hverdags ting

/*public Cards (String[] card1){
   this.card1 = card1;
   this.card1[0] = "Lion";
   this.card1[1] = "Tree";
   this.card1[2] = "Cat";
   this.card1[3] = "Flower";
   this.card1[4] = "Dog";
}
*/
      Scanner scanner = new Scanner(System.in);
      ArrayList<String> card1 = new ArrayList<>();
      card1.add("Lion");
      card1.add("Lion");
      card1.add("Tree");
      card1.add("Tree");
      Collections.shuffle(card1);

/*
   public getMatch () {
      return getMatch;
   }
*/

   }

}
