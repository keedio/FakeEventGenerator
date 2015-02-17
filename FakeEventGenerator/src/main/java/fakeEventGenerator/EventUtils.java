/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/

package fakeEventGenerator;

import org.apache.flume.Event;
import org.apache.flume.event.SimpleEvent;
import java.util.HashMap;
import java.util.Random;


/**
 * 
 * @author Luis Lázaro <lalazaro@keedio.com>
 */

public class EventUtils{
        private HashMap<String, String> headers = new HashMap<>();
        private String VDCNAME = "host";
        private String Field;
        private byte[] data;
        private Random random;
        
       
        /*
        @return Event build from atomic parameters
        */    
        public Event makeEvent( int nCampos ){
            Event event = new SimpleEvent();
            event.setBody(makeData());
            event.setHeaders(makeHeaders(nCampos));
            return event;
        }
        
        public Event makeDummyEvent(){
            Event dummyEvent = new SimpleEvent();
            dummyEvent.setBody( new String("contenido").getBytes());
            HashMap<String,String> dummyHeader = new HashMap<>();
            dummyHeader.put("clave", "campo");
            dummyEvent.setHeaders(dummyHeader);
            return dummyEvent;
        }
        
        /*
        @retunr byte [] paylod of fake event, can be anything
        */
        public byte[] makeData(){
            String payLoad = "whatever";
            byte[] data = payLoad.getBytes();
            return data;
        }
        
        /*
        @return hashmap,
        @param int , fields in value of hashmap
        */
        public HashMap makeHeaders(int nCampos){
            headers.put(makeVDCname(), makeField(nCampos));
            return headers;
        }
        
        
        /*
        @return String, make random name of host
        */
        public String makeVDCname(){
            return VDCNAME + random.nextInt();
        }
        
        /*
        return String, make String composed of concatenated  Filed+i
        */
        public String makeField(int nCampos){
            String [] Chain = new String[nCampos];
            Field = "";
            for (int i = 0; i < nCampos; i++){
                    if (i == nCampos - 1){
                        Chain [i] = "field" + i;
                        Field += Chain[i];                     
                    } else {
                         Chain [i] = "field" + i  +",";
                         Field += Chain[i];
                    }
                }
            return Field;
        }
}
