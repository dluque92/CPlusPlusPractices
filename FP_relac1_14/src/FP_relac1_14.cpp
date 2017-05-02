//============================================================================
// Name        : FP_relac1_14.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int num;
	cout << "Programa para saber si un número es múltiplo de 3, 4 o 5. \n";
	cout << "Introduce un número: ";
	cin >> num;
	if (((num%3==0)&&(num%4==0))&&(num%5==0)){
		cout << "El número "<<num<< " es múltiplo de 3, 4 y 5." <<endl;
	}else if (((num%3==0)&&(num%4==0))&&(num%5!=0)){
			cout << "El número "<<num<< " es múltiplo de 3 y 4." <<endl;
	}else if (((num%3!=0)&&(num%4==0))&&(num%5==0)){
			cout << "El número "<<num<< " es múltiplo de 4 y 5." <<endl;
	}else if (((num%3==0)&&(num%4!=0))&&(num%5==0)){
			cout << "El número "<<num<< " es múltiplo de 3 y 5." <<endl;
	}else if (num%3==0){
		cout << "El número "<<num<< " es múltiplo de 4." <<endl;
	}else if (num%4==0){
		cout << "El número "<<num<< " es múltiplo de 4." <<endl;
	}else if (num%5==0) {
		cout << "El número "<<num<< " es múltiplo de 5." <<endl;
	}else{
		cout << "El número "<<num<< " no es múltiplo de ninguno."<<endl;
	}
	return 0;
}
