import java.io.BufferedReader;
import java.io.File;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.*;


public class Mycache 
{
	static int hits = 0;
	static int miss = 0;
	static boolean ispresent = false;
	int total = 0;
	static int count = 0;
	
	private static long getCurrentTime() {
        Date date = new Date(System.currentTimeMillis());
        return date.getTime();
	}
	
	 
	
	public static void main(String[] args) throws IOException, ParseException
	{ 
		System.out.println("test");
		String file;
		int j=0;
		int index=0;
		int tag=0;
		int indint=0;
		int offint=0;
		int tagint=0;
		String offset="";
		String indexs="";
		String tags="";
		Cache Cacheinstance=new Cache(32,4);
        file = args[0];
        InputStream ips = new FileInputStream(file);
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String ligne;
        
        while ((ligne = br.readLine()) != null) 
        {
        	//total=total+1;
        	String chaine[] = ligne.split("\\s");
        	String w="R";
        		if(chaine[1].equals(w))
        		{
        			count++;
        			String A=chaine[2];
        			A=A.replace("0x", "");
        			Long C=Long.parseLong(A,16);
        			String B=C.toBinaryString(C);
        			indexs="";
        			for(int h=B.length()-10;h<B.length()-5;h++)
        			{
        				indexs+=B.charAt(h);
        				indint=Integer.parseInt(indexs,2);
        				
        			}
        			offset="";
        			for(int h=B.length()-5;h<B.length();h++)
        			{
        				offset+=B.charAt(h);
        				offint=Integer.parseInt(offset,2);
        				
        			}
        			tags="";
        			for(int h=0;h<B.length()-10;h++)
        			{
        				tags+=B.charAt(h);
        				tagint=Integer.parseInt(tags,2);
        			}
        			
        			for (int i=0;i<32;i++)
        			{  System.out.println("the new slot is i:  "+i+"    il la le flag="+Cacheinstance.getslot(i,0).getFlag());
					
        				if(i==indint)
        				{ispresent = false;
        					System.out.println("----------------------------------- avec i="+i);
        					for(int l=0;l<4;l++){
        							System.out.println("mon  i:  "+i+"mon  l:  "+l+"    il la le flag="+Cacheinstance.getslot(i,l).getFlag());
            						if(Cacheinstance.getslot(i,l).getFlag()==0) {
            							Cacheinstance.put(i, l, tagint, 1, offint, (int)getCurrentTime());
            							System.out.println("mon nouveau slot est pour i:  "+i+"    il la le flag=  "+Cacheinstance.getslot(i,0).getFlag() + "  le temps d'accès " + Cacheinstance.getslot(i, l).getTime());
            							miss= miss+1;
            							System.out.println("nouveau miss :"+miss);
            							ispresent = true;
            							System.out.println("is it present :"+ispresent);
            							break;
            						}
            						else {
            							if(Cacheinstance.getslot(i, l).getTag() == tagint && Cacheinstance.getslot(i,l).getOffset() == offint) {
            								Cacheinstance.put(i, l, tagint, 1, offint, (int)getCurrentTime());
            								System.out.println("mon nouveau slot est pour i:  "+i+"    il la le flag=  "+Cacheinstance.getslot(i,0).getFlag() + "  le temps d'accès " + Cacheinstance.getslot(i, l).getTime());
            								hits = hits+1;
            								System.out.println("nouveau hits :"+hits);
            								ispresent = true;
            								break;
            							}
            						}
        							
        						}
        					if(!ispresent) {
        						int lru = 0;
        						for(int k=0;k<3;k++) {
        							if(Cacheinstance.getslot(i, lru).getTime() < Cacheinstance.getslot(i, k).getTime()) {
        								lru = k;
        								
        							}
        							Cacheinstance.put(i, lru, tagint, 1, offint, (int)getCurrentTime());
    								miss = miss+1;
    								System.out.println("mon nouveau slot est pour i:  "+i+"    il la le flag=  "+Cacheinstance.getslot(i,lru).getFlag() + "  le temps d'accès " + Cacheinstance.getslot(i, lru).getTime());
    								break;
        						}
        						
        					}
        					
        						
        					}
        				}
        				
        			}
        						
        			
        			System.out.println("");
    				System.out.println("");
        			System.out.println("");
    				System.out.println("");
        		
        		}
        System.out.println("no of hits : "+hits);
		System.out.println("no of miss : "+miss);
		System.out.println("total : "+(miss+hits));
		System.out.println("total count : "+count);
		System.out.println("hit ratio : "+(hits*100)/(hits+miss));
        
        }
	}
