package Main;

import Interface.Menu;



public class Main {

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.setVisible(true);
        
        //GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCuI-6vEJkDHlpzgwMsHKDP9mXoVqaTEn8").build();
        //GeocodingResult[] results =  GeocodingApi.geocode(context,"1600 Amphitheatre Parkway Mountain View, CA 94043").await();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //System.out.println(gson.toJson(results[0].addressComponents));
    }
}
