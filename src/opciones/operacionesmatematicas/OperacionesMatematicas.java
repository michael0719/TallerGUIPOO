package opciones.operacionesmatematicas;

import static clases.constantes.Strings.*;
import static clases.constantes.Enteros.*;
import clases.operaciones.MatematicasLogica;
import menu.Menu;
import javax.swing.*;
import java.awt.*;

public class OperacionesMatematicas extends Frame {

   private static MatematicasLogica matematicasLogica = new MatematicasLogica();

    protected JPanel operacionesmatematicasform;
    protected JTextField txtnumero1;
    protected JTextField txtnumero2;
    protected JButton btnsumar;
    protected JButton btnrestar;
    protected JButton btnmultiplicar;
    protected JButton btndividir;
    protected JButton btnregresar;
    protected JLabel lblresultado;
    private JButton btbsalir;

    public OperacionesMatematicas(){
        add(operacionesmatematicasform);
        setTitle(TITULO_OPCION_MATEMATICAS.getTexto());
        setSize(QUINIENTOS.getValor(), SEISCIENTOS.getValor());

        btnregresar.addActionListener(e -> {
                Menu menu = new Menu();
                menu.setVisible(true);
                esconderVentana();
        });

        btnsumar.addActionListener(e -> {
            datos(txtnumero1.getText(), txtnumero2.getText());
            lblresultado.setText(String.valueOf(matematicasLogica.calcularSuma()));
        });
        btnrestar.addActionListener(e ->{
            datos(txtnumero1.getText(), txtnumero2.getText());
            lblresultado.setText(String.valueOf(matematicasLogica.calcularResta()));
        });
        btnmultiplicar.addActionListener(e ->{
            datos(txtnumero1.getText(), txtnumero2.getText());
            lblresultado.setText(String.valueOf(matematicasLogica.calcularMultiplicacion()));
        });
        btndividir.addActionListener(e ->{
            if(Double.parseDouble(txtnumero2.getText())!=0) {
                datos(txtnumero1.getText(), txtnumero2.getText());
                lblresultado.setText(String.valueOf(matematicasLogica.calcularDivision()));
            }else{
                JOptionPane.showMessageDialog(null,MENSAJE_DIVISION_CERO.getTexto());
            }
        });

        btbsalir.addActionListener(e->{
            JOptionPane.showMessageDialog(null,MENSAJE_DESPEDIDA.getTexto());
            System.exit(0);
        });
    }

    private void esconderVentana(){ this.dispose();  }

    private void datos(String valor1, String valor2){

        matematicasLogica.setNumero1(Double.parseDouble(valor1));
        matematicasLogica.setNumero2(Double.parseDouble(valor2));
        lblresultado.setVisible(true);

    }

}
