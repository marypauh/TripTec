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
public class ListNode<X> {

  private X elemento;
	private ListNode<X> nodoSig;
	private ListNode<X> nodoAnt;

	public X getElemento() {
		return elemento;
	}

	public void setElemento(X elemento) {
		this.elemento = elemento;
	}

	public ListNode<X> getNodoSig() {
		return nodoSig;
	}

	public void setNodoSig(ListNode<X> nodoSig) {
		this.nodoSig = nodoSig;
	}

	public ListNode<X> getNodoAnt() {
		return nodoAnt;
	}

	public void setNodoAnt(ListNode<X> nodoAnt) {
		this.nodoAnt = nodoAnt;
	}

	public ListNode(X elemento) {
		this.elemento = elemento;
		this.nodoAnt = null;
		this.nodoSig = null;
	}
        
        public ListNode(X elemento, ListNode<X> next){
            this.elemento = elemento;
            this.nodoSig = next;
        }

	@Override
	public String toString() {
		return elemento.toString() + "\n";
	}
    
}
