// use deque can offer/peek/poll from both head and tail

public class Solution {
  private void inQue(Deque<Integer> deQue, int num) {
    // if the previous num is smaller than the current one
    // remove the previous num. since smaller previous number is not important
    // and in that case the largest one is alwasy at the head of the que.
    while (!deQue.isEmpty() && deQue.peekLast() < num) {
      deQue.pollLast();
    }
    deQue.offerLast(num);
  }

  private void outQue(Deque<Integer> deQue, int num) {
    // for every k-size window move, we will remove the left element from the window;
    // check wether the head of the queue is the left element of the window;
    // if yes, than remove. if no, that means it has already been ignored during inque process.
    if (deQue.peekFirst() == num) {
      deQue.pollFirst();
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int numLth = nums.length;
    int[] result =new int[numLth - k + 1];
    Deque<Integer> deQue = new ArrayDeque<>();

    for (int i = 0; i < numLth; i++) {
      // no action for adding to result and outQue during first window session;
      inQue(deQue, nums[i]);
      if (i >= k - 1) {
        result[i - k + 1] = deQue.peekFirst();
        outQue(deQue, nums[i - k + 1]);
      }
    }
    return result;
  }
}
