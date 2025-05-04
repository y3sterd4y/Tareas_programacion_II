import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class Main extends JFrame {
    private JRadioButton rbPalco, rbPlatea, rbGaleria;
    private JTextField txtNumero, txtDiasAnticipacion;
    private JLabel lblInfo, lblDiasAnticipacion;
    private JButton btnVender, btnSalir;
    private JPanel panelBoleto, panelInformacion;

    public Main() {
        super("Teatro Municipal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // Panel del título con imagen
        JPanel panelTitulo = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Teatro Municipal", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(33, 64, 154));
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);

        // Intento cargar una imagen de un teatro
        try {
            URL imageUrl = new URL("https://via.placeholder.com/100x70.png?text=Teatro");
            ImageIcon icon = new ImageIcon(ImageIO.read(imageUrl));
            JLabel lblImagen = new JLabel(icon);
            lblImagen.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 20));
            panelTitulo.add(lblImagen, BorderLayout.EAST);
        } catch (IOException e) {
            System.out.println("No se pudo cargar la imagen: " + e.getMessage());
        }

        panelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelTitulo, BorderLayout.NORTH);

        // Panel principal con datos del boleto
        panelBoleto = new JPanel();
        panelBoleto.setLayout(new GridBagLayout());
        panelBoleto.setBorder(BorderFactory.createTitledBorder("Datos del Boleto"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Tipo de boleto (radio buttons)
        ButtonGroup grupoTipo = new ButtonGroup();
        rbPalco = new JRadioButton("Palco", true);
        rbPlatea = new JRadioButton("Platea");
        rbGaleria = new JRadioButton("Galeria");

        grupoTipo.add(rbPalco);
        grupoTipo.add(rbPlatea);
        grupoTipo.add(rbGaleria);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelBoleto.add(rbPalco, gbc);

        gbc.gridx = 1;
        panelBoleto.add(rbPlatea, gbc);

        gbc.gridx = 2;
        panelBoleto.add(rbGaleria, gbc);

        // Número de boleto
        JLabel lblNumero = new JLabel("Número:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelBoleto.add(lblNumero, gbc);

        txtNumero = new JTextField(10);
        txtNumero.setText("1");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panelBoleto.add(txtNumero, gbc);

        // Días de anticipación
        lblDiasAnticipacion = new JLabel("Cant. Días para el Evento:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelBoleto.add(lblDiasAnticipacion, gbc);

        txtDiasAnticipacion = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panelBoleto.add(txtDiasAnticipacion, gbc);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnVender = new JButton("Vender");
        btnSalir = new JButton("Salir");

        panelBotones.add(btnVender);
        panelBotones.add(btnSalir);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panelBoleto.add(panelBotones, gbc);

        // Panel de información
        panelInformacion = new JPanel(new BorderLayout());
        panelInformacion.setBorder(BorderFactory.createTitledBorder("Información"));

        lblInfo = new JLabel("", JLabel.CENTER);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 14));
        lblInfo.setForeground(new Color(33, 64, 154));
        panelInformacion.add(lblInfo, BorderLayout.CENTER);

        // Añadir paneles al frame
        JPanel panelCentral = new JPanel(new BorderLayout(10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCentral.add(panelBoleto, BorderLayout.CENTER);
        panelCentral.add(panelInformacion, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);

        // Configurar visibilidad inicial de campos
        actualizarCamposVisibles();

        // Configurar eventos de radio buttons
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCamposVisibles();
            }
        };

        rbPalco.addActionListener(radioListener);
        rbPlatea.addActionListener(radioListener);
        rbGaleria.addActionListener(radioListener);

        // Configurar evento del botón Vender
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderBoleto();
            }
        });

        // Configurar evento del botón Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void actualizarCamposVisibles() {
        boolean requiereDias = rbPlatea.isSelected() || rbGaleria.isSelected();
        lblDiasAnticipacion.setVisible(requiereDias);
        txtDiasAnticipacion.setVisible(requiereDias);
    }

    private void venderBoleto() {
        try {
            int numero = Integer.parseInt(txtNumero.getText());

            Boleto boleto = null;

            if (rbPalco.isSelected()) {
                boleto = new Palco(numero);
            } else {
                int diasAnticipacion = 0;

                try {
                    diasAnticipacion = Integer.parseInt(txtDiasAnticipacion.getText());
                    if (diasAnticipacion < 0) {
                        JOptionPane.showMessageDialog(this,
                                "Los días de anticipación no pueden ser negativos.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,
                            "Por favor, ingrese un número válido de días.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (rbPlatea.isSelected()) {
                    boleto = new Platea(numero, diasAnticipacion);
                } else if (rbGaleria.isSelected()) {
                    boleto = new Galeria(numero, diasAnticipacion);
                }
            }

            // Mostrar información del boleto
            if (boleto != null) {
                String info = "Número: " + boleto.getNumero() + ", Precio: " + boleto.getPrecio();
                lblInfo.setText(info);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingrese un número válido para el boleto.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Asegurar que la interfaz se crea en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main gui = new Main();
                gui.setVisible(true);
            }
        });
    }
}

// Clases del modelo (mismo código que antes)
abstract class Boleto {
    protected int numero;
    protected double precio;

    public Boleto(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecio() {
        return precio;
    }

    protected void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Numero: " + numero + ", Precio: " + precio;
    }
}

class Palco extends Boleto {
    private static final double PRECIO_PALCO = 100.0;

    public Palco(int numero) {
        super(numero);
        this.precio = PRECIO_PALCO;
    }

    @Override
    public String toString() {
        return "(Palco) " + super.toString();
    }
}

class Platea extends Boleto {
    private static final double PRECIO_CON_ANTICIPACION = 50.0;
    private static final double PRECIO_SIN_ANTICIPACION = 60.0;
    private static final int DIAS_ANTICIPACION_DESCUENTO = 10;

    protected int diasAnticipacion;

    public Platea(int numero, int diasAnticipacion) {
        super(numero);
        this.diasAnticipacion = diasAnticipacion;

        if (diasAnticipacion >= DIAS_ANTICIPACION_DESCUENTO) {
            this.precio = PRECIO_CON_ANTICIPACION;
        } else {
            this.precio = PRECIO_SIN_ANTICIPACION;
        }
    }

    public int getDiasAnticipacion() {
        return diasAnticipacion;
    }

    @Override
    public String toString() {
        return "(Platea) " + super.toString();
    }
}

class Galeria extends Platea {
    private static final double PRECIO_CON_ANTICIPACION = 25.0;
    private static final double PRECIO_SIN_ANTICIPACION = 30.0;
    private static final int DIAS_ANTICIPACION_DESCUENTO = 10;

    public Galeria(int numero, int diasAnticipacion) {
        super(numero, diasAnticipacion);

        if (diasAnticipacion >= DIAS_ANTICIPACION_DESCUENTO) {
            this.precio = PRECIO_CON_ANTICIPACION;
        } else {
            this.precio = PRECIO_SIN_ANTICIPACION;
        }
    }

    @Override
    public String toString() {
        return "(Galeria) " + super.toString();
    }
}