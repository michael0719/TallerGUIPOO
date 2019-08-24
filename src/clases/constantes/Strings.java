package clases.constantes;

public enum Strings {

    TITULO_OPCION_MATEMATICAS("Opción de Operaciones Matemáticas"),
    MENSAJE_DESPEDIDA("Good bye"),
    MENSAJE_DIVISION_CERO("La division por cero no existe"),
    MENSAJE_TITULO_SALARIO("Calcular salario"),
    MENSAJE_TURNO_DIURNO("Turno : Diurno"),
    MENSAJE_TURNO_NOTURNO("Turno : Noturno"),
    MENSAJE_TIPO_LABORAL("Tipo de dia : Laboral"),
    MENSAJE_TIPO_FESTIVO("Tipo de dia : Festivo"),
    MENSAJE_DATOS("Datos"),
    MENSAJE_NOMBRE("Nombre: "),
    MENSAJE_DIA("Dia: "),
    MENSAJE_HORAS_TRABAJADAS("Horas trabajadas: "),
    MENSAJE_PAGO_TOTAL("Pago total: "),
    MENSAJE_TITULO_CONVERTIDOR("Convertidor de moneda"),
    MENSAJE_PESO("$ "),
    MENSAJE_PESOS_COLOMBIANOS(" Pesos colombianos"),
    MENSAJE_MENU("Menu Principal");

    private String texto;

    Strings(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
