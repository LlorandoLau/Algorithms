
public class Mihai_Patrascu {

	public static int[] Fibonacci(int length){
		int[] F=new int[length];
		F[0]=1;
		F[1]=1;
		for(int i=2;i<length;i++){
			F[i]=F[i-1]+F[i-2];
		}
		return F;
	}
	public static int MihaiSearch(int[] a,int key) {
		
		int N=a.length;
		int[] F=Fibonacci(N);
		
		
		int f1 = 0; //Fk
		int f0=0; //Fk-1
		
		for(int i=0;i<N;i++)
			if(F[i]>=N-1){
				f1=F[i];
				f0=F[i-1];
				break;
			}
		
		int lo=0;
		int hi=lo+f1;
		
		while(lo<=hi){
			int f2=f1-f0;
			StdOut.println("fk: "+f1+" fk-1: "+f0+" fk-2: "+f2+" a[i+Fk-2]: "+a[lo+f2]);
			if(key<a[lo+f2]){
				/*
				 * lo=0,fk_2=5,a[lo+f2]=a[5]=9
				 * 5<9
				 * hi=0+5=5
				 * Search in [0,5]
				 * fk=5
				 * fk_1=3
				 */
				hi=lo+f2;    
				f1=f2;
				f0-=f2;
			}
			else if(key>a[lo+f2]){
				lo+=f2;
				f1=f0;
				f0=f2;
			}
			else
				return lo+f2;		
		}
		
		return -1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,5,6,7,8,9,10,15,19,20};
		StdOut.print(a[MihaiSearch(a, 5)]);
		

	}

}
