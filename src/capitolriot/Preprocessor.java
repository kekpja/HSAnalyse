package capitolriot;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Preprocessor {

	int[] dates = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
	String[] hashtags = {"capitolriot", "capitolriots", "CoupAttempt", "TrumpCoupAttempt", "capitolbreach", "AnatomyOfCapitolAttack"};
	
	
	
	public double[] avgSentimentDay(String path) {
	/** calculates average sentiment per day for the file in this path. Returns array of Sentiment Scores 	
		as doubles. First Entry is the score for  sixth of January (06.01.2021) **/
		
		double[] totalSentimentDay = new double[dates.length];
		int[] countTweetDay = new int[dates.length];
		
		System.out.println("Reading: " + path);
		JSONArray data = AppIO.readJson(path);
		
		//for every tweet
		for (Object x : data) {
			JSONObject tweet = (JSONObject) x;
			
			//extract date
			String dateString = tweet.get("date").toString().substring(8,10);
			int date = Integer.parseInt(dateString);
			
			//add to Sentiment Score (compound) at correct position (day) in array
			double senScore = Double.parseDouble(tweet.get("sentiment-compound").toString());
			totalSentimentDay[date-6] += senScore;
					
			//count number of tweets
			countTweetDay[date-6] += 1;
		}

		//calculate average from scores: for every number in totalSentimentDay divide through int at that position
		double[] avgSentimentPerDay = new double[dates.length];
		for (int i = 0; i < totalSentimentDay.length; i++) {
			avgSentimentPerDay[i] = totalSentimentDay[i] / countTweetDay[i];
		}
		
		//print results
		for (int i = 0; i < avgSentimentPerDay.length; i++) {
			System.out.println("January "+dates[i]);
			System.out.println("sentiment: "+avgSentimentPerDay[i]);
			
		}
		return avgSentimentPerDay;
	}
	
	
	
	
	
	public List<double[]> avgSenPerHashtagPerDay(String directoryPath) {
		/** Average sentiment per hashtag per day. Returns List of 6 double arrays,
		 * each array the scores for one hashtag, each double the score for one day.
		 * Receives path of directory containing all the hashtag files.
		 */
		
		List<double[]> scores = new ArrayList<>();
		File directory = new File(directoryPath);
		
		//run avgSentimentScore for every file in directory and store in list
		for (File JSONfile : directory.listFiles()) {
			System.out.println();
			System.out.println("Reading: " + JSONfile.getName());
			scores.add(avgSentimentDay(JSONfile.getAbsolutePath()));
		}	
		
		System.out.println(Arrays.toString(scores.toArray()));
		
		return scores;
	}
	
	
	
	
	
	
	public int[] tweetPerHashtagPerDay() {
		//Anzahl Tweets pro Tag pro Hashtag (-> HeatmapChart)
		return null;
	}
	
	public int[] tweetPerDay() {
		return null;
	}
	
	public int[] tweetPerHashtag() {
		return null;
	}
}
