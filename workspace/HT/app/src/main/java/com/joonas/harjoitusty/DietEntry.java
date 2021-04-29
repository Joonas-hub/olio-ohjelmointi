package com.joonas.harjoitusty;

public class DietEntry extends Entry{

    private float meatConsumption;
    private float vegetableConsumption;
    private double emission;

    public DietEntry(float meat, float veg){
        // Constructor gets the emissions from the API based on user inputs.
        meatConsumption = meat;
        vegetableConsumption = veg;
        System.out.println("Starting API call");
        APICall api = new APICall();
        emission = api.getEmissions(meatConsumption, vegetableConsumption);
    }

    public String getLogEntry(){
        String logEntry = dateString + "," + meatConsumption + "," + vegetableConsumption + "," + emission;
        return logEntry;
    }
}
