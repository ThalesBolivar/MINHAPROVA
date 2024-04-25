import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Pessoa {
    public final String name;
    private int votos=0;

    Pessoa(String nome) { name=nome; }


    public int getVotos() { return votos; }
    public void incrementaUmVoto() { this.votos=getVotos()+1; }
}

class Main extends JFrame {
    private static int count = 0, max = 0;
    static int eliminado = 0;
    static ArrayList<Pessoa> pessoas = new ArrayList<>();
    static String[] names = new String[]{
            "Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
            "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin",
            "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral",
            "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo",
            "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues", "Wanessa Camargo",
            "Yasmin Brunet"
    };

    static void cadastrar() {
        for (var name : names) pessoas.add(new Pessoa(name));
    }

    static void votar(String name) {
        String lowerCaseName = name.toLowerCase();
        pessoas.forEach(pessoa -> {
            if (pessoa.name.toLowerCase().equals(lowerCaseName)) pessoa.incrementaUmVoto();
        });
    }

    static int result() {
        pessoas.forEach(pessoa -> {
            if (pessoa.getVotos() > max) {
                eliminado = count;
                max = pessoa.getVotos();
            }
            ++count;
        });
        return eliminado;
    }

    private JPanel panel = new JPanel();

    JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setPreferredSize(new Dimension(150, 50));
        return btn;
    }

    Main() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setContentPane(panel);
        panel.setLayout(new GridLayout(2, 1, 20, 20));
        JButton votarButton = createStyledButton("Votar");
        JButton apurarButton = createStyledButton("Apurar resultado");

        votarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String voto = "";
                max=0;
                count=0;
                while(!voto.equals("sair")) {
                    voto= JOptionPane.showInputDialog(null,"Em quem voce vota para sair da casa, digite \"sair\" para encerrar ou clique em \"Cancelar \" :");
                    if (voto == null) return;
                    votar(voto);
                }
            }
        });

        apurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = result();
                JOptionPane.showMessageDialog(null,
                        "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami,\n se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se\n eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou\n conseguir te eliminar com alegria. Com "+pessoas.get(i).getVotos()+" votos, é você quem sai "+pessoas.get(i).name
                );
            }
        });

        panel.add(votarButton);
        panel.add(apurarButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        cadastrar();
        new Main();
    }
}
