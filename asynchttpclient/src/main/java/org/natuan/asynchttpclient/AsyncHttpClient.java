package org.natuan.asynchttpclient;

/**
 * Created by Nguyen Anh Tuan on 15/10/2016.
 * natuan.org@gmail.com
 */
public interface AsyncHttpClient<T> {
    void excuteAsync(HTTPRequest request, ResponseHandler handler);
    T excuteSync(HTTPRequest request, Class<T> clazz);
}
