import edu.princeton.cs.algs4.Point2D;


public class Exec_1_2_2 {

	public static void main(String[] args) {
		//Integer N=Integer.parseInt(args[0]);
		int N=9;
		
		double[] x=new double[N];
		double[] y=new double[N];
		Point2D[] p=new Point2D[N];
		
		for(int n=0;n<N;n++){
			 x[n]=Math.random();
			 y[n]=Math.random();
			 p[n]=new Point2D(x[n],y[n]);
		}
		
		double min=p[0].distanceTo(p[1]);
		
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				if(p[i].distanceTo(p[j])<min)
					min=p[i].distanceTo(p[j]);
			}
			
		}
		StdOut.println(min);	
		}

}
