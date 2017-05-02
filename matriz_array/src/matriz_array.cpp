//============================================================================
// Name        : matriz_array.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned Filas=6;
const unsigned Columnas=8;
typedef int TVectorFila[Columnas];
typedef int TVectorColumna[Filas];
typedef TVectorFila TMatriz[Filas];

void leerMatriz (TMatriz& mat){
	for (unsigned fi=0 ; fi<Filas ; fi++){
		cout << "Introduzca valores para la fila " <<fi<< ": " <<endl;
		for (unsigned co=0 ; co<Columnas ; co++){
			cin >> mat[fi][co];
		}
	}
}

void escribirFilas (const TVectorFila& fila){
	for (unsigned co=0; co<Columnas; co++){
		cout << fila[co] << " ";
	}
}

int sumarFilas (const TVectorFila& fila){
	int resultado=0;
	for (unsigned co=0; co<Columnas; co++){
		resultado+= fila[co];
	}
	return resultado;
}

int sumarColumnas (const TMatriz& matriz, unsigned co){
	int resultado=0;
	for (unsigned fi=0; fi<Filas; fi++){
		resultado= resultado + matriz[fi][co];
	}
	return resultado;
}

int main() {
	TMatriz a;
	TVectorColumna b;
	TVectorFila c;
	leerMatriz(a);
	for (unsigned fi=0; fi<Filas; fi++){
		b[fi]= sumarFilas(a[fi]);
	}
	for (unsigned co=0; co<Columnas; co++){
			c[co]= sumarColumnas(a,co);
	}
	for (unsigned fi=0; fi<Filas; fi++){
		escribirFilas(a[fi]);
		cout << b[fi]<<endl;
	}
	escribirFilas(c);
}
