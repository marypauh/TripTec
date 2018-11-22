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
import java.util.*;

public class Graph {
    public LinkedList <VertexNode> vertex;  //Lista de vértices del grafo


    //Constructor del grafo
    public Graph(){
        this.vertex = new LinkedList<>();
    }

    //Método para agregar un vértice al grafo
    public void addVertex(int v){
        vertex.add(new VertexNode(v));  //Agrega el vértice al final de la lista de vértices
    }

    //Método para agregar una arista al grafo
    public void addEdge(int origen, int destino, int peso){
        searchVertex(origen).edges.add(new Node(destino, peso));  //Buscar el vértice origen y agrega un nodo al final de la lista de aristas de ese vértice
    }

    //Método para buscar un vértice en la lista de vertices del grafo según el dato indicado
    public VertexNode searchVertex(int v){
        //Recorre la lista de vertices
        for(int i = 0; i < this.vertex.size(); i++){
            if(this.vertex.get(i).vertex == v)  //Si encuentra el vértice lo retorna
                return this.vertex.get(i);
        }
        return null;
    }

    //Método para buscar una arista en la lista de aristas
    public Node searchEdge(int origin, int destination){
        VertexNode temp = searchVertex(origin);  //Busca el vértice de origen
        //Busca en la lista de aristas de ese vértice para identificar si se encuentra la arista buscada
        for(int i = 0; i < temp.edges.size(); i++){
            if(temp.edges.get(i).vertex == destination){
                return temp.edges.get(i);
            }
        }
        return null;
    }


    //Método para buscar el primer vértice del grafo que esté sin visitar
    public VertexNode searchNoVisitedVertex(){

        //Recorre la lista de vértices
        for(int i = 0; i < this.vertex.size(); i++){
            if(!this.vertex.get(i).visited ){ //Si encuentra una no visitado lo retorna
                return this.vertex.get(i);
            }
        }
        return null; //Si todos están visitados retorna null
    }

    //Método para imprimir el grafo recorriendo la lista de vértices y por cada vértice imprimiendo la lista de aristas que tiene
    public void printGraph(){
        VertexNode actual;
        for(int i = 0; i < this.vertex.size(); i++){
            actual = vertex.get(i);
            System.out.println("Vertice : " + actual.vertex);
            for(int j = 0; j < actual.edges.size(); j++){
                System.out.println("Arista de "+actual.vertex+ " a " + actual.edges.get(j).vertex + " con peso " + actual.edges.get(j).weight);
            }
        }
    }

    //Método para inicializar todos los nodos como no visitados
    public void initializeVisited(){
        for(int i = 0; i < this.vertex.size(); i++)
            this.vertex.get(i).visited = false;
    }

    //Método para verificar si todos los nodos del grafo están visitados
    public boolean allVisited(){
        for(int i = 0; i < this.vertex.size(); i++){
            if(!this.vertex.get(i).visited)    //Si encuentra uno sin visitar retorna false
                return false;
        }
        return true;    //Si encuentra uno visitado retorna true
    }

    //Método para eliminar un vértice del grafo
    public void deleteVertex(int v){
        this.vertex.remove(searchVertex(v));  //Elimina el vértice de la lista de vértices
        //Elimina todas las aristas en las que el vértice eliminado aparezca como destino
        for(int i = 0; i < vertex.size(); i++)
            removeEdge(vertex.get(i).vertex, v);
    }

    //Método para eliminar una arista de un vértice origen a un vértice destino dado
    public void removeEdge(int origin, int destination){
        //Verifica si el grafo es no dirigido
        if((searchEdge(origin,destination) != null) && (searchEdge(destination,origin) != null)){ //Busca si existe arista de origen a destino y viceversa
            //Verifica si el peso de ambas aristas es igual con lo que se asume que es un grafo no dirigido
            if(searchEdge(origin,destination).weight == searchEdge(destination,origin).weight){
                searchVertex(destination).edges.remove(searchEdge(destination, origin));
            }
        }
        //Elimina el arista de la lista de aristas del vértice origen
        searchVertex(origin).edges.remove(searchEdge(origin, destination));

    }

    //Método para realizar el recorrido en profundidad en el grafo
    public void depthSearch(int initial){
        initializeVisited();  //Inicializa todos los nodos como no visitados
        System.out.println("Depth First Search ");
        DFS(initial); //Hace la llamada al método que realiza el algoritmo
        System.out.println();
    }



    private void DFS(int inicial){

        VertexNode actual = searchVertex(inicial); //Busca el vértice inicial para el recorrido en la lista de vértices

        while(actual != null)  //Ciclo para verificar que todos los vértices estén visitados
        {
            //Si el nodo inicial no está visitado
            if(!actual.visited){
                System.out.print(actual.vertex + " "); //Imprime el vértice
                actual.visited = true;    //Lo actualiza como visitado
            }

            //Revisa todos los nodos adyacentes del nodo recién visitado
            for(int j = 0; j < actual.edges.size(); j++){
                if(! searchVertex(actual.edges.get(j).vertex).visited)  //Si el nodo adyacente no está visitado
                    DFS(actual.edges.get(j).vertex); //Hace la llamada recursiva para realizar el recorrido en el nodo adyacente
            }
            //Verifica si queda algún nodo sin visitar
            actual = searchNoVisitedVertex();
        }
    }

    //Método para recorrer el grafo en anchura
    public void widthSearch(int inicial){

        VertexNode actual;
        LinkedList <VertexNode> queue = new LinkedList<>();    //Estructura auxiliar para hacer el recorrido

        initializeVisited(); //Inicializa todos los nodos como no visitados

        System.out.println("Recorrido en anchura");
        actual = searchVertex(inicial); //Busca el vértice para iniciar el recorrido en la lista de vértices del grafo

        //Ciclo para verificar que todos los nodos estén visitados
        while(actual != null)
        {
            //Si el nodo actual no ha sido visitado
            if(!actual.visited){
                System.out.print(actual.vertex + " "); //Imprime el vértice
                actual.visited = true; //Indica que el vértice fue visitado
                queue.add(actual);  //Agrega el vértice a la cola(estructura auxiliar)
            }
            //Busca todos los vértices adyacentes al vértice recién visitado
            for(int j = 0; j < actual.edges.size(); j++){
                if(! searchVertex(actual.edges.get(j).vertex).visited){ //Si el vértice no se ha visitado aun
                    System.out.print(actual.edges.get(j).vertex + " ");  //Se imprime el vértice
                    queue.add(searchVertex(actual.edges.get(j).vertex));    //Se agrega el vértice a la cola
                    searchVertex(actual.edges.get(j).vertex).visited = true;  //Se indica que el vértice ha sido visitado
                }
            }

            //Mientras la cola no esté vacía
            while(queue.size() > 0)
            {
                VertexNode temp1;

                for(int x = 0; x < queue.getFirst().edges.size(); x++){
                    //Obtiene el primer vértice en la cola
                    temp1 = searchVertex(queue.getFirst().edges.get(x).vertex);
                    if(!temp1.visited){  //Verifica si el primero de la cola no ha sido visitado
                        System.out.print(temp1.vertex + " "); //Imprime el vértice
                        temp1.visited = true;    //Indica que el vértice se ha visitado
                        queue.add(temp1);    //Agrega el vértice al final de la cola
                    }
                }
                //Deletes first vertex in queue
                queue.removeFirst();
            }
            actual = searchNoVisitedVertex();//Verify if theres any vertexs left to visit 
        }
        System.out.println();
    }
}
