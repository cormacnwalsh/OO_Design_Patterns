package scanner;

import java.io.FileNotFoundException;
import java.util.Scanner;

import scanner.GlyphFactory;
import scanner.GlyphFactory.Glyph;

class SimpleWordProcessor {

	public static void main(String args[]){
		
		// Application objects.
		String s;
		Scanner in = null;
		// Create a Document object
		Document d = new Document();
		// Call instance of GlyphFactory singleton.
		GlyphFactory gf = GlyphFactory.getInstance();
		try{
			// Initialise scanner.
			in= new Scanner(System.in);
			// 
			System.out.println("|-Simple Word Processer-|\n"+
							   "Press enter to add string to document.");
			while(true){
				// Read user input.
				System.out.print(": ('-load', '-save', '-exit')\n");
				s = in.nextLine();
				s += "\n";
				// Exit clause.
				if(s.equals("-exit\n")){
					System.out.println("exiting ");
					break; // breaks out of the while loop
				} else if(s.equals("-save\n")) {
					System.out.println("Enter filename: ");
					s = in.nextLine();				
					System.out.println("Saving document...");
					d.saveDocument(s);
					s = "";
				} else if(s.equals("-load\n")) {
					System.out.println("This will override current document. Continue? (y/n)");
					s = in.nextLine();
					if(s.equals("y")) {
						d.clearDocument();
						System.out.println("Enter filename to load: ");
						s = in.nextLine();	
						d.loadDocument(s);
					}
				}
				// For each character of your input.		
				for(Character c : s.toCharArray()) {
					// Retrieve a a glyph from the GlyphFactory	
					Glyph docGlyph = gf.getGlyph(c);				
					// Add the glyph to the document		
					d.in(docGlyph);
				}
				// OUTPUT:			
				System.out.println("You entered string: \n"+s+"\n");
				System.out.println("Printing Document: \n"); 
				System.out.print(d.toString()+"\n"); 		
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in!=null){
				in.close();
			}
		}
		System.out.println(gf);
	}
	

	
}