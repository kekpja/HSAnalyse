package capitolriot;

import java.util.List;

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

	public void displayAverageSentiment(double[] dates, double[] sentScores) {
		// CategoryChart
		CategoryChart cat = new CategoryChartBuilder().width(600).height(500).title("Average Sentiment (all #)")
				.xAxisTitle("Day").yAxisTitle("Sentiment").build();
		// sentiment average (all tweets)
		cat.addSeries("global average", dates, sentScores);
		new SwingWrapper(cat).displayChart();
	}

	public void displayHashtagAverage(double[] dates, List<double[]> sentScores) {
		// XYSeries
		XYChart chart = new XYChartBuilder().width(600).height(500).title("average Sentiment per day (by #)")
				.xAxisTitle("Day").yAxisTitle("Sentiment").build();
		// Sentiment average (for each #)
		chart.addSeries("#capitolriot", dates, sentScores.get(0));
		chart.addSeries("#capitolriots", dates, sentScores.get(1));
		chart.addSeries("#CoupAttempt", dates, sentScores.get(2));
		chart.addSeries("#TrumpCoupAttempt", dates, sentScores.get(3));
		chart.addSeries("#capitolbreach", dates, sentScores.get(4));
		chart.addSeries("#AnatomyOfCapitolAttack", dates, sentScores.get(5));
		new SwingWrapper(chart).displayChart();
	}

	public void displayTweetsPerHashtag(int[] intdates, List<int[]> tweetCounts) {
		
		XYChart chart = new XYChartBuilder().width(600).height(400).title("Tweets per day (by #)").xAxisTitle("Day")
				.yAxisTitle("Tweetcount").build();
		// Customize Chart
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);

		// Series
		chart.addSeries("#capitolriot", intdates, tweetCounts.get(0));
		chart.addSeries("#capitolriots", intdates, tweetCounts.get(1));
		chart.addSeries("#CoupAttempt", intdates, tweetCounts.get(2));
		chart.addSeries("#TrumpCoupAttempt", intdates, tweetCounts.get(3));
		chart.addSeries("#capitolbreach", intdates, tweetCounts.get(4));
		chart.addSeries("#AnatomyOfCapitolAttack", intdates, tweetCounts.get(5));
		new SwingWrapper(chart).displayChart();
	}
}
