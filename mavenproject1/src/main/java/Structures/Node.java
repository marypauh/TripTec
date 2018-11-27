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
public class Node {
    public int vertex;        //Save the vertex
    public int weight;        //Save the vertex weight of the edge

    //Nonde constructor
    public Node(){
        this.vertex = 0;
        this.weight = 0;
    }

    public Node(int  site, int p){
        this.vertex = site;
        this.weight = p;
    }

    public String toString(){
        return "|" + this.vertex + "|" + this.weight + "|->";
    }
}

