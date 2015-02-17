/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fakeEventGenerator;

import java.util.HashMap;
import org.apache.flume.Event;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Lázaro <lalazaro@keedio.com>
 */
public class EventUtilsTest {
    
    public EventUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeField method, of class EventUtils.
     */
    @Test
    public void testMakeField() {
        System.out.println("makeField");
        int nCampos = 5;
        EventUtils instance = new EventUtils();
        String expResult = "field0,field1,field2,field3,field4";
        String result = instance.makeField(nCampos);
        assertEquals(expResult, result);
    }
    
}
