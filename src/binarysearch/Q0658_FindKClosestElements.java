package binarysearch;

import java.util.*;

public class Q0658_FindKClosestElements {
    // 658. Find K Closest Elements - Medium
    // https://leetcode.com/problems/find-k-closest-elements/

    /* ------------------------------------------------------------
       | PATTERN: Binary Search (pencere başlangıcı)
       ------------------------------------------------------------
       Sonuç ardışık k elemanlık bir pencere. Başlangıç indeksini [0, n-k] aralığında binary search ile ara:
       x - arr[mid] > arr[mid + k] - x ise pencere sağa kaymalı, değilse sol yarıda ara.
       Bulunan başlangıçtan k eleman döndür.
    */
    /*  Complexity
        Time  : O(log(n - k) + k)
        Space : O(1) (çıktı hariç)
    */

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // k uzunluğundaki pencerenin başlangıç indeksini binary search ile bul.
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1; // pencere sağa kaymalı
            } else {
                right = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) result.add(arr[i]);
        return result;
    }
}
