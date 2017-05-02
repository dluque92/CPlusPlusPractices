//============================================================================
// Name        : FP_relac2_04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void introducirDatos(unsigned& n){
	cout << "Introducir numero N: ";
	do{
		cin >> n;
	}while(n<=0);
}
unsigned longNum(unsigned n){
	unsigned cont = 0;
	while(n!=0){
		n = n/10;
		cont++;
	}
	return cont;
}
unsigned potencia(unsigned longitud){
	unsigned pot = 1;
	for(unsigned i=0;i<longitud;i++){
		pot*=10;
	}
	return pot/10;
}
void Suma2a2(unsigned n, unsigned longitud){
	unsigned j=10, suma, i;
	i = potencia(longitud);
	cout << "la salida es: ";
	while(i>=j){
		suma = 0;
		suma = ((n/i) + (n%j));
		cout << n/i << " + " << n%j << " = " << suma;
		n%=i;
		n/=10;
		i/=100;
		if(i>=j){
			cout << ", ";
		}
	}
}
void imprimirSuma(unsigned n, unsigned longitud){
	unsigned pot = potencia(longitud/2 + 1);

	cout << "Para el numero: " << n << endl;
	if(longitud%2!=0){
		Suma2a2(n,longitud);
		n = n/pot;
		cout << ", " << n%10 << endl;
	}else{
		Suma2a2(n,longitud);
	}
}
int main() {
	unsigned n, longitud;
	cout << "Programa que suma los digitos 2 a 2. \n";
	introducirDatos(n);
	longitud = longNum(n);
	imprimirSuma(n,longitud);

	return 0;
}
