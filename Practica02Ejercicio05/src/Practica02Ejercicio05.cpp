//============================================================================
// Name        : Practica02Ejercicio05.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	double total,unidades,precio,iva,descuento;
	precio=100;
	iva=0.12;
	descuento=0.05;
	cout <<"Programa para calcular el precio total segun las unidades. \n";
	cout <<"Introduce el número de unidades: ";
	cin >> unidades;
	total=(precio*unidades)*iva+precio*unidades;
	if (total<=300){
		cout << "El precio final es: "<<total <<endl;
	}else{
		total=(((precio*unidades)*iva+precio*unidades)-((precio*unidades)*iva+precio*unidades)*descuento);
		cout << "El precio final con un 5% de descuento es: "<<total <<endl;
	}
	return 0;
}
