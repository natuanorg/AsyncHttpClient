package org.natuan.asynchttpclient;

/**
 * Created by Nguyen Anh Tuan on 15/10/2016.
 * natuan.org@gmail.com
 */
public interface AsyncHttpClient {
    void excuteAsync(HTTPRequest request, ResponseHandler handler);
    Result<HTTPResponse> excuteSync(HTTPRequest request);
}
