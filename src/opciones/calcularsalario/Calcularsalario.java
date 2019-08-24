package opciones.calcularsalario;
import clases.calculosalario.SalarioLogica;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;


import static clases.constantes.Enteros.*;
import static clases.constantes.Strings.*;

public class Calcularsalario  extends Frame {

    DecimalFormat formateador = new DecimalFormat("###,###.##");
    private static SalarioLogica salarioLogica=new SalarioLogica();

    protected JTextField txtnombre;
    protected JPanel panelsalario;
    protected ButtonGroup grupotipodia= new ButtonGroup();
    protected ButtonGroup grupoturno= new ButtonGroup();
    protected JRadioButton rbfestivo;
    protected JRadioButton rblaboral;
    protected JTextField txthoras;
    protected JButton calcularSalarioButton;
    protected JComboBox cmbdia;
    private JRadioButton rbdiurno;
    private JRadioButton rbnoturno;
    private JLabel lblresultado;
    private JButton btnregresar;
    private JButton btnsalir;

    public Calcularsalario(){
        add(panelsalario);
        setTitle(MENSAJE_TITULO_SALARIO.getTexto());
        setSize(QUINIENTOS.getValor(),SEISCIENTOS.getValor());
        this.grupotipodia.add(this.rbfestivo);
        this.grupotipodia.add(this.rblaboral);
        this.grupoturno.add(this.rbdiurno);
        this.grupoturno.add(this.rbnoturno);

        // td: 1 = Festivo, 0 = laboral
        // tur: 1=Noturno , 0=Diurno

        calcularSalarioButton.addActionListener(e->{
            double valor;

            if(this.rbfestivo.isSelected()){
                if(this.rbdiurno.isSelected()) {
                    seteovariables();
                    valor=salarioLogica.jornal(UNO.getValor(),CERO.getValor());
                    imprimiAlerta(valor);
                    lblresultado.setText(""+ formateador.format(valor));
                }else{
                    seteovariables();
                    valor=salarioLogica.jornal(UNO.getValor(),UNO.getValor());
                    imprimiAlerta(valor);
                    lblresultado.setText("" + formateador.format(valor));
                }
            }else{
                if(this.rbdiurno.isSelected()){
                    seteovariables();
                    valor=salarioLogica.jornal(CERO.getValor(),CERO.getValor());
                    imprimiAlerta(valor);
                    lblresultado.setText("" + formateador.format(valor));
                }else{
                    seteovariables();
                    valor=salarioLogica.jornal(CERO.getValor(),UNO.getValor());
                    imprimiAlerta(valor);
                    lblresultado.setText("" +formateador.format(valor));
                }
            }
            lblresultado.setVisible(true);
        });
        btnregresar.addActionListener(e->{
            menu.Menu menu = new Menu();
            menu.setVisible(true);
            esconderVentana();
        });
        btnsalir.addActionListener(e->{
            JOptionPane.showMessageDialog(null,MENSAJE_DESPEDIDA.getTexto());
            System.exit(CERO.getValor());
        });


        txtnombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char validar= e.getKeyChar();
                if(Character.isDigit(validar)){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });


        txthoras.addKeyListener(new KeyAdapter() {
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

    public void seteovariables(){
        salarioLogica.setNombre(txtnombre.getText());
        salarioLogica.setHoras(Integer.parseInt(txthoras.getText()));
    }

    public void imprimiAlerta(double valor){
        if(rbdiurno.isSelected()) {
            if(rblaboral.isSelected()) {
                JOptionPane.showMessageDialog(null, MENSAJE_NOMBRE.getTexto() + txtnombre.getText() + "\n" +
                        MENSAJE_DIA.getTexto() + cmbdia.getSelectedItem() + "\n" + MENSAJE_TURNO_DIURNO.getTexto()+"\n"+MENSAJE_TIPO_LABORAL.getTexto()+"\n"+
                        MENSAJE_HORAS_TRABAJADAS.getTexto()+txthoras.getText()+"\n"+MENSAJE_PAGO_TOTAL.getTexto()+
                        formateador.format(valor),MENSAJE_DATOS.getTexto(),JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, MENSAJE_NOMBRE.getTexto() + txtnombre.getText() + "\n" +
                        MENSAJE_DIA.getTexto() + cmbdia.getSelectedItem() + "\n" + MENSAJE_TURNO_DIURNO.getTexto()+"\n"+MENSAJE_TIPO_FESTIVO.getTexto()+"\n"+
                        MENSAJE_HORAS_TRABAJADAS.getTexto()+txthoras.getText()+"\n"+MENSAJE_PAGO_TOTAL.getTexto()+
                        formateador.format(valor),MENSAJE_DATOS.getTexto(),JOptionPane.WARNING_MESSAGE);
            }
        }else{
            if(rbfestivo.isSelected()) {
                JOptionPane.showMessageDialog(null, MENSAJE_NOMBRE.getTexto() + txtnombre.getText() + "\n" +
                        MENSAJE_DIA.getTexto() + cmbdia.getSelectedItem() + "\n" + MENSAJE_TURNO_NOTURNO.getTexto()+"\n"+MENSAJE_TIPO_FESTIVO.getTexto()+"\n"+
                        MENSAJE_HORAS_TRABAJADAS.getTexto()+txthoras.getText()+"\n"+MENSAJE_PAGO_TOTAL.getTexto()+
                        formateador.format(valor),MENSAJE_DATOS.getTexto(),JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, MENSAJE_NOMBRE.getTexto() + txtnombre.getText() + "\n" +
                        MENSAJE_DIA.getTexto() + cmbdia.getSelectedItem() + "\n" + MENSAJE_TURNO_NOTURNO.getTexto()+"\n"+MENSAJE_TIPO_LABORAL.getTexto()+"\n"+
                        MENSAJE_HORAS_TRABAJADAS.getTexto()+txthoras.getText()+"\n"+MENSAJE_PAGO_TOTAL.getTexto()+
                        formateador.format(valor),MENSAJE_DATOS.getTexto(),JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private void esconderVentana(){ this.dispose();  }
}
