/*
 * Examen_Febrero_11_1.cpp
 *
 *  Created on: 28/1/2015
 *      Author: David
 */


#include <iostream>
using namespace std;

const unsigned FILA=6;
const unsigned COLUMNA=7;
typedef unsigned Tablero [FILA][COLUMNA];

void iniciarTablero(Tablero& tab){
	for (unsigned i=0;i<FILA;i++){
		for (unsigned j=0;j<COLUMNA;j++){
			tab[i][j]=0;
		}
	}
}

void meterFicha(Tablero& tab, unsigned ficha, unsigned columna, bool& ok, unsigned& fila){
	fila=FILA;
	fila--;
	if(tab[fila][columna]==0){
		tab[fila][columna]=ficha;
		ok = true;
	}else{
		do{
			fila--;
		}while((tab[fila][columna]!=0)&&(fila>=0));
		if (fila<0){
			ok = false;
		}else{
			tab[fila][columna]=ficha;
			ok = true;
		}
	}
}

bool cuatroEnRaya(const Tablero& tab, unsigned fil, unsigned col){
	bool existe=false;
	for(unsigned i=0;i<COLUMNA-3;i++){
		if(tab[fil][i]!=0&&((tab[fil][i]==tab[fil][i+1])&&(tab[fil][i]==tab[fil][i+2])&&(tab[fil][i]==tab[fil][i+3]))){
			existe=true;
		}
	}
	if(existe!=true){
		for(unsigned j=0;j<FILA-2;j++){
			if(tab[j][col]!=0&&((tab[j][col]==tab[j+1][col])&&(tab[j][col]==tab[j+2][col])&&(tab[j][col]==tab[j+3][col]))){
				existe=true;
			}
		}
	}
	if(existe!=true){
		for (unsigned k=0;k<FILA;k++){
			for(unsigned l=0;l<COLUMNA;l++){
				if(tab[k][l]!=0&&((tab[k][l]==tab[k+1][l+1])&&(tab[k][l]==tab[k+2][l+2])&&(tab[k][l]==tab[k+3][l+3]))){
					existe=true;
				}
			}
		}
	}
	if(existe!=true){
		for (unsigned m=FILA-1;m<0;m--){
			for(unsigned n=0;n<COLUMNA;n++){
				if(tab[m][n]!=0&&((tab[m][n]==tab[m-1][n+1])&&(tab[m][n]==tab[m-2][n+2])&&(tab[m][n]==tab[m-3][n+3]))){
					existe=true;
				}
			}
		}
	}
	return existe;
}

void mostrarTablero(Tablero& tab){
	for (unsigned i=0;i<FILA;i++){
			for (unsigned j=0;j<COLUMNA;j++){
				cout <<tab[i][j] <<" ";
			}
			cout <<endl;
		}
}

int main(){
	Tablero tab;
	unsigned ficha, fila, columna;
	bool ok;
	bool Cuatro;
	iniciarTablero(tab);
	unsigned i=0;
	do{
		do{
			do{
				ficha=i%2+1;
				cout << "Introduce la columna Jugador "<<ficha<<" :"<<endl;
				cin >> columna;
				}while((columna>7)||(columna<0));
				meterFicha(tab,ficha,columna,ok,fila);
				if(ok==false){
				cout << "No hay más espacio en la columna "<<columna;
			}
		}while(ok!=true);
		mostrarTablero(tab);
		Cuatro=cuatroEnRaya(tab,fila,columna);
		i++;
	}while(Cuatro!=true);
	cout << "Has hecho 4 en raya jugador "<< ficha;
}
