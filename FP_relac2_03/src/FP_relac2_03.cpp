//============================================================================
// Name        : FP_relac2_03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

/*
Escribe un programa que tome como entrada desde teclado dos números naturales (mayores
que cero) "N" e "i", e imprima en pantalla el dígito que ocupa la posición i-ésima del número
N. Si i es mayor que el número de dígitos de N, se escribirá en pantalla -1. Por ejemplo, para N
= 25064 e i = 2, el resultado es el dígito 6, y para i = 7, el resultado es -1.
 */

void introDatos(unsigned& n, unsigned& i){
	do{
		cout << "Introduzca numero N: ";
		cin >> n;
	}while(n<=0);
	do{
		cout << "Introduzca posicion: ";
		cin >> i;
	}while(i<=0);
}

unsigned numDig(unsigned n){
	unsigned cont = 0;
	while(n!=0){
		n = n/10;
		cont++;
	}
	return cont;
}

void imprimirDig(unsigned n, unsigned i){
	unsigned j=0, dig;

	while(j<i){
		dig = n%10;
		j++;
		n = n/10;
	}
	cout << dig << endl;
}
int main() {
	unsigned n, i, num;
	introDatos(n,i);
	num = numDig(n);
	if(num<i){
		cout << -1 << endl;
	}else{
		imprimirDig(n,i);
	}
	return 0;
}
