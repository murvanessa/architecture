public class Cache
{

	private static Myslot Cache[][];
	public Cache(int Numberofsets,int setAssociative)
	{	
	    	Cache=new Myslot[Numberofsets][setAssociative];
	    	
	      	for(int i=0;i<Numberofsets;i++) 
	      	{
	      		for(int j=0;j<setAssociative;j++)
	      		{
	      			Cache[i][j]=new Myslot(i,j,0,0,0,0);
	      		}
	      	}			
	 }
	public static Myslot getslot(int i,int j)
	{
		//System.out.println("je suis dans cache.getslot: i="+i+" j="+j);
		return Cache[i][j];
	}
	public void put(int a,int b,int c,int d,int e, int t)
	
	{
		
		getslot(a,b).setFlag(1);
		getslot(a,b).setTag(c);
		getslot(a,b).setOffset(e);
		getslot(a,b).setTime(t);
	}
	
	public static Myslot Replacemnt(int a, int b, int c, int d, int e) {
		Myslot age;
		boolean isEmpty = true;
		if(isEmpty)
			return getslot(a,b);
		else
			age = getslot(a,b);
			
		return null;
	}
	
}
