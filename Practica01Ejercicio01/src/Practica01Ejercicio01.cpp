//============================================================================
// Name        : Practica1Ejercicio1.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	float euros,pesetas;
	cout << "Programa para cambiar de Pesetas a Euros.\n";
	cout << "Introduce las Pesetas: ";
	cin >> pesetas;
	euros = pesetas/166.38;
	cout << "Las "<< pesetas<<" pesetas son ";
	cout.precision(2);
	cout <<euros<< " euros."<< endl;
	return 0;
}
