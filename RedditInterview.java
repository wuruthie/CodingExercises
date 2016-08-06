import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class RedditInterview{
  public static class Pair<L,R> {
    private L l;
    private R r;
    public Pair(L l, R r){
        this.l = l;
        this.r = r;
    }
    public L getL(){ return l; }
    public R getR(){ return r; }
    public void setL(L l){ this.l = l; }
    public void setR(R r){ this.r = r; }
}
  public static void main(String[] args) {
    // int[] test1 = {3,4,5,4,1};
    // int[] test2 = {3,4,5,6,1};
    // System.out.println(mostInt(test1));
    // System.out.println(mostInt(test2));
    //
    // int[] test3 = {0,5,16,5,7,2,8,3,10};
    // List<Pair> printOut = tenPair(test3);
    // for(int i = 0; i < printOut.size(); i++){
    //   System.out.println("{" + printOut.get(i).getL() + "," + printOut.get(i).getR() + "}");
    // }
    //
    // int[] test4 = {1,2,3,5,6,7,8};
    // int[] test5 = {5,5,5,5,5,5,5};
    // System.out.println(isRotated(test4,test5));
    //
    // System.out.println(fibIterative(8));
    // System.out.println(fibRecursion(8));
    // System.out.println(fibDynamic(8));
    //
    // int[] test6 = {2,3,5,7,3,2,5,6,6,6};
    // System.out.println(loneElement(test6));
    //
    // List<Integer> commonElemList = commonElem(test6, test5);
    // for(int i = 0; i < commonElemList.size(); i++){
    //   System.out.println(commonElemList.get(i));
    // }

    int[] test7 = {1,2,3,4,5,6,7,90};
    System.out.println(binSearchSorted(test7, 90));
  }

  //Find the most frequent integer in an array
  public static int mostInt(int[] arr){
    List<Integer> intList = new ArrayList<Integer>();
    for (int index = 0; index < arr.length; index++)
      {
        intList.add(arr[index]);
      }
      Collections.sort(intList);
      int max = 0;
      int maxFreq = 0;
      int temp = 0;
      for(int i = 0; i < intList.size() - 1; i++){
        if(max < temp){
          max = temp;
          maxFreq = intList.get(i);
        }
        if(intList.get(i) == intList.get(i+1)){
          temp++;
        } else if(intList.get(i) != intList.get(i+1)){ //switching to new set of ints
          max = temp;
          temp = 1;
        }
      }
      return maxFreq;
  }

  //Find pairs in an integer array whose sum is equal to 10 (bonus: do it in linear time)
  public static List<Pair> tenPair(int[] arr){
    List<Pair> pairList = new ArrayList<Pair>();
    List<Integer> intList = new ArrayList<Integer>();
    for(int i = 0; i < arr.length; i++){
      intList.add(arr[i]);
    }
    Collections.sort(intList); //sorted arrayList
    for(int j = 0; j < intList.size(); j++){
      int diff = 10-intList.get(j);
      if(intList.contains(diff)){
        Pair newPair = new Pair(intList.get(j), diff);
        pairList.add(newPair);
      }
    }
    return pairList;
  }

  //Given 2 integer arrays, determine of the 2nd array is a rotated version of the 1st array.
  //Ex. Original Array A={1,2,3,5,6,7,8} Rotated Array B={5,6,7,8,1,2,3}
  public static boolean isRotated(int[] arr1, int[] arr2){
    if(arr1.length != arr2.length){
      return false;
    }
    StringBuilder string1 = new StringBuilder();
    StringBuilder string2 = new StringBuilder();
    for(int i = 0; i < string1.length(); i++){
      string1.append(arr1[i]);
      string2.append(arr2[i]);
    }
    String a = string1.toString();
    String b = string2.toString();
    return ((a+a).indexOf(b) != -1);
  }

  //Write fibbonaci iteratively and recursively (bonus: use dynamic programming)
  public static int fibIterative(int n){
    int curr = 1;
    int next = 1;
    int temp = 0;
    for(int i = 1; i < n; i++){
      temp = next;
      next = curr + next;
      curr = temp;
    }
    return curr;
  }

  public static int fibRecursion(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fibRecursion(n-1) + fibRecursion(n-2);
  }

  public static int fibDynamic(int n){
    int[] fib = new int[n+1];
    if(n == 0) return 0;
    if(n == 1) return 1;
    if(fib[n] != 0) return fib[n];
    fib[n] = fibDynamic(n-1)+fibDynamic(n-2);
    return fib[n];
  }

  //Find the only element in an array that only occurs once.
  public static int loneElement(int[] arr){
    List<Integer> intList = new ArrayList<Integer>();
    for(int i = 0; i < arr.length; i++){
      intList.add(arr[i]);
    }
    Collections.sort(intList);
    int loneElem = 0;
    int count = 0;
    for(int j = 0; j < intList.size() - 1; j++){
      if(count > 1 && intList.get(j) != intList.get(j+1)){
        count = 0;
        loneElem = intList.get(j+1);
      }
      if(intList.get(j) == intList.get(j+1)){
        count++;
      }
    }
    return loneElem;
  }

  //Find the common elements of 2 int arrays
  public static List<Integer> commonElem(int[] arr1, int[] arr2){
    List<Integer> commonElements = new ArrayList<Integer>();
    HashMap compareOne = new HashMap<Integer, Integer>();
    for(int i = 0; i < arr1.length; i++){
      compareOne.put(arr1[i], 1);
    }

    for(int j= 0; j < arr2.length; j++){
      if(compareOne.get(arr2[j]) != null){
        commonElements.add(arr2[j]);
      }
    }
    return commonElements;
  }

  //Implement binary search of a sorted array of integers
  public static int binSearchSorted(int[] arr, int key){
    int mid = arr.length/2;
    int right = mid + 1;
    int left = mid - 1;
    int index = 0;
    if(key > arr[mid]){
      for(int j = right; j < arr.length; j++){
        if(key == arr[j]){
          index = j;
        }
      }
    } else if(key < arr[mid]){
      for(int k = 0; k < left; k++){
        if(key == arr[k]){
          index = k;
        }
      }
    } else if(key == mid){
      index = mid;
    }
    return index;
  }

  //Implement binary search in a rotated array
  public static int binSearchRotated(int[] arr, int key){
    int rotateIndex = 0;
    int index = 0;
    for(int i = 0; i < arr.length-1; i++){
      if(arr[i] > arr[i+1]){
        rotateIndex = i;
        break;
      }
    }

    if(key == arr[rotateIndex]){
      return rotateIndex;
    } else if(key < arr[rotateIndex]){
      for(int k = rotateIndex + 1; k < arr.length; k++){
        if(key == arr[k]){
          index = k;
          break;
        }
      }
      for(int m = 0; m < rotateIndex; m++){
        if(key == arr[m]){
          index = m;
          break;
        }
      }
    } else {
      return -1; //key cannot be greater than rotate index (end of the array)
    }
    return index;
  }
}
