package scanner;

import java.util.Scanner;

class SimpleWordProcessor {

	public static void main(String args[]){

		String s;
		Scanner in = null;
		try{
			
			in= new Scanner(System.in);
			while(true){
				System.out.print("Enter a string:");
				s = in.nextLine();

				if(s.equals("exit")){
					System.out.println("exiting ");
					break; // breaks out of the while loop
				}
							
				// Create a Document object
				Document d = new Document();
				//Create a GlyphFactory object. It should be a singleton
				GlyphFactory gf = GlyphFactory.getInstance();
				// System.out.println(s+"\n");
				// For each character of your input.		
				for(Character c : s.toCharArray()) {
					// System.out.println(c+"\n");
					// Retrieve a a glyph from the GlyphFactory	
					Glyph docGlyph = gf.getGlyph(c);				
					// Add the glyph to the document		
					d.in(docGlyph);
				}
				
				// instead of the line immediately below, you should write which should print out the document 
				// (e.g. the chars in the document)			
				// You should implement the toString method appropriately so that it outputs the String equivalent of the all the glyphs it contains
				System.out.println("\nPrinting Document: \n"); 
				System.out.println(d.toString() + "\n"); 
				
				// System.out.println("You entered string "+s);

			}
		}finally{
			if(in!=null){
				in.close();
			}
		}
	}
}


