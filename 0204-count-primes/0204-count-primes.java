/**
 * 204. Count Primes
 * Sieve of Eratosthenes
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrimes = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            for (long j = (long) i * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }
}