package org.natuan.asynchttpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 10/13/2016
 */
public class TextPlainBody extends Body {

    private String mContent;

    public TextPlainBody(String mMineType) {
        super(mMineType);
    }



    @Override
    void consume(InputStream inputStream) throws IOException {
        byte[] content = read(inputStream);
        mContent = new String(content);
    }

    @Override
    void write(OutputStream out) throws IOException {
        out.write(mContent.getBytes());
    }

    public String getContent() {
        return mContent;
    }
}
