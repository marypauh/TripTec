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
public class Clients {
    String name, tel, mail,birthDate;
    int id;
    Graph wishList;
    
    public Clients(String name, String tel, String mail,String birthDate, int id){
    this.name = name;
    this.tel = tel;
    this.birthDate = birthDate;
    this.id = id;
    }
}
