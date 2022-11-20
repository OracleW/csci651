package com.nyit.assginment_2;

/*
    find MST by Kruskal’s Algorithm

    Author:Wenjia Wang
 */
public class KruskalAlgorithm {
    private static int MAX = Integer.MAX_VALUE;
    int[][] graphOne;
    int[][] graphTwo;
    int[][] graphThree;
    int[] points;

    public KruskalAlgorithm() {
//        Init the graph_A
        graphOne = new int[][]{
                {MAX, 2, MAX, 1, 4, MAX},
                {2, MAX, 3, 3, MAX, 7},
                {MAX, 3, MAX, 5, MAX, 8},
                {1, 3, 5, MAX, 9, MAX},
                {4, MAX, MAX, 9, MAX, MAX},
                {MAX, 7, 8, MAX, MAX, MAX},
        };
//        Init the graph_B
        graphTwo = new int[][]{
                {MAX, 4, MAX, MAX, MAX, MAX, MAX, 8, MAX},
                {4, MAX, 8, MAX, MAX, MAX, MAX, 11, MAX},
                {MAX, 8, MAX, 7, MAX, 4, MAX, MAX, 2},
                {MAX, MAX, 7, MAX, 9, 14, MAX, MAX, MAX},
                {MAX, MAX, MAX, 9, MAX, 10, MAX, MAX, MAX},
                {MAX, MAX, 4, 14, 10, MAX, 2, MAX, MAX},
                {MAX, MAX, MAX, MAX, MAX, 2, MAX, 1, 6},
                {8, 11, MAX, MAX, MAX, MAX, 1, MAX, 7},
                {MAX, MAX, 2, MAX, MAX, MAX, 6, 7, MAX}
        };
//        Init the graph_C
        graphThree = new int[][]{
                {MAX, 28, MAX, MAX, MAX, 10, MAX},
                {28, MAX, 16, MAX, MAX, MAX, 14},
                {MAX, 16, MAX, 12, MAX, MAX, MAX},
                {MAX, MAX, 12, MAX, 22, MAX, 18},
                {MAX, MAX, MAX, 22, MAX, 25, 24},
                {10, MAX, MAX, MAX, 25, MAX, MAX},
                {MAX, 14, MAX, 18, 24, MAX, MAX},
        };
    }

    public static void main(String[] args) {
        KruskalAlgorithm ka = new KruskalAlgorithm();
        System.out.println("Graph 1");
        ka.findMinimumSpanningTreebyGraph(ka.graphOne, 1);
        System.out.println("Graph 2");
        ka.findMinimumSpanningTreebyGraph(ka.graphTwo);
        System.out.println("Graph 3");
        ka.findMinimumSpanningTreebyGraph(ka.graphThree, 1);
    }

    private void findMinimumSpanningTreebyGraph(int[][] graph) {
        this.findMinimumSpanningTreebyGraph(graph, 0);
    }

    private void findMinimumSpanningTreebyGraph(int[][] graph, int index) {
//        Init all points
        points = new int[graph.length];
        int lowest = 0;
        for (int i = 0; i < points.length; i++)
            points[i] = i;
//        Print title
        System.out.println("Edges in Spanning Tree | Cost");
        for (int edge = 0; edge < points.length - 1; edge++) {
            int low = MAX, p1 = -1, p2 = -1;
            for (int v = 0; v < points.length; v++) {
                for (int h = 0; h < points.length; h++) {
                    if (findRoot(v) != findRoot(h) && graph[v][h] < low) {
                        low = graph[v][h];
                        p1 = v;
                        p2 = h;
                    }
                }
            }
            merge(p1, p2);
            System.out.println("   " + (p1 + index) + " -> " + (p2 + index) + "    |    " + low);
            lowest += low;
        }
        System.out.println("Total lowest cost: " + lowest);
    }

//    Tools fun
    private int findRoot(int point) {
        return (point == points[point]) ? (point) : (findRoot(points[point]));
    }

    private void merge(int p1, int p2) {
        int i = findRoot(p1);
        int j = findRoot(p2);
        points[i] = j;
    }
}
