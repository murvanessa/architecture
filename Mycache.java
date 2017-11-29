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
        	String w="W";
        		if(chaine[1].equals(w))
        		{
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
        			{  System.out.println("mon nouveau slot est pout i:  "+i+"    il la le flag="+Cacheinstance.getslot(i,0).getFlag());
					
        				if(i==indint)
        				{System.out.println("----------------------------------- avec i="+i);
        					for(int l=0;l<4;l++)
        					{System.out.println("mon  i:  "+i+"mon  l:  "+l+"    il la le flag="+Cacheinstance.getslot(i,l).getFlag());
        						if(Cacheinstance.getslot(i,l).getFlag()==0)
        						{      		
        							Cacheinstance.getslot(i, l).setFlag(1);
        							System.out.println("mon nouveau slot est pout i:  "+i+"    il la le flag="+Cacheinstance.getslot(i,l).getFlag());
        							
        							
        							break;
        						}
        						
        						
        					}        					
        				}
        				
        			}
        						
        			
        			System.out.println("");
    				System.out.println("");
        			System.out.println("");
    				System.out.println("");
        		
        		}
        
        	}
    
        }
	}


