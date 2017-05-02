//============================================================================
// Name        : FP_relac1_01.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool par;
	unsigned num;
	cout << "Introduce un número para saber si es par: ";
	cin >> num;
	if (num%2==0){
		par = true;
	}else{
		par = false;
	}
	if (par==1){
		cout << "El número "<<num<< " es par.";
	}else{
		cout << "El número "<<num<< " no es par.";
	}
}


