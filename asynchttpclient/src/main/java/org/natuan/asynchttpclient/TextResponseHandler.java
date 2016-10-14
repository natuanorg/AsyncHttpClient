package org.natuan.asynchttpclient;

/**
 * 10/13/2016
 */
public abstract class TextResponseHandler extends ResponseHandler {

    abstract void onSuccess(String response);

    @Override
    public void onSuccess(HTTPResponse response) {
        TextPlainBody body = (TextPlainBody) response.mBody;
        onSuccess(body.getContent());
    }
}
