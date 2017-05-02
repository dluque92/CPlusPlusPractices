//============================================================================
// Name        : Practica04Ejercicio01.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int LeerNFilas(){
	int filas;
	do{
		cout << "Introduce el n�mero de filas de la pir�mide entre 1 y 10: ";
		cin >> filas;
	}while(filas < 1 || filas > 10);
	return filas;
}
void PiramideDigitos(int filas){
	for(unsigned i= 1; i <= filas; i++){
		for(unsigned j = 1; j <= (filas - i); j++){
			cout << " ";
		}
		for(unsigned j= 1; j <= i; j++){
			cout << j;
		}
		for(unsigned h = (i-1); h >= 1; h-- ){
			cout << h;
		}
		cout << endl;
	}
}
int main() {
	int filas;
	cout << "Programa que te crea una pir�mide de n�meros." << endl;
	filas= LeerNFilas();
	PiramideDigitos(filas);
	return 0;
}
