//============================================================================
// Name        : FP_relac1_09.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool nada;
	char c;
	cout << "Programa para saber si es una letra o no. \n";
	cout << "Introduce una letra: ";
	cin >> c;
	if((c>='A')&&(c<='Z')){
		nada = false;
	}else if((c>='a')&&(c<='z')){
		nada = false;
	}else{
		nada = true;
	}
	if(nada==1){
		cout << c<< " no es una letra.";
	}else{
		cout <<c<<" Es una letra.";
	}
}
