#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define SIZE 100

typedef struct nombre nombre;
struct nombre
{
    int tab[SIZE];
};


nombre initialiser0()
{
    nombre nbr;
    for(int i=0; i<SIZE; i++){
        nbr.tab[i]=0;
    }
    return nbr;
}

nombre initialiser1()
{
    nombre nbr;
    for(int i=0; i<SIZE; i++){
        nbr.tab[i]=1;
    }
    return nbr;
}

nombre initialiserRandom()
{
    nombre nbr;
    for(int i=0; i<SIZE; i++){
        nbr.tab[i]= rand ();
    }
    return nbr;
}





/*void libererNombre(nombre nbr)
{
    
    for(int i=0; i<SIZE; i++){
        free(nbr.tab[i]);
    }
    free(nbr.tab);
    free(&nbr);
    
}*/



void affiche(nombre nbr){
    for (int i = 0 ; i < SIZE ; i++){
        printf("%d", nbr.tab[i]);
    }
    printf("\n");
}

bool sontEgaux(nombre nbr1, nombre nbr2){
    for (int i = 0 ; i < SIZE ; i++){
        if(nbr1.tab[i]!=nbr2.tab[i]){
            return false;
        }
    }
    return true;
}

bool estPair(nombre nbr){
    if(nbr.tab[SIZE-1] == 0){
        return true;
    }
    else{
        return false;
    }
}

nombre diviserPar2(nombre nbr){

    for (int i=SIZE-1 ; 0<=i ; i--){
        nbr.tab[i]=nbr.tab[i-1];
    }

    nbr.tab[0]=0;
    return nbr;
}

nombre retirer1(nombre nbr){
    
    for (int i = 0 ; i<SIZE-1 ; i++){
        nbr.tab[i]=nbr.tab[i] -1;
    }

    return nbr;
}



nombre multiplierPar2(nombre nbr){

    for (int i = 0 ; i<SIZE-1 ; i++){
        nbr.tab[i]=  nbr.tab[i] * 2;
    }

    return nbr;
}

nombre ajouter2Nombres(nombre A, nombre B){
    
   
    nombre S;
	
	
	printf("\nLe tableau Somme est:\n");
	for (int i = 0 ; i<SIZE-1 ; i++){
        
        S.tab[i] = A.tab[i] + B.tab[i];
        
        if((A.tab[i] ==0 && B.tab[i] == 1) || (B.tab[i] ==0 && A.tab[i] == 1)){
             S.tab[i] = 1;
        }else{
             S.tab[i] = 0;
        }
    }
    return S;
}




nombre multiplier2Nombres(nombre A, nombre B){
    
   
    nombre M;
	
	
	printf("\nLe tableau Multiplication est:\n");
	for (int i = 0 ; i<SIZE-1 ; i++){
        
        M.tab[i] = A.tab[i] * B.tab[i];
 
        if((A.tab[i] ==0 && B.tab[i] == 1) || (B.tab[i] ==0 && A.tab[i] == 1) || (B.tab[i] ==0 && A.tab[i] == 0)){
             M.tab[i] = 0;
        }else{
             M.tab[i] = 0;
        }
    }
    return M;
}



nombre exponentiationRapideSansModulo(nombre x, nombre y){
    nombre result = initialiser1();
    printf("\nL'exponentiation Rapide Sans Modulo est:\n");
    for (int i = 0 ; i<SIZE-1 ; i++){
	        
	    while (y.tab[i]> 0)
        {
            // Si y est impair, multipliez x par le resultat
            if (y.tab[i] & 1)
                result.tab[i] =  result.tab[i] * x.tab[i];
      
            // y doit etre le meme maintenant
            y.tab[i] = y.tab[i]>>1; // y = y/2
            x.tab[i] = x.tab[i] * x.tab[i];  // remplacer x par x^²
        }
    }
   
    return result;
}







nombre modulo(nombre a, nombre n){
    nombre result = initialiser1();
    printf("a[n]=\n");
    for (int i = 0 ; i<SIZE-1 ; i++){
	    result.tab[i] =  a.tab[i] % n.tab[i];
      
    }
   
    return result;
}





nombre soustraction(nombre a, nombre n){
    nombre result;
    printf("Soutraction\n");
    for (int i = 0 ; i<SIZE-1 ; i++){
	    result.tab[i] =  a.tab[i] - n.tab[i];
      
    }
   
    return result;
}



nombre fastExp(nombre b, nombre m, nombre e)
{

	nombre result = initialiser1();
	printf("\nL'exponentiation Rapide avec Modulo est:\n");
    for (int i = 0 ; i<SIZE-1 ; i++){
	        
	   if (1 & e.tab[i] )
	     result.tab[i]  = b.tab[i] ;
	   while (1) {
	       if (!e.tab[i] ) break;
	       e.tab[i]  >>= 1;
	       b.tab[i]  = (b.tab[i]  * b.tab[i] ) % m.tab[i] ;
	       if (e.tab[i]  & 1)
	       result.tab[i]  = (result.tab[i]  * b.tab[i] ) % m.tab[i] ;
	   }
    }
	
	return result;
}


int gcdExtended(int a, int b, int *x, int *y) {
    // initialisation
    if (a == 0) {
        *x = 0;
        *y = 1;
        return b;
    }
    int x1, y1; // Pour stocker les resultats d'un appel recursif
    int gcd = gcdExtended(b%a, a, &x1, &y1);
    // Mettre à jour x et y en utilisant les resultats de recursif
    // appel
    *x = y1 - (b/a) * x1;
    *y = x1;
    return gcd;
}




int main()
{
    nombre n = initialiser0();
    nombre n1 = initialiser1();
    //nombre x = initialiser1();
    //nombre y = initialiser1();
    nombre e = initialiserRandom();
    nombre e1 = initialiserRandom();
    printf("Init0:");
    affiche(n);
    printf("\nInit1:");
    affiche(n1);

    nombre n2=diviserPar2(diviserPar2(n1));
    printf("\n2div2:");
    affiche(n2);

    nombre n3 = retirer1(n1);
    printf("\nretirer1:");
    affiche(n3);
    
    nombre n4=multiplierPar2(n2);
    printf("\nmult2:");
    affiche(n4);
    
    nombre s = ajouter2Nombres(n, n1);
    affiche(s);
    
    nombre m = multiplier2Nombres(n, n1);
    affiche(m);
    
    nombre k = exponentiationRapideSansModulo(n, n1);
    affiche(k);
   // libererNombre(n);
    
    nombre mod = modulo(n, n1);
    affiche(mod);
    
    nombre sous = soustraction(n, n1);
    affiche(mod);
    
    nombre fexp = fastExp(n, n1, e);
    affiche(fexp);
    

  
    
    int x, y;
    int a = 35, b = 15;
    int g = gcdExtended(a, b, &x, &y);
    printf("\ngcd(%d, %d) = %d, x = %d, y = %d", a, b, g, x, y);
    //libererNombre(n);
//nombre f = inestPremierAvec(e,e1);
//affiche(f);
    return 0;
}
