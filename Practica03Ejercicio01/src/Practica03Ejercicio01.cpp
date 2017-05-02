//============================================================================
// Name        : Practica03Ejercicio01.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
//UTILIZANDO FOR
/*VEO MEJOR Y MÁS FACIL UTILIZAR UN BUCLE FOR, YA QUE SE VA A SEGUIR REPITIENDO
MIENTRAS QUE EL NUMERO SEA MENOR QUE EL CONTADOR Y SIEMRE SE VA A SEGUIR REPITIENDO
YO DE ESTA MANERA LO VEO MÁS FACIL YA QUE EN LA MISMA VARIABLE VEMOS Y COMPRENDEMOS
LO QUE HACEMOS Y PARA MI ME RESULTA MAS FACIL*/
int main() {
	int n1;
	unsigned suma;
	cout << "Programa para calcular la suma de los N primeros números positivos. \n";
	cout << "Introduce el número : ";
	cin >> n1;
	suma = 0;
	for(unsigned i = 1; i <= n1; i++){
		suma = suma + i;
	}
	cout << "La suma es " << suma << endl;
	return 0;
}
