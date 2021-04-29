package com.joonas.harjoitusty;

import org.json.JSONException;
import org.json.JSONObject;

import org.w3c.dom.NodeList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class APICall {
    private int beefLevel;
    private int vegetableLevel;
    private final double avgMeatConsumption = 80.0; // kg/year
    private final double avgVegetableConsumption = 61.2; // kg/year
    private double emission;


    public double getEmissions(double meat, double veg){
        // Gets the calculated emissions of the user inputs using Ilmastodieetti calculator. Returns the emissions in CO2e kg/day.
        beefLevel = (int) Math.round(meat * 365 / avgMeatConsumption * 100);
        vegetableLevel = (int) Math.round(veg * 365 / avgVegetableConsumption * 100);
        String urlString = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/FoodCalculator?query.diet=omnivore&query.lowCarbonPreference=false&query.beefLevel=" + beefLevel + "&query.winterSaladLevel=" + vegetableLevel;
        //System.out.println(urlString);
        URL url;
        try {
            url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream in = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            JSONObject json = new JSONObject(br.readLine());
            emission = Double.parseDouble(json.get("Total").toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Math.floor(emission/365 * 100) / 100;
    }
}
