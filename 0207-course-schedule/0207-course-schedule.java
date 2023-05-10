/**
 * 207. Course Schedule
 * n is the number of courses. m is the number of prerequisites.
 * Time complexity: O(n + m).
 * Space complexity: O(n + m).
 */
class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int nextCourse : outEdges.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return count == numCourses;
    }

}