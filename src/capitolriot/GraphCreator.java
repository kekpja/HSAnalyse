package capitolriot;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.BubbleChart;
import org.knowm.xchart.BubbleChartBuilder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.HeatMapChart;
import org.knowm.xchart.HeatMapChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class GraphCreator {

	public void displayAverageSentiment(double[] dates, double[] sentScores) {
		// CategoryChart
		CategoryChart cat = new CategoryChartBuilder().width(600).height(500).title("Average Sentiment (all #)")
				.xAxisTitle("Day").yAxisTitle("Sentiment").build();
		// sentiment average (all tweets)
		cat.addSeries("global average", dates, sentScores);
		new SwingWrapper(cat).displayChart();
		try {
			BitmapEncoder.saveBitmap(cat, "./AverageSentiment", BitmapFormat.PNG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayHashtagAverage(double[] dates, List<double[]> sentScores) {
		XYChart chart = new XYChartBuilder().width(600).height(500).title("average Sentiment per day (by #)")
				.xAxisTitle("Day").yAxisTitle("Sentiment").build();
		// Sentiment average (for each #)
		chart.addSeries("#AnatomyOfCapitolAttack", dates, sentScores.get(0));
		chart.addSeries("#capitolbreach", dates, sentScores.get(1));
		chart.addSeries("#capitolriot", dates, sentScores.get(2));
		chart.addSeries("#capitolriots", dates, sentScores.get(3));
		chart.addSeries("#CoupAttempt", dates, sentScores.get(4));
		chart.addSeries("#TrumpCoupAttempt", dates, sentScores.get(5));
		new SwingWrapper(chart).displayChart();try {
			BitmapEncoder.saveBitmap(chart, "./HashtagAverage", BitmapFormat.PNG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayTweetsPerHashtag(int[] intdates, List<int[]> tweetCounts) {

		XYChart chart = new XYChartBuilder().width(600).height(400).title("Tweets per day (by #)").xAxisTitle("Day")
				.yAxisTitle("Tweetcount").build();
		// AreaChart
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);

		// Series
		chart.addSeries("#AnatomyOfCapitolAttack", intdates, tweetCounts.get(0));
		chart.addSeries("#capitolbreach", intdates, tweetCounts.get(1));
		chart.addSeries("#capitolriot", intdates, tweetCounts.get(2));
		chart.addSeries("#capitolriots", intdates, tweetCounts.get(3));
		chart.addSeries("#CoupAttempt", intdates, tweetCounts.get(4));
		chart.addSeries("#TrumpCoupAttempt", intdates, tweetCounts.get(5));
		new SwingWrapper(chart).displayChart();
		try {
			BitmapEncoder.saveBitmap(chart, "./TweetsPerHashtag", BitmapFormat.PNG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayHeatMap(int[] intdates, int[][] tweetsPerDay) {
		int[] hashtags = {1,2,3,4,5,6};
		Color[] farben = {Color.white, Color.yellow, Color.orange, Color.red};
		HeatMapChart heat = new HeatMapChartBuilder().width(600).height(500).title("Tweets per Day (by #)")
				.yAxisTitle("Days").yAxisTitle("Hashtags").build();
		heat.addSeries("Heat", intdates, hashtags, tweetsPerDay);
		heat.getStyler().setShowValue(true);
		heat.getStyler().setRangeColors(farben);
		new SwingWrapper(heat).displayChart();
		try {
			BitmapEncoder.saveBitmap(heat, "./TweecountHeatmap", BitmapFormat.PNG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
