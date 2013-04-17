package se.chalmers.tda367.group25.resumate.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class handles IO-stuff.
 */
public class IOHandler {

	
	/* 
	 * Save to file. Implementation taken from "Java Direkt".
	 */
	public void saveFile(String fileName){
		FileWriter w;
		try{
			w = new FileWriter(fileName);
			//textArea.write(w);
		}catch(IOException e){}

	}
	/*
	 * Open file. Implementation taken from "Java Direkt".
	 */
	public void openFile(String fileName){
		FileReader r;
		try {
			r = new FileReader(fileName);
			//textArea.read(r, null);
		} catch (IOException e) {}
	}
	
	/* Send the document*/
	public void send(){
		
	}
	
	/*Print the document*/
	public void print(){
		
	}
}
