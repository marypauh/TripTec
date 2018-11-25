package Main;

import Interface.Menu;
import Structures.ABB;
import Structures.GestionSites;
import Structures.ClientTour;



public class Main {
       public static ABB clientsTree = new ABB();
       public static GestionSites sites = new GestionSites();
       public static ClientTour tour = new ClientTour();
       public static int contador = 0;

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.setVisible(true);
        
        //GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCuI-6vEJkDHlpzgwMsHKDP9mXoVqaTEn8").build();
        //GeocodingResult[] results =  GeocodingApi.geocode(context,"1600 Amphitheatre Parkway Mountain View, CA 94043").await();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //System.out.println(gson.toJson(results[0].addressComponents));
    }
}
