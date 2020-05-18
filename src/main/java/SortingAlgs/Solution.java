package SortingAlgs;

public class Solution {
  public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
    int[] sortedArr = bubbleSort(arr);
    printArray(sortedArr, sortedArr.length);
  }

  public static int[] bubbleSort(int[] arr) {
    // creating a flag to check if its sorted
    boolean isSorted = false;
    // we know that once we make an iteration the last element will be sorted
    int lastUnsorted = arr.length - 1;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < lastUnsorted; i++) {
        if (arr[i] > arr[i + 1]) {
          swapElements(arr, i, i + 1);
          isSorted = false;
        }
      }
    }
    return arr;
  }

  public static void insertionSort(int[] arr) {
    int n = arr.length; // getting the length of the array
    // looping over the entire contents of the array
    for (int i = 1; i < n; i++) {
      int key = arr[i]; // getting the value at the current index
      int j = i - 1; // the value we will be comparing to the currnet index

      // check to see if the value at the current index is greater than the value in the previous index;
      while (j >= 0 && arr[i] > key) {
        // swap the elements
        arr[j + 1] = arr[j];
        j = j - 1;
      }

      arr[j + 1] = key;
    }
  }

  private static void swapElements(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Function to print an array
  static void printArray(int[] arr, int size) {
    int i;
    for (i = 0; i < size; i++) System.out.print(arr[i] + " ");
    System.out.println();
  }
}
