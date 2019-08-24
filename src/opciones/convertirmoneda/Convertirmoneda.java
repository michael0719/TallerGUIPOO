package opciones.convertirmoneda;

import clases.convertir.MonedaLogica;
import menu.Menu;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import static clases.constantes.Enteros.*;
import static clases.constantes.Strings.*;

public class Convertirmoneda extends Frame {
    DecimalFormat formateador = new DecimalFormat("###,###.##");
    private static MonedaLogica monedaLogica=new MonedaLogica();
    protected JPanel panelmoneda;
    protected JRadioButton rbdolar;
    protected JRadioButton rbyen;
    protected JRadioButton rbeuro;
    protected JTextField txtcantidad;
    protected JLabel lblresultado;
    protected JButton btnconvertir;
    protected JButton btnregresar;
    protected JButton btnsalir;
    protected ButtonGroup opcion= new ButtonGroup();

    public Convertirmoneda(){
        add(panelmoneda);
        setTitle(MENSAJE_TITULO_CONVERTIDOR.getTexto());
        setSize(QUINIENTOS.getValor(),CUATROCIENTOS.getValor());
        opcion.add(rbdolar);
        opcion.add(rbeuro);
        opcion.add(rbyen);

        btnregresar.addActionListener(e->{
            menu.Menu menu = new Menu();
            menu.setVisible(true);
            esconderVentana();
        });

        btnsalir.addActionListener(e->{
            JOptionPane.showMessageDialog(null,MENSAJE_DESPEDIDA.getTexto());
            System.exit(CERO.getValor());
        });
        btnconvertir.addActionListener(e->{
           monedaLogica.setCantidadMoneda(Double.parseDouble(txtcantidad.getText()));
           lblresultado.setVisible(true);
           imprimirMoneda();
        });
        txtcantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char validar= e.getKeyChar();
                if(Character.isLetter(validar)){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    private void esconderVentana(){ this.dispose();  }

    private void imprimirMoneda(){
        if(rbdolar.isSelected()){
            lblresultado.setText(MENSAJE_PESO.getTexto()+formateador.format(monedaLogica.dolar())+
                    MENSAJE_PESOS_COLOMBIANOS.getTexto());
        }else if(rbeuro.isSelected()){
            lblresultado.setText(MENSAJE_PESO.getTexto()+formateador.format(monedaLogica.euro())+
                    MENSAJE_PESOS_COLOMBIANOS.getTexto());
        }else{
            lblresultado.setText(MENSAJE_PESO.getTexto()+formateador.format(monedaLogica.yen())+
                    MENSAJE_PESOS_COLOMBIANOS.getTexto());
        }
    }
}
