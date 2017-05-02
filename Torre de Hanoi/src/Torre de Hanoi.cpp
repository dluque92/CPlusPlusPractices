//============================================================================
// Name        : Torre.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
enum Palo {izquierdo, central, derecho};
void leerNumeroDiscos(unsigned& discos){
	do {
		cout << "Introduzca numero de discos (>=1): ";
		cin >> discos;
	} while (discos == 0);
	}
void escribirPalo(Palo p) {
	switch (p){
	case izquierdo: cout << "izquierdo";
	break;
	case central: cout << "central";
	break;
	case derecho: cout << "derecho";
	break;
	}
}
void mueveUno(Palo origen, Palo destino) {
	escribirPalo(origen);
	cout << " -> ";
	escribirPalo(destino);
	cout << endl;
	}
void mueve(unsigned n, Palo origen, Palo auxiliar, Palo destino) {
	if (n == 1) {
		mueveUno(origen,destino);
	} else {
		mueve(n-1,origen,destino,auxiliar);
		mueveUno(origen,destino);
		mueve(n-1,auxiliar,origen,destino);
	}
}
int main() {
	unsigned discos;
	cout << "Programa que hace la torre de Hanoi. \n";
	leerNumeroDiscos(discos);
	cout << "Para " << discos<< " discos se necesitan los movimientos: " << endl;
	mueve(discos,izquierdo,central,derecho);
}
