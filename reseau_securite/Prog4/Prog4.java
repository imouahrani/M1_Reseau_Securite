// Code Java pour implémenter le chiffrement Vigenere 
import java.util.Scanner;

class Prog4 
{ 

    // Cette fonction génère la clé dans
   // de manière cyclique jusqu'à ce que sa longueur ne soit pas
   // égal à la longueur du texte original
    static String generateKey(String str, String key) 
    { 
	    int x = str.length(); 

	    for (int i = 0; ; i++) 
	    { 
		    if (x == i) 
			    i = 0; 
		    if (key.length() == str.length()) 
			    break; 
		    key+=(key.charAt(i)); 
	    } 
	    return key; 
    } 

    // Cette fonction renvoie le texte crypté
   // généré à l'aide de la clé
    static String cipherText(String str, String key) 
    { 
	    String cipher_text=""; 

	    for (int i = 0; i < str.length(); i++) 
	    { 
		    // conversion dans la plage 0-25 
		    int x = (str.charAt(i) + key.charAt(i)) %26; 

		   // convertir en alphabets (ASCII) 
		    x += 'A'; 

		    cipher_text+=(char)(x); 
	    } 
	    return cipher_text; 
    } 

    // Cette fonction décrypte le texte chiffré
    // et renvoie le texte d'origine
    static String originalText(String cipher_text, String key) 
    { 
	    String orig_text=""; 

	    for (int i = 0 ; i < cipher_text.length() && i < key.length(); i++) 
	    { 
		    // conversion dans la plage 0-25 
		    int x = (cipher_text.charAt(i) - key.charAt(i) + 26) %26; 

		    // convertir en alphabets (ASCII) 
		    x += 'A'; 
		    orig_text+=(char)(x); 
	    } 
	    return orig_text; 
    } 

    // Programme principale
    public static void main(String[] args) 
    { 
        System.out.print("Original/Decrypted Text : ");
	    String str = new Scanner(System.in).nextLine();
	    // Supprimer les espaces et la ponctuation
	    // (remplacer les espaces et la ponctuation par rien)
	    //System.out.println(str.replaceAll("[\\str\\p{Punct}]","").toLowerCase());
	    String strWP =  str.replaceAll("[\\str\\p{Punct}]","");
        System.out.println("Original/Decrypted Text without ponctuations and spaces : "+strWP); 
        System.out.print("keyword : ");
	    String keyword = new Scanner(System.in).nextLine();
        //System.out.println(keyword.toLowerCase());

	    String key = generateKey(strWP, keyword); 
	    String cipher_text = cipherText(strWP, key); 

	    System.out.println("\nCiphertext : "+ cipher_text ); 

	    System.out.println("Original/Decrypted Text : "+ originalText(cipher_text, key).toLowerCase()); 
	    }  
} 
