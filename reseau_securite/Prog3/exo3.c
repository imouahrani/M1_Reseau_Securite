#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){

	char c1;
	char c2;

	scanf("%c", &c1);
	scanf(" %c", &c2);

	int somme=c1+c2-96;

	if(somme>122){
		somme=somme-26;
	}

	printf("%c", somme);

	return 0;
}
