package org.natuan.asynchttpclient;

import java.io.IOException;
import java.io.InputStream;

/**
 * 10/13/2016
 */
public class BodyFactory {

    public static Body read(String mimeType, InputStream is) throws IOException {

        Body result = null;

        if (mimeType.startsWith("text")) {
            result = new TextPlainBody(mimeType);
            result.consume(is);
        } else if (mimeType.startsWith("application/json")
                || mimeType.startsWith("application/xml")) {
            result = new RawBody(mimeType);
        }

        if (result != null) {
            result.consume(is);
        }

        return result;
    }
}
