package clases.convertir;
import static clases.constantes.Enteros.*;
public class MonedaLogica extends Moneda {

    public double dolar(){
        return this.getCantidadMoneda()*TRESMIL.getValor();
    }

    public double euro(){
        return  this.getCantidadMoneda()*TRESMILQUINIENTOS.getValor();
    }

    public double yen(){
        return  this.getCantidadMoneda()*MILQUINIENTOS.getValor();
    }

}
