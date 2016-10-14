package org.natuan.asynchttpclient;

/**
 * 10/11/2016
 */
public class Header {
    final String mName;
    final String mValue;

    public Header(String mName, String mValue) {
        this.mName = mName;
        this.mValue = mValue;
    }

    public String getName() {
        return mName;
    }

    public String getValue() {
        return mValue;
    }
}
