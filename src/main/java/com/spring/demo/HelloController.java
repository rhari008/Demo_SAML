package com.spring.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.EncryptedElementType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml.SAMLCredential;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.core.connectivity.api.authentication.AuthenticationHeader;
import com.sap.security.auth.login.LoginContextFactory;


@RestController
@WebServlet("/")
public class HelloController extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	@RequestMapping(value="/hello", method = RequestMethod.GET) 
//	public String getGreeting(@RequestParam("SAMLResponse") String saml) {
//		return "Hari rocks" + saml;
//	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Write the response message, in an HTML page
      try {
    	  		
    	  //SecurityContext authentication = SecurityContextHolder.getContext();
    	  	
//    	  Map<String, Object> samlData = new HashMap<>();
//    	  samlData.put("onelogin.saml2.sp.entityid", "http://localhost:8080/saml2/localidp/metadata");
//    	  samlData.put("onelogin.saml2.sp.assertion_consumer_service.url", new URL("http://localhost:8080/saml2/localidp/sso"));
//    	  samlData.put("onelogin.saml2.security.want_xml_validation",true);
////    	  samlData.put("onelogin.saml2.sp.x509cert", myX509CertInstance);
//
//    	  SettingsBuilder builder = new SettingsBuilder();
//    	  Saml2Settings settings = builder.fromValues(samlData).build();
//    	  
//    	  	Auth auth = new Auth(settings, request, response);
//    	  	auth.processResponse();
//    	  	if (!auth.isAuthenticated()) {
//    	  	   out.println("Not authenticated");
//    	  	} 
//         out.println("<!DOCTYPE html 15>");
//         out.println("<html><head>");
//         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//         out.println("<title>Hello, World</title></head>");
//         out.println("<body>");
//         out.println(request.getAttributeNames());
//         out.println("<h1>Hello, world!</h1> Changed");  // says Hello
//         // Echo client's request information
         String user = request.getRemoteUser();
         if (user != null) {
//           out.println("Hello, " + user);
         } else {
       	  	LoginContext loginContext;
   	        loginContext = LoginContextFactory.createLoginContext("FORM");
   	        loginContext.login();
//   	        out.println("Hello, " + request.getRemoteUser());
         }
         
//         Enumeration<String> names = request.getAttributeNames();
//         
//         while (names.hasMoreElements()) {
//        	 	String attributeName = names.nextElement();
//        	 	out.println(attributeName);
//        	 	String attributeValues = request.getAttribute(attributeName).toString();
//        	 	out.println(attributeValues);
//         }
//                  
//         Enumeration<String> headers = request.getHeaderNames();
//         while (headers.hasMoreElements()) {
//     	 	String headerName = headers.nextElement();
//     	 	out.println("Header Name : " + headerName);
//     	 	String headerValues = request.getHeader(headerName);
//     	 	out.println(headerValues);
//      }
         String authorization = request.getHeader("authorization"); //This is SAML 2.0 token
         
//         Enumeration<String> parameterNames = request.getParameterNames();
//         while (parameterNames.hasMoreElements()) {
//        	 
//             String paramName = parameterNames.nextElement();
//             out.write(paramName);
//             out.write("n");
//  
//             String[] paramValues = request.getParameterValues(paramName);
//             for (int i = 0; i < paramValues.length; i++) {
//                 String paramValue = paramValues[i];
//                 out.println("t" + paramValue);                 
//             }
//  
//         }
         authorization = authorization.substring(8); 
         out.println(authorization);
//         out.println("<p>Request : " + request.getHeaderNames() + "</p>");
//         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
//         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
//         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
//         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
//         // Generate a random number upon each request
//         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
//         out.println("</body>");
//         out.println("</html>");
//      } catch (SettingsException e) {
////		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (Error e) {
////		// TODO Auto-generated catch block
//		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
         out.close();  // Always close the output writer
      }  
	}
}
