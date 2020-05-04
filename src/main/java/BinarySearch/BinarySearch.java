package BinarySearch;

public class BinarySearch<T> {

  /** Recursive way of executing binary search */
  public boolean binarySearchRecursive(int[] array, int x, int min, int max) {
    if (min > max) {
      return false;
    }
    // calculate the mid point
    int mid = min + ((max - min) / 2); // handling any out of bounds error
    if (x < array[mid]) {
      return binarySearchRecursive(array, x, min, array[mid] - 1);
    } else if (x > array[mid]) {
      return binarySearchRecursive(array, x, array[mid] + 1, max);
    }
    return true;
  }

  public boolean binarySearchIterative(int[] array, int x) {
    int min = 0;
    int max = array.length - 1;

    while (min <= max) {
      // calculate the mid point
      int mid = min + ((max - min) / 2);
      if (array[mid] == x) {
        return true;
      } else if (array[mid] < x) {
        max = mid - 1;
      } else if (array[mid] > x) {
        min = mid + 1;
      }
    }

    return false;
  }
}
