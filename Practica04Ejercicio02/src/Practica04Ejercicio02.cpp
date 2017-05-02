//============================================================================
// Name        : Practica04Ejercicio02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
unsigned leerDato(){
	unsigned n;
	cout << "Introduce el número: ";
	cin >> n;
	return n;
}
bool esPrimo(unsigned num){
	bool loes = true ;
	unsigned i = 2;
	while((loes == true) && (i <= unsigned(num/2))){
		if(num != i){
			if(num%i == 0){
				loes = false;
			}
		}
		i++;
	}
	return loes;
}
void imprimePrimos(unsigned N){
	unsigned contador = 0;
	unsigned i = 1;
	while(contador < N){
		if(esPrimo(i)){
			cout << i <<", ";
			contador ++;
		}
		i++;
	}
}
int main() {
	unsigned N;
	cout << "Programa que calcula e imprime por pantalla los N primeros números primos." << endl; // prints !!!Hello World!!!
	N = leerDato();
	imprimePrimos(N);
	return 0;
}
