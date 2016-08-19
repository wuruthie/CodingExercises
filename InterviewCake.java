import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;
public class InterviewCake{
  public static void main(String[] args) {
    int[] stockPricesYesterday = {10, 7, 5, 8, 11, 9};
    System.out.println(getMaxProfit(stockPricesYesterday));

    int[] productOfOtherNumbers = {-10,-10,1,3,2};
    int[] products = getProduct(productOfOtherNumbers);
    for(int i = 0; i < productOfOtherNumbers.length; i++){
      System.out.println(products[i]);
    }
    System.out.println(highestProduct(productOfOtherNumbers));
  }
  public static int getMaxProfit(int[] stockPricesYesterday){
    if(stockPricesYesterday.length < 2){
    return 0;
    }
    int minPrice = stockPricesYesterday[0];
    int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

    for(int i = 1; i < stockPricesYesterday.length; i++){
      int currentPrice = stockPricesYesterday[i];

      int potentialProfit = currentPrice - minPrice;

      maxProfit = Math.max(maxProfit, potentialProfit);

      minPrice = Math.min(minPrice, currentPrice);
    }
    return maxProfit;
  }

  public static int[] getProduct (int[] arr){
    int len = arr.length;
    int[] allOtherProducts = new int[len];
    int productSoFar = 1;
    for(int i = 0; i < len; i++){ //accumulating products before each index
      allOtherProducts[i] = productSoFar;
      productSoFar *= arr[i];
    }

    productSoFar = 1;
    for(int j = len-1; j >= 0; j--){
      allOtherProducts[j] *= productSoFar;
      productSoFar *= arr[j];
    }
    return allOtherProducts;
  }

  //Given a list_of_ints, find the highest_product you can get from three
  //of the integers.
  public static int highestProduct(int[]list_of_ints){
    int highest_product_of_three = list_of_ints[0] * list_of_ints[1] * list_of_ints[2];
    int highest_product_of_2 = list_of_ints[0] * list_of_ints[1];
    int highest = Math.max(list_of_ints[0], list_of_ints[1]);
    int lowest_product_of_2 = list_of_ints[0] * list_of_ints[1];
    int lowest = Math.min(list_of_ints[0], list_of_ints[1]);

    for(int i = 0; i < list_of_ints.length; i++){
      int current = list_of_ints[i];
      highest = Math.max(current, highest);
      lowest = Math.min(current, lowest);
      lowest_product_of_2 = Math.min(lowest_product_of_2, lowest * current);
      highest_product_of_2 = Math.max(highest_product_of_2, highest * current);
      highest_product_of_three = Math.max(highest_product_of_three,Math.max(highest_product_of_2 * current, lowest_product_of_2 * current));
    }
    return highest_product_of_three;
  }

  public class Meeting {

  int startTime;
  int endTime;

  public Meeting(int startTime, int endTime) {
      // number of 30 min blocks past 9:00 am
      this.startTime = startTime;
      this.endTime   = endTime;
  }

  public String toString() {
      return String.format("(%d, %d)", startTime, endTime);
  }
}

public static List<Meeting> condenseMeetingTimes(List<Meeting> meetings){
  List<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);
  Collections.sort(sortedMeetings, new Comparator<Meeting>(){
    public int compare(Meeting one, Meeting two){
      return one.startTime - two.startTime;
    }
  });

  List<Meeting> mergedMeetings = new ArrayList<Meeting>();
  mergedMeetings.add(sortedMeetings.get(0));

  for(Meeting currentMeeting : sortedMeetings){
    Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);
    if(isMergeable(lastMergedMeeting, currentMeeting)){
      lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);
    }else{
    mergedMeetings.add(currentMeeting);
  }
}
return mergedMeetings;
}

public static boolean isMergeable(Meeting one, Meeting two){
  if(one.endTime >= two.startTime){
    return true;
  }else{
    return false;
  }
}
}
