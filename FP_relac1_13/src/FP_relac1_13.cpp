//============================================================================
// Name        : FP_relac1_13.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int n1,n2;
	cout << "Programa para saber si al introducir 2 números son divisibles. \n";
	cout << "Introduce el primer número: ";
	cin >> n1;
	cout << "Introduce el segundo número: ";
	cin >> n2;
	if (n1%n2==0){
		cout << "El numero "<<n1<< " es divisible por el número "<<n2;
	}else if (n2%n1==0){
		cout << "El numero "<<n2<< " es divisible por el número "<<n1;
	}else{
		cout << "Ninguno de los dos números son divisibles entre si.";
	}
}
