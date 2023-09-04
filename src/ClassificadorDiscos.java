import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassificadorDiscos extends JFrame {
    private JPanel myPanel;
    private JTextField txtMedia;
    private JTextField txtDesvio;
    private JTextField txtTolerancia;
    private JTextField txtValorDesejado;
    private JButton btnResultado;
    private JTextField txtValorCorrecao;
    private JSpinner spnMedicoes;
    private JTextField txtStudent;
    private JLabel lblVerde;
    private JLabel lblAmarelo;
    private JLabel lblVermelho;

    private float media;
    private float desvioPadrao;
    private float valorCorrecao;
    private int numeroMedicoes;
    private float tStudent;
    private float valorDesejado;
    private float tolerancia;

    private void lerDados() {
        media = Float.parseFloat(txtMedia.getText());
        desvioPadrao = Float.parseFloat(txtDesvio.getText());
        valorCorrecao = Float.parseFloat(txtValorCorrecao.getText());
        numeroMedicoes = (int) spnMedicoes.getValue();
        tStudent = Float.parseFloat(txtStudent.getText());
        valorDesejado = Float.parseFloat(txtValorDesejado.getText());
        tolerancia = Float.parseFloat(txtTolerancia.getText());
    }


    public ClassificadorDiscos() {
        setContentPane(myPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setVisible(true);
        setTitle("Classificador de discos");
        lblVerde.setVisible(false);
        lblAmarelo.setVisible(false);
        lblVermelho.setVisible(false);

        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lblVerde.setVisible(false);
                lblAmarelo.setVisible(false);
                lblVermelho.setVisible(false);
                lerDados();
                Classificador meuClassificador = new Classificador(media, desvioPadrao, valorCorrecao,
                        numeroMedicoes, tStudent, tolerancia, valorDesejado);

                String resultado = meuClassificador.getResultado();

                if (resultado.equals("Verde")){
                    lblVerde.setVisible(true);
                } else if (resultado.equals("Amarelo")) {
                    lblAmarelo.setVisible(true);
                } else {
                    lblVermelho.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        ClassificadorDiscos meuClassificadorDiscos = new ClassificadorDiscos();
    }
}
