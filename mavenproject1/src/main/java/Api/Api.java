package Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.GeolocationApi;
import com.google.maps.GeolocationApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import java.awt.Desktop;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;



public class Api {
   
    private final static String APIKEY = "AIzaSyDanbQ78_DvUe7SfCog0ggOZc7kfID4UIA";
    private String lat;
    private String lng;
    
    
    public void getLocation(String address) throws URISyntaxException, IOException, Exception{
        
        double latitude = geocodelat(address);
        double longitude = geocodelng(address);
        String result = "https://www.google.com/maps/search/?api=1&query="+latitude+","+longitude;
        Desktop.getDesktop().browse(new URI(result));
    
    }
    public static String lookupAddr(String establishment) throws ApiException, InterruptedException, IOException { // Da la direccion de un lugar
	
	//set up key
	GeoApiContext lookupDoodad = new GeoApiContext.Builder()
		    .apiKey("AIzaSyDanbQ78_DvUe7SfCog0ggOZc7kfID4UIA")
		    .build();
		GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
		    establishment).await();
		
		//converts results into usable address
		
		String address = (results[0].formattedAddress);
	
	return address;
    }
    public long getDuration(String addrOne, String addrTwo) throws ApiException, InterruptedException, IOException{
        GeoApiContext distCalcer = new GeoApiContext.Builder()
		    .apiKey(APIKEY)
		    .build();
        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer);
        DistanceMatrix result = req.origins(addrOne).destinations(addrTwo).await();
        
        long duration = result.rows[0].elements[0].duration.inSeconds;
        
        return duration;
    }
    public static long getDriveDist(String addrOne, String addrTwo) throws ApiException, InterruptedException, IOException{ //Distancia en metros de dos lugares
			
	//set up key
   	GeoApiContext distCalcer = new GeoApiContext.Builder()
		    .apiKey(APIKEY)
		    .build();
   	
   	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
       DistanceMatrix result = req.origins(addrOne)
               .destinations(addrTwo)
               .mode(TravelMode.DRIVING)
               .avoid(RouteRestriction.TOLLS)
               .language("en-US")
               .await();
       
			long distApart = result.rows[0].elements[0].distance.inMeters;
	
	return distApart;
}
    public static void distanceMatrix(String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException{ //No se JJAA
	GeoApiContext context = new GeoApiContext.Builder()
		    .apiKey(APIKEY)
		    .build();
		
		DistanceMatrixApiRequest req=DistanceMatrixApi.newRequest(context);
		DistanceMatrix t=req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).await();
		//long[][] array=new long[origins.length][destinations.length];
		File file=new File("Matrix.txt");
		FileOutputStream out=new FileOutputStream(file);
		DataOutputStream outFile=new DataOutputStream(out);
		for(int i=0;i<origins.length;i++){
			for(int j=0;j<destinations.length;j++){
				//System.out.println(t.rows[i].elements[j].distance.inMeters);
				outFile.writeLong(t.rows[i].elements[j].distance.inMeters);
			}
		}
		outFile.close();
    }
    
    private String result;
    
    public void lookupCoord(String establishment) throws ApiException, InterruptedException, IOException {   //Recibe lugar exacto y da latitud y longitd
		
	//set up key
	GeoApiContext lookupDoodad = new GeoApiContext.Builder()
		    .apiKey(APIKEY)
		    .build();
	GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
	  establishment)
                .await();		
    try {
        results = GeocodingApi.geocode(lookupDoodad, establishment).await();
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            this.lat = gson.toJson(results[0].geometry.location.lat);
            this.lng = gson.toJson(results[0].geometry.location.lng);
    }   catch (final Exception e) {
            throw e;
    }
        System.out.println("Latitude:  "+lat);
        System.out.println("Longitude:  "+lng);       
    }
    
    public String reverseGeocode(final double latitude, final double longitude) throws Exception { //Recibe latitud y longitud
    final GeoApiContext context = new GeoApiContext.Builder()
            .apiKey(APIKEY)
            .build();
    final LatLng latlng = new LatLng(latitude, longitude);
    final GeocodingResult[] results;
    try {
        results = GeocodingApi.reverseGeocode(context, latlng).await();
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            this.result = gson.toJson(results[0].formattedAddress);
    }   catch (final Exception e) {
            throw e;
    }
        return result;
} 
    public double geocodelat(final String address) throws Exception {      //Devuelve latitud
        final GeoApiContext context = new GeoApiContext.Builder()
            .apiKey(APIKEY)
            .build();
        final GeocodingResult[] results;
        try {
            results = GeocodingApi.geocode(context, address).await();
            final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            this.lat = gson.toJson(results[0].geometry.location.lat);
    }   catch (final Exception e) {
            throw e;
    }
        double latitude = Double.parseDouble(lat); 
        return latitude;
}
    public double geocodelng(final String address) throws Exception {      //Devuelve longitud
        final GeoApiContext context = new GeoApiContext.Builder()
            .apiKey(APIKEY)
            .build();
        final GeocodingResult[] results;
        try {
            results = GeocodingApi.geocode(context, address).await();
            final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            this.lng = gson.toJson(results[0].geometry.location.lng);
    }   catch (final Exception e) {
            throw e;
    }
    double longitude = Double.parseDouble(lng);    
    return longitude;
}
}