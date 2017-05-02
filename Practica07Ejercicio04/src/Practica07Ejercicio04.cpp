//============================================================================
// Name        : Practica07Ejercicio04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <conio.h>
using namespace std;

const int N = 100;
typedef int TMatriz[N][N];

struct Matriz {
TMatriz numeros; // array de enteros
unsigned tam; // numero de celdas ocupadas
};

void LeerN(Matriz& a){
	cout << "Programa que te generea un cuadrado mágico NxN."<<endl;
	do{
		cout << "Introduce un numero impar N: ";
		cin >> a.tam;
	}while(a.tam%2==0);
}

void inicializar(Matriz& a){
	for(unsigned fila=0; fila<a.tam; fila++){
		for(unsigned columna=0; columna<a.tam; columna++){
			a.numeros[fila][columna]=0;
		}
	}
	a.numeros[0][a.tam/2]=1;
}

void decrementar(const Matriz& a, unsigned &v){
	if(v==0){
		v=a.tam-1;
	}else{
		v--;
	}
}

void incrementar(const Matriz& a, unsigned &v){
	if(v==a.tam-1){
		v=0;
	}else{
		v++;
	}
}

void siguienteCoordenada(const Matriz& a, unsigned &x, unsigned &y){
	decrementar(a,x);
	decrementar(a,y);
	if(a.numeros[x][y]!=0){
		incrementar(a,x);
		incrementar(a,y);
		incrementar(a,x);
	}
}
void CrearMagico(Matriz& a){
	unsigned x=0;
	unsigned y=a.tam/2;
	inicializar(a);
	for(unsigned i=2; i<=a.tam*a.tam; i++){
		siguienteCoordenada(a,x,y);
		a.numeros[x][y]=i;
	}
}

void ImprimirMatriz(Matriz& a){
	for(unsigned fila=0; fila<a.tam; fila++){
		for(unsigned columna=0; columna<a.tam; columna++){
			cout << a.numeros[fila][columna] <<" ";
		}
		cout << endl;
	}
}

int main() {
	Matriz a;
	LeerN(a);
	CrearMagico(a);
	ImprimirMatriz(a);
}
