
public class Myslot 
{
	 public int []slot;
	
	public Myslot(int a,int b,int c,int d,int e)
	{
		slot=new int[3];
		slot[0]=c;
		slot[1]=d;
		slot[2]=e;
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
	
	public String toString() {
		return "Tag: "+slot[0]+" offset: "+slot[1]+" Flag: "+slot[2];
	}
	
	

}
