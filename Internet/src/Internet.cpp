#include <iostream>
using namespace std;

const unsigned MAXIMO = 1000;
typedef unsigned TErastotenes[MAXIMO];

unsigned leerN (){
	unsigned N;
	do{
		cout << "Introduce N: ";
		cin >> N;
	}while(N > 1000);
	return N;
	}

void inicializar(TErastotenes& erastotenes, unsigned N){
	for(unsigned i=0; i<N; i++){
		erastotenes[i]=i+1;
		}
	}

void criba (TErastotenes erastotenes, unsigned N){
	for(unsigned i=2; i<N; i++){
		if(erastotenes[i] != 0){
			for(unsigned j = i+1; j < N; j++){
				if((j+1)%(i+1) == 0){
					erastotenes[j] = 0;
				}
			}
		}
	}
}

void mostrar(const TErastotenes& erastotenes, unsigned N){
	for(unsigned i = 0;i < N; i++){
		if(erastotenes[i] != 0){
			cout << erastotenes[i] << " ";
		}
	}
}

int main() {
	unsigned dim = leerN();
	TErastotenes erastotenes;
	inicializar(erastotenes, dim);
	criba(erastotenes, dim);
	mostrar(erastotenes, dim);
	return 0;
}
