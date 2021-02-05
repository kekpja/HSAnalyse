package capitolriot;

import org.json.simple.JSONArray;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class GraphCreator {
	
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
			//add to Sentiment Score at that position
			//add 1 to count at that position
		
		//calculate average from scores: 
			//for every number in totalSentimentDay divide through int at that position
		
		return null;
	}
	
	public double[] avgSentimentHashtag() {
		return null;
	}
	
	public int[] hashtagPerDay() {
		return null;
	}
	
	public int[] tweetPerDay() {
		return null;
	}
	
	public int[] tweetPerHashtag() {
		return null;
	}
	
	public void displaySentimentChart(double[] sentScores){
		// Create Chart
				XYChart chart = new XYChartBuilder().width(600).height(500).title("Gaussian Blobs").xAxisTitle("X").yAxisTitle("Y").build();

				// Customize Chart
				chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
				chart.getStyler().setChartTitleVisible(false);
				chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
				chart.getStyler().setMarkerSize(16);

				// Series
				chart.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
				XYSeries series = chart.addSeries("Gaussian Blob 2", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
				series.setMarker(SeriesMarkers.DIAMOND);

				new SwingWrapper(chart).displayChart();
	}
	
	public void displayQuantityChart(int[] quantities){
		// Create Chart
				XYChart chart = new XYChartBuilder().width(600).height(500).title("Gaussian Blobs").xAxisTitle("X").yAxisTitle("Y").build();

				// Customize Chart
				chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
				chart.getStyler().setChartTitleVisible(false);
				chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
				chart.getStyler().setMarkerSize(16);

				// Series
				chart.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
				XYSeries series = chart.addSeries("Gaussian Blob 2", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
				series.setMarker(SeriesMarkers.DIAMOND);

				new SwingWrapper(chart).displayChart();
	}
}
