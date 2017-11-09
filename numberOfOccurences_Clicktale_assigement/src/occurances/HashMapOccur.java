package occurances;

import java.util.HashMap;

public class HashMapOccur {

	public HashMap<Character, Integer> countOccur(String str){
		//Creating a HashMap containing char as a key and occurrences as  a value
		int len = str.length();
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		
		
		//Converting given string to char array
		char[] strArr = str.toCharArray();

		//checking each char of strArray
		for (char c : strArr){

			if(charCountMap.containsKey(c)){
				charCountMap.put(c, charCountMap.get(c)+1);
			}
			else{
				charCountMap.put(c, 1);
			}
		}
		
		return charCountMap;

	}
	
	public boolean stringCount(String str){
		
		if(str.length()>1000){
			return false;
		}
		else{
			return true;
		}
		
		
	}
}
