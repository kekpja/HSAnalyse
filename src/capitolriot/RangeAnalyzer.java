package capitolriot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RangeAnalyzer {

	
	
	public void printContentOfMostLikedTweets (int amount, String path) {
		/** Get an amount of max likes by iterating through the whole file saving one tweet always replacing 
		 * as soon as higher likeCount is found.
		 */
		
		int highestLikeCount = 0;
		JSONObject maxTweet = null;
		JSONArray data = AppIO.readJson(path);		
		
		for (int i = 0; i < amount; i++) {
			
			//calculate max number
			for (Object x : data) {
				JSONObject tweet = (JSONObject) x;
				int likeCount = Integer.parseInt(tweet.get("likeCount").toString());
				if (likeCount > highestLikeCount) {
					highestLikeCount = likeCount;
					maxTweet = tweet;
					//System.out.println(likeCount);
					//System.out.println("NEW MAX");
				}
			}
			
			System.out.println(maxTweet.get("content"));
			System.out.println(maxTweet.get("likeCount"));
			System.out.println("-----");

			
			//reset
			data.remove(maxTweet);
			highestLikeCount = 0;
			
		}	
	}
	
	
	
	
	public void printContentOfMostRetweetedTweets (int amount, String path) {
		
		int highestRTCount = 0;
		JSONObject maxTweet = null;
		JSONArray data = AppIO.readJson(path);		
		
		for (int i = 0; i < amount; i++) {
			
			//calculate max number
			for (Object x : data) {
				JSONObject tweet = (JSONObject) x;
				int RTCount = Integer.parseInt(tweet.get("retweetCount").toString());
				if (RTCount > highestRTCount) {
					highestRTCount = RTCount;
					maxTweet = tweet;
					//System.out.println(likeCount);
					//System.out.println("NEW MAX");
				}
			}
			
			System.out.println(maxTweet.get("content"));
			System.out.println(maxTweet.get("retweetCount"));
			System.out.println("-----");

			
			//reset
			data.remove(maxTweet);
			highestRTCount = 0;
		}
	}

	
	
	
	public void printFrequencyMapLikes (int amount, String path) {
		
		int highestLikeCount = 0;
		JSONObject maxTweet = null;
		JSONArray data = AppIO.readJson(path);	
		String[] tweetContent = new String[amount];
		List<String> words = new ArrayList<String>();
		
		//get TOP X in String Array
		for (int i = 0; i < amount; i++) {
			
			//calculate max number
			for (Object x : data) {
				JSONObject tweet = (JSONObject) x;
				int likeCount = Integer.parseInt(tweet.get("likeCount").toString());
				if (likeCount > highestLikeCount) {
					highestLikeCount = likeCount;
					maxTweet = tweet;
				}
			}
			
			//System.out.println(maxTweet.get("content"));
			//System.out.println(maxTweet.get("likeCount"));
			//System.out.println("-----");
			tweetContent = maxTweet.get("content").toString().split(" ");
			for (String s : tweetContent) words.add(s);

			
			//reset
			data.remove(maxTweet);
			highestLikeCount = 0;
			
		}
		
		//convert ArrayList to Array
		String[] wordArray = new String[words.size()];
		for (int i = 0; i < words.size(); i++) 
			wordArray[i] = words.get(i);
		
		
		//calculate frequency
        Map<String, Long> frequencyMap =
                    Stream.of(wordArray)
                    .collect(Collectors.groupingBy(Function.identity(),
                                            Collectors.counting()));
        
        //sort map
        // 1. Convert Map to List of Map
        List<Map.Entry<String, Long>> list =
                new LinkedList<Map.Entry<String, Long>>(frequencyMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Map.Entry<String, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        
        
        //print
        for (String s : sortedMap.keySet())
            System.out.println(s + ": " + sortedMap.get(s));
      
	   
	}
	
	
	
	

	
	
	public void getDictionaryTopRetweetcount (int amount, String path) {
		
		
		int highestRTCount = 0;
		JSONObject maxTweet = null;
		JSONArray data = AppIO.readJson(path);	
		String[] tweetContent = new String[amount];
		List<String> words = new ArrayList<String>();
		
		//get TOP X in String Array
		for (int i = 0; i < amount; i++) {
			
			//calculate max number
			for (Object x : data) {
				JSONObject tweet = (JSONObject) x;
				int retweetCount = Integer.parseInt(tweet.get("retweetCount").toString());
				if (retweetCount > highestRTCount) {
					highestRTCount = retweetCount;
					maxTweet = tweet;
				}
			}
			
			//System.out.println(maxTweet.get("content"));
			//System.out.println(maxTweet.get("likeCount"));
			//System.out.println("-----");
			tweetContent = maxTweet.get("content").toString().split(" ");
			for (String s : tweetContent) words.add(s);

			
			//reset
			data.remove(maxTweet);
			highestRTCount = 0;
			
		}
		
		//convert ArrayList to Array
		String[] wordArray = new String[words.size()];
		for (int i = 0; i < words.size(); i++) 
			wordArray[i] = words.get(i);
		
		
		//calculate frequency
        Map<String, Long> frequencyMap =
                    Stream.of(wordArray)
                    .collect(Collectors.groupingBy(Function.identity(),
                                            Collectors.counting()));
        
        //sort map
        // 1. Convert Map to List of Map
        List<Map.Entry<String, Long>> list =
                new LinkedList<Map.Entry<String, Long>>(frequencyMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Map.Entry<String, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        
        
        //print
        for (String s : sortedMap.keySet())
            System.out.println(s + ": " + sortedMap.get(s));
      
	   
	}
	
}
