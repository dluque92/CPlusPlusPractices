//============================================================================
// Name        : FP_relac1_02.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool digitos;
	unsigned num;
	cout << "Programa para saber si has introducido un n�mero de 3 digitos. \n";
	cout << "Introduce el n�mero: ";
	cin >> num;
	if((num>99)&&(num<1000)){
		digitos = true;
	}else{
		digitos = false;
	}
	if (digitos==1){
		cout << "El n�mero "<<num<<" tiene 3 digitos.";
	}else{
		cout << "El n�mero "<<num<<" no tiene 3 digitos.";
	}
	return 0;
}
