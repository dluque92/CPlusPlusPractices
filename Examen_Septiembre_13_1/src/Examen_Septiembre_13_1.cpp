//============================================================================
// Name        : Examen_Septiembre_13_1.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX = 10;
const unsigned MAX_REP = 5;

typedef unsigned TPosiciones[MAX_REP];
struct TNumero {
	unsigned num;
	TPosiciones pos;
	unsigned ocupa;
};

typedef TNumero TSecuencia[MAX];
struct TNumeros {
	TSecuencia numeros;
	unsigned tam;
};

unsigned leerValorM() {
	unsigned M;
	do {
		cout << "Introduzca el valor de M (0 < M <= " << MAX << "): ";
		cin >> M;
	} while ((M == 0) || (M > MAX));
	return M;
}

unsigned buscarNumero(unsigned num, const TNumeros& sec) {
	unsigned cont = 0;
	while ((cont < sec.tam) && (sec.numeros[cont].num != num)) {
		cont++;
	}
	return cont;
}

unsigned buscarMenor(const TNumeros& sec) {
	unsigned indMenor;
	indMenor = 0;
	for (unsigned cont = 1; cont < sec.tam; cont++) {
		if (sec.numeros[cont].num < sec.numeros[indMenor].num) {
			indMenor = cont;
		}
	}
	return indMenor;
}

void leerSecuencia(unsigned M, TNumeros& sec) {
	unsigned indNum, indMenor, posicion, numero;
	cout << "Introduzca una secuencia de numeros acabada en 0:\n";
	sec.tam = 0;
	cin >> numero;
	posicion = 1;
	while (numero != 0) {
		indNum = buscarNumero(numero,sec);
		if (indNum < sec.tam) { // el numero ya estaba en sec
			if (sec.numeros[indNum].ocupa < MAX_REP) { // robusto. Aunque no es necesario por el enunciado del problema
				sec.numeros[indNum].pos[sec.numeros[indNum].ocupa] = posicion;
				sec.numeros[indNum].ocupa++;
			}
		} else { // el numero no estaba en sec
			if (sec.tam < M) { // todavia no hemos leido M numeros
				sec.numeros[sec.tam].num = numero;
				sec.numeros[sec.tam].pos[0] = posicion;
				sec.numeros[sec.tam].ocupa = 1;
				sec.tam++;
			} else { // ya hemos leido M numeros
				indMenor = buscarMenor(sec);
				if (numero > sec.numeros[indMenor].num) {
					sec.numeros[indMenor].num = numero;
					sec.numeros[indMenor].pos[0] = posicion;
					sec.numeros[indMenor].ocupa = 1;
				}
			}
		}
		cin >> numero;
		posicion++;
	}
}

void escribirSecuencia(const TNumeros& sec) {
	cout << "Los " << sec.tam << " mayores y sus posiciones son:" << endl;
	for (unsigned i = 0; i < sec.tam; i++) {
		cout << sec.numeros[i].num << ": ";
		for (unsigned j = 0; j < sec.numeros[i].ocupa; j++) {
			cout << sec.numeros[i].pos[j] << " ";
		}
		cout << endl;
	}
}

int main() {
	unsigned M;
	TNumeros sec;
	M = leerValorM();
	leerSecuencia(M,sec);
	escribirSecuencia(sec);
	return 0;
}
