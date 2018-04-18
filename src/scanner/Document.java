package scanner;

import java.util.LinkedList;

public class Document {

    // I want you to use a data structure other than
    // an array, arraylist or hashmap to store the glyph data
    // look at the collections framework and decide what might be appropriate
    // Linked List.
    LinkedList<Glyph> doc_list = new LinkedList<>();

    public void in(Glyph glyph) {
        // System.out.println("glyph into document...");
        doc_list.add(glyph);
    }

    @Override
    public String toString() {
        // System.out.println("document toString...");
        String s = "";

        for (Glyph g : doc_list) {
            s += g.getCharacter();
        }
        return s;

    }

}
