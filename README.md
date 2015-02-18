# FakeEventGenerator
Generate fake events in terms of Apache Flume with payload and headers for testing porposes.
Package FakeEventGenerator generates two different events, a dummy event with a header with <key,value> that will be enriched via a second package with a custom interceptor called FeederInterceptor.
# FeederInterceptor
The initial event (poor event in terms of informational data in headers) will be added an second key and a total of 'n' fields in the value of the map. Header of the poor event is passed through feederIntercept returning an enriched event with new header maintaining previous header:

-
example:

previous header  <(key),(value)> ---> feederInterceptor ----> new header <(key,key2),(value,field0,field1,field2)>

# AdderInterceptor
This interceptor adds a secon pair of <key, value> to the initial event's header.
-
example
previous header <(key0),(value)> ----> adderInterceptor ----> new header
[ <(key0),(value)>, <(host),(field0,field1,field2,...)>]
