import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formulario extends JFrame implements ChangeListener {
    private JPanel paneliz, paneliz2,panelde2, panelde, panelButton, panelForm, panelContainer,panelRadio,panelRadio2;
    private JLabel nombre, precio, descripcion,nombreB, precioB, descripcionB;
    private JTextField text1, text2, text3,text4, text5, text6;
    private JRadioButton radio1,radio2,radio3,radio4,radio5,radio6;
    private JButton btnQuery,boton1;
    private ButtonGroup buttonGroup;

    private static ArrayList<Comida> lista = new ArrayList<>();

    EventClick eventClick = new EventClick();
    public Formulario() {
        initControl();
        configFrame();
        setControl();
        configPanel();
        add(panelContainer);
        query();
        radio1.addChangeListener(this);
        radio2.addChangeListener(this);
        radio3.addChangeListener(this);
    }

    private void query(){
        btnQuery.addActionListener(e -> {
            FormList formList = new FormList();
            formList.setVisible(true);
            this.setVisible(false);
        });
    }

    private void initControl(){
        paneliz = new JPanel();
        paneliz2 = new JPanel();
        panelde = new JPanel();
        panelde2 = new JPanel();
        panelButton = new JPanel();
        panelForm = new JPanel();
        panelContainer = new JPanel();
        panelRadio = new JPanel();
        panelRadio2 = new JPanel();

        nombre = new JLabel();
        descripcion = new JLabel();
        precio = new JLabel();
        nombreB = new JLabel();
        descripcionB = new JLabel();
        precioB = new JLabel();

        boton1 = new JButton();
        btnQuery = new JButton();


        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        text5 = new JTextField();
        text6 = new JTextField();

        radio1 = new JRadioButton();
        radio2 = new JRadioButton();
        radio3 = new JRadioButton();
        radio4 = new JRadioButton();
        radio5 = new JRadioButton();
        radio6 = new JRadioButton();
        buttonGroup = new ButtonGroup();
    }

    private void configFrame(){
        setTitle("Orden de Pedidos");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 500);
    }

    private void setControl(){
        nombre.setText("Ingresar Comida");
        descripcion.setText("Descripcion");
        precio.setText("Ingresar Precio(caracter)");

        nombreB.setText("Ingresar Bebidas");
        descripcionB.setText("Descripcion");
        precioB.setText("Ingresar Precio(caracter)");

        boton1.setText("Ingresar Pedido");
        btnQuery.setText("Consultar Pedidos");

        radio1.setText("Deshabilita el orden de comidas");
        radio2.setText("Deshabilita el orden de bebidas");
        radio3.setText("Deshabilita todos");

        radio4.setText("Habilitar el orden de comidas");
        radio5.setText("habilitar el orden de bebidas");
        radio6.setText("Habilitar todos");
    }

    private void configPanel(){paneliz.setLayout(new GridLayout(4, 0));
        paneliz.setLayout(new GridLayout(4, 0));
        paneliz.add(nombre);
        paneliz.add(descripcion);
        paneliz.add(precio);
        panelde.setLayout(new GridLayout(4, 0));
        panelde.add(text1);
        panelde.add(text2);
        panelde.add(text3);


        paneliz2.setLayout(new GridLayout(4, 0));
        paneliz2.add(nombreB);
        paneliz2.add(descripcionB);
        paneliz2.add(precioB);
        panelde2.setLayout(new GridLayout(4, 0));
        panelde2.add(text4);
        panelde2.add(text5);
        panelde2.add(text6);


        panelForm.setLayout(new GridLayout(1, 1));
        panelForm.setPreferredSize(new Dimension(500, 100));

        panelForm.add(paneliz);
        panelForm.add(panelde);
        panelForm.add(paneliz2);
        panelForm.add(panelde2);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(150, 50));
        panelButton.add(boton1);
        boton1.addActionListener(eventClick);
        panelButton.add(btnQuery);

        panelRadio.setLayout(new FlowLayout());
        panelRadio.setPreferredSize(new Dimension(200, 50));
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        panelRadio.add(radio1);
        panelRadio.add(radio2);
        panelRadio.add(radio3);

        panelRadio2.setLayout(new FlowLayout());
        panelRadio2.setPreferredSize(new Dimension(200, 50));
        buttonGroup.add(radio4);
        buttonGroup.add(radio5);
        buttonGroup.add(radio6);
        panelRadio2.add(radio4);
        panelRadio2.add(radio5);
        panelRadio2.add(radio6);

        panelContainer.setLayout(new GridLayout(4, 0));
        panelContainer.add(panelForm);
        panelContainer.add(panelButton);
        panelContainer.add(panelRadio);
        panelContainer.add(panelRadio2);

        add(panelContainer);
    }

    public static ArrayList<Comida> getElemento(){
        return lista;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (radio1.isSelected()) {//deshabilitar comidas
            text1.setEnabled(false);
            text2.setEditable(false);
            text3.setEditable(false);
        }
        if (radio2.isSelected()) {//deshabilitar bebidas
            text4.setEditable(false);
            text5.setEditable(false);
            text6.setEditable(false);
        }
        if (radio3.isSelected()) {
            text1.setEditable(false);
            text2.setEditable(false);
            text3.setEditable(false);
            text4.setEditable(false);
            text5.setEditable(false);
            text6.setEditable(false);
        }

        if(radio4.isSelected()){
            text1.setEnabled(true);
            text2.setEditable(true);
            text3.setEditable(true);
        }
        if (radio5.isSelected()){
            text4.setEditable(true);
            text5.setEditable(true);
            text6.setEditable(true);
        }
        if(radio6.isSelected()){
            text1.setEditable(true);
            text2.setEditable(true);
            text3.setEditable(true);
            text4.setEditable(true);
            text5.setEditable(true);
            text6.setEditable(true);
        }

    }

    public class EventClick implements ActionListener {
        public EventClick(){
            lista = new ArrayList<>();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = text1.getText();
            String descripcion = text2.getText();
            String precio= text3.getText();
            String nombreB = text1.getText();
            String descripcionB = text2.getText();
            String precioB= text3.getText();
            lista.add(new Comida(nombre,descripcion,precio,nombreB,descripcionB,precioB));
            text1.setText(" ");
            text2.setText(" ");
            text3.setText(" ");
            text4.setText(" ");
            text5.setText(" ");
            text6.setText(" ");

            for (Comida personas:lista) {
                System.out.println("Nombre Comida: " + personas.getNombre() + " Descripcion comida: " + personas.getDescripcion()
                        + " Precio Comida: "+personas.getPrecio() + "Nombre Bebida: " + personas.getNombreB() + " Descripcion bebida: " + personas.getDescripcionB()
                        + " Precio Comida: "+personas.getPrecioB());
            }
        }
    }
}
