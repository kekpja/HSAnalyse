package capitolriot;

import org.json.simple.JSONArray;

public class Preprocessor {

	String[] Stringdates = {"06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
	int[] dates = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	String[] hashtags = {"capitolriot", "capitolriots", "CoupAttempt", "TrumpCoupAttempt", "capitolbreach", "AnatomyOfCapitolAttack"};
	
	public double[] avgSentimentDay() {
		
		double[] totalSentimentDay;
		int[] countTweetDay;
		
		JSONArray data = AppIO.readJson("SenScore_capitolbreach.json");
		
		//for every tweet
			//extract date
			//find position in array (-6)
			//add to Sentiment Score (compound) at that position
			//add 1 to count at that position
		
		//calculate average from scores: 
			//for every number in totalSentimentDay divide through int at that position
		
		return null;
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
