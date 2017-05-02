//============================================================================
// Name        : Practica02Ejercicio03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
char c;
int main() {
	cout << "Programa para saber si introduces una letra o un punto. \n";
	cout << "Introduce un caracter: ";
	cin >> c;
	if (c=='.'){
		cout << "Es punto." <<endl;
	}else if (((c>='A')&&(c<='Z'))||((c>='a')&&(c<='z'))){
		cout << "Es letra." <<endl;
	} else {
		cout << "Error" <<endl;
	}
	return 0;
}
