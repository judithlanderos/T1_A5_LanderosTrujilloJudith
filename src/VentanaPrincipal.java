import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame implements ActionListener {
    
    private JLabel txtConvertir, txtA, txtIgual;
    private JTextField cajaUno, cajaDos;
    private JComboBox<String> comboGrados, comboCen;
    
    public VentanaPrincipal() {
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setTitle("Conversiones");
        setVisible(true);
        
        txtConvertir = new JLabel();
        txtConvertir.setText("Convertir");
        add(txtConvertir);
        
        cajaUno = new JTextField("70", 10);
        add(cajaUno);
        
        comboGrados = new JComboBox<String>();
        comboGrados.addItem("CELSIUS");
        comboGrados.addItem("FAHRENHEIT");
        comboGrados.addItem("KELVIN");
        comboGrados.addItem("RANKINE");
        comboGrados.addActionListener(this); 
        add(comboGrados);
        
        txtA = new JLabel();
        txtA.setText("A:");
        add(txtA);
        
        comboCen = new JComboBox<String>();
        comboCen.addItem("CELSIUS");
        comboCen.addItem("FAHRENHEIT");
        comboCen.addItem("KELVIN");
        comboCen.addItem("RANKINE");
        comboCen.addActionListener(this); // Agregar ActionListener para el segundo JComboBox
        add(comboCen);
        
        txtIgual = new JLabel();
        txtIgual.setText("=");
        add(txtIgual);
        
        cajaDos = new JTextField(10);
        cajaDos.setEditable(false); 
        add(cajaDos);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboGrados || e.getSource() == comboCen) { // Verificar el origen del evento
            String seleccion = (String) comboGrados.getSelectedItem(); 
            double valor = Double.parseDouble(cajaUno.getText()); 
            
            // Realizar la conversión basada en la selección en comboGrados y comboCen
            if (e.getSource() == comboGrados) {
                seleccion = (String) comboGrados.getSelectedItem();
            } else if (e.getSource() == comboCen) {
                seleccion = (String) comboCen.getSelectedItem();
            }
            
            switch (seleccion) {
                case "CELSIUS":
                    cajaDos.setText(String.valueOf(valor)); 
                    break;
                case "FAHRENHEIT":
                    cajaDos.setText(String.valueOf(Conversiones.celsiusToFahrenheit(valor)));
                    break;
                case "KELVIN":
                    cajaDos.setText(String.valueOf(Conversiones.celsiusToKelvin(valor)));
                    break;
                case "RANKINE":
                    cajaDos.setText(String.valueOf(Conversiones.celsiusToRankine(valor)));
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}
