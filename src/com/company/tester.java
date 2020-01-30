package com.company;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.IOException;

public class tester {

   public static void test() {
       System.out.println(urlConnection.getJSONstring());
       String getStringJSON = urlConnection.getJSONstring().toString();
       ObjectMapper mapper = new ObjectMapper();
       //try {

          // stockDataParser mp = mapper.readValue(getStringJSON, stockDataParser.class);
           //System.out.println(mp.getMonthly_Time_Series());
       /*} catch (JsonParseException e) {
           e.printStackTrace();
       } catch (JsonMappingException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }*/
   }
}
