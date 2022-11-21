package com.nyit.assginment_2;

import java.util.ArrayList;
import java.util.List;

/*
    find MST by Kruskal’s Algorithm

    Author:Wenjia Wang
 */
public class KruskalAlgorithm {
    private static int MAX = Integer.MAX_VALUE;
    int[][] matrixOne;
    int[][] matrixTwo;
    int[][] matrixThree;
    int[] points;
    ArrayList<Node[]> listOne;
    ArrayList<Node[]> listTwo;
    ArrayList<Node[]> listThree;


    public KruskalAlgorithm() {
//        Init the graph_1
        matrixOne = new int[][]{
                {MAX, 2, MAX, 1, 4, MAX},
                {2, MAX, 3, 3, MAX, 7},
                {MAX, 3, MAX, 5, MAX, 8},
                {1, 3, 5, MAX, 9, MAX},
                {4, MAX, MAX, 9, MAX, MAX},
                {MAX, 7, 8, MAX, MAX, MAX},
        };
        listOne = new ArrayList<Node[]>();
        listOne.add(new Node[]{}); //0-null
        listOne.add(new Node[]{new Node(5, 4), new Node(4, 1), new Node(2, 2)}); //1-5-4-2
        listOne.add(new Node[]{new Node(1, 2), new Node(4, 3), new Node(3, 3), new Node(6, 7)}); //2-1-4-3-6
        listOne.add(new Node[]{new Node(4, 5), new Node(2, 4), new Node(6, 8)}); //3-4-2-6
        listOne.add(new Node[]{new Node(5, 9), new Node(1, 1), new Node(2, 3), new Node(3, 5)}); //4-5-1-2-3
        listOne.add(new Node[]{new Node(4, 9), new Node(1, 4)}); //5-4-1
        listOne.add(new Node[]{new Node(3, 8), new Node(2, 7)}); //6-3-2
//        listOne.add(new Node[]{}); //last-null

//        Init the graph_2
        matrixTwo = new int[][]{
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
        listTwo = new ArrayList<Node[]>();
        listTwo.add(new Node[]{new Node(1, 4), new Node(7, 8)}); //0-1-7
        listTwo.add(new Node[]{new Node(0, 4), new Node(7, 11), new Node(2, 8)}); //1-0-7-2
        listTwo.add(new Node[]{new Node(1, 8), new Node(8, 2), new Node(3, 7)}); //2-1-8-3
        listTwo.add(new Node[]{new Node(2, 7), new Node(5, 14), new Node(4, 9)}); //3-2-5-4
        listTwo.add(new Node[]{new Node(3, 9), new Node(5, 10)}); //4-3-5
        listTwo.add(new Node[]{new Node(6, 2), new Node(2, 4), new Node(3, 7), new Node(4, 10)}); //5-6-2-3-4
        listTwo.add(new Node[]{new Node(7, 1), new Node(8, 6), new Node(5, 2)}); //6-7-8-5
        listTwo.add(new Node[]{new Node(0, 8), new Node(1, 11), new Node(8, 7), new Node(6, 1)}); //7-0-1-8-6
        listTwo.add(new Node[]{new Node(7, 7), new Node(2, 2), new Node(6, 6)}); //8-7-2-6


//        Init the graph_3
        matrixThree = new int[][]{
                {MAX, 28, MAX, MAX, MAX, 10, MAX},
                {28, MAX, 16, MAX, MAX, MAX, 14},
                {MAX, 16, MAX, 12, MAX, MAX, MAX},
                {MAX, MAX, 12, MAX, 22, MAX, 18},
                {MAX, MAX, MAX, 22, MAX, 25, 24},
                {10, MAX, MAX, MAX, 25, MAX, MAX},
                {MAX, 14, MAX, 18, 24, MAX, MAX},
        };
        listThree = new ArrayList<Node[]>();
        listThree.add(new Node[]{}); //0-null
        listThree.add(new Node[]{new Node(6, 10), new Node(2, 28)}); //1-6-2
        listThree.add(new Node[]{new Node(1, 28), new Node(7, 14), new Node(3, 16)}); //2-1-7-3
        listThree.add(new Node[]{new Node(2, 16), new Node(4, 12)}); //3-2-4
        listThree.add(new Node[]{new Node(5, 22), new Node(7, 18), new Node(3, 12)}); //4-5-7-3
        listThree.add(new Node[]{new Node(6, 25), new Node(7, 24), new Node(4, 22)}); //5-6-7-4
        listThree.add(new Node[]{new Node(1, 10), new Node(5, 25)}); //6-1-5
        listThree.add(new Node[]{new Node(5, 24), new Node(4, 18), new Node(2, 14)}); //7-5-4-2
//        listThree.add(new Node[]{}); //last-null
    }

    public static void main(String[] args) {
        KruskalAlgorithm ka = new KruskalAlgorithm();
        System.out.println("Graph 1");
//        ka.findMinimumSpanningTreebyGraph(ka.matrixOne, 1);
        ka.findMinimumSpanningTreebyList(ka.listOne, 1);
        System.out.println("Graph 2");
//        ka.findMinimumSpanningTreebyGraph(ka.matrixTwo);
        ka.findMinimumSpanningTreebyList(ka.listTwo);
        System.out.println("Graph 3");
//        ka.findMinimumSpanningTreebyGraph(ka.matrixThree, 1);
        ka.findMinimumSpanningTreebyList(ka.listThree, 1);
    }

    private void findMinimumSpanningTreebyGraph(int[][] graph) {
        this.findMinimumSpanningTreebyGraph(graph, 0);
    }

    private void findMinimumSpanningTreebyGraph(int[][] graph, int index) {
//        Print title
        System.out.println("Edges in Spanning Tree | Cost");
//        Init all points
        points = new int[graph.length];
        int lowest = 0;
        for (int i = 0; i < points.length; i++)
            points[i] = i;
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

    private void findMinimumSpanningTreebyList(ArrayList<Node[]> list) {
        this.findMinimumSpanningTreebyList(list, 0);
    }

    private void findMinimumSpanningTreebyList(ArrayList<Node[]> list, int index) {
//        Print title
        System.out.println("Edges in Spanning Tree | Cost");
        int lowest = 0;
        int begin = index;
//        Init all points
//        points = (index == 0) ? (new int[list.size()]) : (new int[list.size() - 1]);
        points = new int[list.size()];
        for (int i = 0; i < points.length; i++)
            points[i] = i;
        int maxEdge = (begin == 0) ? (points.length - 1) : (points.length - 2);
        for (int edge = 0; edge < maxEdge; edge++) {
            int low = MAX, p1 = -1, p2 = -1;
            for (int i = 0; i < list.size(); i++) {
                Node[] nodes = list.get(i);
                if (nodes.length == 0)
                    continue;
                for (int j = 0; j < nodes.length; j++) {
                    Node node = nodes[j];
                    if (findRoot(i) != findRoot(node.destination) && node.value < low) {
                        low = node.value;
                        p1 = i;
                        p2 = node.destination;
                    }
                }
            }
            merge(p1, p2);
            System.out.println("   " + (p1) + " -> " + (p2) + "    |    " + low);
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

    class Node {
        int destination = -1;
        int value = -1;

        Node(int dest, int val) {
            this.destination = dest;
            this.value = val;
        }

    }

}
