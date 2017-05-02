//============================================================================
// Name        : Practica07Ejercicio03.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

const int N = 5;
typedef unsigned int TMatriz[N][N];

void leerMatriz (TMatriz& a){
	cout << "Programa que te genera una matriz 5x5 y te suma la diagonal."<<endl;
	cout << "Introduzca valores para la matriz:" <<endl;
	for (int fi=0 ; fi<N ; fi++){
		for (int co=0 ; co<N ; co++){
			cin >> a[fi][co];
		}
	}
}

bool filas(const TMatriz& a, int res){
	bool igual = true;
	int suma = 0;
	for(int i=0;i<N;i++){
		suma = 0;
		for(int j=0;j<N;j++){
			suma+=a[i][j];
		}
		if(suma!=res){
			igual = false;
			break;
		}
	}
	return igual;
}
bool columnas(const TMatriz& a, int res){
	bool igual = true;
	int suma = 0;
	for(int i=0;i<N;i++){
		suma = 0;
		for(int j=0;j<N;j++){
			suma+=a[j][i];
		}
		if(suma!=res){
			igual = false;
			break;
		}
	}
	return igual;
}

bool diagonal1(const TMatriz& a, int res){
	bool igual = true;
	int suma = 0, i=0, j=0;
 	while((i<N)&&(j<N)){
		suma+=a[i][j];
		i++;
		j++;
	}
	if(suma!=res){
		igual = false;
	}
	return igual;
}

bool diagonal2(const TMatriz& a, int res){
	bool igual = true;
	int suma = 0, i=N-1, j=N-1;
 	while((i>=0)&&(j>=0)){
		suma+=a[i][j];
		i--;
		j--;
	}
	if(suma!=res){
		igual = false;
	}
	return igual;
}

unsigned resultado(const TMatriz& a){
	int res = 0;
	for(int j=0;j<N;j++){
		res+=a[0][j];
	}
	return res;
}

bool magico(const TMatriz& a){
	int res = resultado(a);
	if((!filas(a,res))||(!columnas(a,res))||(!diagonal1(a,res))||(!diagonal2(a,res))){
		return false;
	}else{
		return true;
	}
}
int main() {
	TMatriz a;
	leerMatriz(a);
	if(magico(a)){
		cout << "El cuadrado es magico" << endl;
	}else{
		cout << "No es un cuadrado magico" << endl;
	}
}
