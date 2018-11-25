package Structures;

public class Site {
    private String name;
    private String price;
    private String description;
    private String activities;
    private String lat;
    private String lng;
    private String address;

    public Site(String name, String price, String description, String activities, String lat, String lng, String address) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.activities = activities;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getActivities() {
        return activities;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Site: " + "name:" + name + ", price:" + price + ", description:" + description + ", activities:" + activities + ", lat:" + lat + ", lng:" + lng + ", address:" + address;
    }
    
   
    
    
}
