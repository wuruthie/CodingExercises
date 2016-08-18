import java.util.HashMap;
import java.util.Arrays;

public class Cracking{
  public static void main(String args[]){
    // System.out.println(isAnagram("Cat", "Tac"));
    // System.out.println(isAnagram("Fac", "Tac"));
    // System.out.println(isAnagram("Catttt", "Tac"));
    // System.out.println(isAnagram("!!!!", "!!!!"));
    // System.out.println(isAnagram("Ca!", "!ac"));
    //int[] unsorted = new int[]{5,3,7,10,3,5};
    //String sorted = Arrays.toString(dupeSelectionSort(unsorted));
    //System.out.println(sorted);
    //String testOne = "Mr John Smith      ";
    //System.out.println(urlify(testOne, 13));
  }

  public static boolean isAnagram(String one, String two){
    //Q: Is it just alphabetical or alphanumeric //ascii?
      if(one.length() < 1 || two.length() < 1){ //if either are empty
        return false;
      }
      if(one.length() != two.length()){ //lengths are not the same
        return false;
      }

      //key = character value = count
      HashMap<Character, Integer> hashOne = new HashMap<Character, Integer>();
      HashMap<Character, Integer> hashTwo = new HashMap<Character, Integer>();

      int length = one.length();

      for(int i = 0; i < length; i++){
        char currentOne = one.charAt(i);
        char currentTwo = one.charAt(i);
        if(hashOne.containsKey(currentOne)){
          int oldCount = hashOne.get(currentOne);
          int newCount = oldCount++;
          hashOne.put(currentOne, newCount);
        } else{
        hashOne.put(currentOne, 1);
      }
      if(hashTwo.containsKey(currentTwo)){
        int oldCount = hashTwo.get(currentTwo);
        int newCount = oldCount++;
        hashTwo.put(currentTwo, newCount);
      } else{
      hashTwo.put(currentTwo, 1);
    }
  }

  return hashOne.equals(hashTwo);
}

//Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//column is set to 0.
public void setZero(int[][] matrix){
  int length = matrix.length();
  int[] row = new int[length];
  int[] col = new int[length];
  for(int i = 0; i < length; i++){ //for every column
    for(int j = 0; j < matrix[0].length(); j++){ //for every row
      if(matrix[i][j] == 0){
        row[i] = 1;
        col[j] = 1;
      }
    }
    for(int k = 0; k < length; k++){
      for(int l = 0; l < matrix[0].length();l++){
        if(row[k] == 1 || col[l] == 1){
          matrix[i][j] = 0;
        }
      }
    }
  }
}

// Assume you have a method isSubstring which checks if one word is a substring of
//another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
//only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
public boolean isRotation(String a, String b){
  int length = a.length;
  if(length == b.length && length > 0){
    String aa = a + a;
    return isSubstring(aa, b);
  }
  return false;
  }

//Given an array of integers, sort it and return duplicates in order
//selection sort
  public static int[] dupeSelectionSort(int[] sortedInts){
  //  int min = sortedInts[0];
    int smallestIndex = 0;
    for(int i = 0; i < sortedInts.length-1; i++){
      for(int j = i+1; j < sortedInts.length; j++){
        if(sortedInts[j] < sortedInts[smallestIndex]){
        //  min = sortedInts[j];
          smallestIndex = j;
      }
    }
      int temp = sortedInts[i];
      sortedInts[i] = sortedInts[smallestIndex];
      sortedInts[smallestIndex] = temp;
    }
    return sortedInts;
  }

//write a method to replace all spaces in a string with "%20"
  public static String urlify(String s, int length){
    int endOfString = length;
    char[] unmodified = s.toCharArray();
    for(int i = 0; i < length; i++){
      if(unmodified[i] == ' '){
        for(int j = endOfString; j > i; j--){ //from the space to the end of the string
         unmodified[j+2] = unmodified[j]; //move all characters by the length of the sequence to be added
        }
        unmodified[i] = '%';
        unmodified[i+1] = '2';
        unmodified[i+2] = '0';
      }
    }
    String output = new String(unmodified);
    return output;
  }

// child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
// 3 steps at a time. Implement a method to count how many possible ways the
//child can run up the stairs.
public static int stairPaths(int steps, int[] map){
  if(n < 0){
    return 0;
  }else if(n == 0){
    return 1;
  } else if(map[n] > -1){
    return map[n];
  }else{
    map[n] = stairPaths(n-3, map)
             + stairPaths(n-2, map)
             + stairPaths(n-1, map);
    return map[n];
  }
}

}
