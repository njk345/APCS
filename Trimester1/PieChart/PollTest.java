//NICK KEIRSTEAD

import java.util.Random;

public class PollTest {
  public static void main (String[] args) {
    PollDisplayPanel votingMachine = new PollDisplayPanel("Tami", "Brian", "Liz");
    Random rgen = new Random();
    for (int i = 0; i < 1000; i++) {
       int r = rgen.nextInt(3); //random int between 0 and 2 inclusive
       if (r == 0) {
           votingMachine.vote1();
       }
       else if (r == 1) {
           votingMachine.vote2();
       }
       else {
           votingMachine.vote3();
       }
    }
    
    System.out.println(votingMachine.toString());
  }
}
