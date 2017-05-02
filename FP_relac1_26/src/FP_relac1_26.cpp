//============================================================================
// Name        : FP_relac1_26.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int sup, inf, num;
	bool final = false;
	char op;
	cout << "Programa para adivinar un número. \n";
	cout << "Introduce un límite superior: ";
	cin >> sup;
	cout << "Introduce un límite inferior: ";
	cin >> inf;
	while (final == false){
	      num = (sup+inf)/2;
	      cout << "El numero es " << num << "?" << endl;
	      cout << "Contesta con '=' si es ese, '<' si es menor o '>' si es mayor: ";
	      cin >> op;
	      if (op == '<'){
	    	  sup = num;
	      }else if (op == '>'){
	    	  inf = num;
	      }else if (op == '='){
	    	  cout << "Numero adivinado.";
	    	  final = true;
	      }
	}
	return 0;
}
