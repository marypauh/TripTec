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
    GestionSites wishList;
    
    public Clients(String name, String tel, String mail,String birthDate, int id){
    this.name = name;
    this.tel = tel;
    this.birthDate = birthDate;
    this.id = id;
    this.mail = mail;
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

    public GestionSites getWishList() {
        return wishList;
    }

    public void setWishList(GestionSites wishList) {
        this.wishList = wishList;
    }
    public void addWishList(String id, String name, String price, String description, String activities, String lat, String lng,String address){
    wishList.createSites(id,name,price,description,activities,lat,lng,address);}
    
    public void printWishlist(){
    System.out.println(wishList.toString());
    }
}
