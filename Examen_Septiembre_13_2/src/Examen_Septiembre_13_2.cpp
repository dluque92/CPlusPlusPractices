//============================================================================
// Name        : Examen_Septiembre_13_2.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
using namespace std;

const unsigned TAM = 8;

typedef char SopaDeLetras[TAM][TAM];

void leer(SopaDeLetras& sopa, string& palabra) {
	cout << "Introduzca la sopa de letras como una matriz " << TAM << "x" << TAM << " de caracteres\n";
	for (unsigned f = 0; f < TAM; f++) {
		for (unsigned c = 0; c < TAM; c++) {
			cin >> sopa[f][c];
		}
	}
	cout << "Ahora introduzca la palabra a buscar: ";
	cin >> palabra;
}

bool estaNorte(unsigned fila, unsigned columna, const string& palabra, const SopaDeLetras& sopa) {
	int contNorte = fila;
	unsigned contPalabra = 0;

	while ((contNorte >= 0) && (contPalabra < palabra.length())
			&& (sopa[contNorte][columna] == palabra[contPalabra])) {
		contNorte--;
		contPalabra++;
	}

	return contPalabra >= palabra.length();

}

bool estaSur(unsigned fila, unsigned columna, const string& palabra, const SopaDeLetras& sopa) {
	int contSur = fila;
	unsigned contPalabra = 0;

	while ((contSur < int(TAM)) && (contPalabra < palabra.length())
			&& (sopa[contSur][columna] == palabra[contPalabra])) {
		contSur++;
		contPalabra++;
	}

	return contPalabra >= palabra.length();

}

bool estaOeste(unsigned fila, unsigned columna, const string& palabra, const SopaDeLetras& sopa) {
	int contOeste = columna;
	unsigned contPalabra = 0;

	while ((contOeste >= 0) && (contPalabra < palabra.length())
			&& (sopa[fila][contOeste] == palabra[contPalabra])) {
		contOeste--;
		contPalabra++;
	}

	return contPalabra >= palabra.length();

}


bool estaEste(unsigned fila, unsigned columna, const string& palabra, const SopaDeLetras& sopa) {
	int contEste = columna;
	unsigned contPalabra = 0;

	while ((contEste < int(TAM)) && (contPalabra < palabra.length())
			&& (sopa[fila][contEste] == palabra[contPalabra])) {
		contEste++;
		contPalabra++;
	}

	return contPalabra >= palabra.length();

}

void buscar(const string& palabra, const SopaDeLetras& sopa,
		 	 bool& esta, unsigned& fila, unsigned& columna, string& direccion) {

	esta = false;
	fila = 0;
	while ((!esta) && (fila < TAM)) {
		columna = 0;
		while ((!esta) && (columna < TAM)) {
			if (sopa[fila][columna] == palabra[0]) {
				if (estaNorte(fila,columna,palabra,sopa)) {
					esta = true;
					direccion = "Norte";
				} else if (estaSur(fila,columna,palabra,sopa)) {
					esta = true;
					direccion = "Sur";
				} else if (estaEste(fila,columna,palabra,sopa)) {
					esta = true;
					direccion = "Este";
				} else if (estaOeste(fila,columna,palabra,sopa)) {
					esta = true;
					direccion = "Oeste";
				}
			}
			if (!esta) {
				columna++;
			}
		}
		if (!esta) {
			fila++;
		}
	}
}

int main() {
	string palabra,direccion;
	SopaDeLetras sopa;
	bool esta;
	unsigned fila, columna;

	leer(sopa,palabra);
	buscar(palabra,sopa,esta,fila,columna,direccion);
	if (esta) {
		cout << "la palabra " << palabra << " esta en la posicion ("
			 << fila << ", " << columna << ") " << direccion << endl;
	} else {
		cout << "La palabra " << palabra << " no esta en la sopa de letras\n";
	}

	return 0;
}
