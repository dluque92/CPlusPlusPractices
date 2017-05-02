//============================================================================
// Name        : FP_relac1_02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool digitos;
	unsigned num;
	cout << "Programa para saber si has introducido un número de 3 digitos. \n";
	cout << "Introduce el número: ";
	cin >> num;
	if((num>99)&&(num<1000)){
		digitos = true;
	}else{
		digitos = false;
	}
	if (digitos==1){
		cout << "El número "<<num<<" tiene 3 digitos.";
	}else{
		cout << "El número "<<num<<" no tiene 3 digitos.";
	}
	return 0;
}
