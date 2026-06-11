package arrays.twopointers;


public class Q0011_ContainerWithMostWater {
    // 11. Container With Most Water - Medium
    // https://leetcode.com/problems/container-with-most-water/

    // -----------------------------------------------
    // |PATTERN: Two Pointers from Both Ends       ✅|
    // -----------------------------------------------
    /*
        Başlangıç:
            left = 0
            right = n - 1

        Her adımda alanı hesaplarız.
        Sonra kısa olan tarafı hareket ettiririz.

        Neden?
        Çünkü alanı sınırlayan şey:
            min(height[left], height[right])

        Eğer kısa olan tarafı sabit tutarsan, width azalır ve height limiti aynı kalır.
        Daha iyi alan bulma ihtimali yoktur.
    */
    /*
        Time: O(n)
        Space: O(1)
    */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
