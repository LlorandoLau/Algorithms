import java.awt.Color;

public class Draw{
	
		public static void main(String[] args){
			int acc=500;
			StdDraw.setXscale(0,500);
			StdDraw.setYscale(0,500);
			StdDraw.setPenRadius(.005);
			for(int i=0;i<500;i++){
				StdDraw.setPenColor(Color.DARK_GRAY);
				StdDraw.point(20+((i-1)*50),20 );
				StdDraw.point(20,((i-1)*50)+20);
				StdDraw.setPenColor(Color.RED);
				StdDraw.point(i+70, Math.pow(i,3)+70);
				String s="("+i+" , "+Math.pow(i, 2)+")";
				StdDraw.text(i+110, Math.pow(i,3)+70,s);
			
	}
		}

}
		