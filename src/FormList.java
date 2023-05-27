import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FormList extends JFrame {
    private JTable jTable;
    private DefaultTableModel modelo;
    private JButton regresar,cerrar;
    private JPanel panelButton1;
    private ButtonGroup buttonGroup2;
    public FormList (){
        initControl();
        configTable();
        configFrame();
    }
    private void Control(){
        panelButton1 = new JPanel();
        regresar = new JButton();
        cerrar = new JButton();
        buttonGroup2 = new ButtonGroup();
    }
    private void initControl(){
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(Titulos.titulos);
        String [] fila = new String[modelo.getColumnCount()];
        ArrayList<Comida> lista = Formulario.getElemento();
        for (Comida userTable : lista) {
            fila[0] = userTable.getNombre();
            fila[1] = userTable.getDescripcion();
            fila[2] = userTable.getPrecio();
            fila[3] = userTable.getNombreB();
            fila[4] = userTable.getDescripcionB();
            fila[5] = userTable.getPrecioB();
            modelo.addRow(fila);
        }
        jTable = new JTable(modelo);
    }

    private void configFrame(){
        setTitle("Tabla de Pedidos");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(600, 200);
    }
    private void setControl(){
        regresar.setText("Regresar al registro");
        cerrar.setText("Cerrar registro");

    }
    private void configTable(){
        jTable.setGridColor(new Color(88, 214, 141));
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(jTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}