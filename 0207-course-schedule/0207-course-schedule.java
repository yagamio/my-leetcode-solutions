/**
 * 207. Course Schedule
 * DFS ---> topology sort of graph.
 * v is the number of courses. e is the number of prerequisites.
 * Time complexity: O(v + e).
 * Space complexity: O(v + e).
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // !!! Not "graph.get(i).add()"
        }

        // Store subsequent courses in the graph
        for (int[] prerequisite : prerequisites) {
            int courseA = prerequisite[0];
            int courseB = prerequisite[1];
            graph.get(courseB).add(courseA);
        }

        // Array to store the status of course
        // 0 for not visited; 1 for visting; 2 for visited
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visited[i] = 0;
        }

        // Check if each course can be studied (if circle exists)
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCircle(i, visited, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCircle(int course, int[] visited, List<List<Integer>> graph) {
        visited[course] = 1; // Set status as visiting
        
        // Check subsequent courses by recursion
        for (int nextCourse : graph.get(course)) {
            if (visited[nextCourse] == 1) return true; // If visited, circle exists
            if (visited[nextCourse] == 0 && hasCircle(nextCourse, visited, graph)) return true;
        }
        visited[course] = 2;
        
        return false;
    }
}