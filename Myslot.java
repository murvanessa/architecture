public class Myslot 
{
	 public int []slot;
	
	public Myslot(int a,int b,int c,int d,int e, int time)
	{
		slot=new int[4];
		slot[0]=c;
		slot[1]=d;
		slot[2]=e;
		slot[3]= time;
	}

	public  int getTag() {
		return slot[0];
	}

	public  void setTag(int t) {
		slot[0]= t;
	}

	public  int getFlag() {
		return slot[1];
	}

	public void setFlag(int f) {
		slot[1] = f;
	}

	public  int getOffset() {
		return slot[2];
	}

	public  void setOffset(int a) {
		slot[2] = a;
	}
	
	public  int getTime() {
		return slot[3];
	}

	public  void setTime(int time) {
		slot[3] = time;
	}
	
	
	public String toString() {
		return "Tag: "+slot[0]+" offset: "+slot[1]+" Flag: "+slot[2]+ " time: "+slot[3];
	}
	
	

}
