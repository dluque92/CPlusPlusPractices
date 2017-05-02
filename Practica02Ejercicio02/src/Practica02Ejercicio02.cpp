//============================================================================
// Name        : Practica02Ejercicio02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int n1,n2,n3;
int main() {
	cout << "Programa para saber cual de ellos es mayor y si existe o no. \n";
	cout << "Introduce el primer numero: ";
	cin >> n1;
	cout << "Introduce el segundo numero: ";
	cin >> n2;
	cout << "Introduce el tercer numero: ";
	cin >> n3;
	if ((n1=n2)&&(n1=n3)){
		cout << "Los tres numeros son iguales." <<endl;
	}else if ((n1=n2)&&(n1!=n3)){
		cout << "El numero n1 y n2 son iguales" <<endl;
	}else if ((n1!=n2)&&(n1=n3)){
		cout << "El numero n1 y n3 son iguales" <<endl;
	}else if ((n1!=n2)&&(n2=n3)){
			cout << "El numero n2 y n3 son iguales" <<endl;
	}else if ((n1>n2)&&(n1>n3)){
		cout << "El numero "<<n1<< " es mayor que "<<n2<< " y es mayor que "<<n3 <<endl;
	}else if ((n1>n2)&&(n1<n3)){
		cout << "El numero "<<n1<< " es mayor que "<<n2<< " y es menor que "<<n3 <<endl;
	}else if ((n1<n2)&&(n2>n3)){
		cout << "El numero "<<n2<< " es mayor que "<<n1<< " y es mayor que "<<n3 <<endl;
	}else if ((n1<n2)&&(n2<n3)){
		cout << "El numero "<<n2<< " es mayor que "<<n1<< " y es menor que "<<n3 <<endl;
	}else{
		cout << "El numero "<<n3<< " es mayor que "<<n1<< " y es mayor que "<<n2 <<endl;
	}
	return 0;
}
