//============================================================================
// Name        : Examen_Septiembre_12_1.cpp
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

struct TPalabra {
	string  palabra;
	TPosiciones posiciones;
	unsigned nposic;
};

typedef TPalabra TColeccion[MAX_PAL_DIST];


struct TDatos {
	TColeccion palabras;
	unsigned npal;
};


unsigned buscar(const TDatos& datos, const string& pal) {
	unsigned i = 0;

	while ((i < datos.npal) && (datos.palabras[i].palabra != pal)) {
		i++;
	}

	return i;
}


void almacenar(TDatos& datos, const string& pal, unsigned pos) {
	unsigned ind = buscar(datos,pal);

	if (ind >= datos.npal) { // primera aparicion
		datos.palabras[datos.npal].palabra = pal;
		datos.palabras[datos.npal].posiciones[0] = pos;
		datos.palabras[datos.npal].nposic = 1;
		datos.npal++;
	} else {				// se repite la palabra
		datos.palabras[ind].posiciones[datos.palabras[ind].nposic] = pos;
		datos.palabras[ind].nposic++;
	}
}

void escribir(const TDatos& datos) {

	for (unsigned i = 0; i < datos.npal; i++) {
			cout << datos.palabras[i].palabra;
			for (unsigned j = 0; j < datos.palabras[i].nposic; j++) {
				cout << " " << datos.palabras[i].posiciones[j] << " ";
			}
			cout << endl;
	}
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
		almacenar(datos,palabra,pos);
		cin >> palabra;
		pos++;
	}

	escribir(datos);

	return 0;
}
