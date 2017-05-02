//============================================================================
// Name        : FP_relac1_25.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int lista, nu = 12, cont = 1, pri, ult;
	bool val = false, valpri = false;
	cout << "Programa para saber si está el numero 12. \n";
	do{
		cout << "Introduce una cadena de numeros, acabada en 0: ";
		cin >> lista;
		if(lista == nu && valpri == false){
			pri = cont;
			valpri = true;
		}
		if(lista == nu){
			ult = cont;
			val = true;
		}
		cont ++;
	}
	while(lista != 0);
	if(val == true){
		cout << "El número 12 aparace por primera vez en la posición " << pri << endl;
		cout << "El número 12 aparace por última vez en la posición " << ult << endl;
	}else{
		cout << "El número 12 no aparece." << endl;
	}
	return 0;
}
