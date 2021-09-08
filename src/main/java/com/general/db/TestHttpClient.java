package com.general.db;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;

import java.io.IOException;

public class TestHttpClient {
    public static void main(String[] args) throws IOException {

        SchemeRegistry sr = new SchemeRegistry();
        sr.register(new Scheme("http", 8002, PlainSocketFactory.getSocketFactory()));
        ThreadSafeClientConnManager connectionManager = new ThreadSafeClientConnManager(sr);

        HttpRoute routeSdm = new HttpRoute(new HttpHost("no-st-h12-s-d-vsdm-01"));
        connectionManager.setDefaultMaxPerRoute(512);
        connectionManager.setMaxForRoute(routeSdm, 512);
        connectionManager.setMaxTotal(512);

        HttpParams params = new BasicHttpParams();
        params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
        params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
        DefaultHttpClient httpClient = new DefaultHttpClient(connectionManager, params);
        HttpResponse httpResponse = httpClient.execute(new HttpGet("http://no-st-h12-s-d-vsdm-01:8002/sdm/fips"));
        System.out.println(httpResponse.getStatusLine().getStatusCode());
    }
}
