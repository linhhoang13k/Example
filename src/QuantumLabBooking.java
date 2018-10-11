package tiendm.codefight.challenge.oct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tien.dinhmanh
 *
 */
public class QuantumLabBooking {
  int quantumLabBooking(int[][] friends, int firstInLine, int k) {
    Queue<Integer> q = new LinkedList<>();
    List<Integer> lsBooking = new ArrayList<>();
    q.add(firstInLine);
    lsBooking.add(firstInLine);
    while (!q.isEmpty() && lsBooking.size() <= k) {
      int cur = q.poll();
      for(int i = 0; i < friends.length; i++) {
        if(friends[cur][i] == 1) {
          q.add(i);
          lsBooking.add(i);
        }
      }
    }
    if(lsBooking.size() <= k) return -1;
    return lsBooking.get(k);
  }
  public static void main(String[] args) {
    int[][] friends = { {1,1,1}, 
                        {1,0,0}, 
                        {0,1,1}};
    QuantumLabBooking q = new QuantumLabBooking();
    System.out.println(q.quantumLabBooking(friends, 1, 10));
  }
}
