import java.util.*;

public class BucketSort {
   public static void bucketSort(int[] nums, int maxVal) {
      int[] buckets = new int[maxVal + 1];
      for (int num : nums) {
         buckets[num]++;
      }
      int i = 0;
      for (int j = 0; j < buckets.length; j++) {
         while (buckets[j] > 0) {
            nums[i++] = j;
            buckets[j]--;
         }
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int maxVal = sc.nextInt();
      int[] nums = new int[maxVal];
      for (int i = 0; i < maxVal; i++) {
         nums[i] = sc.nextInt();
      }
      bucketSort(nums, maxVal);
      for (int i = 0; i < maxVal; i++) {
         System.out.println(nums[i]);

      }
      sc.close();
   }
}