//============================================================================
// Name        : FP_relac3_23.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX_PAL_DIST=10;
typedef string TPalabras [MAX_PAL_DIST];

struct TReg{
	unsigned tam;
	TPalabras pal;
};

bool ContienePatron(const string& patron, const string& texto){
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

void almacenar(TReg& p, const string& texto){
	unsigned j=0;
	while((j<p.tam)&&(p.pal[j]!=texto)){
		j++;
	}
	if (j==p.tam){
		p.pal[j]=texto;
		p.tam++;
	}
}

void mostrar(const TReg& p){
	for(unsigned i=0;i<p.tam;i++){
		cout << p.pal[i] << " ";
	}
}

int main() {
	string patron, texto;
	TReg p;
	bool contiene;
	p.tam=0;
	cout << "Programa que te dice las palabras del texto que contenga dicho patron (INTRODUCE TODO EN MAYUSCULAS)" <<endl;
	cout << "Para terminar escriba FIN."<<endl;
	cout << "Patrón: ";
	cin >> patron;
	cout << "Texto: ";
	cin >> texto;
	while(texto != "FIN"){
		contiene=ContienePatron(patron,texto);
		if(contiene==true){
			almacenar(p,texto);
		}
		cin >> texto;
	};
	mostrar(p);
}
