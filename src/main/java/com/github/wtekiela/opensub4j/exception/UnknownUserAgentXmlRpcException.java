/**
 * 
 */
package com.github.wtekiela.opensub4j.exception;

import org.apache.xmlrpc.XmlRpcException;

/**
 * @author peremanent
 *
 */
public class UnknownUserAgentXmlRpcException extends XmlRpcException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7136937634234281035L;

	/**
	 * @param pMessage
	 */
	public UnknownUserAgentXmlRpcException(String pMessage) {
		super(pMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pCode
	 * @param pMessage
	 */
	public UnknownUserAgentXmlRpcException(int pCode, String pMessage) {
		super(pCode, pMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pMessage
	 * @param pLinkedException
	 */
	public UnknownUserAgentXmlRpcException(String pMessage, Throwable pLinkedException) {
		super(pMessage, pLinkedException);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pCode
	 * @param pMessage
	 * @param pLinkedException
	 */
	public UnknownUserAgentXmlRpcException(int pCode, String pMessage, Throwable pLinkedException) {
		super(pCode, pMessage, pLinkedException);
		// TODO Auto-generated constructor stub
	}

}
