public class F{
	static double[] F=new double[100];
	public static void main(String[] args){
		for(int i=0;i<100;i++){
			cal_F(i);
			StdOut.println(i+" "+F[i]);
		}
	}
	public static void cal_F(int N){
		if(N==0)
			F[N]=0;
		else if(N==1)
			F[N]=1;
		else F[N]=F[N-1]+F[N-2];
	}
	
}