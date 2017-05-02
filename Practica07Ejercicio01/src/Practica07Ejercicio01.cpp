//============================================================================
// Name        : Practica07Ejercicio01.cpp
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

void mayor (TMatriz& a){
	int may;
	int fil;
	int col;
	may=a[0][0];
	for (int fi=0 ; fi<Filas ; fi++){
		for (int co=0 ; co<Columnas ; co++){
			if(may<a[fi][co]){
				may=a[fi][co];
				fil=fi;
				col=co;
			}
		}
	}
	cout <<"El mayor de la matriz es: "<<may <<" y está en la posicion: "<<fil<<","<<col;
}

int main() {
	TMatriz a;
	leerMatriz(a);
	mayor(a);
}
