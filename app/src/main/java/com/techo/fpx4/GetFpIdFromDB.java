package com.techo.fpx4;

import java.net.URLEncoder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetFpIdFromDB {

    public String getFpId(String email, String contact) {
        try {

            HttpGet httpget;
            HttpClient httpclient;
            httpclient = new DefaultHttpClient();
            httpget = new HttpGet(
                    "http://www.msu-footprints.org/app_fpid.php?email=" + URLEncoder.encode(email) + "&&contact=" + URLEncoder.encode(contact)); // change this to your URL.....
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httpget,
                    responseHandler);

            return response.trim();

        } catch (Exception e) {
            //System.out.println("ERROR : " + e.getMessage());
            return "error";
        }
    }
}