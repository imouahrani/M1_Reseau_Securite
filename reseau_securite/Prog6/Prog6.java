// Compter les occurrences 
//de pat dans txt.
import java.io.*;
class Prog6 { 
	
	static int countFreq(String pat, String txt) {		 
		int M = pat.length();		 
		int N = txt.length();		 
		int res = 0; 

		/* Une boucle pour faire glisser pat [] un par un */
		for (int i = 0; i <= N - M; i++) { 
			/*  Pour l'index courant i, vérifier la correspondance  */
			int j;			 
			for (j = 0; j < M; j++) { 
				if (txt.charAt(i + j) != pat.charAt(j)) { 
					break; 
				} 
			} 

			// if pat[0...M-1] = txt[i, i+1, ...i+M-1] 
			if (j == M) {				 
				res++;				 
				j = 0;				 
			}			 
		}		 
		return res;		 
	} 

	/* Programme principale */
	static public void main(String[] args) throws IOException{ 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Cipher:");
        String txt = br.readLine();

		
		String pat1 = "abc";	
		String pat2 = "bcd";
		String pat3 = "abcd";
		String pat4 = "mno";
				 
		System.out.println("abc trouvé "+countFreq(pat1, txt)+" fois");
		System.out.println("bcd trouvé "+countFreq(pat2, txt)+" fois");
		System.out.println("abcd trouvé "+countFreq(pat3, txt)+" fois");	
	    System.out.println("mno trouvé "+countFreq(pat4, txt)+" fois");	 
	} 
} 
