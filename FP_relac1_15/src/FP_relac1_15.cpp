//============================================================================
// Name        : FP_relac1_15.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	double pi = 3.1416;
	double grados,minutos,segundos,radianes;
	cout << "Programa para convertir un angulo expresado en grados / minutos / segundos a radianes. \n";
	cout << "Introduce los grados: ";
	cin >> grados;
	cout << "Introduce los minutos: ";
	cin >> minutos;
	cout << "Introduce los segundos: ";
	cin >> segundos;
	grados = (grados + (minutos/60));
	grados = (grados + segundos/3600);
	radianes = (grados*pi)/180;
	cout << "Son : "<<radianes<< " radianes.";
}
