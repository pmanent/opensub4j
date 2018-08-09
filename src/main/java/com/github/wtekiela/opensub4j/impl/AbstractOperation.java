/**
 * Copyright (c) 2017 Wojciech Tekiela
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.github.wtekiela.opensub4j.impl;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

import com.github.wtekiela.opensub4j.exception.BadLoginXmlRpcException;
import com.github.wtekiela.opensub4j.exception.UnknownUserAgentXmlRpcException;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractOperation<T> implements Operation<T> {

    @Override
    public T execute(XmlRpcClient client, ResponseParser parser) throws XmlRpcException {
        Object response = client.execute(getMethodName(), getParams());
        System.out.println(response.toString());
        System.out.println(response.getClass());
        manageResponse(response);
        return parser.bind(getResponseObject(), (Map) response);
    }
    
    private void manageResponse(Object response) throws XmlRpcException{
    	if(response !=null && response instanceof java.util.HashMap){
    		HashMap<String, String> map = (HashMap<String, String>)response;
    		String status="";
    		status=map.get("status");
    		if("401 Unauthorized".equalsIgnoreCase(status)){
    			throw new BadLoginXmlRpcException("Bad Login Request");
    		} else if("414 Unknown User Agent".equals(status)){
    			throw new UnknownUserAgentXmlRpcException("Unknown user agent");
    			
    			
    		}
    	}
    	
    }

    abstract String getMethodName();

    abstract Object[] getParams();

    abstract T getResponseObject();

}
