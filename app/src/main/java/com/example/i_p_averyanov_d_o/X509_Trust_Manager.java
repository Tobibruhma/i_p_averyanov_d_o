package com.example.i_p_averyanov_d_o;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class X509_Trust_Manager implements X509TrustManager {

    
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }


    HostnameVerifier TRUST_ALL_CERTIFICATES = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;

        }





    };








}