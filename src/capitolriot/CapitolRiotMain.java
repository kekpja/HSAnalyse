package capitolriot;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class CapitolRiotMain {

	public static void main(String[] args) {
		double[] xData = new double[] { 0.0, 0.5, 2.0 };
		double[] yData = new double[] { 2.0, 0.5, 0.0 };

		// Create Chart
		XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

		// Show it
		new SwingWrapper(chart).displayChart();
	}

}
