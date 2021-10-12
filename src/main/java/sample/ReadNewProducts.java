package main.java.sample;



import org.json.JSONArray;
import org.json.JSONML;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Locale;


public class ReadNewProducts {
     static int rows;
     static int columns;

    public static void readFromJsonFile(String filename, ArrayList<Products> productsArrayList){

   try {
       String text=new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);

       JSONObject object=new JSONObject(text);
       JSONArray arrayOfItems=object.getJSONArray("items");
       JSONObject config=object.getJSONObject("config");

       rows=config.getInt("rows");
       columns=config.getInt("columns");



       for (int i=0;i<arrayOfItems.length();i++){
           String name=arrayOfItems.getJSONObject(i).getString("name");
           int amount=arrayOfItems.getJSONObject(i).getInt("amount");
           String price=arrayOfItems.getJSONObject(i).getString("price");
           double priceDouble= Double.valueOf(price.replace("$"," "));

           productsArrayList.add(new Products(name,amount,priceDouble));

       }

   }catch (Exception e){
       System.out.println(e.toString());

   }

    }
}
