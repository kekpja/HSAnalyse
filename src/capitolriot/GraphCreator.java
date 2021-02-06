package capitolriot;

import org.json.simple.JSONArray;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class GraphCreator {
	
	public void displayAverageSentiment(double[] dates, double[] sentScores){
		CategoryChart cat = new CategoryChartBuilder().width(600).height(500).title("Average Sentiment (all #)").xAxisTitle("Day").yAxisTitle("Sentiment").build();
		cat.addSeries("global average", dates, sentScores);
		new SwingWrapper(cat).displayChart();
	}
	
	public void displayHashtagAverage(double[] dates, double[] sentScores) {
		
	}
	
	public void displayTweetsPerHashtag(int[] dates, int[] tweetCounts){
		
	}
}
