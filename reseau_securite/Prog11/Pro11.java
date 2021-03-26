

class Pro11{
	public static void main(String[] args){
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String br = "CRYPTOGRAPHY";

        int sommeOccur=0;
        int nombreCarac=0;
        
        while(br != " "){

            sommeOccur += compterOccur(br, br.charAt(0));
            br = br.replaceAll(Character.toString(br.charAt(0))," ");
           System.out.println( sommeOccur);
            nombreCarac++;
        }
	}
	
	public static int compterOccur(String chaine, char car)
    {
        int nb = 0;
        for (int i=0; i < chaine.length(); i++){
            if (chaine.charAt(i) == car)
            nb++;
        }
        return nb;
    }
}
