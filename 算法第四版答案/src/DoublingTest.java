
import java.util.Arrays;

import edu.princeton.cs.*;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublingTest {
		public static double timeTrial(int N){
			int MAX=1000000;
			int[] a=new int[N];
			for(int i=0;i<N;i++){
				a[i]=StdRandom.uniform(-MAX,MAX);
			}
			Stopwatch timer=new Stopwatch();
			int cnt=count(a);
			return timer.elapsedTime();
		}
		
		public void addDataValue(double x,double y){
			StdDraw.point(x, y);
		}
		
		@SuppressWarnings("deprecation")
		public static int count(int[] a){
			Arrays.sort(a);
			int N=a.length;
			int cnt=0;
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++)
					if(BinarySearch.rank(-a[i]-a[j], a)>j)
						cnt++;
			return cnt;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdDraw.setXscale(0,5000);
		StdDraw.setYscale(0,5000);
		StdDraw.setPenRadius(.005);
		StdDraw.setPenColor(StdDraw.RED);
		/*int N=250;
		double time1=timeTrial(N);
		while(true){
			double time2=timeTrial(N*2);
			StdDraw.line(N, time1+250, N*2, time2+250);
			time1=time2;
			N+=250;
		}*/
		for (int i= 0;true; i++) {
			StdDraw.point(i, Math.pow(i, 2)/1000);
			
		}
	}
	

}
