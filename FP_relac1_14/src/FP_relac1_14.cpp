//============================================================================
// Name        : FP_relac1_14.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int num;
	cout << "Programa para saber si un n�mero es m�ltiplo de 3, 4 o 5. \n";
	cout << "Introduce un n�mero: ";
	cin >> num;
	if (((num%3==0)&&(num%4==0))&&(num%5==0)){
		cout << "El n�mero "<<num<< " es m�ltiplo de 3, 4 y 5." <<endl;
	}else if (((num%3==0)&&(num%4==0))&&(num%5!=0)){
			cout << "El n�mero "<<num<< " es m�ltiplo de 3 y 4." <<endl;
	}else if (((num%3!=0)&&(num%4==0))&&(num%5==0)){
			cout << "El n�mero "<<num<< " es m�ltiplo de 4 y 5." <<endl;
	}else if (((num%3==0)&&(num%4!=0))&&(num%5==0)){
			cout << "El n�mero "<<num<< " es m�ltiplo de 3 y 5." <<endl;
	}else if (num%3==0){
		cout << "El n�mero "<<num<< " es m�ltiplo de 4." <<endl;
	}else if (num%4==0){
		cout << "El n�mero "<<num<< " es m�ltiplo de 4." <<endl;
	}else if (num%5==0) {
		cout << "El n�mero "<<num<< " es m�ltiplo de 5." <<endl;
	}else{
		cout << "El n�mero "<<num<< " no es m�ltiplo de ninguno."<<endl;
	}
	return 0;
}
