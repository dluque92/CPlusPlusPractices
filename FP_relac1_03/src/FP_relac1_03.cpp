//============================================================================
// Name        : FP_relac1_03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool divisor;
	unsigned num;
	cout << "Programa para saber si un número es divisor de 100. \n";
	cout << "Introduce un número: ";
	cin >> num;
	if (100%num==0){
		divisor = true;
	}else{
		divisor = false;
	}
	if (divisor==1){
		cout << "El número "<<num<<" es un divisor de 100";
	}else{
		cout << "El número "<<num<<" no es un divisor de 100";
	}
}
