//============================================================================
// Name        : Practica03Ejercicio07.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	char op;
	int a, b;
	cout << "Programa que es como una calculadora. \n";
	do{
		cout << "Operación : ";
		cin >> op;
		if(op == '&'){
			cout << "FIN DEL PROGRAMA";
		} else {
			if((op != '+') && (op!= '-') && (op != '*')&&(op != '/')){
				throw "Operación no existente";
			}else{
				cout << "Operando 1 : ";
				cin >> a;
				cout << "Operando 2 : ";
				cin >> b;
				cout << "Resultado : ";
				switch (op){
				case '+': cout << b+a << endl;
				break;
				case '-': cout << a - b << endl;
				break;
				case '*': cout << a* b << endl;
				break;
				case '/': cout << a/b << endl;
				break;
				}
			}
		}
	}while(op != '&');
	return 0;
}
