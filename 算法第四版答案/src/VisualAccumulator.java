
public class VisualAccumulator {

	private double total=0;
	private int N=0;
	//ÉèÖÃ×ø±êÏµ
	public VisualAccumulator(int trials,double max){
		StdDraw.setXscale(0,trials);
		StdDraw.setYscale(0,max);
		StdDraw.setPenRadius(.005);
	}
	public void addDataValue(double val){
		N++;
		total+=val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}
}
