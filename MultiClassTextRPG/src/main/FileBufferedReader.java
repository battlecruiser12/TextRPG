package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class FileBufferedReader {
	
	public static ArrayList<String> fileBuffReader(String fileName) throws Exception{
		ArrayList<String> temp = new ArrayList<String>();
		File file = new File("./assets/" + fileName);
		if(!file.exists()) {
			return temp;
		}
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		while(line != null) {
			temp.add(line);
			line = reader.readLine();
		}
		reader.close();
		return temp;
		
		
	}

}
