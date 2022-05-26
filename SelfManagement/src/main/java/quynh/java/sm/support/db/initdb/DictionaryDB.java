package quynh.java.sm.support.db.initdb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryDB {
	public List<String> readFile() {
		String file ="src/main/resources/engwords.txt";	     
	    ArrayList<String> wordList = new ArrayList<String>(); 
	    try {
	        File myFile = new File(file);
	        Scanner myReader = new Scanner(myFile);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          wordList.add(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    return wordList;
	}
	public static void main(String[] args) {
		DictionaryDB ddb = new DictionaryDB();
		List<String> wordList = ddb.readFile();
		System.out.print(wordList.size());
	}
}
