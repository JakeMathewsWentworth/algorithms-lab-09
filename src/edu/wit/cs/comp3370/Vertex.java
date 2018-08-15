package edu.wit.cs.comp3370;

// represents a vertex in a graph, including a unique ID to keep track of vertex
public class Vertex {

    @Override
    public boolean equals(Object e1) {
        if (e1 == null || !(e1 instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) e1;
        boolean x = this.x == vertex.x;
        boolean y = this.y == vertex.y;
        boolean id = this.ID == vertex.ID;
        return x && y && id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = (int) (53 * hash + x);
        hash = (int) (53 * hash + y);
        return hash;
    }

    @Override
    public String toString() {
        return "[ID: " + ID + ", x: " + x + ", y: " + y + "]";
    }

    /********************************************
     * 
     * You shouldn't modify anything past here
     * 
     ********************************************/

    public double x;
    public double y;
    public int ID;
}
