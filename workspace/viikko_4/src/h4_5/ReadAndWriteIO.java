package h4_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ReadAndWriteIO {

	
	public void readZip(String path) {
		try {
			ZipFile zip = new ZipFile(path);
			Enumeration<? extends ZipEntry> entries = zip.entries();
			
			InputStream inputstream = zip.getInputStream(entries.nextElement());
			BufferedReader in = new BufferedReader(new InputStreamReader(inputstream));	
	
			String line = in.readLine();
			while (line != null) {
				System.out.println(line);
				line = in.readLine();
			}	
			in.close();

			zip.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
