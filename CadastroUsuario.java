import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;

public class CadastroUsuario {
    public static void main(String[] args) {

        //Configurando o JFrame
        JFrame frame = new JFrame("Cadastro de usuário"); 
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(null);
        frame.setLayout(new FlowLayout());

        //Labels
        JLabel labelNome = new JLabel("Nome");
        JLabel labelEmail = new JLabel("E-mail");
        JLabel labelIdade = new JLabel("Idade");

        //TextInputs
        JTextField inputNome = new JTextField(40);
        JTextField inputEmail = new JTextField(100);
        JTextField inputIdade = new JTextField(3);

        //Buttons
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar");

        //Configurando ações dos botões
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){

                //Pega os dados dos inputs
                String nome = inputNome.getText();
                String email = inputEmail.getText();
                int idade = Integer.parseInt(inputIdade.getText());
                
                // Verifica se a idade é válida e define a menssagem 
                String menssagem;
                if(idade > 115){
                    menssagem = "Idade inválida";
                }else{
                    menssagem = "Usuário cadastrado com sucesso\nNome: " + nome + "\n" + "E-mail: " + email + "\n" + "Idade: " + idade;
                }

                // Mostra a menssagem
                JOptionPane.showMessageDialog(null,menssagem,"menssagem", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        botaoLimpar.addActionListener(new ActionListener() {
            
        });

        // Deixando o frame vizível
        frame.setVisible(true);
    }
}