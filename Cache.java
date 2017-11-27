public class Cache
{

	private static Myslot Cache[][];
	public Cache(int Numberofsets,int setAssociative)
	{	
	    	this.Cache=new Myslot[Numberofsets][setAssociative];
	      	for(int i=0;i<Numberofsets;i++) 
	      	{
	      		for(int j=0;j<setAssociative;j++)
	      		{
	      			Cache[i][j]=new Myslot(i,j,0,0,0);
	      		}
	      	}			
	 }
	public Myslot get(int i,int j)
	{
		return Cache[i][j];
	}
	public void put(int a,int b,int c,int d,int e)
	{
		Cache[a][b]=new Myslot(a,b,c,d,e);
	}
}
