//============================================================================
// Name        : Practica04Ejercicio04.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main (){
	int n;
	cout << "Programa que te dibuja un rombo seg�n el numero. \n";
	cout << " Introduzca un n�mero : ";
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
