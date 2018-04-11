package scanner;

import java.util.HashMap;

// A flyweight class implemented as a singleton
public class GlyphFactory {
	
	private static GlyphFactory instance;
	
	// Private constructor for Singleton.	
	private GlyphFactory() {
	}
	// getInstance
	public static GlyphFactory getInstance() {
		if(instance==null) {
			// System.out.println("Making new GlyphFactory...");
			instance = new GlyphFactory();
		}
		// System.out.println("Returning GlyphFactory singleton...");
		return instance;
	}
	

	// Linked list for Flyweight.
	// LinkedList<Glyph> l = new LinkedList<>();	
	
	HashMap<Character, Glyph> glyph_pool = new HashMap<Character, Glyph>();
	
	// getGlyph.
	public Glyph getGlyph(Character c) {
		// System.out.println("getting glyph...");
		Glyph glph = glyph_pool.get(c);	
			
		if(glph == null) {
			glph = new Glyph(c);
		}
		
		return glph;
	}
}
