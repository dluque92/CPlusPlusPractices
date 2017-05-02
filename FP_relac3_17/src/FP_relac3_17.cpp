//============================================================================
// Name        : FP_relac3_17.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned FILAS = 10;
const unsigned COLUMNAS = 10;
typedef int TMatriz[FILAS][COLUMNAS];

struct TMatrizDim{
	TMatriz mat;
	unsigned tam;
};

void LeerMatriz(TMatrizDim& m){
	cout << "Introduzca los datos de la matriz: "<<endl;
	for(unsigned i=0; i<m.tam;i++){
		for(unsigned j=0; j<m.tam; j++){
			cin >> m.mat[i][j];
		}
	}
}

unsigned MinFila(const TMatrizDim& m, unsigned fila){
	unsigned col;
	int menor;
	menor=m.mat[fila][0];
	for(unsigned j=1;j<m.tam;j++){
		if(m.mat[fila][j]<menor){
			menor=m.mat[fila][j];
			col=j;
		}
	}
	return col;
}

unsigned MaxCol(const TMatrizDim& m, unsigned col){
	unsigned fila;
	int mayor;
	mayor=m.mat[0][col];
	for(unsigned i=1;i<m.tam;i++){
		if(m.mat[i][col]>mayor){
			mayor=m.mat[i][col];
			fila=i;
		}
	}
	return fila;
}

void PuntoSilla(const TMatrizDim& m){
	unsigned fil,col;
	for (unsigned i=0; i<m.tam;i++){
		col=MinFila(m,i);
		fil=MaxCol(m,col);
		if(fil==i){
			cout << "("<<i<<","<<col<<") es un punto de silla"<<endl;
		}
	}
}

int main() {
	TMatrizDim a;
	cout << "Introduzca la dimension de la matriz"<<endl;
	cin >> a.tam;
	LeerMatriz(a);
	PuntoSilla(a);
	return 0;
}
