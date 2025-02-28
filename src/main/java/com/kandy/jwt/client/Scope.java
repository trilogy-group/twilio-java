package com.kandy.jwt.client;

import java.io.UnsupportedEncodingException;

/**
 * Token to access features of Kandy Client.
 */
public interface Scope {

    public String getPayload() throws UnsupportedEncodingException;

}
