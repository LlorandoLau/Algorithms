

public class Exec_1_2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ACTGACG";
		String t="TGACGAC";
		
		String fir=t.substring(0,1);
		int i=s.indexOf(fir);
		String sub=s.substring(i,s.length())+s.substring(0,i);
		
		if(sub.equals(t)){
			StdOut.print("s is the circular rotation of t");
		}else{
			StdOut.print("s is not the circular rotation of t");
		}
		
		}
		
	}

