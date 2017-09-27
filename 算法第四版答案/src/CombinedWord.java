import java.util.concurrent.Exchanger;

import edu.princeton.cs.algs4.Quick;

public class CombinedWord {

	public static String[] CombinedWord(String[] s) {

		/*
		 * int N=s.length; String[] CW=new String[N]; int sum=0; for(int
		 * i=0;i<N;i++){ for(int j=0;j<N;j++){ for(int k=0;k<N;k++){
		 * StdOut.println(s[i]+" "+s[j]+" "+s[k]); if(s[i].equals(s[j]+s[k]))
		 * CW[sum++]=s[i]; } } } String[] subStrings=new String[sum]; for(int
		 * i=0;i<sum;i++) subStrings[i]=CW[i]; return subStrings;
		 */
	}

	public static boolean less(String s1,String s2){
		int N=s1.length();
		int M=s2.length();
		if(N<M)
			return true;
		else {
			return false;
		}
	}
	public static void exch(String[] s,int i,int j) {
		String sub=s[i];
		s[i]=s[j];
		s[j]=sub;
	}
	public static String[] sort(String[] a){
		int N=a.length;
		for(int i=0;i<N;i++){
			for(int j=i;j>0 && less(a[j],a[j-1]);j--){
				exch(a,j,j-1);
			}
		}
		return a;
	}
	public static int[][] only(String[] a) {
		a=sort(a);
		int N = a.length;
		int[][] sub = new int[N][N];
		sub[0][0] = a[0].length();
		StdOut.print(sub[0][0]);
		int index = 0;
		int i = 0;
		int j = 2;
		for(int h=0;h<N;h++)
			StdOut.println(a[h]);
		while (index < a.length) {
			if (sub[i][0] == a[index].length()) {
				sub[i][0] = a[index].length();
				sub[i][1]++;
				sub[i][j++] = index++;
			} else {
				sub[++i][0] = a[index].length();
				j = 2;
				sub[i][1]++;
				sub[i][j++] = index++;
			}
		}
		for(int h=0;h<N;h++)
			StdOut.println(sub[h][0]);
		return sub;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "after", "thought", "afterthought", "miss", "you",
				"missyou" };
		int[][] a = only(s);
		/*for (int i = 0; i < a.length; i++) {
				StdOut.print(a[i][0] + " ");
			StdOut.println();
		}*/
	}

}
