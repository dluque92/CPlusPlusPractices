//============================================================================
// Name        : FP_relac2_02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void PiramideDigitos(int filas){
	for(unsigned i= 1; i <= filas; i++){
		for(unsigned j = 1; j <= (filas - i); j++){
			cout << " ";
		}
		for(unsigned j= 1; j <= i; j++){
			cout << " *";
		}
		cout << endl;
	}
}
int main() {
	int filas;
	cout << "Programa que te crea una pirámide de * " << endl;
	cout << "Introduce el número de filas de la pirámide: ";
	cin >> filas;
	PiramideDigitos(filas);
	return 0;
}
