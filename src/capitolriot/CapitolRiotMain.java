package capitolriot;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CapitolRiotMain {

	public static void main(String[] args) {
		
		AppIO io = new AppIO();
		JSONArray data = io.readJson("SenScore_capitolbreach.json");
		
		//Example for reading tweet-data:
        JSONObject tweet = (JSONObject) data.get(0);
        System.out.println(tweet.get("content"));
		
	}
	
	

}
