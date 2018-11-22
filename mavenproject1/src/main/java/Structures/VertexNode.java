/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author raquelrojas
 */
import java.util.* ;

public class VertexNode {
    public int vertex;                    //Storage the vertex
    public boolean visited;            //Indicates if the vertex is visited or not
    public LinkedList <Node> edges;    //List of edges

    public VertexNode(){
        this.vertex = 0;
        this.visited = false;
        this.edges  = new LinkedList<>();
    }

    public VertexNode(int v){
            this.vertex = v;
            this.visited = false;
            this.edges  = new LinkedList<>();
    }

    public String toString(){
        return "|" + this.vertex + "|" + "|->";
    }//fin método aCadena
}
