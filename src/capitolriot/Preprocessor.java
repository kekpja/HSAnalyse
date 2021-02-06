package capitolriot;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Preprocessor {

	int[] dates = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
	String[] hashtags = {"capitolriot", "capitolriots", "CoupAttempt", "TrumpCoupAttempt", "capitolbreach", "AnatomyOfCapitolAttack"};
	
	public double[] avgSentimentDay(String path) {
	/** calculates average sentiment per day for the file in this path. Returns array of Sentiment Scores 	
		as doubles. First Entry is the sixth of January (06.01.2021) **/
		
		double[] totalSentimentDay = new double[dates.length];
		int[] countTweetDay = new int[dates.length];
		
		JSONArray data = AppIO.readJson(path);
		System.out.println("finished reading file");
		
		//for every tweet
		for (Object x : data) {
			JSONObject tweet = (JSONObject) x;
			
			//extract date
			String dateString = tweet.get("date").toString().substring(8,10);
			int date = Integer.parseInt(dateString);
			
			//add to Sentiment Score (compound) at correct position in array
			double senScore = Double.parseDouble(tweet.get("sentiment-compound").toString());
			totalSentimentDay[date-6] += senScore;
					
			//count number of tweets
			countTweetDay[date-6] += 1;
		}

		//calculate average from scores: for every number in totalSentimentDay divide through int at that position
		double[] avgSentimentPerDay = new double[dates.length];
		for (int i = 0; i < totalSentimentDay.length; i++) {
			avgSentimentPerDay[i] = totalSentimentDay[i] / countTweetDay[i];
			System.out.println("January " + dates[i] + ": ");
			System.out.println(totalSentimentDay[i]);
			System.out.println(countTweetDay[i]);
			System.out.println(avgSentimentPerDay[i]);
			System.out.println();
		}
		for (int i = 0; i < avgSentimentPerDay.length; i++) {
			System.out.println("sentiment"+avgSentimentPerDay[i]);
			System.out.println("date"+dates[i]);
		}

		return avgSentimentPerDay;
	}
	
	
	
	
	
	public double[] avgSentPerHashtagPerDay() {
		//Sentiment Durchschnitt per Hashtag per day -> BubbleChart
		return null;
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
