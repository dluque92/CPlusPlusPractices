//============================================================================
// Name        : Practica03Ejercicio01.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
//UTILIZANDO FOR
/*VEO MEJOR Y M�S FACIL UTILIZAR UN BUCLE FOR, YA QUE SE VA A SEGUIR REPITIENDO
MIENTRAS QUE EL NUMERO SEA MENOR QUE EL CONTADOR Y SIEMRE SE VA A SEGUIR REPITIENDO
YO DE ESTA MANERA LO VEO M�S FACIL YA QUE EN LA MISMA VARIABLE VEMOS Y COMPRENDEMOS
LO QUE HACEMOS Y PARA MI ME RESULTA MAS FACIL*/
int main() {
	int n1;
	unsigned suma;
	cout << "Programa para calcular la suma de los N primeros n�meros positivos. \n";
	cout << "Introduce el n�mero : ";
	cin >> n1;
	suma = 0;
	for(unsigned i = 1; i <= n1; i++){
		suma = suma + i;
	}
	cout << "La suma es " << suma << endl;
	return 0;
}
