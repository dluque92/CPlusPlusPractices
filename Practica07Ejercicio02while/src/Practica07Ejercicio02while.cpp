//============================================================================
// Name        : Practica07Ejercicio02while.cpp
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
	cout << "Programa que te genera una matriz 5x5 y te dice si es simétrica."<<endl;
	cout << "Introduzca valores para la matriz:" <<endl;
	for (int fi=0 ; fi<Filas ; fi++){
		for (int co=0 ; co<Columnas ; co++){
			cin >> a[fi][co];
		}
	}
}

bool simetrica(TMatriz& a){
	bool sim = true;
	unsigned fi=0, co=1;
	while((sim)&&(fi<Filas-1)){
		co=fi+1;
		while((sim)&&(co<Columnas-1)){
			if(a[fi][co]!=a[co][fi]){
				sim=false;
			}
			co++;
		}
		fi++;
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
