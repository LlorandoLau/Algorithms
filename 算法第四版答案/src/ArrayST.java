import org.omg.CORBA.ValueBaseHolder;


public class ArrayST<Value> {
	private double[] array;
	private int length;
	private int Max;
	public ArrayST(int max){
		array=new double[max];
		this.length=0;
		this.Max=max;
	}
	public void put(double val){
	if(length<Max)
			array[length++]=val;
	else {
		StdOut.println("The array is full");
	}
		
	}
	public int get(double val){
		for(int i=0;i<length;i++)
			if(array[i]==val)
				return i;
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayST a=new ArrayST(50);
		for(int i=0;i<50;i++){
			a.put(i*i-i);
		}
		for(int i=49;i>=1;i--){
			StdOut.println(a.get(i*i-i));
		}
	}

}
