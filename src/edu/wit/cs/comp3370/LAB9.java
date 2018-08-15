package edu.wit.cs.comp3370;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* Calculates the minimal spanning tree of a graph 
 * 
 * Wentworth Institute of Technology
 * COMP 3370
 * Lab Assignment 9
 * 
 */

public class LAB9 {

    // TODO document this method
    public static void FindMST(Graph g) {
        // TODO generate edges from graph vertices
        Set<Edge> edges = new HashSet<>();
        for (Vertex sourceVertex : g.getVertices()) {
            for (Vertex destinationVertex : g.getVertices()) {
                if (sourceVertex.equals(destinationVertex)) {
                    continue;
                }

                Edge edge = computeEdge(sourceVertex, destinationVertex);
                if (edge.cost < g.epsilon) {
                    boolean added = edges.add(edge);
                    if (!added) {
                        System.out.println(edges);
                        System.out.println(edge);
                        System.out.println("");
                    }
                }
            }
        }

        System.out.println(edges);
        // TODO populate graph with MST edges
    }

    private static Edge computeEdge(Vertex source, Vertex destination) {
        double a = source.x - destination.x;
        double b = source.y - destination.y;
        double distance = Math.sqrt((a * a) + (b * b));
        return new Edge(source, destination, distance);
    }

    /********************************************
     * 
     * You shouldn't modify anything past here
     * 
     ********************************************/

    // reads in an undirected graph from a specific file formatted with one
    // x/y node coordinate per line:
    private static Graph InputGraph(String file1) {

        Graph g = new Graph();
        try (Scanner f = new Scanner(new File(file1))) {
            while (f.hasNextDouble()) // each vertex listing
                g.addVertex(f.nextDouble(), f.nextDouble());
        } catch (IOException e) {
            System.err.println("Cannot open file " + file1 + ". Exiting.");
            System.exit(0);
        }

        return g;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String file1;

        System.out.printf("Enter <points file> <edge neighborhood>\n");
        System.out.printf("(e.g: points/small .5)\n");
        file1 = s.next();

        // read in vertices
        Graph g = InputGraph(file1);
        g.epsilon = s.nextDouble();

        FindMST(g);

        s.close();

        System.out.printf("Weight of tree: %f\n", g.getTotalEdgeWeight());
    }

}
