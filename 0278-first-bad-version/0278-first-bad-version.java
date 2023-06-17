/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/**
 * 278. First Bad Version
 * Binary search. Blue and Red.
 * Time complexity: O(logN)
 * Space complexity: O(1)
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left + 1 != right) {
            int mid = left + ((right - left) >> 1);
            if (!isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}