//============================================================================
// Name        : Examen_Septiembre_12_2.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const int FILAS = 5;
const int COLUMNAS = 5;

typedef int Superficie[FILAS][COLUMNAS];

typedef char Lava[FILAS][COLUMNAS];

void inicializar(Lava& lava) {
	for (int i = 0; i < FILAS; i++) {
		for (int j = 0; j < COLUMNAS; j++) {
			lava[i][j] = ' ';
		}
	}
}

bool valida(int f, int c) {
	return (0 <= f) && (f < FILAS) && (0 <= c) && (c < COLUMNAS);
}

void desplazar(int fOrig, int cOrig, int fDest, int cDest, const Superficie& sup, Lava& lava) {
	if (valida(fDest,cDest) && (sup[fDest][cDest] < sup[fOrig][cOrig])) {
		lava[fDest][cDest] = 'P';
	}
}

void desplazarVecinos(int f, int c, const Superficie& sup, Lava& lava) {
	desplazar(f,c,f,c-1,sup,lava);
	desplazar(f,c,f,c+1,sup,lava);
	desplazar(f,c,f-1,c,sup,lava);
	desplazar(f,c,f+1,c,sup,lava);
}

void nuevaPosicion(const Lava& lava, int& f, int& c, bool& estable) {
	int i,j;

	estable = true;
	i = 0;
	while ((i < FILAS) && estable) {
		j = 0;
		while ((j < COLUMNAS) && estable) {
			if (lava[i][j] == 'P') {
				f = i;
				c = j;
				estable = false;
			}
			j++;
		}
		i++;
	}
}


// solución iterativa
/*
void flujoDeLava(const Superficie& sup, int fil, int col, Lava& lava) {
	bool estable;
	int f,c;

	inicializar(lava); // todas las casillas a blanco
	f = fil;
	c = col;
	lava[f][c] = 'P'; // pendiente de tratar
	do {
		desplazarVecinos(f,c,sup,lava);
		lava[f][c] = '*';
		nuevaPosicion(lava,f,c,estable);
	} while (!estable);
}
*/


// solución recursiva
void flujoDeLavaRec(const Superficie& sup, int fil, int col, Lava& lava) {
	lava[fil][col] = '*';
	if (valida(fil,col-1) && (sup[fil][col-1] < sup[fil][col])) {
			flujoDeLavaRec(sup,fil,col-1,lava);
	}
	if (valida(fil,col+1) && (sup[fil][col+1] < sup[fil][col])) {
			flujoDeLavaRec(sup,fil,col+1,lava);
	}
	if (valida(fil-1,col) && (sup[fil-1][col] < sup[fil][col])) {
			flujoDeLavaRec(sup,fil-1,col,lava);
	}
	if (valida(fil+1,col) && (sup[fil+1][col] < sup[fil][col])) {
			flujoDeLavaRec(sup,fil+1,col,lava);
	}
}

void flujoDeLava(const Superficie& sup, int fil, int col, Lava& lava) {
	inicializar(lava);
	flujoDeLavaRec(sup,fil,col,lava);
}

int main() {
	Superficie sup;
	Lava lava;
	int fil,col;

	cout << "Introduzca superficie (matriz de naturales " << FILAS << "x" << COLUMNAS << ")\n";

	for (int i = 0; i < FILAS; i++) {
		for (int j = 0; j < COLUMNAS; j++) {
			cin >> sup[i][j];
		}
	}

	cout << "Introduzca punto de crater (fila y columna):";
	cin >> fil >> col;

	flujoDeLava(sup,fil,col,lava);

	cout << "El recorrido de la lava es:\n";

	for (int i = 0; i < FILAS; i++) {
		for (int j = 0; j < COLUMNAS; j++) {
			cout << lava[i][j];
		}
		cout << endl;
	}

	return 0;
}
