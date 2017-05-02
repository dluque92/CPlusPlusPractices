//============================================================================
// Name        : 15.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned Filas=3;
const unsigned Columnas=5;

typedef int TVectorFila[Columnas];
typedef int TVectorFila TMatriz[Filas];
typedef int TMatriz [Filas][Columnas];

bool Busca(const TMatriz &m, int num){
	bool encontrado=false;
	unsigned fi,co;
	fi=0;
	while((fi<Filas)&&(!encontrado)){
		co=0;
		while((co<Columnas)&&(!encontrado)){
			if (m[fi][co]==num){
				encontrado = true;
			}
		}co++;
	}fi++;
	return encontrado;
}

int sumaDiagonal(const TMatriz &m){
	unsigned suma=0;
	for(unsigned i=0;i<Filas;i++){
		suma=suma+m[i][i];
	}
	return suma;
}

int main() {
	cout << "" << endl; // prints 
	return 0;
}
