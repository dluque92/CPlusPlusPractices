//============================================================================
// Name        : FP_relac3_19.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAXCARGOS=15;
const unsigned MAXPART=10;

typedef unsigned TMatriz[MAXPART][MAXCARGOS];

struct TMatrizDim{
	TMatriz mat;
	unsigned numPart;
	unsigned numCarg;
};

struct TReg{
	string nombre;
	unsigned votos;
};

typedef TReg TArray[MAXPART];

struct TElecciones{
	TArray partidos;
	unsigned tam;
};

void mayor(TMatrizDim& m, unsigned& partido, unsigned& cargo){
	unsigned max=m.mat[0][0];
	partido=0;
	cargo=0;
	for(unsigned i=0;i<m.numPart;i++){
		for(unsigned j=0; j<m.numCarg; j++){
			if(m.mat[i][j]>max){
				max=m.mat[i][j];
				partido=i;
				cargo=j;
			}
		}
	}
}

void mayores(TMatrizDim& m, const TElecciones& a, TElecciones& resul){
	unsigned partido, cargo;
	for(unsigned i=0;i<m.numCarg;i++){
		mayor(m,partido,cargo);
		resul.partidos[partido].votos++;
		m.mat[partido][cargo]=0;
	}
}

void calcularDhort(TMatrizDim& matriz, const TElecciones& a, TElecciones& resul){
	for(unsigned i=0;i<matriz.numPart;i++){
		for(unsigned j=0; j<matriz.numCarg; j++){
			matriz.mat[i][j]=a.partidos[i].votos/(j+1);
		}
	}
	mayores(matriz,a,resul);
}

void iniciaResul(TElecciones& resul, const TElecciones& a){

}

int main() {
	unsigned cargos, num;
	TElecciones a, resul;
	TMatrizDim m;
	cout << "P";
	do{
		cout << "Introduzca el número de cargos: ";
		cin >> cargos;
	}while (cargos>MAXCARGOS);
	do{
		cout << "Introduzca el número de partidos: ";
		cin >> num;
	}while (cargos>MAXPART);
	a.tam=num;
	for(unsigned i=0;i<a.tam;i++){
		cout << "Partido "<<i+1 <<": ";
		cin >> a.partidos[i].nombre;
		cin >> a.partidos[i].votos;
	}
	m.numPart=num;
	m.numCarg=cargos;
	iniciaResul(resul,a);
	calcularDhort(m,a,resul);
	cout << "Los cargos Electos son: ";
	for (unsigned i=0;i<resul.tam;i++){
		if(resul.partidos[i]!=0){
			cout << resul.partidos[i].nombre << " " << resul.partidos[i].votos;
		}
	}
	return 0;
}
