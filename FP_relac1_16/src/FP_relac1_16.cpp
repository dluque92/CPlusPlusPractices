//============================================================================
// Name        : FP_relac1_16.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int num;
	cout << "Programa para saber el Descuento que tenemos. \n";
	cout << "Introduce la cantidad de articulos: ";
	cin >> num;
	while (num==1){

	}
	if (num==1){
		cout << "as" <<endl;
	}else if (num==2){
		cout << "El precio es el 95%. Tiene un 5% de Descuento." <<endl;
	}else if (num==3) {
		cout << "El precio es el 90%. Tiene un 10% de Descuento." <<endl;
	}else if (num>=4) {
			cout << "El precio es el 85%. Tiene un 15% de Descuento." <<endl;
	}else{
		cout << "No has introducido ningún articulo."<<endl;
	}
	return 0;
}
