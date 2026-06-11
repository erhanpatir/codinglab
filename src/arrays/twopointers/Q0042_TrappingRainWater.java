package arrays.twopointers;

public class Q0042_TrappingRainWater {
    // 42 - Trapping Rain Water - Hard
    // https://leetcode.com/problems/trapping-rain-water/
    // --------------------------------------------
    // |PATTERN: Two Pointers + Running Max     ✅|
    // --------------------------------------------
    /*
        İki pointer:
            left = 0
            right = n - 1

        İki max:
            leftMax
            rightMax

        Kural:
            height[left] < height[right]  ise sol tarafı işleriz.

        Çünkü sağda en az height[right] kadar bir boundary olduğunu biliyoruz.
        Bu durumda sol tarafta tutulacak suyu belirleyen şey leftMax olur.
    */
    /*
        Complexity Analysis
        Time: O(n)
        Space: O(1)
    */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    public static int trap2(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;

        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
    /* Dry run: [3,0,2,0,4]
        height   = [3,0,2,0,4]

        leftMax  = [3,3,3,3,4]
        rightMax = [4,4,4,4,4]

        Şimdi her index:

        i=0: min(3,4)-3 = 0
        i=1: min(3,4)-0 = 3
        i=2: min(3,4)-2 = 1
        i=3: min(3,4)-0 = 3
        i=4: min(4,4)-4 = 0

        Toplam:

        7
        Complexity
        Time: O(n)
        Space: O(n)

        Bu çözüm interview’da tamamen kabul edilebilir.
        Two pointer optimal versiyon sadece space’i O(1) yapıyor.
    */
}
