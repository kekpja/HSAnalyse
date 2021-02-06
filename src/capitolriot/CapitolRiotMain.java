package capitolriot;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CapitolRiotMain {

	public static void main(String[] args) {
		
		Preprocessor pre = new Preprocessor();
		pre.avgSentimentDay("SenScore_capitolbreach.json");
		
		/*Example for reading tweet-data:
		JSONArray data = AppIO.readJson("SenScore_capitolbreach.json");
        JSONObject tweet = (JSONObject) data.get(0);
        System.out.println(tweet.get("content"));
        */
		
	}
	
	

}
