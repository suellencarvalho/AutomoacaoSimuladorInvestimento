package Prova_sicredi_SimInvest.SicrediSimuladorInvestimento;

import static io.restassured.RestAssured.*;
import org.hamcrest.*;
import org.junit.Test;

public class testApi {
	  @Test
	    public void testValidarResponse(){

	        given().
	        
	        relaxedHTTPSValidation().

	        when().
	                get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador")
	        .then()
	                .statusCode(200)
	                .body(CoreMatchers.is("{\"id\":1,\"meses\":[\"112\",\"124\",\"136\",\"148\"],\"valor\":[\"2.802\",\"3.174\",\"3.564\",\"3.971\"]}"))
	                .contentType("application/json");
	    }


}
