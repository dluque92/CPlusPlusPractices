//============================================================================
// Name        : FP_relac2_02.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
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
	cout << "Programa que te crea una pir�mide de * " << endl;
	cout << "Introduce el n�mero de filas de la pir�mide: ";
	cin >> filas;
	PiramideDigitos(filas);
	return 0;
}
