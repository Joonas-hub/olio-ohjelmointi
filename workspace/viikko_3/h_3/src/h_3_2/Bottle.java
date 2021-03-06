package h_3_2;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    
    public Bottle(){
    	name = "Pepsi Max";
    	manufacturer = "Pepsi";
    	total_energy = 0.3;
    }
    public Bottle(String name, String manuf, float totE){
    	this.name = name;
    	manufacturer = manuf;
    	total_energy = totE;
    }
    
    public String getName(){
    	return name;
    }
    public String getManufacturer(){
    	return manufacturer;
    }
    public double getEnergy(){
    	return total_energy;
    }
}