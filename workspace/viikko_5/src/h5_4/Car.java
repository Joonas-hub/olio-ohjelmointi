package h5_4;

import java.util.ArrayList;

public class Car {
	
	ArrayList<String> partList = new ArrayList<String>();
	
	public Car() {
		
		
		
		Body body = new Body();
		Chassis chassis = new Chassis();
		Engine engine = new Engine();
		Wheel[] wheels = new Wheel[4];
		for (int i = 0; i < 4; i++) {
			wheels[i] = new Wheel();
		}
		partList.add(wheels.length + " Wheel");
	}
	
	private class Body{
		public Body() {
			System.out.println("Manufacturing: Body");
			partList.add("Body");
		}
	}
	private class Chassis{
		public Chassis() {
			System.out.println("Manufacturing: Chassis");
			partList.add("Chassis");
		}
	}
	private class Engine{
		public Engine() {
			System.out.println("Manufacturing: Engine");
			partList.add("Engine");
		}
	}
	private class Wheel{
		public Wheel() {
			System.out.println("Manufacturing: Wheel");
		}
	}
	
	public void print() {
		System.out.println("Car parts:");
		for (String i : partList) {
			System.out.println("\t" + i);
		}
	}

}