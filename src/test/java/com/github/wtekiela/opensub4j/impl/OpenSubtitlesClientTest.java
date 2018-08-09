/**
 * 
 */
package com.github.wtekiela.opensub4j.impl;


import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.wtekiela.opensub4j.exception.BadLoginXmlRpcException;
import com.github.wtekiela.opensub4j.exception.UnknownUserAgentXmlRpcException;
import com.github.wtekiela.opensub4j.impl.OpenSubtitlesClientImpl;

/**
 * @author peremanent
 *
 */
public class OpenSubtitlesClientTest {

	/**
	 * 
	 */
	public OpenSubtitlesClientTest() {
	}
	@Test
    public void badCredentialsException() throws Exception {
    	
    	String protocol = "https";
		String host = "api.opensubtitles.org";
		Integer port = 443;
		String pathFile = "/xml-rpc";
		URL serverUrl = new URL(protocol, host, port,pathFile);
		
		OpenSubtitlesClientImpl osClient = new OpenSubtitlesClientImpl(serverUrl);
		XmlRpcException actual = null;
		try {
			osClient.login("dummy", "dummyPassword", "en", "TemporaryUserAgent");
		} catch (XmlRpcException e) {
			if(e instanceof BadLoginXmlRpcException){
				actual=e;
			}
		}
		Assert.assertNotNull(actual);
    	
    }
    
    @Test
    public void badUserAgentException() throws Exception {
    	
    	String protocol = "https";
		String host = "api.opensubtitles.org";
		Integer port = 443;
		String pathFile = "/xml-rpc";
		URL serverUrl = new URL(protocol, host, port, pathFile);
		
		OpenSubtitlesClientImpl osClient = new OpenSubtitlesClientImpl(serverUrl);
		XmlRpcException actual = null;
		try {
			osClient.login("dummy", "dummy", "es", "mporaryUserAgent");
		} catch (XmlRpcException e) {
			if(e instanceof UnknownUserAgentXmlRpcException){
				actual=e;
			}
		}
		Assert.assertNotNull(actual);
    	
    }
}
