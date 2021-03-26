import java.util.Scanner;
import java.util.Arrays;


public class vigenre {

	
	//EXERCICE 2
	public static String convert(String s){
		return s.replaceAll("[\\s\\p{Punct}]","").toLowerCase();
	}


	//EXERCICE 3
	public static char cesar(char c1, char c2){

		int somme=c1+c2-97;
		
		if(somme>122){
			somme=somme-26;
		}
        
		return (char)somme;	
	}
	
	
	//EXERCICE 4
	public static String chiffreVigenere(String text, String key){ 

        text=convert(text);
        key=convert(key);
        
	    StringBuffer buff = new StringBuffer(text);
		
		for(int i = 0; i < text.length(); i++)
		{
			char kIndex=key.charAt(i % key.length());
			char tIndex=text.charAt(i);
			char newChar = cesar(tIndex , kIndex );
			buff.setCharAt(i, newChar);
		}
		
		return buff.toString();
    }
	
	
	//EXERCICE 5
	public static String dechiffreVigenere(String text, String key){

        text=convert(text);
        key=convert(key);
        
	    StringBuffer buff = new StringBuffer(text);
		int somme;
		
		for(int i = 0; i < text.length(); i++)
		{
			char kIndex=key.charAt(i % key.length());
			char tIndex=text.charAt(i);
			
			somme=tIndex-kIndex+97;
    		if(somme<97){
    			somme=somme+26;
    		}
	
			buff.setCharAt(i, (char)somme);
		}
		
		return buff.toString();
    }
    
	
	//EXERCICE 11
	public static float probaRepet(String text){

		text=convert(text);

        int size=text.length();
	    
	    int tab[ ] = new int[size];
	    
	    for(int i=0; i<size; i++){
	        tab[i]=1;
	    }
	    
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                if( text.charAt(i)==text.charAt(j) ){
                    tab[i]++;
                    tab[j]++;
                }
            }
        }
        
        float numerateur=0;
	    float denominateur=0;
	        
        for(int i=0; i<size; i++){
            
	        if(tab[i]!=1){//le caractère est il rendondant ?
	            numerateur+= (float)(tab[i]*(tab[i]-1)) / (float)(size-1);
	            denominateur+=(float)tab[i];
	        }
        }
	        
        if(numerateur==0){//on a trouvé aucune redondance
            return 0;
        }
        else{
            return numerateur/denominateur;
        }		
	}
	
	
	public static void main(String...args){
		
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Saisissez un texte à chiffrer: ");
	    String s=scanner.nextLine();
	    
	    System.out.print("Saisissez une clé: ");
	    String k=scanner.nextLine();
	    
	    System.out.println();
	    
	    System.out.println("Chiffre " + s + " => " + chiffreVigenere(s, k));
	    System.out.println("Decrypt " + chiffreVigenere(s, k) + " => " + dechiffreVigenere(chiffreVigenere(s, k), k));
	    
	    System.out.println("Probabilité que 2 caractères se repetent dans " + s + ": " + probaRepet(s));  
    }

}