

public class EXEC_1_1_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.print(3);
		int N=4;
		boolean[][] a=new boolean[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(isprime(i,j))
					a[i][j]=true;
				else if(i==0 || j==0)
					a[i][j]=false;
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				StdOut.print(a[i][j]+" ");
			}
			StdOut.println();
		}
		
		
		}
	static boolean isprime(int a,int b){
		int[] factors_a=factors(a);
		int[] factors_b=factors(b);
		for(int i=0;i<factors_a.length;i++){
			for(int j=0;j<factors_b.length;j++){
				if(factors_a[i]==factors_b[j] || isZeroOrOne(factors_a[i],factors_b[j])){
					StdOut.println(factors_a[i]+" "+factors_b[j]);
					return false;
				}

			}
		}
		return true;
	}

	static int[] factors(int product){
		if(product==0){
			int[] factors={0};
			return factors;
		}else if(product==1){
			int[] factors={1};
			return factors;
		}else{
		int half=product/2;
		int[] sub=new int[100];
		int sum=0;
		for(int i=1;i<=half;i++){
			if(product%i==0){
				if(i==1){
					sub[sum++]=product;
				}else{
					sub[sum++]=i;
					sub[sum++]=product/i;
				}
			}
		}
		int[] factors=new int[sum];
		for(int i=0;i<sum;i++)
			factors[i]=sub[i];
		return factors;
		}

	}
	
	static boolean isZeroOrOne(int a,int b){
		if(a==0 || b==0 || a==1 || b==1)
			return true;
		else
			return false;
	}
	
		
	}

