package dynamicprogramming;

import java.util.ArrayList;

public class Dp {

  static int climbingStairs(int n) {
    if(n == 1)
      return 1;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for(int i = 2; i < n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n-1];
  }

  static int houseRobber(int[] nums) {
    if(nums.length == 0)
      return 0;
    int[] dp = new int[nums.length+1];
    dp[0] = 0;
    dp[1] = nums[0];
    for(int i = 2; i <= nums.length; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
    }
    return dp[nums.length];
  }


  static String[] composeRanges(int[] nums) {
    if(nums.length == 0)
      return new String[0];

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    ArrayList<String> r = new ArrayList<>();
    r.add(Integer.toString(nums[0]));
    int j = 0;
    int i = 2;
    for(i = 1; i < nums.length; i++) {
      dp[i] = nums[i];
      if(nums[i] - dp[i-1] > 1) {
        String s = r.remove(j++) + "->" + Integer.toString(dp[i-1]);
        r.add(s);
        r.add(Integer.toString(nums[i]));
      }
    }
    if(nums[i-1] - nums[i-2] == 1) {
      String s = r.remove(j++) + "->" + Integer.toString(dp[i-1]);
      r.add(s);
    }
    return r.toArray(new String[0]);
  }

  static int mapDecoding(String message) {
    int prev = 0, count = 0, curr = 1;

    for (int i = 0; i < message.length(); i++) {
      int digit = message.charAt(i) - 48;
      int number = 0;

      if(i > 0)
        number = (message.charAt(i - 1) - 48) * 10 + digit;
      if(digit > 0)
        count = curr;
      if(number <= 26 && number > 9)
        count += prev;

      prev = curr;
      curr = count % 1000000007;
      count = 0;

    }
    return curr;
  }

    public static void main(String[] args) {
    int[] nums = {-111, -110, 112};
    String[] s = composeRanges(nums);
    for (String str:
         s) {
      System.out.println(str);
    }
  }

}
