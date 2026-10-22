package ficheros.caracteres.actividades.act_10;

import javax.swing.*;
import java.awt.*;

/**
 * Activ 1.10 - Lectura y escritura de ficheros de texto con Path y Files.
 *
 * La interfaz gráfica ya está hecha. Vosotros solo tenéis que rellenar los TRES métodos
 * marcados con TODO (sobrescribir, anadirAlFinal y mostrarContenido).
 * No hace falta tocar nada más.
 */
public class Ventana extends JFrame {

    private final JTextField txtNombre = new JTextField();
    private final JTextArea txtTexto = new JTextArea(5, 40);
    private final JTextArea txtContenido = new JTextArea(5, 40);

    public Ventana() {
        super("Activ 1.10");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtContenido.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(alinear(etiqueta("Nombre del fichero:")));
        panel.add(Box.createVerticalStrut(5));
        panel.add(alinear(txtNombre));
        panel.add(Box.createVerticalStrut(20));

        panel.add(alinear(etiqueta("Texto a escribir:")));
        panel.add(Box.createVerticalStrut(5));
        panel.add(alinear(new JScrollPane(txtTexto)));
        panel.add(Box.createVerticalStrut(20));

        panel.add(alinear(etiqueta("Contenido del fichero:")));
        panel.add(Box.createVerticalStrut(5));
        panel.add(alinear(new JScrollPane(txtContenido)));
        panel.add(Box.createVerticalStrut(15));

        JButton btnSobrescribir = new JButton("Sobrescribir");
        JButton btnAnadir = new JButton("Añadir al final");
        JButton btnMostrar = new JButton("Mostrar contenido");

        // Cada botón llama a un método que tenéis que implementar vosotros
        btnSobrescribir.addActionListener(e -> sobrescribir(getNombre(), getTexto()));
        btnAnadir.addActionListener(e -> anadirAlFinal(getNombre(), getTexto()));
        btnMostrar.addActionListener(e -> setContenido(mostrarContenido(getNombre())));

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        botones.add(btnSobrescribir);
        botones.add(btnAnadir);
        botones.add(btnMostrar);
        panel.add(alinear(botones));

        setContentPane(panel);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    // =====================================================================
    //  CÓDIGO DE LA INTERFAZ (no hace falta tocarlo)
    // =====================================================================

    private JLabel etiqueta(String texto) {
        JLabel l = new JLabel(texto);
        l.setFont(l.getFont().deriveFont(Font.BOLD));
        return l;
    }

    private <T extends JComponent> T alinear(T c) {
        c.setAlignmentX(Component.LEFT_ALIGNMENT);
        return c;
    }

    /** Devuelve el texto del campo "Nombre del fichero". */
    private String getNombre() {
        return txtNombre.getText();
    }

    /** Devuelve el texto del área "Texto a escribir". */
    private String getTexto() {
        return txtTexto.getText();
    }

    /** Muestra un texto en el área "Contenido del fichero". */
    private void setContenido(String s) {
        txtContenido.setText(s);
    }

    /** Muestra una ventana de error con el mensaje indicado. */
    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /** Muestra una pregunta Sí/No. Devuelve true si el usuario pulsa "Sí". */
    private boolean confirmar(String msg) {
        return JOptionPane.showConfirmDialog(this, msg, "Confirmar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    // =====================================================================
    //  LO QUE TENÉIS QUE IMPLEMENTAR
    //
    //  Usad Path y Files. Si algo falla, avisad al usuario con mostrarError("...")
    //  y salid del método (return). No dejéis que el programa se rompa.
    // =====================================================================

    /**
     * Escribe el texto en el fichero. Si el fichero ya existía, se pierde su contenido anterior.
     * Si no existe, se crea.
     *
     * @param nombre nombre (o ruta) del fichero, tal y como lo ha escrito el usuario
     * @param texto  texto que hay que escribir
     */
    private void sobrescribir(String nombre, String texto) {
        // TODO 1: comprueba que el nombre no está vacío ni formado solo por espacios
        // TODO 2: crea el Path a partir del nombre. Ojo: puede lanzar InvalidPathException
        //         (por ejemplo, si el nombre contiene caracteres no permitidos)
        // TODO 3: comprueba si el texto está vacío o formado solo por espacios o saltos de línea.
        //         Si lo está, el fichero quedaría vacío: pregunta al usuario si quiere
        //         continuar (usa confirmar(...)) y sal del método si responde que no
        // TODO 4: comprueba que la ruta no es un directorio
        // TODO 5: comprueba que la carpeta donde se va a crear el fichero existe
        // TODO 6: si el fichero ya existe, comprueba que se puede escribir en él
        //         y pregunta al usuario si quiere sobrescribirlo (usa confirmar(...))
        // TODO 7: escribe el texto en el fichero y captura la IOException
    }

    /**
     * Añade el texto al final del fichero, en una línea nueva, sin borrar lo que ya había.
     * Si el fichero no existe, se crea.
     *
     * @param nombre nombre (o ruta) del fichero, tal y como lo ha escrito el usuario
     * @param texto  texto que hay que añadir
     */
    private void anadirAlFinal(String nombre, String texto) {
        // TODO 1: comprueba que el nombre no está vacío ni formado solo por espacios
        // TODO 2: crea el Path a partir del nombre (cuidado con InvalidPathException)
        // TODO 3: comprueba que hay texto que añadir (que no esté vacío ni formado solo por
        //         espacios o saltos de línea). Si no lo hay, avisa con mostrarError(...)
        // TODO 4: comprueba que la ruta no es un directorio
        // TODO 5: comprueba que la carpeta donde se va a crear el fichero existe
        // TODO 6: si el fichero ya existe, comprueba que se puede escribir en él
        // TODO 7: añade el texto al final (¿qué opciones hay que indicar para no borrar
        //         el contenido anterior?) y captura la IOException
        //         Pista: que cada texto añadido quede en una línea distinta
    }

    /**
     * Lee el contenido completo del fichero y lo devuelve para mostrarlo en pantalla.
     *
     * @param nombre nombre (o ruta) del fichero, tal y como lo ha escrito el usuario
     * @return el contenido del fichero, o una cadena vacía ("") si ha habido algún error
     */
    private String mostrarContenido(String nombre) {
        // TODO 1: comprueba que el nombre no está vacío ni formado solo por espacios
        // TODO 2: crea el Path a partir del nombre (cuidado con InvalidPathException)
        // TODO 3: comprueba que el fichero existe
        // TODO 4: comprueba que no es un directorio
        // TODO 5: comprueba que se puede leer
        // TODO 6: lee el contenido del fichero y captura la IOException
        // TODO 7: devuelve el contenido como String ("" si ha habido algún error)
        return "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana().setVisible(true));
    }
}