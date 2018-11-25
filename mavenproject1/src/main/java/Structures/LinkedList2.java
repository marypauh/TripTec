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
public class LinkedList2<X> {
  
        private ListNode<X> inicio;
    private ListNode<X> fin;
    private int size;

    public ListNode<X> getInicio() {
        return inicio;
    }

    public void setInicio(ListNode<X> inicio) {
        this.inicio = inicio;
    }

    public ListNode<X> getFin() {
        return fin;
    }

    public void setFin(ListNode<X> fin) {
        this.fin = fin;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String msg = "";
        ListNode<X> temp = inicio;
        for (int i = 0; i < size; i++) {
            msg += temp.toString();
            temp = temp.getNodoSig();
        }
        return msg;
    }

    private boolean esVacia() {
        return size == 0;
    }

    public void insertarDetras(X elemento) {
        ListNode<X> nuevoNodo = new ListNode<>(elemento);
        if (esVacia()) {
            inicio = nuevoNodo;
            fin = inicio;
            size++;
        } else {
            fin.setNodoSig(nuevoNodo);
            fin.getNodoSig().setNodoAnt(fin);
            fin = fin.getNodoSig();
            size++;
        }
    }

    public ListNode<X> buscarNodo(X elemento) {
        ListNode<X> temp = inicio;
        if (!esVacia()) {
            for (int i = 0; i < size; i++) {
                if (temp.getElemento() == elemento) {
                    System.out.println("ECONTRADO: " + temp.getElemento().toString());
                    break;
                } else {
                    temp = temp.getNodoSig();
                }
            }
        }
        return temp;

    }

    public void eliminarNodoEspecifico(X elemento) throws Exception {
            ListNode<X> aux1;
        ListNode<X> aux2, elim;
        elim = buscarNodo(elemento);

        if (size == 1) {
            inicio = null;
            fin = null;
            size--;

        } else if (inicio.getElemento().equals(elemento)) {
            ListNode<X> temp = inicio;
            inicio = inicio.getNodoSig();
            inicio.setNodoSig(null);
            temp.setNodoSig(null);
            size--;

        } else if (fin.getElemento().equals(elemento)) {
            ListNode<X> temp = fin;
            fin = fin.getNodoAnt();
            fin.setNodoSig(null);
            temp.setNodoAnt(null);
            size--;

        } else {
            elim = buscarNodo(elemento);
            aux1 = elim.getNodoAnt();
            aux2 = elim.getNodoSig();
            aux1.setNodoSig(aux2);
            aux2.setNodoAnt(aux1);

            elim.setNodoAnt(null);
            elim.setNodoSig(null);
            size--;
        }
    }
}
