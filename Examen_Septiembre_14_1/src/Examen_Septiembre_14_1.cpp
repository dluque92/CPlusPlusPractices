//============================================================================
// Name        : Examen_Septiembre_14_1.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned TAM = 8;

typedef char TMatriz[TAM][TAM];

int contarFichas(const TMatriz& m) {
	int res = 0;

	// los bordes no los recorremos
	for (unsigned f = 1; f < TAM-1; f++) {
		for (unsigned c = 1; c < TAM-1; c++) {
			//if ( ((f % 2 != 0 && c % 2 == 0) || (f % 2 == 0 && c % 2 != 0))	&& (m[f][c] != 'V') ) {
			if ( ((f+c) % 2 != 0) && (m[f][c] != 'V') ) {
				res++;
			}
		}
	}

	return res;
}

int main() {
	TMatriz m;

	for (unsigned f = 0; f < TAM; f++) {
		for (unsigned c = 0; c < TAM; c++) {
			m[f][c] = 'V';
		}
	}

	m[1][2] = 'R';
	m[2][3] = 'd';
	m[4][4] = 'A';

	cout << contarFichas(m) << endl;

	return 0;
}
