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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract class ListOperation<T> implements Operation<List<T>> {

    @Override
    public List<T> execute(XmlRpcClient client, ResponseParser parser) throws XmlRpcException {
        Object response = client.execute(getMethodName(), getParams());
        try {
            return parser.bindList(getResponseClass(), (Map) response);
        } catch (InstantiationException | IllegalAccessException e) {
            return new ArrayList<>();
        }
    }

    abstract String getMethodName();

    abstract Object[] getParams();

    abstract Class<T> getResponseClass();
}
