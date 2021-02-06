package capitolriot;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.knowm.xchart.BubbleChart;
import org.knowm.xchart.BubbleChartBuilder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.HeatMapChart;
import org.knowm.xchart.HeatMapChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.internal.chartpart.Annotation;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class CapitolRiotMain {

	
	//TODO replace with path to complete json-file ("SenScore_total.json")
	static String path = "D:/ASM_Data/SenScore/SenScore_capitolbreach.json";
	
	//TODO replace with path to local directory containing files with SenScores
	static String directoryPath = "D:/ASM_Data/SenScore";
	
	
	
	public static void main(String[] args) {
		double[] dates = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] intdates = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		// create singlesents -> json 
		double[] sent1 = {42, 7, 8, 9, 5, 11, 12, 13, 14, 3, 16, 17, 18, 19, 20, 21};
		double[] sent2 = {16, 7, 8, 9, 10, 1, 12, 13, 14, 15, 5, 17, 18, 19, 45, 21};
		double[] sent3 = {6, 2, 8, 9, 10, 11, 12, 13, 2, 15, 16, 17, 18, 19, 20, 21};
		double[] sent4 = {16, 7, 8, 9, 2, 11, 12, 5, 14, 15, 16, 17, 18, 19, 20, 21};
		double[] sent5 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 6, 16, 17, 18, 19, 20, 21};
		double[] sent6 = {1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 3, 20, 21};
		List<double[]> singlesents = new ArrayList<double[]>();
		singlesents.add(sent1);
		singlesents.add(sent2);
		singlesents.add(sent3);
		singlesents.add(sent4);
		singlesents.add(sent5);
		singlesents.add(sent6);
		
		// create tweetcount -> json
		int[] tweetcounts1 = {42, 7, 8, 9, 5, 11, 12, 13, 14, 3, 16, 17, 18, 19, 20, 21};
		int[] tweetcounts2 = {16, 7, 8, 9, 10, 1, 12, 13, 14, 15, 5, 17, 18, 19, 45, 21};
		int[] tweetcounts3 = {6, 2, 8, 9, 10, 11, 12, 13, 2, 15, 16, 17, 18, 19, 20, 21};
		int[] tweetcounts4 = {16, 7, 8, 9, 2, 11, 12, 5, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] tweetcounts5 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 6, 16, 17, 18, 19, 20, 21};
		int[] tweetcounts6 = {1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 3, 20, 21};
		List<int[]> tweetcounts = new ArrayList<int[]>();
		tweetcounts.add(tweetcounts1);
		tweetcounts.add(tweetcounts2);
		tweetcounts.add(tweetcounts3);
		tweetcounts.add(tweetcounts4);
		tweetcounts.add(tweetcounts5);
		tweetcounts.add(tweetcounts6);
		
		GraphCreator graphy = new GraphCreator();
		Preprocessor pre = new Preprocessor();
		AppIO io = new AppIO();

		
		double[] sents = pre.avgSentimentDay(path);
		// displays average sentiments for all hashtags
		graphy.displayAverageSentiment(dates, sents);
		

		singlesents = pre.avgSenPerHashtagPerDay(directoryPath);
		// displays average sentiments for each hashtags
		graphy.displayHashtagAverage(dates, singlesents);
		
		//TODO: replace int[] with data: tweets per hashtag -> in area charts to show total tweet amount
		graphy.displayTweetsPerHashtag(intdates, tweetcounts);
        
        
        // All Chart examples
		CategoryChart cat = new CategoryChartBuilder().width(600).height(500).title("FirstCategoryChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		BubbleChart bub = new BubbleChartBuilder().width(600).height(500).title("FirstBubbleChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		HeatMapChart heat = new HeatMapChartBuilder().width(600).height(500).title("FirstBubbleChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		PieChart pie = new PieChartBuilder().width(600).height(500).title("FirstPieChart").build();
		
		// Cat Series
		cat.addSeries("#capitolriot", new double[] { 1, 2, 3, 4}, new double[] { 0.3, -0.9, 0.9, -0.1});
		// Bub Series
		bub.addSeries("Hashtags", new double[] { 1, 2, 3, 4}, new double[] { 0.3, -0.9, 0.9, -0.1}, new double[] { 0.7, 4, 4, 15});
		// Heat Series
		heat.addSeries("Heat", new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3}, new int[][] {{2, 4, 5}, {1, 2, 7}, {0, 5, 0}, {2, 4, 7}, {2, 15, 8}});
		// Pie Series
		pie.addSeries("#capitolriot", 10000);
		pie.addSeries("#trumpcoup", 12000);
		pie.addSeries("#blm", 5000);
		//new SwingWrapper(cat).displayChart();
		//new SwingWrapper(bub).displayChart();
		//new SwingWrapper(heat).displayChart();
		//new SwingWrapper(pie).displayChart();

	}
	
	

}
