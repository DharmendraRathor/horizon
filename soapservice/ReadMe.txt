Maven spring boot code to demonstrate sample SOAP services. 
Code is developed based on online article at "spring.io"

To run project,
1.Run maven build
mvn clean install 

2. pom.xml has plugin to generate java classes from xsd during build time. 
it is comment, it can be enabled to generate java classes again.

2. Got to target folder and run following command 


java -jar target/soapservice-0.0.1-SNAPSHOT.jar

3. In Eclipse , you can right click App.java and > Run As Java application. 


4. Services can be tested using curl or rest client. 

POST  http://localhost:8080/ws/getCountryRequest

Header should have ""content-type: text/xml""

Request
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://spring.io/">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCountryRequest>
         <gs:name>Spain</gs:name>
      </gs:getCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>

5. WSDL file can be accessed at location

GET http://localhost:8080/ws/countries.wsdl
