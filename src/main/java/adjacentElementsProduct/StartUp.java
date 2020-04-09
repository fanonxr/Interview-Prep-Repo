package adjacentElementsProduct;

public class StartUp {
  public static void main(String[] args) {
    int[] testArray = {3, 6, -2, -5, 7,3};
    int testElement = adjacentElementsProduct(testArray);
    System.out.println("Answer is: " + testElement);
  }

  public static int adjacentElementsProduct(int[] inputArray) {
    int product = inputArray[0] * inputArray[1];

    for (int i = 1; i < inputArray.length - 1; i++) {
      int newProduct = inputArray[i] * inputArray[i + 1];
      // check to see if the product is bigger than the first product
      if (product < newProduct) {
        product = newProduct;
      }
    }
    return product;
  }
}


