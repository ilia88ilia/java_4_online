package ua.com.illia;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Graph {

    private final Map<String, Integer> nodes = new TreeMap<>();
    private final int[][] evaluations;

    public Graph(int size) {
        evaluations = new int[size][size];
    }

    public static int[] findCheapestWay(int source, int[][] evaluations) {
        boolean[] visited = new boolean[evaluations.length];
        Arrays.fill(visited, false);

        int[] costs = new int[evaluations.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[source] = 0;

        for (int i = 0; i < evaluations.length - 1; i++) {
            int minCost = findMinCost(visited, costs);
            visited[minCost] = true;
            for (int j = 0; j < visited.length; j++) {
                if (!visited[j] && evaluations[minCost][j] != 0) {
                    int temp = costs[minCost] + evaluations[minCost][j];
                    if (temp < costs[j]) {
                        costs[j] = temp;
                    }
                }
            }
        }
        return costs;
    }

    private static int findMinCost(boolean[] visited, int[] costs) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && costs[i] < min) {
                min = costs[i];
                index = i;
            }
        }
        return index;
    }

    public void addNode(int id, String name) {
        if (nodes.containsKey(name)) {
            throw new SecurityException();
        }
        nodes.put(name, id);
    }

    public void addWay(int from, int to, int cost) {
        if (from < 0 || to < 0 || cost < 0) {
            throw new SecurityException();
        }
        evaluations[from][to] = cost;
    }

    public int cityIndex(String name) {
        return nodes.get(name);
    }

    public int[][] getEvaluations() {
        return evaluations;
    }
}