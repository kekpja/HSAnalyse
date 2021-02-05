package capitolriot;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CapitolRiotMain {

	public static void main(String[] args) {
		
		JSONArray data = readJson("SenScore_capitolbreach.json");
		
		//Example for reading tweet-data:
        JSONObject tweet = (JSONObject) data.get(0);
        System.out.println(tweet.get("content"));
		
	}
	
	
	
	
	public static JSONArray readJson(String path) {
		
	    try {
	        Object object = new JSONParser()
	                .parse(new FileReader(path));
	        
	        JSONArray data = (JSONArray)object;

	        return data;
	        
	    }
	    catch(FileNotFoundException fe) {
	        fe.printStackTrace();
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
