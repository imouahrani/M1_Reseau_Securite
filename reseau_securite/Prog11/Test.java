import java.util.Random;
public class Test
{
    public static void main(String[] args)
    {
        
        
        for (int i = 0; i < 2; i++ )
            System.out.println("Letter: "+Letter.random());
        
        System.out.println("Probability Ke = "+Letter.A.getFrequency()); // Ke = 0.079

         
    }
}
