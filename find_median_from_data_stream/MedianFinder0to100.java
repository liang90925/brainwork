
// use priority queue
// time complexity: addNum -> O(log(n)); getMedian -> O(1)


// Time complexity O(5*Log(n)) + O(1) At worst case, there are three heap insertions and two heap deletions.
// Space Complexity O(n) linear space to hold input in containers

// If all integer numbers from the stream are between 0 and 100, how would you optimize it?
public class MedianFinder0to100 {
  private final int[] bucket = new int[101];
  private int totalNum = 0;
  // Add a number into the data structure;
  public void addNum(int num) {
    bucket[num]++;
    totalNum++;
  }

  // returns the median of current data stream
  public double findMedian() {
    int temSum = 0;
    int first = (totalNum + 1) / 2;
    int second = totalNum % 2 == 0 ? first + 1 : first;

    for (int i = 0; i < bucket.length; i++) {
      temSum += bucket[i];
      if (temSum == first) {
        if (first == second) {
          return i;
        } else {
          for (int j = i +1; j < bucket.length; j++) {
            if (bucket[j] != 0) {
              return (double) (i + j) / 2;
            }
          }
        }
        return i;
      } else if (temSum > first){
        return i;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    MedianFinder0to100 medianFinder0to100 = new MedianFinder0to100();
    medianFinder0to100.addNum(1);
    medianFinder0to100.addNum(2);
    System.out.println(medianFinder0to100.findMedian());
    medianFinder0to100.addNum(3);
    System.out.println(medianFinder0to100.findMedian());
    medianFinder0to100.addNum(3);
    System.out.println(medianFinder0to100.findMedian());

    medianFinder0to100.addNum(4);
    System.out.println(medianFinder0to100.findMedian());

    medianFinder0to100.addNum(5);
    System.out.println(medianFinder0to100.findMedian());

  }
}



// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
