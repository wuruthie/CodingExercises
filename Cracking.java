import java.util.HashMap;

public class Cracking{
  public static void main(String args[]){
    System.out.println(isAnagram("Cat", "Tac"));
    System.out.println(isAnagram("Fac", "Tac"));
    System.out.println(isAnagram("Catttt", "Tac"));
    System.out.println(isAnagram("!!!!", "!!!!"));
    System.out.println(isAnagram("Ca!", "!ac"));
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
  int length = matrix.length;
  int[] row = new int[length];
  int[] col = new int[length];
  for(int i = 0; i < length; i++){ //for every column
    for(int j = 0; j < matrix[0].length; j++){ //for every row
      if(matrix[i][j] == 0){
        row[i] == 1;
        col[j] == 1;
      }
    }
    for(int k = 0; k < length; k++){
      for(int l = 0; l < matrix[0].length){
        if(row[k] == 1 || col[l] == 1){
          matrix[i][j] == 0;
        }
      }
    }
  }
}
}
