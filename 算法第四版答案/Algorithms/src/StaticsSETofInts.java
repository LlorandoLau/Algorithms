
import java.util.*;
public class StaticsSETofInts {

	private int[] a;
	public StaticsSETofInts(int[] keys) {
		a=new int[keys.length];
		for(int i=0;i<keys.length;i++)
			a[i]=keys[i];
		Arrays.sort(a);
	}
	public boolean contains(int key){
		return rank(key)!=-1;
	}
	private int rank(int key) {
		int lo=0;
		int hi=a.length-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			if(key<a[mid])
				hi=mid-1;
			else if(key>a[mid])
				lo=mid+1;
			else 
				return mid;
			
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
