//============================================================================
// Name        : Practica08Ejercicio02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

void esAnagrama(string palabra, string texto,unsigned cont){
	unsigned contador = 0;
	bool loes = false;
	string aux = texto;
	if(palabra.size() == texto.size()){
		for(unsigned i=0; i<palabra.size(); i++){
			unsigned j=0;
			loes = false;
			while(j < texto.size() && loes==false){
				if(palabra[i] == aux[j]){
					loes = true;
					contador++;
					aux[j] = ' ';
				}
				j++;
			}
		}
		if(contador == palabra.size()){
			cout << texto << " es anagrama de "<< palabra << endl;
			cont++;
		}
	}
}

int main(){
	string texto, palabra;
	unsigned cont=0;
	cout << "Programa que te dice cuantas palabras del texto son un anagrama de la primera palabra introducia. " << endl;
	cout << "Introduce el texto acabado en FIN: ";
	getline(cin, palabra, ' ');
	cin >> texto;
	while(texto != "FIN"){
		esAnagrama(palabra,texto,cont);
		cin >> texto;
	}
}
