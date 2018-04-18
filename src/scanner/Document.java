package scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import scanner.GlyphFactory.Glyph;

public class Document {
	// Linked list needs to be generic.
	// Linked List.
	static LinkedList<Glyph> doc_list = new LinkedList<>();
	// Outer-Inner instantiation.
	// Add Glyph to list
	public void in (Glyph glyph){
		// System.out.println("glyph into document...");
		doc_list.add(glyph);
	}	
	// Document toString.
	public String toString(){
		// System.out.println("document toString...");
		String s = "";	
		for(Glyph g: doc_list){
			s += g.getCharacter();
		}	
		return s;		
	}	
	public void saveDocument(String filename) {
		
		try {		
			FileWriter fileWriter = new FileWriter(filename+".txt");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write("Document:\n\n");
			
			for(Glyph g: doc_list) {
				writer.write(g.getCharacter());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void loadDocument(String filename) throws FileNotFoundException {
		
		File docFile = new File(filename+".txt");	
		GlyphFactory gf = GlyphFactory.getInstance();
		
		try {
			FileReader fileReader = new FileReader(docFile);
			BufferedReader reader = new BufferedReader(fileReader);		
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				for(Character c: line.toCharArray()) {
					Glyph g = gf.getGlyph(c);
					this.in(g);
				}	
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void clearDocument() {
		doc_list = new LinkedList<>();
	}
}