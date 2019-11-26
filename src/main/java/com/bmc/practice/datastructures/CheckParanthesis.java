package com.bmc.practice.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckParanthesis {
	
	public static void checkWithArray(String par, Map map) {
		
		System.out.println("Checking with Array ...");
		
		char arr[] = par.toCharArray();
		boolean bal = true;
		
		if(((arr.length) % 2 != 0)) {
		
			System.out.println("in array .. not balanced !");
			return;
		}
			else {
				int m = (0 + arr.length)/2;
				int j = m;
				int i = --m;			
				
				while(i>=0 && j<arr.length) {
					if(arr[i]=='{' && arr[j]=='}' || arr[i]=='(' && arr[j]==')' || arr[i]=='[' && arr[j]==']') 
						bal = true;
					i--; j++;
				}				
			}
		if(bal) System.out.println("in array .. balanced !");
		else System.out.println("in array .. not balanced !");
		}
		
	

	public static void main(String[] args) {

	boolean balanced = true;	
	
    Map map = new HashMap();
    
    map.put('{','}');
    map.put('[', ']');
    map.put('(', ')');
    
    Stack st = new Stack();
    
    String parstr = "{()}[[";
    
    Character ch,stch;
    
    for(int i=0;i<parstr.length();i++) {
    	ch = parstr.charAt(i);
    	
    	if(map.containsKey(ch)) {
    		st.push(ch);
    	}
    	else if(map.containsValue(ch)) { 		
    		
    		if (st.isEmpty()) {
    			balanced = false;
    			break;
    			
    		} else {
    	 if(ch == ']' && (Character)st.pop() != '[')
            balanced = false;
        else if(ch == '}' && (Character)st.pop() != '{')
            balanced = false;
         else if(ch == ')' && (Character)st.pop() != '(')
            balanced = false;
    	} } }
    	
    
    	 if(!st.isEmpty()) balanced = false;
    	      
    if(balanced) System.out.println("Balanced !");
    else System.out.println("Nott Balanced !"); 
    
    checkWithArray(parstr,map);
    

	}

}
