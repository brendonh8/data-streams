package com.github.brendonh8.kafka.streaming;

import com.google.common.collect.Lists;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class TwitterProducer {
    public TwitterProducer() {}

    public static void main(String[] args){
        new TwitterProducer().run();
    }

    public void  run(){
        // create twitter client

        // create kafka producer

        // loop to send tweets to kafka
    }

    Properties prop;
    {
        try {
            prop = new Credentials("src/main/resources/config/config.properties").getCredentials();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createTwitterClient(){
        /* Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(100000);

        /* Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
        Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();

        List<String> terms = Lists.newArrayList("kafka");
        hosebirdEndpoint.trackTerms(terms);

        // These secrets should be read from a config file
        Authentication hosebirdAuth = new OAuth1((String) prop.get("key"), (String) prop.get("secret_key"),
                (String) prop.get("token"), (String) prop.get("token_secret"));
    }
}
