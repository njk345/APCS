//NICK KEIRSTEAD

public class Day {
  public static void main(String[] args) {
    int startDay = 0;
    System.out.println(dayOfWeek(startDay,1));
    System.out.println(dayOfWeek(startDay,7));
  }
  public static int dayOfWeek(int dayOfWeek1, int day) {
    int rawDay = (Math.abs(day-1)) % 7;
    int shiftedDay = (dayOfWeek1 + rawDay) % 7;
    return shiftedDay;
  }
}
