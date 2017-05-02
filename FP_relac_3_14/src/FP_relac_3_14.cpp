//============================================================================
// Name        : FP_relac_3_14.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned MAX=26;
struct TReg{
	int mayor;
	int posicion;
};

typedef TReg TVector[MAX];

void iniciarVector(TVector& v){
	for(unsigned i=0; i<MAX; i++){
		v[i].posicion=-1;
		v[i].mayor=-1;
	}
}

unsigned ConvertirCarNum(char car){
	unsigned num;
	num=int(car)-65;
	return num;
}

void EscribirVector(const TVector& v){
	int dist;
	char car;
	for (unsigned i=0;i<MAX;i++){
		if(v[i].mayor!=-1){
			dist=v[i].mayor;
			car=char(i+65);
			cout << "Distancia entre "<<car <<": "<<dist <<endl;
		}
	}
}

int main() {
	TVector v;
	unsigned num,cont;
	char car;
	int distancia;
	iniciarVector(v);
	cout << "Introduzca un texto acabado en ."<<endl;
	car=cin.get();
	cont=0;
	while(car!='.'){
		num=ConvertirCarNum(car);
		if (v[num].posicion==-1){
			v[num].posicion=cont;
		}else{
			distancia=(cont-v[num].posicion)-1;
			if (distancia>v[num].mayor){
				v[num].mayor=distancia;
			}
			v[num].posicion=cont;
		}
		car=cin.get();
		cont++;
	}
	EscribirVector(v);
}
