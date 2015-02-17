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


package feederInterceptor;

import org.apache.flume.interceptor.Interceptor; 
import  org.apache.flume.Event;
import org.apache.flume.Context;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import fakeEventGenerator.EventUtils;

/**
 * 
 * @author Luis Lázaro <lalazaro@keedio.com>
 */
public class FeederInterceptor implements Interceptor{
    
    private int CAMPOS = 10; //número de campos a incluir para enriquecer
    private EventUtils  eventUtil = new EventUtils();
    
    @Override
    public void initialize(){}
    
    public Event  intercept(Event event){
        Map<String,String> poorHeader = new HashMap<>();
        Map<String,String> richHeader = new HashMap<>();
        poorHeader =  event.getHeaders();
        for ( String key : poorHeader.keySet()){
            richHeader.put( key + "," +  eventUtil.makeVDCname(), poorHeader.get(key) + "," + eventUtil.makeField(CAMPOS));
            event.setHeaders( richHeader );
        }   
        return event; //enriched event
    }
    
  public List<Event> intercept(List<Event> events) {
      for (Event event:events) {
        intercept(event);
      }
      return events;
   }
  
    @Override
  public void close() {}
  
  public static class Builder implements Interceptor.Builder {
       public Interceptor build() {
         return new FeederInterceptor();
       }
       @Override
       public void configure(Context context) {}
     }
  
    

}
