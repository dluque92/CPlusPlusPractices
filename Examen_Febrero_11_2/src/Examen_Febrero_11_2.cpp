//============================================================================
// Name        : Examen_Febrero_11_2.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

bool estaPatron(const string& patron,const string& texto){
	bool contiene = false;
	unsigned i=0;
	while((!contiene)&&(i<texto.size()-patron.size()+1)){
		if(texto.substr(i,patron.size())==patron){
			contiene=true;
		}else{
			i++;
		}
	}
	return contiene;
}

void sustituir(const string& patron, const string& sustituto, const string& texto, string& result){
	unsigned i=0;
	while(texto.substr(i,patron.size())!=patron){
		i++;
	}
	result=texto.substr(0,i);
	result+=sustituto;
	unsigned j=i+patron.size();
	result+=texto.substr(j,texto.size()-j);
}

int main(){
	string patron, sustituto, texto, result;
	bool esta;
	cout << "Programa que te sustituye un patron que contenga una palabra por un sustituto."<<endl;
	cout << "PATRON: ";
	cin >> patron;
	cout << "SUSTITUTO: ";
	cin >> sustituto;
	cout << "INTRODUCE EL TEXTO: ";
	cin >> texto;
	unsigned i=0;
	while(texto!="FIN"){
		esta=estaPatron(patron, texto);
		if(esta==true){
			i++;
			sustituir(patron,sustituto,texto,result);
			cout <<"Palabra n."<<i <<":" <<result <<endl;
		}
		cin >> texto;
	}
	if(i!=0){
		cout << "El numero de palabras que contiene el patron " <<patron <<" son: " <<i <<endl;
		cout << "Las palabras con el patron sustituido por "<<sustituto <<" son:" <<endl;
	}else{
		cout << "No hay palabras que contengan el patron.";
	}
}
