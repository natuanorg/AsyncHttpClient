package org.natuan.asynchttpclient;

/**
 * 10/13/2016
 */
public interface BodyEncoder<T> {
    Body encode(T obj, String mimeType) throws Exception;
}
