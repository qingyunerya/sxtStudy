package 问答1;

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
private static List<List<Integer>> runn(String input){
		
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<Integer> li = null;
		int start=0;int end=0;
		for(int i=0;i<input.length()-1;i++)
		{
			start=i;
			while(input.charAt(i)==input.charAt(i+1)) {
				i++;
				if(i==(input.length()-1))break;
//				i++;
			}
			end=i;
			if(end-start+1>=3) {
				li = new ArrayList<Integer>();
				li.add(start);
				li.add(end);
				list.add(li);
			}
		}
		return list;
		
	}
	public static void main(String[] args) {
		System.out.println(run("你你你我我我我我我"));
	}
}
