//============================================================================
// Name        : FP_relac2_10.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
/*
 Dise�a un procedimiento recursivo que lea una secuencia de caracteres de longitud
 arbitraria terminada en un punto, y la imprima en orden inverso. El procedimiento
 no tiene par�metros.
 */
void inv_sec(){
	char c;
	cin.get(c);
	if(c=='.'){

	}else{
		inv_sec();
		cout << c;
	}
}
int main() {
	cout << "Introduzca caracteres terminados en punto: ";
	inv_sec();
	return 0;
}

