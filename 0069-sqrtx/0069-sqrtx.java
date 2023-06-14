/**
 * 69. Sqrt(x)
 * Blue & Red / Binary search
 * N is the value of int x
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        
        int left = 1; // points to blue area, normally left = -1
        int right = x;  // points to red area, normally right = N
        
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            
            // isBlue = mid * mid <= x;
            // if isBlue(mid), then expand blue area(left) to mid
            if (mid <= x / mid) {
                left = mid;
                // if not isBlue(mid), then expand red area(right) to mid
            } else {
                right = mid;
            }
        }
        return left; // return blue
    }
}