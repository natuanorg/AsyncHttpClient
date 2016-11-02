package org.natuan.asynchttpclient;

/**
 * Created by Nguyen Anh Tuan on 03/11/2016.
 * natuan.org@gmail.com
 */

public class JsonResponseConverter<POJO> {
    /**
     * Convert HTTPResponse to POJO.
     * @param response
     * @param clazz
     * @return
     */
    public POJO convert(HTTPResponse response, Class clazz) {
        Throwable error = null;
        RawBody body = (RawBody) response.mBody;
        if (body != null) {
            POJO obj = null;
            try {
                obj = new JsonConverter<POJO>().decode(body, clazz);
                return obj;
            } catch (Exception e) {
                error = e;
            }
        }
        return null;
    }
}
