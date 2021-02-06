package capitolriot;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
		double[] dates = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		GraphCreator graphy = new GraphCreator();
		Preprocessor prep = new Preprocessor();
		
		//TODO: replace double[] with data array: average sentiment (all #) per day
		double[] avgSentimentPerDay = prep.avgSentimentDay("SenScore_capitolbreach.json");
		graphy.displayAverageSentiment(dates, avgSentimentPerDay);
		
		
		
		/*Example for reading tweet-data:
        JSONObject tweet = (JSONObject) data.get(0);
        System.out.println(tweet.get("content"));
        */
        
        
        // All Chart examples
		CategoryChart cat = new CategoryChartBuilder().width(600).height(500).title("FirstCategoryChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		BubbleChart bub = new BubbleChartBuilder().width(600).height(500).title("FirstBubbleChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		HeatMapChart heat = new HeatMapChartBuilder().width(600).height(500).title("FirstBubbleChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		PieChart pie = new PieChartBuilder().width(600).height(500).title("FirstPieChart").build();
		XYChart chart = new XYChartBuilder().width(600).height(500).title("FirstCategoryChart").yAxisTitle("Time").yAxisTitle("Sentiment").build();
		

		// XYSeries
		chart.addSeries("a", new double[] { 12, 30, 15, 0.7, 19 }, new double[] { 4, -5, 19, 6, 0.5 });
		XYSeries series = chart.addSeries("Gaussian Blob 2", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
		series.setMarker(SeriesMarkers.DIAMOND);
		
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
