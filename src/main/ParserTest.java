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
    }

}
