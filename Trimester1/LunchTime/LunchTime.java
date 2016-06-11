//NICK KEIRSTEAD
//I am assuming throughout this program, for convenience, that
//time is measured on a 24-hour cycle (rather than A.M./P.M.)

import java.util.Scanner;

public class LunchTime {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter Current Time (hh:mm): ");

    String inputTime = s.next();

    int breakIndex = inputTime.indexOf(":");
    int hour = Integer.parseInt(inputTime.substring(0,breakIndex));
    int min = Integer.parseInt(inputTime.substring(breakIndex+1));
    
    System.out.println(minutesUntilLunch(hour,min));
  }
  public static int minutesUntilLunch(int hour, int min) {
    //measuring the difference in times in terms of the #minutes
    //of each time since 0:00
    int minSinceStart = hour * 60 + min; 
    //min since 0:00 of inputted time

    int minTilLunch;
    if (minSinceStart > 13 * 60) {
      minTilLunch = 24 * 60 - minSinceStart;
      //first add minutes diff. from inputted time to midnight
      minTilLunch += 13 * 60;
      //then add minutes diff. from midnight to 1 pm
    }
    else minTilLunch = 13 * 60 - minSinceStart;
    
    return minTilLunch;
  }
}
