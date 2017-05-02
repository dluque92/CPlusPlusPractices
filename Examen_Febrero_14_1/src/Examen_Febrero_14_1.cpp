//============================================================================
// Name        : Examen_Febrero_14_1.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX = 10;

typedef int TArray[MAX];

struct TLista {
	TArray elementos;
	unsigned numElem;
};

// Version 1: Mas sencilla y natural, pero menos eficiente
/*

bool esta(int elem, const TLista& lista) {
	unsigned cont = 0;

	while ((cont < lista.numElem) && (elem != lista.elementos[cont])) {
		cont++;
	}

	return (cont < lista.numElem);
}

unsigned repeticiones(int elem, const TLista& lista) {
	unsigned res = 0;

	for (unsigned i = 0; i < lista.numElem; i++) {
		if (elem == lista.elementos[i]) {
			res++;
		}
	}

	return res;
}

void criba(unsigned x, const TLista& lista1, TLista& lista2) {
	lista2.numElem = 0;
	for (unsigned i = 0; i < lista1.numElem; i++) {
		if ((repeticiones(lista1.elementos[i],lista1) == x)
				&& (!esta(lista1.elementos[i],lista2))) {
			lista2.elementos[lista2.numElem] = lista1.elementos[i];
			lista2.numElem++;
		}
	}
}

*/

// Version 2: Menos facil de ver, pero mas eficiente

typedef bool TContados[MAX];

void inicializar(TContados contados) {
	for (unsigned i = 0; i < MAX; i++) {
		contados[i] = false;
	}
}

// calcula las repeticiones y marca contados
void repeticiones(int pos, const TLista& lista, TContados& contados, unsigned& rep) {
	rep = 1;
	contados[pos] = true;

	for (unsigned i = pos + 1; i < lista.numElem; i++) {
		if (lista.elementos[pos] == lista.elementos[i]) {
			contados[i] = true;
			rep++;
		}
	}
}


void criba(unsigned x, const TLista& lista1, TLista& lista2) {
	TContados contados;
	unsigned rep;

	inicializar(contados);

	lista2.numElem = 0;
	for (unsigned i = 0; i < lista1.numElem; i++) {
		if (!contados[i]) {
			repeticiones(i,lista1,contados,rep);
			if (rep == x) {
				lista2.elementos[lista2.numElem] = lista1.elementos[i];
				lista2.numElem++;
			}
		}
	}
}


int main() {
	TLista lista1, lista2;
	unsigned repeticiones;
	int num;


	cout << "Introduzca la lista original (0 para terminar y como maximo " << MAX << " elementos): ";
	lista1.numElem = 0;
	cin >> num;
	while ((lista1.numElem < MAX) && (num != 0)) {
		lista1.elementos[lista1.numElem] = num;
		lista1.numElem++;
		cin >> num;
	}

	cout << "Introduzca el numero de repeticiones para realizar la criba: ";
	cin >> repeticiones;

	criba(repeticiones,lista1,lista2);

	cout << "La lista cribada es: ";
	for (unsigned i = 0; i < lista2.numElem; i++) {
		cout << lista2.elementos[i] << " ";
	}

	return 0;

}
