package com.cyberspy.io;


import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TestMain {
	
	
	static final String CONSUMER_KEY = "LOwTRIHq25lQ7aMYYynrgZval";
	static final String CONSUMER_SECRET = "7nVMNBdO00EHJ1iu1EWFIFRvVjIJ9D96imAsPFBzs8IAXUaY6R";
	static final String ACCESS_TOKEN = "4873705424-2FrUAJkUUVuHUna8EiEAYbH44L6VWf9CEgsTsYQ";
	static final String ACCESS_TOKEN_SECRET = "Wb4E6I8J7dlNXakQ2VhIJtWX7jxLvwFIsBf2D38IWUDvm";

	
	public static Twitter getTwitterInstance() {
	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey(CONSUMER_KEY)
	    .setOAuthConsumerSecret(CONSUMER_SECRET)
	    .setOAuthAccessToken(ACCESS_TOKEN)
	    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    return tf.getInstance();
	}
	private static void showHomeTimeline(Twitter twitter) {

	    List<Status> statuses = null;
	    try {
	        statuses = twitter.getHomeTimeline();

	        System.out.println("Showing home timeline.");

	        for (Status status : statuses) {
	            System.out.println(status.getUser().getName() + ":" + status.getText());
	            String url= "https://twitter.com/" + status.getUser().getScreenName() + "/status/" 
	            + status.getId();
	            System.out.println("Above tweet URL : " + url);
	        }
	    } catch (TwitterException e) {
	        e.printStackTrace();
	    }
	}
	public static void main(String[] args) throws TwitterException {
		
		showHomeTimeline(getTwitterInstance());
		
		

	}

}
