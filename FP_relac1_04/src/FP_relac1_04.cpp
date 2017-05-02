//============================================================================
// Name        : FP_relac1_04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool pertenece = false;
	unsigned x;
	cout << "Programa para saber si el número pertenece al rango {3,4,5,6,7}. \n";
	cout << "Introduce un número: ";
	cin >> x;
	for(unsigned i=3;i<=7;i++){
		if (i==x){
			pertenece = true;
		}
	}
	if (pertenece==1){
		cout << "El número "<<x<<" pertenece al rango.";
	}else{
		cout << "El número "<<x<<" no pertenece al rango.";
	}
}
