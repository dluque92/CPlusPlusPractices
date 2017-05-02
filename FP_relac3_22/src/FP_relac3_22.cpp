//============================================================================
// Name        : FP_relac3_22.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

const unsigned MAX_PAL_DIST=100;
typedef string TPalabras [MAX_PAL_DIST];

struct TReg{
	unsigned tam;
	TPalabras pal;
};

void introducePatron(string& patron){
	cout << "Introduce el Patrón: ";
	cin >> patron;
}

bool estaPrefijo(string patron, string texto){
	bool contiene = false;
	if(texto.substr(0,patron.size())==patron){
		contiene = true;
	}
	return contiene;
}

bool estaSufijo(string patron, string texto){
	bool contiene = false;
	if(texto.substr(texto.size()-patron.size(),patron.size())==patron){
		contiene = true;
	}
	return contiene;
}

bool estaPatron(string patron, string texto){
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

void almacenar(TReg& p, string texto){
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

void borrar(TReg& p){
	unsigned i=p.tam;
	while(i!=0){
		p.pal[i]=' ';
		p.tam--;
		i--;
	}
}
int main() {
	TReg p;
	unsigned opcion;
	string patron, texto;
	p.tam=0;
	bool contiene;
	while((opcion!=0)||(opcion>3)){
		cout << "Programa que te busca las palabras que tengan prefijo, sufijo o contengan el patron."<<endl;
		cout << "Opciones:"<<endl;
		cout << "1. Buscar Prefijo."<<endl;
		cout << "2. Buscar Sufijo."<<endl;
		cout << "3. Buscar que lo contenga."<<endl;
		cout << "0. Salir."<<endl;
		cout << "Elige que opción quieres: ";
		cin >> opcion;
		switch(opcion){
		case 1:
			introducePatron(patron);
			cout << "Introduce el texto: ";
			cin >> texto;
			while(texto!="FIN"){
				contiene=estaPrefijo(patron, texto);
				if(contiene==true){
					almacenar(p,texto);
				}
				cin >> texto;
			};
			mostrar(p);
			borrar(p);
			break;
		case 2:
			introducePatron(patron);
			cout << "Introduce el texto: ";
			cin >> texto;
			while(texto!="FIN"){
				contiene=estaSufijo(patron, texto);
				if(contiene==true){
					almacenar(p,texto);
				}
				cin >> texto;
			};
			mostrar(p);
			borrar(p);
			break;
		case 3:
			introducePatron(patron);
			cout << "Introduce el Texto: ";
			cin >> texto;
			while(texto!="FIN"){
				contiene=estaPatron(patron,texto);
				if(contiene==true){
					almacenar(p,texto);
				}
				cin >> texto;
			};
			mostrar(p);
			borrar(p);
			break;
		}
		cout <<endl;
		cout <<endl;
	};
	cout << "FIN DEL PROGRAMA.";
}
