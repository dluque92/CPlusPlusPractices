//============================================================================
// Name        : FP_relac1_03.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool divisor;
	unsigned num;
	cout << "Programa para saber si un n�mero es divisor de 100. \n";
	cout << "Introduce un n�mero: ";
	cin >> num;
	if (100%num==0){
		divisor = true;
	}else{
		divisor = false;
	}
	if (divisor==1){
		cout << "El n�mero "<<num<<" es un divisor de 100";
	}else{
		cout << "El n�mero "<<num<<" no es un divisor de 100";
	}
}
