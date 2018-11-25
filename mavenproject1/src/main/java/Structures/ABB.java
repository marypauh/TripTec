/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import java.util.Vector;

/**
 *
 * @author raquelrojas
 */
public class ABB {
        
    Clients raiz;
    ABB subLeft;
    ABB subRight;

    //Empty tree constructor
    public ABB() {
        raiz = null;
        subLeft = null;
        subRight = null;
    }

    // Leaf constructor
    public ABB( Clients client) {
        this.raiz = client;
        subLeft = null;
        subRight = null;
    }

    private boolean isEmpty() {
        boolean vacio = true;

        if ( raiz != null )
            vacio = false;

        return vacio;
    }

    public void insert(Clients client) {
        if( isEmpty() ) {
            raiz = client;
            subLeft = new ABB();
            subRight = new ABB();
        } else {
            if( client.id < raiz.id ) {
                subLeft.insert(client);
            } else if ( client.id > raiz.id ) {
                subRight.insert(client);
            }
        }
    }
    public Clients getRoot(){
    return raiz;
    }

    public ABB search( int id ) {
        ABB searched = null;

        if( !isEmpty() ) {
            if( id < raiz.id ) {
                searched = subLeft.search(id);
            } else if ( id > raiz.id ) {
                searched = subRight.search(id);
            } else {
                return this;
            }
        }

        return searched;
    }


    private ABB searchMin() {
        ABB actualThree = this;

        while( !actualThree.subLeft.isEmpty() ) {
            actualThree = actualThree.subLeft;
        }

        return actualThree;
    }

    private boolean isLeaf() {
        boolean leaf = false;

        if( subLeft.isEmpty() && subRight.isEmpty() ) {
            leaf = true;
        }

        return leaf;
    }

    public void delete( int id ) {
        ABB toDelete = search(id);

        if (toDelete != null) {
            if( toDelete.isLeaf() ) {
                toDelete.raiz = null;
            } else {
                ABB min =  toDelete.subRight.searchMin();
                toDelete.raiz = min.raiz;
                min.delete(min.raiz.id);
            }
        }
    }

    public void preOrden() {
        if( !isEmpty() ) {
            System.out.println( raiz );
            subLeft.preOrden();
            subRight.preOrden();
        }
    }

    public void enOrden() {
        if( !isEmpty() ) {
            subLeft.enOrden();
            System.out.println( raiz );
            subRight.enOrden();
        }
    }

    public void postOrden() {
        if( !isEmpty() ) {
            subLeft.postOrden();
            subRight.postOrden();
            System.out.println( raiz );
        }
    }


    public void forLevel() {
        Vector<ABB> queue = new Vector<ABB>();
        ABB tree;

        queue.add(this);
        while( !queue.isEmpty() ) {
            tree = queue.elementAt(0);
            queue.remove(0);
            System.out.println( tree.raiz );
            if ( !tree.subLeft.isEmpty() ) queue.add( tree.subLeft );
            if (!tree.subRight.isEmpty() ) queue.add( tree.subRight );
        }
    }
}
