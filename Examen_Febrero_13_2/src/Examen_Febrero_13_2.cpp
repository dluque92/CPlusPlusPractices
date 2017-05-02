//============================================================================
// Name        : Examen_Febrero_13_2.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;


struct TPuntoInteres {
	unsigned tipo;
	string nombre;
	bool hayPuntoInteres;
};

const int N = 20;
typedef TPuntoInteres Filas[N];
typedef Filas TMapa[N];

bool esValida(int fila, int columna) {
	return ((0 <= fila) && (fila < N) && (0 <= columna) && (columna < N));
}

void buscarPuntoInteresHorizontal(const TMapa& mapa, unsigned tipo, int fila, int columna, int distancia,
		int& filaPi, int& columnaPi, bool& ok) {

	int co = columna-distancia;
	while ((!ok) && (co < columna+distancia)) {
		if (esValida(fila-distancia,co)
			&& mapa[fila-distancia][co].hayPuntoInteres
			&& mapa[fila-distancia][co].tipo == tipo) {
			ok = true;
			filaPi = fila-distancia;
			columnaPi = co;
		} else if (esValida(fila+distancia,co)
				   && mapa[fila+distancia][co].hayPuntoInteres
				   && mapa[fila+distancia][co].tipo == tipo) {
			ok = true;
			filaPi = fila+distancia;
			columnaPi = co;
		}
		co++;
	}
}

void buscarPuntoInteresVertical(const TMapa& mapa, unsigned tipo, int fila, int columna, int distancia,
		int& filaPi, int& columnaPi, bool& ok) {

	int fi = fila-distancia;
	while ((!ok) && (fi < fila+distancia)) {
		if (esValida(fi,columna-distancia)
					&& mapa[fi][columna-distancia].hayPuntoInteres
					&& mapa[fi][columna-distancia].tipo == tipo) {
					ok = true;
					filaPi = fi;
					columnaPi = columna-distancia;
				} else if (esValida(fi,columna+distancia)
						   && mapa[fi][columna+distancia].hayPuntoInteres
						   && mapa[fi][columna+distancia].tipo == tipo) {
					ok = true;
					filaPi = fi;
					columnaPi = columna+distancia;
				}
				fi++;
	}
}

void buscarPuntoInteres(const TMapa& mapa, unsigned tipo, int fila, int columna, int distancia,
						int& filaPi, int& columnaPi, bool& ok) {
	buscarPuntoInteresHorizontal(mapa,tipo,fila,columna,distancia,filaPi,columnaPi,ok);
	if (!ok) {
		buscarPuntoInteresVertical(mapa,tipo,fila,columna,distancia,filaPi,columnaPi,ok);
	}
}

void puntoInteresMasCercano(const TMapa& mapa, unsigned tipo, int fila, int columna,
							TPuntoInteres& puntInt, int& filaPi, int& columnaPi, bool& ok) {
	int distancia;

	if ((tipo > 3) || (fila < 0) || (fila >= N) || (columna < 0) || (columna >= N)) {
		ok = false;
	} else {
		if (mapa[fila][columna].hayPuntoInteres && mapa[fila][columna].tipo == tipo) {
			ok = true;
			puntInt = mapa[fila][columna];
		} else {
			distancia = 1;
			ok = false;
			while (((fila-distancia >= 0) || (fila+distancia < N)
					|| (columna-distancia >= 0) || (columna+distancia < N)) && !ok) {
				buscarPuntoInteres(mapa,tipo,fila,columna,distancia,filaPi,columnaPi,ok);
				distancia++;
			}
			if (ok) {
				puntInt = mapa[filaPi][columnaPi];
			}

		}
	}
}

int main()
{
        TMapa mapa;
        int fila, columna, filaPi, columnaPi;
        unsigned tipo;
        TPuntoInteres puntoInteres;
        bool ok;

        for (int i=0; i< N; i++){
            for (int j=0; j < N; j++){
                mapa[i][j].hayPuntoInteres = false;
            }
        }

        mapa[0][0].nombre = "Hotel Plaza";
        mapa[0][0].tipo = 0;
        mapa[0][0].hayPuntoInteres = true;

        mapa[19][19].nombre = "Hotel Los Pacos";
        mapa[19][19].tipo = 0;
        mapa[19][19].hayPuntoInteres = true;

        mapa[2][4].nombre = "Gasolinera Las Chapas";
        mapa[2][4].tipo = 1;
        mapa[2][4].hayPuntoInteres = true;

        mapa[0][1].nombre = "Gasolinera Teatinos";
        mapa[0][1].tipo = 1;
        mapa[0][1].hayPuntoInteres = true;

        fila = 2;
        columna = 3;
        tipo = 1;
        puntoInteresMasCercano(mapa, tipo, fila, columna, puntoInteres, filaPi, columnaPi, ok);
        if (ok)
        {
            cout << "La gasolinera mas cercana a la posicion (" << fila << "," << columna << ") es: " << puntoInteres.nombre << " en la posicion: (" << filaPi << "," << columnaPi << ")" << endl << endl;
        }else
        {
            cout << "No se ha encontrado ningun punto de interes del tipo solicitado." << endl << endl;
        }

        tipo = 0;
        puntoInteresMasCercano(mapa, tipo, fila, columna, puntoInteres, filaPi, columnaPi, ok);
        if (ok)
        {
            cout << "El hotel mas cercano a la posicion (" << fila << "," << columna << ") es: " << puntoInteres.nombre << " en la posicion: (" << filaPi << "," << columnaPi << ")" << endl << endl;
        }else
        {
            cout << "No se ha encontrado ningun punto de interes del tipo solicitado." << endl << endl;
        }

        tipo = 2;
        puntoInteresMasCercano(mapa, tipo, fila, columna, puntoInteres, filaPi, columnaPi, ok);
        if (ok)
        {
            cout << "El hospital mas cercano a a la posicion (" << fila << "," << columna << ") es: " << puntoInteres.nombre << " en la posicion: (" << filaPi << "," << columnaPi << ")" << endl << endl;
        }else
        {
            cout << "No se ha encontrado ningun punto de interes del tipo solicitado." << endl << endl;
        }
}
