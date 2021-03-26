//un programme qui génére 2 lettres, mais avec la fréquence d'apparition 

import java.util.Random;
/*
 *Voir le lien :
 https://fr.wikipedia.org/wiki/Fr%C3%A9quence_d'apparition_des_lettres_en_fran%C3%A7aisFréquence d'apparition des lettres en français
*/


public enum Letter
{   // Fréquence d'apparition des lettres en français
    S(19), T(20), U(21), V(22), W(23), X(24), Y(25), Z(26), A(1), B(2), C(3),
D(4), E(5), F(6), G(7), H(8), I(9), J(10), K(11), L(12), M(13), N(14), O(15),
P(16), Q(17), R(18);
    
    private final int occ;
    
    private Letter(int occ)
    {
        this.occ = occ;
    }
    
    private static char[] tab = null;
    
    private static void fillTab()
    {
        int n = 0;
        
        for (Letter v : Letter.values())
            n += v.occ;
        
        tab = new char[n];
        
        int i = 0;
        for (Letter v : Letter.values())
            for (int j = 0; j < v.occ; i++ , j++ )
                tab[i] = v.toString().charAt(0);
    }
    
    public double getFrequency()
    {
        if (tab == null)
            fillTab();
        
        return ((double) occ) / tab.length;
    }
    
    private static Random rand = new Random();
    
    public static char random()
    {
        if (tab == null)
            fillTab();
        
        return tab[rand.nextInt(tab.length)];
    }
}
