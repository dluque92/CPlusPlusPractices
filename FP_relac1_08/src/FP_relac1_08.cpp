//============================================================================
// Name        : FP_relac1_08.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	bool mayuscula;
	bool nada;
	char c;
	cout << "Programa para saber si una letra es mayuscula o min�scula. \n";
	cout << "Introduce una letra: ";
	cin >> c;
	if((c>='A')&&(c<='Z')){
		mayuscula = true;
	}else if((c>='a')&&(c<='z')){
		mayuscula = false;
	}else{
		nada = true;
	}
	if(nada==1){
		cout << c<< " no es una letra.";
	}else if(mayuscula==1){
		cout << "La letra "<<c<<" es mayuscula.";
	}else{
		cout << "La letra "<<c<<" es minuscula.";
	}
}
