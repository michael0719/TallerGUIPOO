package menu;

import opciones.calcularsalario.Calcularsalario;
import opciones.convertirmoneda.Convertirmoneda;
import opciones.operacionesmatematicas.OperacionesMatematicas;
import static clases.constantes.Strings.*;

import javax.swing.*;
import java.awt.*;

public class Menu extends Frame {
    private JPanel menuprincipal;
    private JButton operacionesMatematicasButton;
    private JButton btncalcularsalario;
    private JButton btnconvertidor;
    private JButton btnsalir;

    public Menu(){
        add(menuprincipal);
        setTitle(MENSAJE_MENU.getTexto());
        setSize(500, 600);
        operacionesMatematicasButton.addActionListener(e -> {
                OperacionesMatematicas operacionesMatematicas = new OperacionesMatematicas();
                operacionesMatematicas.setVisible(true);
                esconderVentana();
        });
        btnsalir.addActionListener(e->{
            JOptionPane.showMessageDialog(null,MENSAJE_DESPEDIDA.getTexto());
            System.exit(0);
        });
        btncalcularsalario.addActionListener(e->{
            Calcularsalario calcularsalario=new Calcularsalario();
            calcularsalario.setVisible(true);
            esconderVentana();
        });
        btnconvertidor.addActionListener(e->{
            Convertirmoneda convertirmoneda= new Convertirmoneda();
            convertirmoneda.setVisible(true);
            esconderVentana();
        });
    }

    private void esconderVentana(){
        this.dispose();
    }

}
