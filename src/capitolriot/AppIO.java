package capitolriot;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


public class AppIO {

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
