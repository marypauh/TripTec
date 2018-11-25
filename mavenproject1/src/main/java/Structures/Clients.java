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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Graph getWishList() {
        return wishList;
    }

    public void setWishList(Graph wishList) {
        this.wishList = wishList;
    }
    
    
}
