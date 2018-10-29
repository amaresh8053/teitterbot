package com.cyberspy.io;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


@RestController
public class AutotweetController {
	
	Twitter twitter = new TwitterFactory().getInstance();
	
	@GetMapping("/timeline")
	public List<String> getTimeLine() throws TwitterException {
		
		System.setProperty("java.net.useSystemProxies", "true");
	    return twitter.getHomeTimeline().stream()
	      .map(item -> item.getText())
	      .collect(Collectors.toList());
	}
	
	@GetMapping("/post/{tweet}")
	public String createTweet(@PathVariable String tweet) throws TwitterException {
		System.out.println(" psting tweets.........."+tweet);
	    Status status = twitter.updateStatus(tweet);
	    return status.getText();
	}
}
