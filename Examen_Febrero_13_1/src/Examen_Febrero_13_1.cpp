//============================================================================
// Name        : Examen_Febrero_13_1.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX_PAL_DIST = 10;
typedef string TArray[MAX_PAL_DIST];

struct TAlmacen {
	TArray palabras;
	unsigned numPalabras;
};

unsigned buscar(char c, const string& s) {
	unsigned i = 0;

	while ((i < s.size()) && (c != s[i])) {
		i++;
	}

	return i;
}

bool mismasLetras(const string& pal1, const string& pal2) {
	unsigned i,j;
	bool res = true;
	string aux = pal2;

	i = 0;
	while ((i < pal1.size()) && res) {
		j = buscar(pal1[i], aux);
		if (j < aux.size()) {
			aux[j] = ' ';
			i++;
		} else {
			res = false;
		}
	}

	return res;
}

bool esVocal(char c) {
	return ((c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U'));
}

void desglosar(const string& pal, string& vocales, string& consonantes) {
	vocales = "";
	consonantes = "";
	for (unsigned i = 0; i < pal.size(); i++) {
		if (esVocal(pal[i])) {
			vocales += pal[i];
		} else {
			consonantes += pal[i];
		}
	}
}

void meter(const string& pal, TAlmacen& almacen) {
	unsigned i = 0;

	while ((i < almacen.numPalabras) && (almacen.palabras[i] != pal)) {
		i++;
	}

	if (i >= almacen.numPalabras) {
		almacen.palabras[almacen.numPalabras] = pal;
		almacen.numPalabras++;
	}
}


int main() {
	string primera, pal;
	string vocalesPrimera, consonantesPrimera, vocalesPal, consonantesPal;

	TAlmacen almacen;

	almacen.numPalabras = 0;

	cout << "Introduzca un texto terminado con la palabra FIN\n";

	cin >> primera;
	if (primera != "FIN") {
		desglosar(primera,vocalesPrimera,consonantesPrimera);
		cin >> pal;
		while (pal != "FIN") {
			if (primera.size() == pal.size()) {
				desglosar(pal,vocalesPal,consonantesPal);
				if ((consonantesPrimera == consonantesPal)
					 && (mismasLetras(vocalesPrimera,vocalesPal))) {
					meter(pal,almacen);
				}
			}
			cin >> pal;
		}
	}
	cout << "El numero de palabras asociadas por vocales fantasmas con el patron "
		 << primera << " es " << almacen.numPalabras << endl;

	for (unsigned i = 0; i < almacen.numPalabras; i++) {
		cout << "Palabra n. " << i+1 << " : " << almacen.palabras[i] << endl;
	}

	return 0;
}
