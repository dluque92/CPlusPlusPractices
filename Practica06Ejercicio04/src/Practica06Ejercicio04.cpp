//============================================================================
// Name        : Practica06Ejercicio04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

typedef unsigned TFrecuencias[10];

void inicializar(TFrecuencias& frecuencias){
	for(unsigned i= 0; i < 10; i++){
		frecuencias[i]= 0;
	}
}

void leerDatos(TFrecuencias& frecuencias){
	int num = -1;
	cout << "Programa que te crea un histograma de números del 0 al 9."<<endl;
	cout << "Introduce numeros hasta que introduzcas un número negativo."<<endl;
	do {
		frecuencias[num]++;
		cin >> num;
	}while(num >= 0);
}

unsigned tomar_mayor(const TFrecuencias& miarray){
	unsigned mayor = miarray[0];
	for(unsigned i=1; i< 10; i++){
		if(miarray[i] > mayor){
			mayor = miarray[i];
		}
	}
	return mayor;
}

void imprimirFrecuencias (TFrecuencias& frecuencias, unsigned mayor){
	unsigned a = mayor;
	for(unsigned i= 0; i < mayor; i++){
		for(unsigned e=0; e< 10; e++){
			if(frecuencias[e] == a){
				cout << "* ";
				frecuencias[e] = frecuencias[e]-1;
			}else{
				cout << "  ";
			}
		}
		a = tomar_mayor(frecuencias);
		cout << endl;
	}
	cout << "0 1 2 3 4 5 6 7 8 9";
}

int main() {
	TFrecuencias frecuencias;
	inicializar(frecuencias);
	leerDatos(frecuencias);
	imprimirFrecuencias(frecuencias, tomar_mayor(frecuencias));
	return 0;
}
