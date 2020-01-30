package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;

import org.json.simple.parser.*;

public class urlConnection {
    private static HttpURLConnection connection;
    public static JSONObject outJSON =new JSONObject();
    public static void connect(){
        //Api request
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=AAPL&outputsize=full&datatype=json&apikey=3RXKB3XV9WWLA591");
            connection = (HttpURLConnection) url.openConnection();
            //requesting setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            int status = connection.getResponseCode();
            System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            //System.out.println(responseContent.toString());
            //Map tsd = new LinkedHashMap(5);
           JSONObject obj_JSONObject = new JSONObject(responseContent.toString());
            JSONObject on2 = obj_JSONObject.getJSONObject("Time Series (Daily)");
            //String objson = responseContent.toString();
            //JSONObject obj_JSONObject2=new JSONObject();
            //outJSON = obj_JSONObject;
            System.out.println(on2);
            Integer count = 0;
            //obj_JSONObject = (JSONObject) responseContent;

            //JSONArray testArray = on2.toJSONArray(on2.names());

          // JsonParser parser = new JsonParser();
         //   JsonObject json = (JsonObject) parser.parse(responseContent.toString());
      //  System.out.println(json);
           // JsonObject on2= json.getAsJsonObject("Time Series (Daily)");
          //  JsonArray array = (JsonArray) on2;



            //JSONObject TSDObj= obj_JSONObject.getJSONObject("Time Series (5min)"); // TSD stands for Time Series (Daily)


           for (Integer i = 2; i <= 9; i++) {
                for (Integer j = 1; j <= 9; j++) {
                    try {
                        JSONObject dateOBJ = on2.getJSONObject("2000-0" + i + "-0" + j + "");
                        System.out.println(dateOBJ);
                    } catch (JSONException e) {
                     //   e.printStackTrace();
                    }
                }

                //i was thiking a try catch situation

            }

            /*for (Integer a= 1; a<= 30; a+=1) {
                for (Integer i = 9; i < 16; i += 1) {
                    if (i == 9) {

                        for (Integer j = 35; j < 60; j += 5) {
                            JSONObject dateOBJ = on2.getJSONObject("2020-01-" + a + " " + count + "" + i + ":" + j + ":00");
                            System.out.println(dateOBJ);
                        }
                    } else {
                        for (Integer j = 35; j < 60; j += 5) {
                            JSONObject dateOBJ = on2.getJSONObject("2020-01-" + a + " " + i + ":" + j + ":00");
                            System.out.println(dateOBJ);
                        }
                    }
                }
            }*/

    /*        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }}

     */
                    //String obj2 = TSDObj.toString();

                    /*Iterator TSDIt = on2.key;
                    JSONArray jsonArray = new JSONArray();
                    while (TSDIt.hasNext()) {
                        String key = (String) TSDIt.next();
                        jsonArray.put(on2.get(key));
                    }*/


                // JSONObject o = jsonArray.getJSONObject(1);
                //System.out.println(o);

            /*

            USE BELOW TO SORT THE WHOLE ARRAY

             */

        /* for(int i=0; i< jsonArray.length(); i++){
                JSONObject o = jsonArray.getJSONObject(i);
                System.out.println("hello");
                System.out.println(o);
            }
*/


          /*  Object obj = new JSONParser().parse(responseContent.toString());
            Gson gson1 = new Gson();
            Gson gson2 = new Gson();
            stockDataParser obj1 = gson1.fromJson(objson, stockDataParser.class);
            String objson2 = obj1.toString();
            dateParser obj2 = gson2.fromJson(objson2, dateParser.class);
            System.out.println(obj2);*/
            }


        catch (MalformedURLException e){
        e.printStackTrace();
    }
        catch (IOException e){
        e.printStackTrace();
    }
       catch (JSONException e) {
            e.printStackTrace();
        } finally {
        connection.disconnect();
    }


    }
    public static JSONObject getJSONstring() {
        return outJSON;
    }}
