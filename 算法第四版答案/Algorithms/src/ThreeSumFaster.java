import java.io.File;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;


public class ThreeSumFaster {

	public static int BiggerThanZero(int[] a) {
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
			if(a[i]>=0)
				return i;
		return -1;
	}
	public static int count(int[] a){
		Arrays.sort(a);
		int N=a.length;
		int cnt=0;
		int j=BiggerThanZero(a);
		if(j==-1)
			return -1;
		/*for(int i=0;i<N;i++)
		 * 	for(int j=i+1;j<N;j++)
		 * 类的循环里，运行的总次数=0+1+2+3+……+(N-1)
		 *                =(N-1)*N/2
		 * 
		 * T=(j-1)*j/2 * (N-j)
		 * t1(T)~(j^3/2)*N
		 * t1的时间复杂度是常数级别
		 */
		for(int i=0;i<j;i++){
			for(int h=i+1;h<j;h++){
				for(int k=j;k<N;k++){
					if(a[i]+a[h]+a[k]>0)
						continue;
					if(a[i]+a[h]+a[k]==0)
						cnt++;
					
				}
			}
		
		}
		/*T=(N-j-1)*(N-j)/2 * (j-1)
		 * t2~((j-1)/2)*N^2
		 * t2的时间复杂度是平方级别
		 */
		for(int h=j;h<N;h++){
			for(int k=h+1;k<N;k++){
				for(int i=j-1;i>=0;i--){
					int sum=a[i]+a[h]+a[k];
					if(sum<0)
						continue;
					if(sum==0)
						cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:\\Users\\Llorando\\2Kints.txt");
	    In in=new In(file);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int cnt=0;
        /*在这个循环里面，a[i]<a[j]<a[h],这样得到的组合唯一
        for(int i=0;i<a.length;i++){
        	for(int j=i+1;j<a.length;j++){
        		for(int h=j+1;h<a.length;h++)
        			if(a[i]+a[j]+a[h]==0){
        				StdOut.println(a[i]+" "+a[j]+" "+a[h]);
        				cnt++;
        			}
        	}
        }
        StdOut.print(cnt);*/
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
	}

}