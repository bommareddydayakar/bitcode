package com.daya.algos.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTMLProcessor {
	public static void main(String[] args) {
		String s = "<p>one<p>two</p></p><div><div><div>alsflasjfljsf</div></div></div><br>";
		Element ele = new Element();
		StringBuffer sb = new StringBuffer();
		Map<String,String> map = new HashMap<String,String>();
		processString(s,sb,map,0);
		map.put("scraped-content", sb.toString());
		System.out.println(sb.toString());
		for (String key: map.keySet()) {
			System.out.println(key+"-->"+map.get(key));
		}
	}
	private static void processString(String s, StringBuffer sb, Map<String, String> map,int count) {
		if(s == null || s.length() == 0)
			return ;
		s = s.trim();
		int be = s.indexOf('<');
		int end = s.indexOf('>');
		
		if(be != 0){
			map.put("#ph"+ ++count +"#", s.substring(0, be));
			sb.append("#ph"+ count +"#");
		}
		sb.append(s.substring(be,end+1));
		processString(s.substring(end+1), sb,map,count);
	}
	private static void processString(String s, Element ele) {
		if(s == null || s.length() < 0)
			return ;
		int be = s.indexOf('<');
		if(be > 0){
			// Text encountered
			ele.text = s.substring(0,be);
		}
		if(be > -1){
			int i =be+1;
			while(i<s.length() && s.charAt(i++) == ' '){
			}
			if(s.charAt(i-1) =='/'){
				//end element
				int en  = s.indexOf('>');
				ele.end = s.substring(be,en+1);
			}else{
				int en  = s.indexOf('>');
				Element children = new Element();
				children.start = s.substring(be,en+1);
				processString(s.substring(en+1), children);
				ele.children.add(children);
				
				
			}
		}
	}
}
class Element{
	String start = "";
	String end = "";
	String text = "";
	List<Element> children = new ArrayList<Element>();
}