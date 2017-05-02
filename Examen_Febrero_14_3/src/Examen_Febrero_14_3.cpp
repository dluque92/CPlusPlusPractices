//============================================================================
// Name        : Examen_Febrero_14_3.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX_PAL_DIST = 20;

typedef string TPalabras[MAX_PAL_DIST];

struct TDatos {
	TPalabras pal;
	unsigned nPal;
};

bool termina(const string& pal, const string& sufijo) {
	unsigned inicioSufijo;
	bool tieneSufijo = false;

	if (pal.size() >= sufijo.size()) {
	 	inicioSufijo = pal.size() - sufijo.size();
	 	if (sufijo == pal.substr(inicioSufijo,sufijo.size())) {
				tieneSufijo = true;
	 	}
	}

	return tieneSufijo;
}

bool esta(const string& pal, const TDatos& datos) {
	unsigned i = 0;

	while ((i < datos.nPal) && (pal != datos.pal[i])) {
		i++;
	}

	return i < datos.nPal;
}


void escribir(const string& sufijo, const TDatos& datos) {
	cout << "Las palabras que terminan por " << sufijo << " son:\n";
	for (unsigned i = 0; i < datos.nPal; i++) {
		cout << datos.pal[i] << " ";
	}
}

int main()
{
	TDatos datos;
	string pal, sufijo;

	cout << "Introduzca el sufijo: ";

	cin >> sufijo;

	cout << "Introduzca el texto (FIN para terminar)\n";

	datos.nPal = 0;

	cin >> pal;

	while (pal != "FIN") {
		if ((termina(pal,sufijo)) && (!esta(pal,datos))) {
			datos.pal[datos.nPal] = pal;
			datos.nPal++;
		}
		cin >> pal;
	}

	escribir(sufijo,datos);

    return 0;
}
