/*Programme java qui demande à l'utilisateur de saisir son nom  et de lui afficher */
import java.util.Scanner;


public class Prog1 {

	public static void main(String...args)
    {
	    System.out.print("Input : ");
	    String s = new Scanner(System.in).nextLine();

	    // Supprimer les espaces et la ponctuation
	    // (remplacer les espaces et la ponctuation par rien)
	    System.out.println("Output: "+s);
    }
}
