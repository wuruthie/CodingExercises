
public class DynamicProgramming{
  public static void main(String[] args) {
    System.out.println(minToOne(7));
    System.out.println(bottomUpMinToOne(7));
    int[] m = new int[100];
    System.out.println(waysUpStairs(4,m));

    int[] coins = {1,3,5};
    System.out.println(coinSum(coins));
  }
  //On a positive integer, you can perform any one of the following 3 steps.
  //1.) Subtract 1 from it. ( n = n - 1 )
  // 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )
  //3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  )
  //Now the question is, given a positive integer n, find the minimum number of steps
  //that takes n to 1
  public static int minToOne(int n){
    int[] memo = new int[n+1]; //Java initializes all indices in an array automatically to zero.

    if(n==1){ return 0; }
    if(memo[n] != 0){ return memo[n]; } //already solved problem

    int r = 1 + minToOne(n-1);

    if(n%2 == 0){ r = Math.min(r, 1+ minToOne(n/2)); }
    if(n%3 == 0){ r = Math.min(r, 1+ minToOne(n/3)); }
    memo[n] = r; //save the result
    return r;
  }

  public static int bottomUpMinToOne(int n){
    int i = 0;
    int[] dp = new int[n+1];

    dp[1] = 0;
    for(i = 2; i <= n; i++){
      dp[i] = 1 + dp[i-1];
      if(i%2 == 0){ dp[i] = Math.min(dp[i], 1 + dp[i/2]); }
      if(i%3 == 0){ dp[i] = Math.min(dp[i], 1 + dp[i/3]); }
    }
    return dp[n];
  }

  //A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
  // Implement a method to count how many possible ways the child can run up the stairs.
  public static int waysUpStairs(int steps, int[] memo){
    if(steps < 0){
       return 0;
    }else if(steps == 0){
      return 1;
    }else if(memo[steps] != 0){
      return memo[steps];
    }else{
      memo[steps] = waysUpStairs(steps-1, memo) + waysUpStairs(steps-2, memo) + waysUpStairs(steps-3, memo);
    }
    return memo[steps];
  }

//Imagine a robot sitting on the upper left corner of an X by Ygrid.
//The robot can only move in two directions: right and down.
//How many possible paths are there for the robot to go from (0, 0) to (X, Y) ?
// public static int roboPaths(int[][] grid){
//   if(validPath())
// }
//
// public static boolean validPath(int x, int y, int gridHeight, int gridWidth){
//   if(x + 1 > gridWidth || y + 1 > gridHeight){
//     return false;
//   }
//   return true;
// }

//Given a list of N coins, their values (V1, V2, … , VN), and the total sum S.
//Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want),
//or report that it’s not possible to select coins in such a way that they sum up to S.
public static int coinSum(int coins, int totalSum){
  int[] minCoins = new int[totalSum];
  for(int i = 0; i < totalSum; i++){ //setting all indices to "infinity"
    minCoins[i] = null;
  }

  min[0] = 0;
  for(int j = 1; j <= totalSum; j++){
    for(int k = 0; k < coins.length(); k++){
      if(coins[k] <= j && minCoins[j - coins[k]] + 1 < minCoins[j]){
        minCoins[j] = minCoins[j - coins[k]] + 1;
      }
    }
  }
  return minCoins[totalSum];
}
}
