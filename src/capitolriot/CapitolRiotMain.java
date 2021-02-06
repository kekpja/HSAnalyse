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

	public static void main(String[] args) {
		double[] dates = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] intdates = {1, 2, 12, 7, 4, 5, 1, 13, 3, 15, 3, 4, 18, 43, 20, 5};
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
		GraphCreator graphy = new GraphCreator();
		Preprocessor pre = new Preprocessor();
		AppIO io = new AppIO();
		String path = "SenScore_capitolbreach.json";
		
		io.readJson(path);
		double[] sents = pre.avgSentimentDay(path);
		//TODO: replace double[] with data: average sentiment (all #) per day
		graphy.displayAverageSentiment(dates, sents);
		
		//TODO: replace double[] with data: average sentiment (single #) per day
		graphy.displayHashtagAverage(dates, singlesents);
		
		//TODO: replace int[] with data: tweets per hashtag -> in area charts to show total tweet amount
		graphy.displayTweetsPerHashtag(intdates, new int[] {1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 25});
		
		JSONArray data = AppIO.readJson("SenScore_capitolbreach.json");
		
		//Example for reading tweet-data:
        JSONObject tweet = (JSONObject) data.get(0);
        System.out.println(tweet.get("content"));
        
        
        
        // All Chart examples
		CategoryChart cat = new CategoryChartBuilder().width(600).height(500).title("FirstCategoryChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		BubbleChart bub = new BubbleChartBuilder().width(600).height(500).title("FirstBubbleChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		HeatMapChart heat = new HeatMapChartBuilder().width(600).height(500).title("FirstBubbleChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		PieChart pie = new PieChartBuilder().width(600).height(500).title("FirstPieChart").build();
		XYChart chart = new XYChartBuilder().width(600).height(500).title("FirstCategoryChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		

		// XYSeries
		chart.addSeries("#capitolriot", dates, sent1);
		chart.addSeries("#capitolriots", dates, sent2);
		chart.addSeries("#CoupAttempt", dates, sent3);
		chart.addSeries("#TrumpCoupAttempt", dates, sent4);
		chart.addSeries("#capitolbreach", dates, sent5);
		chart.addSeries("#AnatomyOfCapitolAttack", dates, sent6);
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
		new SwingWrapper(chart).displayChart();
		//new SwingWrapper(bub).displayChart();
		//new SwingWrapper(heat).displayChart();
		//new SwingWrapper(pie).displayChart();

	
		// XYChart AREA CHART
		/*
		// Create Chart
		final XYChart chart = new XYChartBuilder().width(600).height(400).title("Area Chart").xAxisTitle("X").yAxisTitle("Y").build();

		// Customize Chart
		chart.getStyler().setLegendPosition(LegendPosition.InsideNE);

		// Series
		chart.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
		chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
		chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });
		chart.addSeries("d", new double[] { 0.3, -0.9, 0.9, -0.1}, new double[] { 0.7, 4, 4, 15});
		chart.addSeries("e", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
		chart.addSeries("f", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

		  @Override
		  public void run() {

		    // Create and set up the window.
		    JFrame frame = new JFrame("Advanced Example");
		    frame.setLayout(new BorderLayout());
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    // chart
		    JPanel chartPanel = new XChartPanel<XYChart>(chart);
		    frame.add(chartPanel, BorderLayout.CENTER);

		    // label
		    JLabel label = new JLabel("Blah blah blah.", SwingConstants.CENTER);
		    frame.add(label, BorderLayout.SOUTH);

		    // Display the window.
		    frame.pack();
		    frame.setVisible(true);
		    
		  }
		});
		*/
	}
	
	

}
