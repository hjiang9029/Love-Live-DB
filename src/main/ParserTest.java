package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * To test the parser.
 * @version 2018-01-06
 * @author Henry Jiang
 *
 */
public class ParserTest {
    
    private Parser parser;
    
    @Before
    public void setUp() throws Exception {
        parser = new Parser();
        parser.parse();
    }

    @Test
    public void test() {
        assertEquals(3, Parser.Muse.getSubUnits().size());
        assertEquals(3, Parser.Aqours.getSubUnits().size());
        assertEquals(9, Parser.Muse.getIdols().size());
        assertEquals(9, Parser.Aqours.getIdols().size());
        Parser.Muse.getSubUnits();
        Parser.Aqours.getSubUnits();
        Parser.Muse.getIdols();
        Parser.Aqours.getIdols();
        assertEquals(113, Parser.Muse.getTotalSongs());
        assertEquals(59, Parser.Aqours.getTotalSongs());
        System.out.println(Parser.Muse.getSubUnits().get(0).toStringFull());
        System.out.println();
        SubUnit test = new SubUnit("BiBi");
        System.out.println(Parser.Muse.getSong("eien friends"));
        System.out.println(Parser.Muse.getSubUnit(test).getSong("psychic fire"));
    }
    
    

}
