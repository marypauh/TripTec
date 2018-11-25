/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author marip
 */
public class GestionSites {
    private LinkedList2<Site> sites;

	public LinkedList2<Site> getSites() {
		return sites;
	}
    

	public void setSites(LinkedList2<Site> Site) {
		this.sites = Site;
	}

	public GestionSites() {
		this.sites= new LinkedList2<>();
	}

	private Site buscar(String id) {
        ListNode<Site> temp = sites.getInicio();
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

    public void createSites(String id, String name, String price, String description, String activities, String lat, String lng, String address) {
        //Libros newLibro = new Libros(String issn, String nombre, CategoriasLibros tema, int cantvendida, int cantdisponible, String descripcion,String libreria, double precio);
        Site newSite = new Site(id, name, price,description, activities, lat, lng, address);
        this.sites.insertarDetras(newSite);
    }

    public void deleteSites(String id) throws Exception {
        sites.eliminarNodoEspecifico(buscar(id));
    }

    public String consultarSites() {
        return sites.toString();
    }
    
    
}
