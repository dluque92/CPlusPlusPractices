//============================================================================
// Name        : FP_relac3_12.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const unsigned N = 5;
typedef unsigned TVector[N];

unsigned valorAbsoluto(int v) {
	unsigned res;
	if (v < 0) {
		res = -v;
	} else {
		res = v;
	}
	return res;
}

int sumaPesos(const TVector &v, int inicio, int fin, unsigned centro){
	int suma = 0;
    for(int i = inicio; i <= fin; i++){
    	suma = suma + valorAbsoluto(centro-i) * v[i];
    }
    return suma;
}

void centroVector(const TVector &v, bool &existe, unsigned &centro){
    existe = false;
    centro = 1;
    while (centro <= N-2 && !existe){
        if (sumaPesos(v,0,centro-1,centro) == sumaPesos(v,centro+1,N-1,centro)) {
            existe = true;
        } else {
            centro++;
        }
    }
}

int main(){
    TVector v;
    bool existe;
    unsigned centro;
    cout << "Introduzca " << N << " numeros naturales: " << endl;
    for (unsigned i = 0; i < N; i++){
        cin >> v[i];
    }
    centroVector(v,existe,centro);
    if (existe){
        cout << "El centro de este vector es el indice " << centro << endl;
    }else{
        cout << "Este vector no tiene centro " << endl;
    }
}
