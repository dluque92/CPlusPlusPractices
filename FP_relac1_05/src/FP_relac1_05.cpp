//============================================================================
// Name        : FP_relac1_05.cpp
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
	cout << "Programa para saber si el número pertenece al rango {1,2,3,7,8,9}. \n";
	cout << "Introduce un número: ";
	cin >> x;
	if(((x>=1)&&(x<=3))||((x>=7)&&(x<=9))){
			pertenece = true;
	}
	if (pertenece==1){
		cout << "El número "<<x<<" pertenece al rango.";
	}else{
		cout << "El número "<<x<<" no pertenece al rango.";
	}
}
