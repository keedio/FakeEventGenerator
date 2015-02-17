/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feederInterceptor;

import java.util.List;
import org.apache.flume.Event;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import fakeEventGenerator.EventUtils;
import java.util.Iterator;

/**
 *
 * @author Luis Lázaro <lalazaro@keedio.com>
 */
public class FeederInterceptorTest {
    
    public FeederInterceptorTest() {
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
     * Test of intercept method, of class FeederInterceptor.
     */
    @Test
    public void testIntercept_Event_key() {
        System.out.println("intercept");
        Event event = new EventUtils().makeDummyEvent();
        FeederInterceptor instance = new FeederInterceptor();
        String expResult = "clave,host";
        Event resultEvent = instance.intercept(event);
        String result = null;
        for (String key : resultEvent.getHeaders().keySet()){
           result = key;
        }
        assertEquals(expResult, result);
    }

    
    
}
