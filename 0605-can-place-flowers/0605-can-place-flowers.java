/**
 * 605. Can Place Flowers
 * N is the length of int[] flowerbed
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Core idea is to count the number of consecutive zeros and count new plants
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numOfZeros = 1; // starts with 1
        int totalNewPlants = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int newPlants = 0;
            while (i <= flowerbed.length - 1 && flowerbed[i] == 0) {
                i++;
                numOfZeros++;
                if (i == flowerbed.length) numOfZeros++;
            }
            if (numOfZeros % 2 == 0) {
                newPlants = (numOfZeros - 2) / 2;
            } else {
                newPlants = (numOfZeros - 1) / 2;
            }
            totalNewPlants += newPlants;
            if (totalNewPlants >= n) return true;
            numOfZeros = 0;      
        }
        return false;
    }
}