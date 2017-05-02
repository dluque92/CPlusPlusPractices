//============================================================================
// Name        : Relacion02Ejercicio05.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int LeerNumero(){
	int numero;
	do{
		cout << "Introduce un número mayor que 1: ";
		cin >> numero;
	}while(numero <=1);
	return numero;
}
bool esPrimo(unsigned num){
	bool loes = true ;
	unsigned i = 2;
	while((loes == true) && (i <= unsigned(num/2))){
		if(num != i){
			if(num%i == 0){
				loes = false;
			}
		}
		i++;
	}
	return loes;
}
void descomposicionPrimos(int numero){
	int cociente;
	cociente=numero;
	unsigned i;
	for(i=2;i<=numero/2;i++){
		while(cociente%i==0){
			cout <<i <<" ";
			cociente = cociente/i;}
		if(cociente<i)break;
	}
}
int main() {
	int cociente, numero;
	cociente = numero;
	cout << "Programa que te descompone un número en factores primos: \n";
	numero= LeerNumero();
	if (esPrimo(numero)){
		cout << "El numero " <<numero << " descompuesto en factores primos es: "<<numero;
	}else{
		cout << "El numero " <<numero << " descompuesto en factores primos es: ";
		descomposicionPrimos(numero);
	}
	return 0;
}
