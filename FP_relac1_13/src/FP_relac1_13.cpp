//============================================================================
// Name        : FP_relac1_13.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int n1,n2;
	cout << "Programa para saber si al introducir 2 n�meros son divisibles. \n";
	cout << "Introduce el primer n�mero: ";
	cin >> n1;
	cout << "Introduce el segundo n�mero: ";
	cin >> n2;
	if (n1%n2==0){
		cout << "El numero "<<n1<< " es divisible por el n�mero "<<n2;
	}else if (n2%n1==0){
		cout << "El numero "<<n2<< " es divisible por el n�mero "<<n1;
	}else{
		cout << "Ninguno de los dos n�meros son divisibles entre si.";
	}
}
