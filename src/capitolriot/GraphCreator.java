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
