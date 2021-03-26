// Java program to count occurrences of pattern 
// in a text. 
import java.io.*;
import java.lang.NumberFormatException;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Comparator;
class Prog7
{ 
	int KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 

		// create lps[] that will hold the longest 
		// prefix suffix values for pattern 
		int lps[] = new int[M]; 
		int j = 0; // index for pat[] 

		// Preprocess the pattern (calculate lps[] 
		// array) 
		computeLPSArray(pat,M,lps); 

		int i = 0; // index for txt[] 
		int res = 0; 
		int next_i = 0; 
		
		while (i < N) 
		{ 
			if (pat.charAt(j) == txt.charAt(i)) 
			{ 
				j++; 
				i++; 
			} 
			if (j == M) 
			{ 
				// When we find pattern first time, 
				// we iterate again to check if there 
				// exists more pattern 
				j = lps[j-1]; 
				res++; 

				// We start i to check for more than once 
				// appearance of pattern, we will reset i 
				// to previous start+1 
				if (lps[j]!=0) 
					i = ++next_i; 
				j = 0; 
			} 

			// mismatch after j matches 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) 
			{ 
				// Do not match lps[0..lps[j-1]] characters, 
				// they will match anyway 
				if (j != 0) 
					j = lps[j-1]; 
				else
					i = i+1; 
			} 
		} 
		return res; 
	} 

	void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		// length of the previous longest prefix suffix 
		int len = 0; 
		int i = 1; 
		lps[0] = 0; // lps[0] is always 0 

		// the loop calculates lps[i] for i = 1 to M-1 
		while (i < M) 
		{ 
			if (pat.charAt(i) == pat.charAt(len)) 
			{ 
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else // (pat[i] != pat[len]) 
			{ 
				// This is tricky. Consider the example. 
				// AAACAAAA and i = 7. The idea is similar 
				// to search step. 
				if (len != 0) 
				{ 
					len = lps[len-1]; 

					// Also, note that we do not increment 
					// i here 
				} 
				else // if (len == 0) 
				{ 
					lps[i] = len; 
					i++; 
				} 
			} 
		} 
	} 
	


public void findSubstr(String input, int length, boolean verbose) {

    LinkedHashMap<String, Integer> counts = 
      new LinkedHashMap<String, Integer>();
    LinkedHashMap<String, LinkedList<Integer>> collisions = 
      new LinkedHashMap<String, LinkedList<Integer>>();

    //remove all non-alpha characters
    input = input.replaceAll("[^A-Za-z]", "");
    boolean foundSubStr = false;
    int orig_len = length;
    boolean found_any = false;

    //sliding window to check for repeated substrings.
    for ( int i=0, j=length; j <= input.length() ;) {
      String sub = input.substring(i, j);

      //if the substring is in the map
      if ( counts.containsKey(sub) && collisions.containsKey(sub) ){
        int count = counts.get(sub);
        counts.put(sub, count+1);
    
        //store the index of the substring
        LinkedList<Integer> temp = collisions.get(sub);
        temp.add(i);
        collisions.put(sub, temp);
        
        //set found to true
        foundSubStr = true;
        found_any = true;
      }
      //put it in the map with a count of 1
      else {
        counts.put(sub, 1);
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(i);
        collisions.put(sub, list);
      }

      // condition that checks if it didn't any substrings of size 'length', 
      // then don't contiue to check length 'length + 1')
      if( j == input.length() && foundSubStr == true){
        foundSubStr = false;      
        i = 0;
        length += 1;
        j = length;
      }
      else {
        i++;
        j++;
      }
    }
    
    //The output must be sorted by length, then count, then alphabetically.
    // The comparator and treemap sort on theses three values
    TreeMap<String, Integer> counts_final =
      new TreeMap<String, Integer>(new LengthCompare(counts));

    //Sort elements by putting back in map
    for (Map.Entry<String, Integer> entry : counts.entrySet()){
      counts_final.put(entry.getKey(), entry.getValue());
    }

    if ( verbose ){
      for (Map.Entry<String, LinkedList<Integer>> entry: collisions.entrySet()){
        System.out.println( "Substr: " + entry.getKey() + " list: " 
                              + entry.getValue()) ;
      } 
      for (Map.Entry<String, Integer> entry: counts_final.entrySet() ){
        System.out.println( "Substr: " + entry.getKey() + " count: " 
                            + entry.getValue()) ;
      } 
    }
    //Don't print if we never found any!
    if( found_any ){
      printSubstrResults(counts_final, collisions, orig_len);
    }
  }
  
  /**
   * Prints the substring counts, the repeated substrings and the positions of
   * each substring in the ciphertext with a distance from the previous 
   * substring.
   *@param counts is a sorted map with the substrings as keys and counts as values
   *@param locations is a map with the substrings as keys and a linked list of the 
   * index of each substring.
   *@param orig_len is a copy of the original minimum length inputed by the user
   */
  public void printSubstrResults( TreeMap<String, Integer> counts, 
                                  LinkedHashMap<String, LinkedList<Integer>> 
                                  locations, int orig_len ){

    System.out.println("Length Count Word Location (distance)");
    System.out.println("====== ===== ==== =========");

    for (Map.Entry<String, Integer> entry : counts.entrySet() ) {
      if ( entry.getValue() >= 2 ) {
        LinkedList<Integer> list = locations.get(entry.getKey());
        System.out.printf("%6d %5d %4s ", (entry.getKey()).length(), 
                          entry.getValue(), entry.getKey() );
        int i = 0;
        for (; i < list.size(); i++){
          if (i > 0) {
            System.out.printf("%d (%d) ", list.get(i), 
                              list.get(i) - list.get(i-1));            
          }
          else{
            System.out.print(list.get(i) + " ");
          }
        }
        System.out.print("\n");
      }
    }
  }

  //comparator method for sorting treemap
  private class LengthCompare implements Comparator<String> {

    Map<String, Integer> base;
    public LengthCompare(Map<String, Integer> base){
      this.base = base;
    }

      @Override 
      public int compare(String s1, String s2){
      int return_val = 0;

      //sort by length
      if ( s1.length() < s2.length() ){
        return_val = 1;
      }
      else if ( s1.length() > s2.length() ){
        return_val = -1;
      }
      else { //sort by count
        if (base.get(s1) < base.get(s2)){
          return_val = 1;
        }
        else if (base.get(s1) > base.get(s2)){
          return_val = -1;
        }
        else{
          //Alphabetical
          return_val = s1.compareTo(s2);
        }
      }
      return return_val;
    }

  }//end of private class





	// Driver program to test above function 
	public static void main(String args[]) 
	{ 
		String txt = "mnoabcdmno"; 
		String pat = "mno"; 
		int ans = new Prog7().KMPSearch(pat,txt); 

		findSubstr(an, 10, true);
	} 
} 

