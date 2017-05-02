//============================================================================
// Name        : Practica08Ejercicio04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

string sumar(string conjunto1, string conjunto2){
	string sumar;
	sumar=conjunto1;
	for(unsigned i=0;i<conjunto2.size();i++){
		unsigned cont=0;
		for(unsigned j=0; j<sumar.size();j++){
			if(conjunto2[i]==sumar[j]){
				cont++;
			}
		}
		if(cont==0){
			sumar+=conjunto2[i];
		}
	}
	return sumar;
}

string restar(string conjunto1, string conjunto2){
	string restar;
	restar=conjunto1;
	for(unsigned i=0;i<conjunto2.size();i++){
		unsigned restarsize=restar.size();
			for(unsigned j=0; j<restarsize;j++){
				if(conjunto2[i]==restar[j]){
					for(unsigned k=j;k<restar.size();k++){
						restar[k]=restar[k+1];
					}
					restar[restar.size()-1]=' ';
				}
			}
		}
	return restar;
}

string multiplicar(string conjunto1, string conjunto2){
	string multiplicar;
	for(unsigned i=0;i<conjunto1.size();i++){
		for(unsigned j=0; j<conjunto2.size();j++){
			if(conjunto1[i]==conjunto2[j]){
				multiplicar+=conjunto1[i];
			}
		}
	}
	return multiplicar;
}

int main() {
	string conjunto1, conjunto2;
	char oper;
	cout << "Programa que hace la función de calculadora." <<endl;
	cout << "Operación: ";
	cin >> oper;
	while(oper != '&'){
		cout << "Conjunto 1: ";
		cin >> conjunto1;
		cout << "Conjunto 2: ";
		cin >> conjunto2;
		switch(oper){
			case '+':
				cout << "Resultado: "<<sumar(conjunto1,conjunto2)<<endl;
				break;
			case '-':
				cout << "Resultado: "<<restar(conjunto1,conjunto2)<<endl;
				break;
			case '*':
				cout << "Resultado: "<<multiplicar(conjunto1,conjunto2)<<endl;
				break;
		}
		cout << "Operación: ";
		cin >> oper;
	}
	cout <<endl <<"FIN DEL PROGRAMA.";
}
