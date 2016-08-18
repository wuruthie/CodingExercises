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
}
