//============================================================================
// Name        : Examen_Septiembre_14_3.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX_PAL_DIST = 20;
const unsigned MAX_REP = 10;

typedef unsigned TPosiciones[MAX_REP];

struct TPalindromo {
	string  palabra;
	TPosiciones posiciones;
	unsigned nposic;
};

typedef TPalindromo TColeccionPalindromos[MAX_PAL_DIST];


struct TDatos {
	TColeccionPalindromos palindromos;
	unsigned npal;
};


unsigned buscar(const TDatos& datos, const string& pal) {
	unsigned i = 0;

	while ((i < datos.npal) && (datos.palindromos[i].palabra != pal)) {
		i++;
	}

	return i;
}


void almacenar(TDatos& datos, const string& pal, unsigned pos) {
	unsigned ind = buscar(datos,pal);

	if (ind >= datos.npal) { // primera aparicion
		datos.palindromos[datos.npal].palabra = pal;
		datos.palindromos[datos.npal].posiciones[0] = pos;
		datos.palindromos[datos.npal].nposic = 1;
		datos.npal++;
	} else {				// se repite la palabra
		datos.palindromos[ind].posiciones[datos.palindromos[ind].nposic] = pos;
		datos.palindromos[ind].nposic++;
	}
}

void escribir(const TDatos& datos) {

	for (unsigned i = 0; i < datos.npal; i++) {
			cout << datos.palindromos[i].palabra;
			for (unsigned j = 0; j < datos.palindromos[i].nposic; j++) {
				cout << " " << datos.palindromos[i].posiciones[j] << " ";
			}
			cout << endl;
	}
}

bool esPalindromo(const string& pal) {
	unsigned i,j;

	i = 0;
	j = pal.size() - 1;
	while ((i < j) && (pal[i] == pal[j])) {
	    i++;
	    j--;
	}
	return (i >= j);
}


int main() {
	string palabra;
	unsigned pos;
	TDatos datos;

	datos.npal = 0;

	cout << "Introduzca texto (FIN para terminar)\n";

	cin >> palabra;
	pos = 1;
	while (palabra != "FIN") {
		if (esPalindromo(palabra)) {
			almacenar(datos,palabra,pos);
		}
		cin >> palabra;
		pos++;
	}

	escribir(datos);

	return 0;
}
