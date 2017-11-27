
public class Myslot 
{
	 private static int set;
	 private static int num;
	 private static int tag;
	 private static int flag;
	 private static int offset;
	
	public Myslot(int a,int b,int c,int d,int e)
	{
		this.set=a;
		this.num=b;
		this.tag=c;
		this.flag=d;
		this.offset=e;
	}

	public  int getTag() {
		return tag;
	}

	public  void setTag(int tag) {
		this.tag = tag;
	}

	public  int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public  int getOffset() {
		return offset;
	}

	public  void setOffset(int offset) {
		this.offset = offset;
	}
	
	

}
