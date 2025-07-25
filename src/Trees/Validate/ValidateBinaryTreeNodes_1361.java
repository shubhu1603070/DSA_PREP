package Trees.Validate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinaryTreeNodes_1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (leftChild[i] < 0 || leftChild[i] >= n) {
                    return false;
                }
                inDegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                if (rightChild[i] < 0 || rightChild[i] >= n) {
                    return false;
                }
                inDegree[rightChild[i]]++;
            }
        }

        int rootCandidate = -1;
        int rootCount = 0;

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                rootCandidate = i;
                rootCount++;
            } else if (inDegree[i] > 1) {
                return false;
            }
        }

        System.out.println(Arrays.toString(inDegree));
        if (rootCount != 1) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(rootCandidate);
        visited[rootCandidate] = true;
        int visitedNodeCount = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visitedNodeCount++;
            int left = leftChild[currentNode];
            if (left != -1) {
                if (visited[left]) {
                    return false;
                }
                visited[left] = true;
                queue.offer(left);
            }
            int right = rightChild[currentNode];
            if (right != -1) {
                if (visited[right]) {
                    return false;
                }
                visited[right] = true;
                queue.offer(right);
            }
        }
        return visitedNodeCount == n;
    }

}
