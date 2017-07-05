package eliza2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Eliza {
	String response = "", question = "", qualifier = "";
	public HashMap<String,String> replacementMap = new HashMap<String, String>();
	public Set<String> hedgeSet = new HashSet<String>();
	public Set<String> qualifierSet = new HashSet<String>();
	Random rand = new Random();
	public Eliza () {

		hedgeSet.add("Please tell me more");
		hedgeSet.add("Many of my patients tell me the same thing");
		hedgeSet.add("It is getting late, maybe we had better quit");

		replacementMap.put("i", "you");
		replacementMap.put("me", "you");
		replacementMap.put("my", "your");
		replacementMap.put("am", "are");
		replacementMap.put("My", "your");
		replacementMap.put("I", "you");	

		qualifierSet.add("Why do you say that ");
		qualifierSet.add("You seem to think that ");
		qualifierSet.add("So, you are concerned that ");
	}
	private String replace(String input) {
		question = choice(qualifierSet);
		String[] words = input.split("\\s+");
		int i =0;
		for (; i <= words.length-1; i++) {
			for (String key : replacementMap.keySet()) {
				if (key.equals(words[i])) {
					words[i] = replacementMap.get(words[i]);
					
				}
				
			}
			question = question+words[i]+" ";
		}	
		return	question;
	}		

	public String choice(Set s) {
		int index = rand.nextInt(s.size());
		Iterator<String> iter = s.iterator();
		for (int i = 0; i < index; i++) {
			qualifier = iter.next();	
		} 
		//System.out.print(qualifier + " " + question);
		return iter.next();
	}

	public String response(String input) {
		Random rand = new Random();
		int style = rand.nextInt(2);
		if (style == 0 ) {
			return replace(input);
		}
		else {
			return choice(hedgeSet);
		}
	}
}
