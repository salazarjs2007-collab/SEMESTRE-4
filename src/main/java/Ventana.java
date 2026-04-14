import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JTextArea txtListado;
    private JButton btnRegistrar;
    private JButton btnVer;
    private JButton btnAtender;
    private JButton btnMostrar;
    private JButton btnCantidad;
    private JButton btnEspacios;
    private JLabel SoporteTecnico;


    SistemaTurnosSoporte sistema = new SistemaTurnosSoporte();

    public Ventana() {

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = txtCodigo.getText();
                String des = txtDescripcion.getText();

                boolean res = sistema.registrarTurno(cod, des);

                if(res){
                    JOptionPane.showMessageDialog(null, "Turno registrado");
                    txtCodigo.setText("");
                    txtDescripcion.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar");
                }

                actualizarArea();
            }
        });

        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        sistema.verSiguienteTurno());
            }
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = sistema.atenderSiguienteTurno();
                JOptionPane.showMessageDialog(null, res);
                actualizarArea();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarArea();
            }
        });

        btnCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Cantidad: " + sistema.obtenerCantidadTurnos());
            }
        });

        btnEspacios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Espacios: " + sistema.obtenerEspaciosDisponibles());
            }
        });
    }

    public void actualizarArea(){
        txtListado.setText("");
        txtListado.setText(sistema.mostrarCola());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Soporte Tecnico");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}