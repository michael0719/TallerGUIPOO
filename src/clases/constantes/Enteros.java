package clases.constantes;

public enum Enteros {

    CERO(0),
    UNO(1),
    QUINIENTOS(500),
    SEISCIENTOS(600),
    CUATROCIENTOS(400),
    TREINTAYCINCOMIL(35000),
    CINCUENTAMIL(50000),
    TRESMIL(3000),
    TRESMILQUINIENTOS(3500),
    MILQUINIENTOS(1500);

    private int valor;

    Enteros(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
