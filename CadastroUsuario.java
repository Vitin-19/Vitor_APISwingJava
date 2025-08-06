import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;

public class CadastroUsuario {
    public static void main(String[] args) {

        //Configurando o JFrame
        JFrame frame = new JFrame("Cadastro de usuário"); 
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1,20,20));
        
        //Labels
        JLabel labelNome = new JLabel("Nome");
        JLabel labelEmail = new JLabel("E-mail");
        JLabel labelIdade = new JLabel("Idade");
        JLabel labelGenero = new JLabel("Gênero");

        //TextInputs
        JTextField inputNome = new JTextField(40);
        JTextField inputEmail = new JTextField(100);
        JTextField inputIdade = new JTextField(3);

        //RadioButtons
        JRadioButton masc = new JRadioButton("Masculino");
        JRadioButton fem = new JRadioButton("Feminino");
        JRadioButton outro = new JRadioButton("Outro");

        //Configurando RadioButtons
        masc.setActionCommand("Masculino");
        fem.setActionCommand("Feminino");
        outro.setActionCommand("Outro");

        //Buttons
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar");

        //Panels
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0,1));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Adiciona uma borda vazia para espaçar os elementos da borda

        //Painel dos gêneros
        ButtonGroup generos = new ButtonGroup();

        // Adicionando os componentes ao painel de gêneros
        generos.add(masc);
        generos.add(fem);
        generos.add(outro);


        //Configurando ações dos botões
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){

                //Pega os dados dos inputs
                String nome = inputNome.getText();
                String email = inputEmail.getText();
                String idade = inputIdade.getText();
                String genero = generos.getSelection().getActionCommand();

                // Verifica se todos os campos foram preenchidos
                if (nome.isEmpty() || email.isEmpty() || idade.isEmpty()){ 
                    JOptionPane.showMessageDialog(null, "Todos os campos devem estar preeenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                };

                // Verifica se o email é válido
                if(!email.contains("@")) {
                    JOptionPane.showMessageDialog(null, "Insira um email válido", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                };

                // Tenta transformar a idade em inteiro para a verificar se é válida
                try{
                    Integer.parseInt(idade);
                }catch(Exception error){
                    JOptionPane.showMessageDialog(null, "Insira uma idade válida", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                };
                
                String menssagem = "Usuário cadastrado com sucesso\nNome: " + nome + "\n" + "E-mail: " + email + "\n" + "Idade: " + idade + "\n" + "Gênero: " + genero;

                // Mostra a menssagem
                JOptionPane.showMessageDialog(null,menssagem,"menssagem", JOptionPane.INFORMATION_MESSAGE);
            };
        });
        
        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){

                // Limpa os inputs deixando-os vazios
                inputNome.setText(null);
                inputEmail.setText(null);
                inputIdade.setText(null);
            };
        });

        //Adiciona os componentes no painel
        form.add(labelNome);
        form.add(inputNome);
        form.add(labelEmail);
        form.add(inputEmail);
        form.add(labelIdade);
        form.add(inputIdade);
        form.add(labelGenero);
        form.add(masc);
        form.add(fem);
        form.add(outro);
        form.add(botaoLimpar);
        form.add(botaoCadastrar);

        //Adiciona o painel no frame
        frame.add(form);

        // Deixando o frame vizível
        frame.setVisible(true);
    };
};