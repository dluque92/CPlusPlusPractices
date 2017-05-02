//============================================================================
// Name        : Practica03Ejercicio03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	cout << "Programa para mostrarte un tablero de Ajedrez: \n";
	for(int i= 1; i <= 8; i++){
		for(int j = 1; j <= 8; j++){
			if ((i + j)%2 == 0){
				cout << " B ";
			}else {
				cout << " N ";
			}
		}
		cout << endl;
	}
	return 0;
}
