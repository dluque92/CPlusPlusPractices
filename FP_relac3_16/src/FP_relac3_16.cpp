//============================================================================
// Name        : FP_relac3_16.cpp
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
	cout << "Programa que te genera una matriz 5x5 y te suma la diagonal."<<endl;
	cout << "Introduzca valores para la matriz:" <<endl;
	for (int fi=0 ; fi<Filas ; fi++){
		for (int co=0 ; co<Columnas ; co++){
			cin >> a[fi][co];
		}
	}
}

int sumadiagonal(TMatriz& a){
	int suma=0;
	int fi=0;
	for (int co=0 ; co<Columnas ; co++){
		suma= suma+ a[fi][co];
		fi++;
		}
	return suma;
}

int main() {
	TMatriz a;
	int suma;
	leerMatriz(a);
	suma=sumadiagonal(a);
	cout << "La suma de los digitos de la diagonal es: "<<suma;
}
