/**
 * 210. Course Schedule II
 * n is the number of courses. m is the number of prerequisites.
 * Time complexity: O(n + m).
 * Space complexity: O(n + m).
 */
class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // create an adjacency list to store the outgoing edges.
        List<List<Integer>> outEdges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            outEdges.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses]; // new int array to store indegree.

        // fill in outEdges and indegree by iterating prerequisites.
        for (int[] pre : prerequisites) {
            int courseA = pre[0];
            int courseB = pre[1];
            outEdges.get(courseB).add(courseA);
            indegree[courseA]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        int completeCourses = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course; // 注意这里将int添加到int数组的方式，是通过下标，而不是append
            completeCourses++;
            for (int nextCourse : outEdges.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        if (completeCourses != numCourses) return new int[0];
        return result;
    }

}