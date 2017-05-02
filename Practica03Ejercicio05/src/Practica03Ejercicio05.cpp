//============================================================================
// Name        : Practica03Ejercicio05.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int n1, mult = 0;
	double PI = 4, i = 2, j = 3;
	cout << "Programa para calcular PI a partir de un número de fracciones. \n";
	cout << "Introduce un número: ";
	cin >> n1;
	if (n1==0){
		cout << "No se puede calcular con 0 multiplicaciones." << endl;
		return 0;
	}else{
		while(mult <= n1){
			PI = PI * i/j;
			i = i + 2;
			mult++;
			if(mult <= n1){
				PI = PI * i/j;
				j = j + 2;
				mult++;
			}
		}
	}
	cout << "Pi = "<< PI << endl;
	return 0;
}
