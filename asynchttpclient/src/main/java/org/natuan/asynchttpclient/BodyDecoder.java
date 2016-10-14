package org.natuan.asynchttpclient;

/**
 * 10/13/2016
 */
public interface BodyDecoder<T> {
    T decode(Body body) throws Exception;
}
