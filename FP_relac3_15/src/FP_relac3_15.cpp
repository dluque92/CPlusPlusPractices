//============================================================================
// Name        : FP_relac3_15.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const int Filas=5;
const int Columnas=5;
typedef int TVectorFila[Columnas];
typedef int TVectorColumna[Filas];
typedef TVectorFila TMatriz[Filas];

void leerMatriz (TMatriz& a){
	cout << "Programa que te genera una matriz 5x5 y te busca un número en ella."<<endl;
	cout << "Introduzca valores para la matriz:" <<endl;
	for (int fi=0 ; fi<Filas ; fi++){
		for (int co=0 ; co<Columnas ; co++){
			cin >> a[fi][co];
		}
	}
}

bool esta(TMatriz& a, int k){
	bool estas;
	for (int fi=0 ; fi<Filas ; fi++){
		for (int co=0 ; co<Columnas ; co++){
			if(k==a[fi][co]){
				estas=true;
			}else{
				estas=false;
			}
		}
	}
	return estas;
}

int main() {
	TMatriz a;
	int k;
	leerMatriz(a);
	cout << "Introduce el número que quieras buscar en la matriz: ";
	cin >> k;
	if(esta(a,k)==true){
		cout << "El número "<<k<<" se encuentra en la matriz.";
	}else{
		cout << "El número "<<k<<" no se encuentra en la matriz.";
	}
}
