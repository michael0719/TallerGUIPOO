package clases.calculosalario;
import static clases.constantes.Enteros.*;
public class SalarioLogica extends Salario {

    public double jornal(int td,int tur){
        if(td==1){
            if(tur==0)
                return (this.getHoras()*TREINTAYCINCOMIL.getValor())*1.1;
            else{
                return (this.getHoras()*CINCUENTAMIL.getValor())*1.15;
            }
        }else{
            if(tur==0){
                return (this.getHoras()*TREINTAYCINCOMIL.getValor())*1.0;
            }else{
                return (this.getHoras()*CINCUENTAMIL.getValor())*1.0;
            }
        }
    }

}
