//============================================================================
// Name        : Practica06Ejercicio05.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX = 1000;
typedef unsigned TErastotenes[MAX];

unsigned leerN(){
	unsigned N;
	cout << "Programa que realiza la Criba de Erastotenes."<<endl;
	cout << "Introduce el m�ximo hasta donde quieres que muestre los n�meros: ";
	cin >> N;
	return N;
}

void inicializar(TErastotenes& erastotenes, unsigned N){
	for(unsigned i=0; i<N; i++){
		erastotenes[i]=i+1;
	}
}

void criba(TErastotenes erastotenes, unsigned N){
	for(unsigned i=2; i<N; i++){
		for(unsigned j=i+1; j<N; j++){
			if((j+1)%(i) == 0){
				erastotenes[j] = 0;
			}
		}
	}
}

void mostrar(const TErastotenes& erastotenes, unsigned N){
	for(unsigned i = 0;i < N; i++){
		if(erastotenes[i] != 0){
			cout << erastotenes[i] << " ";
		}
	}
}

int main() {
	TErastotenes erastotenes;
	unsigned N =leerN();
	inicializar(erastotenes,N);
	criba(erastotenes,N);
	mostrar(erastotenes,N);
}
