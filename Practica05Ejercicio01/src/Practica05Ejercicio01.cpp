//============================================================================
// Name        : Practica05Ejercicio01.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

unsigned sumaNaturales(unsigned n){
	unsigned suma=0;
	for(unsigned i=1;i<=n;i++){
		suma=suma+i;
	}
	return suma;
}

int main() {

	unsigned n;
	cout << "Programa que te calcula la suma de los N números naturales."<<endl;
	cout << "Introduce el número N: ";
	cin >> n;
	cout << "La suma de los N numeros naturales es: "<< sumaNaturales(n);;
	return 0;
}
