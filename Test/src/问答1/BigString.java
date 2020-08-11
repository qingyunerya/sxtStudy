package ÎÊ´ð1;

import java.util.ArrayList;
import java.util.List;

public class BigString{
	
	private static List<List<Integer>> run(String input){
		
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<Integer> li = null;
		int start=0;int end=0;int num=1;
		for(int i=0;i<input.length()-1;i++)
		{
			if(input.charAt(i)==input.charAt(i+1)) {
				num++;
				if(i==input.length()-2&&num>=3)
				{
						end=i+1;
						li = new ArrayList<Integer>();
						li.add(start);
						li.add(end);
						list.add(li);
				}
			}
			else
			{
				if(num>=3) {
					end=i;
					li = new ArrayList<Integer>();
					li.add(start);
					li.add(end);
					list.add(li);
				}
				start=i+1;
				num=1;
			}
			System.out.println(input.charAt(i));
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		System.out.println(run("ÄãÄãÄãÎÒÎÒÎÒ¸¡¶¯Ì¤Ì¤Ì¤Ì¤½Ó½ü·ôÉ«Ì¤·´·´¸´¸´·³·³·³·¨·³·³·´·´¸´¸´·³·³·³·³·³·³·³·³·³·³·³·³·³·³·³"));
	}
}
