/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

public class GestionEdges {
    private LinkedList2<Edge> sites;

	public LinkedList2<Edge> getEdges() {
		return sites;
	}
    

	public void setEdges(LinkedList2<Edge> Edge) {
		this.sites = Edge;
	}

	public GestionEdges() {
		this.sites= new LinkedList2<>();
	}

	private Edge buscar(String id) {
        ListNode<Edge> temp = sites.getInicio();
        for (int i = 0; i < sites.getSize(); i++) {
            if (temp.getElemento().getId().equals(id))
            {
                break;
            } else {
                temp = temp.getNodoSig();
            }
        }
        return temp.getElemento();
    }

    public void createEdges(String id, String name,String duration,String distance,String address) {
        //Libros newLibro = new Libros(String issn, String nombre, CategoriasLibros tema, int cantvendida, int cantdisponible, String descripcion,String libreria, double precio);
        Edge newEdge = new Edge(id, name,duration, distance, address);
        this.sites.insertarDetras(newEdge);
    }

    public void deleteSites(String id) throws Exception {
        sites.eliminarNodoEspecifico(buscar(id));
    }

    public String consultarSites() {
        return sites.toString();
    } 
}
