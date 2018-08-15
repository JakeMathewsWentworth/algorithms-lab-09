package edu.wit.cs.comp3370;

public class Edge {

    @Override
    public boolean equals(Object e1) {
        if (e1 == null || !(e1 instanceof Edge)) {
            return false;
        }
        Edge edge = (Edge) e1;
        boolean case1 = this.src.equals(edge.src) && this.dst.equals(edge.dst);
        boolean case2 = this.src.equals(edge.dst) && this.dst.equals(edge.src);
        ;
        boolean cost = this.cost == edge.cost;
        return (case1 || case2) && cost;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.src != null ? this.src.hashCode() : 0);
        hash = 53 * hash + (this.dst != null ? this.dst.hashCode() : 0);
        hash = (int) (27 * hash + cost);
        return hash;
    }

    @Override
    public String toString() {
        return "[cost: " + cost + ", src: " + src + ", dst: " + dst + "]";
    }

    /********************************************
     * 
     * You shouldn't modify anything past here
     * 
     ********************************************/

    public Vertex src;
    public Vertex dst;
    public double cost;

    // creates an edge between two vertices
    Edge(Vertex s, Vertex d, double c) {
        src = s;
        dst = d;
        cost = c;
    }

}
