package h4_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteIO {

	
	public void readFile(String path) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line = in.readLine();
			while (line != null) {
				System.out.println(line);
				line = in.readLine();
			}
			
			
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readAndWrite(String input, String output) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(input));
			BufferedWriter out = new BufferedWriter(new FileWriter(output));
			
			String line = in.readLine();
			while (line != null) {
				if (line.strip().length() < 30 && line.strip().length() > 0 && line.contains("v")) {
					out.write(line + "\n");
				}
				line = in.readLine();
			}
			
			
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
