import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;//importando tudo
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funcionario extends JFrame implements ActionListener {
    public static String[] proteina_do_dia, salada_do_dia, sobremesa_do_dia, suco_do_dia, dia_da_semana;
    private JTextField proteina, salada, sobremesa, suco;
    private JTextField diasemanal;
    private JLabel jlproteina, jlsalada, jlsobremesa, jlsuco;
    private JButton[]vazio;
    private JButton proximo, anterior, salvar, sair;
    private JPanel cadastro, botoes, imgEDiadasemana;
    public static int dia = 0;

    Funcionario() {


        //criando vazios para layouts

        vazio = new JButton[10];
        vazio[0] = new JButton();
        vazio[0].setVisible(false);

        vazio[1] = new JButton();
        vazio[1].setVisible(false);

        vazio[2] = new JButton();
        vazio[2].setVisible(false);

        vazio[3] = new JButton();
        vazio[3].setVisible(false);

        vazio[4] = new JButton();
        vazio[4].setVisible(false);

        vazio[5] = new JButton();
        vazio[5].setVisible(false);

        vazio[6] = new JButton();
        vazio[6].setVisible(false);

        vazio[7] = new JButton();
        vazio[7].setVisible(false);




        ImageIcon imagem = new ImageIcon("cadastroru.png");
        JLabel imagens = new JLabel(imagem);

        this.setSize(500, 700);
        this.setTitle("Funcionario: ");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);

        Color vermelho = new Color(255, 0, 87);// vermelho

        proximo = new JButton(">>>>>");
        proximo.setBackground(vermelho);
        proximo.setBorder(new EmptyBorder(8, 8, 8, 8));// removendo as bordas
        proximo.addActionListener(this);

        sair = new JButton("SAIR");
        sair.setBackground(vermelho);
        sair.setBorder(new EmptyBorder(8, 8, 8, 8));// removendo as bordas
        sair.addActionListener(this);

        salvar = new JButton("SALVAR");
        salvar.setBackground(vermelho);
        salvar.setBorder(new EmptyBorder(8, 8, 8, 8));// removendo as bordas
        salvar.addActionListener(this);

        anterior = new JButton("<<<<<");
        anterior.setBackground(vermelho);
        anterior.setBorder(new EmptyBorder(8, 8, 8, 8));// removendo as bordas
        anterior.addActionListener(this);

        botoes = new JPanel();
        botoes.setLayout(new FlowLayout());
        botoes.add(anterior);
        botoes.add(salvar);
        botoes.add(proximo);
        botoes.add(sair);

        jlproteina = new JLabel("PROTEINA:");
        jlsalada = new JLabel("SALADA:");
        jlsobremesa = new JLabel("SOBREMESA:");
        jlsuco = new JLabel("SUCO:");

        proteina = new JTextField();

        salada = new JTextField();

        sobremesa = new JTextField();

        suco = new JTextField();

        dia_da_semana = new String[5];
        dia_da_semana[0] = new String("Segunda-Feira");

        dia_da_semana[1] = new String("Terça-Feira");

        dia_da_semana[2] = new String("Quarta-Feira");

        dia_da_semana[3] = new String("Quinta-Feira");

        dia_da_semana[4] = new String("Sexta-Feira");

        diasemanal = new JTextField(dia_da_semana[dia]);

        diasemanal.setEditable(false);
        diasemanal.setHorizontalAlignment(JTextField.CENTER);

        imgEDiadasemana = new JPanel();
        imgEDiadasemana.add(imagens);
        imgEDiadasemana.add(diasemanal);
        imgEDiadasemana.setLayout(new GridLayout(2, 1));

        cadastro = new JPanel();

        cadastro.setLayout(new GridLayout(4, 3));
        cadastro.add(vazio[0]);
        cadastro.add(jlproteina);
        cadastro.add(proteina);
        cadastro.add(vazio[4]);
        cadastro.add(vazio[1]);
        cadastro.add(jlsalada);
        cadastro.add(salada);
        cadastro.add(vazio[5]);
        cadastro.add(vazio[2]);
        cadastro.add(jlsobremesa);
        cadastro.add(sobremesa);
        cadastro.add(vazio[6]);
        cadastro.add(vazio[3]);
        cadastro.add(jlsuco);
        cadastro.add(suco);
        cadastro.add(vazio[7]);

        for (int i = 0; i < 5; i++) {
            proteina.setHorizontalAlignment(JTextField.CENTER);
            salada.setHorizontalAlignment(JTextField.CENTER);
            sobremesa.setHorizontalAlignment(JTextField.CENTER);
            suco.setHorizontalAlignment(JTextField.CENTER);
            diasemanal.setLayout(new BorderLayout());
            diasemanal.setBorder(new EmptyBorder(0, 0, 0, 0));
            Font fonte = new Font("Arial", Font.BOLD, 25);// settando o tamanho do JtextField
            diasemanal.setFont(fonte);
        }

        this.setLayout(new BorderLayout());
        this.add(imgEDiadasemana, BorderLayout.NORTH);
        this.add(cadastro);
        this.add(botoes, BorderLayout.SOUTH);
        this.setVisible(true);

        proteina_do_dia = new String[5];
        salada_do_dia = new String[5];
        sobremesa_do_dia = new String[5];
        suco_do_dia = new String[5];


    }

    // definindo as variaveis ponte

    public static String getProteina_do_dia() {
        return proteina_do_dia[dia];
    }

    public static String getSalada_do_dia() {
        return salada_do_dia[dia];
    }

    public static String getSobremesa_do_dia() {
        return sobremesa_do_dia[dia];
    }

    public static String getSuco_do_dia() {
        return suco_do_dia[dia];
    }

    public static String getDia_da_semana() {
        return dia_da_semana[dia];
    }

    public static void setDia(int dia) {
        Funcionario.dia = dia;
    }

    public static int getDia() {
        return dia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salvar) {
            proteina_do_dia[dia] = proteina.getText();
            salada_do_dia[dia] = salada.getText();
            sobremesa_do_dia[dia] = sobremesa.getText();
            suco_do_dia[dia] = suco.getText();

        } else if (e.getSource() == proximo) {
            if (dia < 5) {
                dia++;
                diasemanal.setText(dia_da_semana[dia]);
                proteina.setText(proteina_do_dia[dia]);
                salada.setText(salada_do_dia[dia]);
                sobremesa.setText(sobremesa_do_dia[dia]);
                suco.setText(suco_do_dia[dia]);
                proteina_do_dia[dia] = proteina.getText();
                salada_do_dia[dia] = salada.getText();
                sobremesa_do_dia[dia] = sobremesa.getText();
                suco_do_dia[dia] = suco.getText();

            }
        } else if (e.getSource() == anterior) {
            if (dia > 0) {
                dia--;
                diasemanal.setText(dia_da_semana[dia]);
                proteina.setText(proteina_do_dia[dia]);
                salada.setText(salada_do_dia[dia]);
                sobremesa.setText(sobremesa_do_dia[dia]);
                suco.setText(suco_do_dia[dia]);

            }
        } else if (e.getSource() == sair) {
            dia=0;
            if(proteina_do_dia[0]==null){
                Restaurante.confirmacao_cardapio=0;

            }else{
                Restaurante.confirmacao_cardapio=1;
            }
            dispose();
            Restaurante.menu();

        }

    }
}
