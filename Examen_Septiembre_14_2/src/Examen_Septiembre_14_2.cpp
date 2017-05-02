//============================================================================
// Name        : Examen_Septiembre_14_2.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

struct TSegmento {
	unsigned origen;
	unsigned longitud;
};

const unsigned MAXSEG = 10;

typedef TSegmento TArray[MAXSEG];

struct TListaSegs {
	unsigned numSeg;
	TArray lista;
};

void construirListaSeg(const string& cadena, char c, TListaSegs& listaSeg) {
	unsigned cont, longitud;

	listaSeg.numSeg = 0;

	cont = 0;
	while (cont < cadena.length()) {
		if (cadena[cont] == c) {
			if (listaSeg.numSeg < MAXSEG) { // aunque no lo pide explicitamente el enunciado
				listaSeg.lista[listaSeg.numSeg].origen = cont;
				longitud = 1;
				cont++;
				while ((cont < cadena.length()) && (cadena[cont] == c)) {
					cont++;
					longitud++;
				}
				listaSeg.lista[listaSeg.numSeg].longitud = longitud;
				listaSeg.numSeg++;
			} else {
				cont = cadena.length(); // terminamos porque no caben mas en listaSeg
			}
		} else {
			cont++;
		}
	}

}

int main() {
	string cadena = "abcaaabbbaaaaaabaaaabababaaaa";
	TListaSegs listaSeg;
	construirListaSeg(cadena,'a',listaSeg);
	for (unsigned cont = 0; cont < listaSeg.numSeg; cont++) {
		cout << "{" << listaSeg.lista[cont].origen << "," << listaSeg.lista[cont].longitud << "} ";
	}

	return 0;
}
