package tiendm.codefight.challenge.sep;

/**
 * @author tien.dinhmanh
 *
 */
public class TakingAttendance {
  int takingAttendance(String[] classList) {
    int sum = 0;
    for (String s : classList) {
      sum += caculateTakingAttendance(s);
    }
    return sum;
  }

  private int caculateTakingAttendance(String s) {
    int sum = 5;
    s = s.toLowerCase();
    s += "a";
    int count = isConsonant(s.charAt(0)) ? 1 : 0;
    for(int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if(isConsonant(c)) {
        count++;
      }else {
        if(count > 0) {
          sum += Math.pow(2, count-1);
        }
        count = 0;
      }
    }
    return sum;
  }

  boolean isConsonant(char x) {
    String notConsonant = "aeiouy";
    return notConsonant.indexOf(x) < 0;
  }

  public static void main(String[] args) {
    TakingAttendance a = new TakingAttendance();
    String[] s = {"Ashley", "Robert", "Miles", "Archibald", "Taylor", "Vanessa", "Isaac"};
    System.out.println(a.takingAttendance(s));
  }
}
