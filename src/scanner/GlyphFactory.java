package scanner;

import java.util.HashMap;

// A flyweight class implemented as a singleton
public class GlyphFactory {
	
	// Private instance.
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
	
	// HashMap for Flyweight.
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
	public class Glyph {	
		private Glyph g;
		// Character Attribute.
		private char chr;
		// Constructor.
		private Glyph(Character c) {
			this.chr = c;
		}
		// Getter.
		public char getCharacter() {
			return chr;
		}
		public Glyph returnGlyph() {
			return g;
		}
	}
}