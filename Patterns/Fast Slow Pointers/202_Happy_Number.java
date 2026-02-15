/*
Problem: Happy Number
Platform: LeetCode #202
Pattern: Two Pointers (Fast & Slow)
Difficulty: Easy

Approach 1 : Hashset
- use a hashset to store the squares
- calvulate the sum of squares repeatedly
- if we reach 1 , the number is Happy
- if any numbers repeat from the hashset -> it has a cycle -> nto Happy

TC : O(log n)
SC : O(log n)

Approach2 : Fast Slow pointers
- use two pointers:
   - slow moves 1 step (one square transformation)
   - fast moves 2 steps (two square transformation)
- if fast reach 1 -> happy number
- if slow == fast -> cycle -> not happy

TC : O(log n)
SC :(1)

Approach 3 : Recursion
- base case :
  - if n is 1 or 7 then true
  - if n is less than 10 and not 1 0r 7 -> never becoming 1 -> not Happy
- recursively compute square sum.


*/

class Solution {
  public boolean isHappyA(int n) {
    Set<Integer> squares = new HashSet<>();

    while (n != 1 && !squares.contains(n)) {
      squares.add(n);
      n = getSquare(n);
    }
    return n == 1;
  }

  public boolean isHappyB(int n) {
    int slow = n;
    int fast = getSquare(n);
    while (fast != 1 && slow != fast) {
      slow = getSquare(slow);
      fast = getSquare(getSquare(fast));
    }
    return fast == 1;
  }

  private int getSquare(int n) {
    int ans = 0;
    while (n > 0) {
      int d = n % 10;
      ans += d * d;
      n /= 10;
    }
    return ans;
  }

  public boolean isHappy(int n) {
    if (n == 1 || n == 7)
      return true;
    if (n < 10)
      return false;
    int sum = 0;
    while (n > 0) {
      int dig = n % 10;
      sum += dig * dig;
      n = n / 10;
    }
    return isHappy(sum);
  }
}
