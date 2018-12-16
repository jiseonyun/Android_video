package com.example.jiseo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class fetchData extends AsyncTask<Void,Void,Void> {
    String data="";
    static ArrayList<IdPair> pairs;
    @Override
    protected Void doInBackground(Void... voids) {
        try{
            URL url = new URL("http://52.194.187.201:13001/api/contents/0/index/0");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data+ line;
            }


            DataObject dataObject = new DataObject(); // init object

            JSONObject jsonObject = new JSONObject(data); // whole json is an object! (data is your json)

            int code = jsonObject.optInt("code"); // get code from main json

            dataObject.setCode(code); // set code to our object

           // List<IdPair> pairs = new ArrayList<>(); // init list of id pairs

            pairs = new ArrayList<IdPair>();
            JSONArray datas = jsonObject.optJSONArray("datas"); // get json array from main json

            IdPair pair = null; // define idPairs object


            for (int i=0; i<datas.length() ; i++) {
                JSONObject object = datas.getJSONObject(i);// each jsonObject in the jsonArray

                pair = new IdPair();// init idPair

                int id = object.optInt("id"); // get the object id
                int targetId = object.optInt("target_id"); // get the object target_id
                String title = object.optString("title");
                String image = object.optString("image");
                String source = object.optString("source");
                String link = object.optString("link");
                String update_at = object.optString("update_at");
                String create_at = object.optString("create_at");

                // set values to our object
                pair.setId(id);
                pair.setTarget_id(targetId);
                pair.setTitle(title);
                pair.setImage(image);
                pair.setSource(source);
                pair.setLink(link);
                pair.setUpdate_at(update_at);
                pair.setCreate_at(create_at);
                pairs.add(pair);

            }

           // MainActivity.PairList = pairs;

        }
        catch(MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
    public void DataSetting(ArrayList<IdPair> pairs){

        ListviewAdapter listviewAdapter= new ListviewAdapter();

        for (int i=0; i<10; i++) {
            listviewAdapter.addItem("1","1");
        }
        MainActivity.listView.setAdapter(listviewAdapter);
    }
}
