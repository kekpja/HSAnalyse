package capitolriot;
import java.util.ArrayList;
import java.util.List;

public class CapitolRiotMain {

	// TODO replace with path to complete json-file ("SenScore_total.json")
	static String path = "D:/ASM_Data/SenScore/SenScore_capitolbreach.json";

	// TODO replace with path to local directory containing files with SenScores
	static String directoryPath = "D:/ASM_Data/SenScore";

	public static void main(String[] args) {
		GraphCreator graphy = new GraphCreator();
		Preprocessor pre = new Preprocessor();
		double[] dates = { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
		int[] intdates = { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
		List<double[]> singlesents = new ArrayList<double[]>();
		List<int[]> tweetcounts = new ArrayList<int[]>();

		// Create test Array for HeatMap (6 values in each array, dates.lenght arrays in
		// test)
		int[][] test = { { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, };
		//display HeatMap (tweetcount for all hashtags)
		//graphy.displayHeatMap(intdates, pre.tweetPerHashtagPerDayArray(directoryPath));

		// display average sentiments for all hashtags
		//double[] sents = pre.avgSentimentDay(path);
		//graphy.displayAverageSentiment(dates, sents);

		// display average sentiments for each hashtag
		//singlesents = pre.avgSenPerHashtagPerDay(directoryPath);
		//graphy.displayHashtagAverage(dates, singlesents);

		// displays tweetcount for each day for one hashtag
		//tweetcounts = pre.tweetPerHashtagPerDay(directoryPath);
		//graphy.displayTweetsPerHashtag(intdates, tweetcounts);
		
		
		
		RangeAnalyzer ra = new RangeAnalyzer();
		System.out.println("MOST LIKED TWEETS:");
		ra.printContentOfMostLikedTweets(10, path);
		
		System.out.println("MOST RETWEETED TWEETS:");
		ra.printContentOfMostRetweetedTweets(10, path);
		
		System.out.println("Frequency Map (LikeCount):");
		ra.printFrequencyMapLikes(1000, path);
		
		System.out.println("Frequency Map (RetweetCount):");
		ra.printFrequencyMapLikes(1000, path);
		

	}

}
