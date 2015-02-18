/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adderInterceptor;


import org.apache.flume.Event;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import fakeEventGenerator.EventUtils;


/**
 *
 * @author Luis Lázaro <lalazaro@keedio.com>
 */
public class AdderInterceptorTest {
    
    public AdderInterceptorTest() {
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
     * Test of intercept method, of class AdderInterceptor.
     */
    @Test
    public void testIntercept_Event() {
        Event event = new EventUtils().makeDummyEvent();
        AdderInterceptor instance = new AdderInterceptor();
        String expResult = "host:field0,field1,field2,field3,field4";
        Event resultEvent = instance.intercept(event);
        String result = null;
        for (String key : resultEvent.getHeaders().keySet()){
           result = key  + ":" + resultEvent.getHeaders().get(key);
           System.out.println(result);
        }
        
        assertEquals(expResult, result);
    }

  
    
}
