package com.crm.qa.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Headers;
public class HandleBasicAuth {
	
public static void main(String[] args) {
		
		
		// Start Chrome Browser
		ChromeDriver driver=new ChromeDriver();
		
		// Get devTools
		DevTools chromeDevTools=driver.getDevTools();
		
		// Create sessions
		chromeDevTools.createSession();
		
		// Enable network
		chromeDevTools.send(Network.enable(Optional.of(0), Optional.of(0), Optional.of(0)));

		// Create hashmap for storing key value pair
		Map<String, Object> header=new HashMap<>();
	
		// Create authentication string- please replace with your application username and password - in current case guest is username and password as well.
		String basicAuth ="Basic " + new String(new Base64().encode(String.format("%s:%s", "guest", "guest").getBytes()));
		
		// add Authorization as key and basicAuth as value
		header.put("Authorization", basicAuth);
		
		// add authentication as part of header
		chromeDevTools.send(Network.setExtraHTTPHeaders(new Headers(header)));
		
		// please replace this with your application url
		driver.get("https://jigsaw.w3.org/HTTP/");
		
		// click on link and your request should be authenticated
		driver.findElement(By.linkText("Basic Authentication test")).click();
		
	}
	
	

}
