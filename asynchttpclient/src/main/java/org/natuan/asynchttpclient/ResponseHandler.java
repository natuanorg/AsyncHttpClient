package org.natuan.asynchttpclient;

/**
 * 10/11/2016
 */
public abstract class ResponseHandler {
    abstract public void onSuccess(HTTPResponse response);

    abstract public void onFailure(HTTPResponse response);

    abstract public void onError(Throwable error);
}
