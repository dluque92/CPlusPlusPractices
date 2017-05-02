//============================================================================
// Name        : Practica04Ejercicio04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main (){
	int n;
	cout << "Programa que te dibuja un rombo según el numero. \n";
	cout << " Introduzca un número : ";
	cin >> n;
	for (int j = 0; j < n; ++j) {
		for (int i = 0; i < n-j-1; ++i) {
			cout << " ";
		}
		for (int i = 0; i < 2*j+1; ++i) {
			cout << "*" ;
		}
		cout << endl ;
	}
	for (int j = n-2; j >= 0; --j) {
		for (int i = 0; i < n-j-1; ++i) {
			cout << " ";
		}
		for (int i = 0; i < 2*j+1; ++i) {
			cout << "*" ;
		}
		cout << endl ;
	}
}
