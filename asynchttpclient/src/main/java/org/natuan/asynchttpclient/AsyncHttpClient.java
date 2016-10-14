package org.natuan.asynchttpclient;

/**
 * 10/11/2016
 */
public interface AsyncHttpClient {
    void excute(HTTPRequest request, ResponseHandler handler);
}
