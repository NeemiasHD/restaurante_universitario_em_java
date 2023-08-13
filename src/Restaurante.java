import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;//importando tudo
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurante extends JFrame implements ActionListener {
    private JTextField Titulo;
    private JTextField dia_da_semana, proteina, salada, sobremesa, suco;
    private JButton proximo, anterior, voltarMenu;
    private JButton[] vazio;// botão vazio pra colocar no layout
    private JPanel botoes, cardapio;
    private static Funcionario funcionario;

    public String etiqueta_proteina = "PROTEINA: ", etiqueta_salada = "SALADA: ", etiqueta_sobremesa = "SOBREMESA: ",
            etiqueta_suco = "SUCO: ";

    public static int confirmacao_cardapio = 0;
    static int menu;

    public static void menu() {
        ImageIcon icon = new ImageIcon("icone.png");
        UIManager.put("OptionPane.yesButtonText", "Cadastrar Cardápio");
        UIManager.put("OptionPane.noButtonText", "Ver Cardápio");

        int menu = JOptionPane.showConfirmDialog(null, null,
                "R.U", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);


        if (menu == 0) {
            funcionario = new Funcionario();

        } else if (menu == 1) {
            if (confirmacao_cardapio == 0) {
                JOptionPane.showMessageDialog(null, "SEM CARDAPIO DISPONÍVEL");
            }
            Restaurante restaurante = new Restaurante();

        }

        else if (menu != 0 || menu != 1) {
            System.exit(0);
        }

    }

    Restaurante() {
        if (confirmacao_cardapio == 0) {
            menu();
            return;

        } else {
        }

        Color vermelho = new Color(255, 0, 87);// vermelho
        // criando imagens
        ImageIcon imagem = new ImageIcon("restaurante.png");
        JLabel imagens = new JLabel(imagem);

        this.setSize(500, 700);
        this.setTitle("Restaurante Universitario");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);

        proximo = new JButton(">>>>>");
        proximo.setBackground(vermelho);
        proximo.setBorder(new EmptyBorder(8, 8, 8, 8));// removendo as bordas
        proximo.addActionListener(this);

        voltarMenu = new JButton("MENU");
        voltarMenu.setBackground(vermelho);
        voltarMenu.setBorder(new EmptyBorder(8, 8, 8, 8));// removendo as bordas
        voltarMenu.addActionListener(this);

        anterior = new JButton("<<<<<");
        anterior.setBackground(vermelho);
        anterior.setBorder(new EmptyBorder(8, 8, 8, 8));// removendo as bordas
        anterior.addActionListener(this);

        // criando um botão vazio pra colocar espaços vazios no layout.
        vazio = new JButton[10];
        vazio[0] = new JButton();
        vazio[0].setVisible(false);
        vazio[1] = new JButton();
        vazio[1].setVisible(false);
        vazio[2] = new JButton();
        vazio[2].setVisible(false);
        vazio[3] = new JButton();
        vazio[3].setVisible(false);

        // declarando os dias da semana
        dia_da_semana = new JTextField(funcionario.getDia_da_semana());
        dia_da_semana.setEditable(false);
        dia_da_semana.setHorizontalAlignment(JTextField.CENTER);
        dia_da_semana.setBackground(vermelho);

        // Itens do cardapio:
        // proteina

        proteina = new JTextField(etiqueta_proteina + funcionario.getProteina_do_dia());
        proteina.setHorizontalAlignment(JTextField.CENTER);
        proteina.setBorder(new EmptyBorder(0, 0, 0, 0));// removendo as bordas
        proteina.setEditable(false);

        // salada

        salada = new JTextField(etiqueta_salada + funcionario.getSalada_do_dia());
        salada.setHorizontalAlignment(JTextField.CENTER);
        salada.setBorder(new EmptyBorder(0, 0, 0, 0));// removendo as bordas
        salada.setEditable(false);

        // sobremesa

        sobremesa = new JTextField(etiqueta_sobremesa + funcionario.getSobremesa_do_dia());
        sobremesa.setHorizontalAlignment(JTextField.CENTER);
        sobremesa.setBorder(new EmptyBorder(0, 0, 0, 0));// removendo as bordas
        sobremesa.setEditable(false);

        // Suco

        suco = new JTextField(etiqueta_suco + funcionario.getSuco_do_dia());
        suco.setHorizontalAlignment(JTextField.CENTER);
        suco.setBorder(new EmptyBorder(0, 0, 0, 0));// removendo as bordas
        suco.setEditable(false);

        cardapio = new JPanel(new GridLayout(5, 1));
        cardapio.add(dia_da_semana);
        cardapio.add(proteina);

        cardapio.add(salada);
        cardapio.add(sobremesa);
        cardapio.add(suco);

        // adicioando botões de proximo e anterior
        botoes = new JPanel();
        botoes.setLayout(new FlowLayout());
        botoes.add(anterior);
        botoes.add(voltarMenu);
        botoes.add(proximo);

        this.setLayout(new BorderLayout());
        this.add(imagens, BorderLayout.NORTH);
        this.add(cardapio, BorderLayout.CENTER);
        this.add(botoes, BorderLayout.SOUTH);
        this.setVisible(true);

        // adicionando os actions listener

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltarMenu) {
            dispose();
            menu();

        } else if (e.getSource() == proximo) {
            if (funcionario.getDia() < 5) {
                funcionario.setDia(+funcionario.getDia() + 1);
                dia_da_semana.setText(funcionario.getDia_da_semana());
                proteina.setText(etiqueta_proteina + funcionario.getProteina_do_dia());
                salada.setText(etiqueta_salada + funcionario.getSalada_do_dia());
                sobremesa.setText(etiqueta_sobremesa + funcionario.getSobremesa_do_dia());
                suco.setText(etiqueta_suco + funcionario.getSuco_do_dia());

            }

        } else if (e.getSource() == anterior) {
            if (funcionario.getDia() > 0) {
                funcionario.setDia(funcionario.getDia() - 1);
                dia_da_semana.setText(funcionario.getDia_da_semana());
                proteina.setText(etiqueta_proteina + funcionario.getProteina_do_dia());
                salada.setText(etiqueta_salada + funcionario.getSalada_do_dia());
                sobremesa.setText(etiqueta_sobremesa + funcionario.getSobremesa_do_dia());
                suco.setText(etiqueta_suco + funcionario.getSuco_do_dia());
            }

        }
    }
}
