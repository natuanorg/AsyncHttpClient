package org.natuan.asynchttpclient;

import java.lang.reflect.Type;

/**
 * Created by Nguyen Anh Tuan on 15/10/2016.
 * natuan.org@gmail.com
 */
public abstract class JsonResponseHandler<ResponseType> extends ResponseHandler {
    private final Type responseType;

    public JsonResponseHandler(Type responseType) {
        this.responseType = responseType;
    }

    abstract public void onSuccess(ResponseType response);

    @Override
    public void onSuccess(HTTPResponse response) {
        RawBody body = (RawBody) response.mBody;
        if (body != null) {
            ResponseType obj = null;
            try {
                obj = new JsonConverter<ResponseType>(responseType).decode(body);
                onSuccess(obj);
            } catch (Exception e) {
                onError(e);
            }
        } else {
            onSuccess((ResponseType) null);
        }
    }
}
