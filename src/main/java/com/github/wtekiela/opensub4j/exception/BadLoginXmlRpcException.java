/**
 * 
 */
package com.github.wtekiela.opensub4j.exception;

import org.apache.xmlrpc.XmlRpcException;

/**
 * @author peremanent
 *
 */
public class BadLoginXmlRpcException extends XmlRpcException {

	/**
	 * @param pMessage
	 */
	public BadLoginXmlRpcException(String pMessage) {
		super(pMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pCode
	 * @param pMessage
	 */
	public BadLoginXmlRpcException(int pCode, String pMessage) {
		super(pCode, pMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pMessage
	 * @param pLinkedException
	 */
	public BadLoginXmlRpcException(String pMessage, Throwable pLinkedException) {
		super(pMessage, pLinkedException);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pCode
	 * @param pMessage
	 * @param pLinkedException
	 */
	public BadLoginXmlRpcException(int pCode, String pMessage, Throwable pLinkedException) {
		super(pCode, pMessage, pLinkedException);
		// TODO Auto-generated constructor stub
	}

}
