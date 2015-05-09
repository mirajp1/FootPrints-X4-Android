package com.techo.fpx4;

import java.net.URLEncoder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetScheduleFromDB {

    public String getSchedule(String event_id_text) {
        try {

            HttpGet httpget;
            HttpClient httpclient;
            httpclient = new DefaultHttpClient();
            httpget = new HttpGet(
                    "http://www.msu-footprints.org/testdb1.php?eventid=" + URLEncoder.encode(event_id_text)); // change this to your URL.....
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httpget,
                    responseHandler);

            return response.trim();

        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
            return "error";
        }
    }
}