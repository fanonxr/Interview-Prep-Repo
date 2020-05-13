package TimePlanner;

class Solution {

  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // create our two pointers to keep track and compare
    int slotsAPointer = 0;
    int slotsBPointer = 0;

    // progress until either pointer reaches the end of the list
    while (slotsAPointer < slotsA.length && slotsBPointer < slotsB.length) {
      // get the biggest start time between the two slots
      int start = Math.max(slotsA[slotsAPointer][0], slotsB[slotsBPointer][0]);
      // get the smallest end time between the two slots
      int end = Math.min(slotsA[slotsAPointer][1], slotsB[slotsBPointer][1]);
      // check if the start time + duration of meeting is less than or equal to the end time
      if (start + dur <= end) return new int[]{start, start + dur};

      // check which start time is the smallest and increment the pointer
      if (slotsA[slotsAPointer][1] < slotsB[slotsAPointer][1]) slotsAPointer++;
      else slotsBPointer++;
    }
    // if none, just return an empty array
    return new int[]{};
  }

  public static void main(String[] args) {
  }

}
