//============================================================================
// Name        : FP_relac1_21.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int n1, numero;
	bool text = false;
	cout << "Programa para saber si un num�ro est� en una secuencia hasta que introduzcas 0 \n";
	cout << "Introduce el n�mero que quieres buscar en la secuencia: ";
	cin >> n1;
	if(n1 == 0){
		cout << "FIN DEL PROGRAMA";
	}else{
		do{
			cout << "Introduce un n�mero: ";
			cin >> numero;
			if (numero==n1){
				text = true;
			}
			}while (numero != 0);
		}
	if (text==true){
		cout << "El n�mero "<<n1<< " aparece en la secuencia" <<endl;
	}else{
		cout << "El n�mero "<<n1<< " no aparece en la secuencia" <<endl;
	}
	return 0;
}
