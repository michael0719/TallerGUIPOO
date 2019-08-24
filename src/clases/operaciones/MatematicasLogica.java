package clases.operaciones;

public class MatematicasLogica extends Matematicas {

    public double calcularSuma(){
        return (this.getNumero1()+this.getNumero2());
    }

    public double calcularResta(){
        return (this.getNumero1()-this.getNumero2());
    }

    public double calcularMultiplicacion(){
        return (this.getNumero1()*this.getNumero2());
    }

    public double calcularDivision(){
        return (this.getNumero1()/this.getNumero2());
    }
}
