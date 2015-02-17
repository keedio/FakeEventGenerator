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
//import org.apache.flume.interceptor.Interceptor.Builder;
import  org.apache.flume.Event;
import org.apache.flume.Context;
import java.util.List;
/**
 * 
 * @author Luis Lázaro <lalazaro@keedio.com>
 */
public class FeederInterceptor implements Interceptor{
    
    
    @Override
    public void initialize(){}
    
    public Event  intercept(Event event){
        //feed header;
        return event;
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
