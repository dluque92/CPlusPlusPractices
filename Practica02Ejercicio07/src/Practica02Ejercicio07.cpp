//============================================================================
// Name        : Practica02Ejercicio07.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
using namespace std;
int main() {
	int mes;
	cout <<"Programa para saber cuantos dias tiene el mes. \n";
	cout << "Introduce el ordinal de un mes (Ejemplo: Enero = 1):";
	cin >> mes;
	while(mes < 1 || mes > 12);
	switch(mes){
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12: cout << "El mes tiene 31 dias."<< endl;
	break;
	case 2: cout << "El mes tiene 28 dias."<< endl;
	break;
	default: cout << "El mes tiene 30 dias."<< endl;
	break;
	}
	return 0;
}
