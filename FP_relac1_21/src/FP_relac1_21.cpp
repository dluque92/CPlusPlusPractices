//============================================================================
// Name        : FP_relac1_21.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int n1, numero;
	bool text = false;
	cout << "Programa para saber si un numéro está en una secuencia hasta que introduzcas 0 \n";
	cout << "Introduce el número que quieres buscar en la secuencia: ";
	cin >> n1;
	if(n1 == 0){
		cout << "FIN DEL PROGRAMA";
	}else{
		do{
			cout << "Introduce un número: ";
			cin >> numero;
			if (numero==n1){
				text = true;
			}
			}while (numero != 0);
		}
	if (text==true){
		cout << "El número "<<n1<< " aparece en la secuencia" <<endl;
	}else{
		cout << "El número "<<n1<< " no aparece en la secuencia" <<endl;
	}
	return 0;
}
