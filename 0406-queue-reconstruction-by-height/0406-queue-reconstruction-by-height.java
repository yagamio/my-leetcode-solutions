/**
 * 406. Queue Reconstruction by Height
 * Greedy
 * N is the length of int[][] people
 * Time complexity: O(N^2)
 * Space complexity: O(N)
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0] == null) return new int[0][0];
        Arrays.sort(people, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][2]);
    }
}