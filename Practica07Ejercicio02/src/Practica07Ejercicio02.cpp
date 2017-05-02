//============================================================================
// Name        : Practica07Ejercicio02.cpp
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
	cout << "Programa que te genera una matriz 5x5 y te dice el mayor."<<endl;
	cout << "Introduzca valores para la matriz:" <<endl;
	for (int fi=0 ; fi<Filas ; fi++){
		for (int co=0 ; co<Columnas ; co++){
			cin >> a[fi][co];
		}
	}
}

bool simetrica(TMatriz& a){
	bool sim=false;
	int contador;
	contador=Filas*Columnas;
	int cont;
	cont=0;
	for (int fi=0 ; fi<Filas ; fi++){
		for (int co=0 ; co<Columnas ; co++){
			if(a[fi][co]==a[co][fi]){
				cont++;
			}
		}
	}
	if(cont==contador){
		sim=true;
	}
	return sim;
}

int main() {
	TMatriz a;
	leerMatriz(a);
	if(simetrica(a)==true){
		cout << "La matriz es simetrica.";
	}else{
		cout << "La matriz no es simetrica.";
	}
}
