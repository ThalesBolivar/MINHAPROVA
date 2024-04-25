import java.util.ArrayList;
import java.util.Scanner;

class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void adicionarVoto() {
        votos++;
    }
}

public class BigBrother {
    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Beatriz Reis"));
        jogadores.add(new Jogador("Davi Brito"));
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add(new Jogador("Giovanna Lima"));
        jogadores.add(new Jogador("Giovanna Pitel"));
        jogadores.add(new Jogador("Isabelle Nogueira"));
        jogadores.add(new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add(new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Lucas Pizane"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add(new Jogador("Matteus Amaral"));
        jogadores.add(new Jogador("Maycon Cosmer"));
        jogadores.add(new Jogador("MC Bin Laden"));
        jogadores.add(new Jogador("Michel Nogueira"));
        jogadores.add(new Jogador("Nizam"));
        jogadores.add(new Jogador("Raquele Cardozo"));
        jogadores.add(new Jogador("Rodriguinho"));
        jogadores.add(new Jogador("Thalyta Alves"));
        jogadores.add(new Jogador("Vanessa Lopes"));
        jogadores.add(new Jogador("Vinicius Rodrigues"));
        jogadores.add(new Jogador("Wanessa Camargo"));
        jogadores.add(new Jogador("Yasmin Brunet"));

        Scanner scanner = new Scanner(System.in);
        String voto;
        Jogador jogadorMaisVotado = null;

        do {
            System.out.println("Digite o nome do jogador que deseja votar (ou 'sair' para terminar): ");
            voto = scanner.nextLine();

            if (!voto.equalsIgnoreCase("sair")) {
                boolean jogadorEncontrado = false;
                for (Jogador jogador : jogadores) {
                    if (jogador.getNome().equalsIgnoreCase(voto)) {
                        jogador.adicionarVoto();
                        jogadorEncontrado = true;
                        break;
                    }
                }
                if (!jogadorEncontrado) {
                    System.out.println("Jogador não encontrado. Por favor, digite um nome válido.");
                }
            }
        } while (!voto.equalsIgnoreCase("sair"));

        int maxVotos = 0;
        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > maxVotos) {
                maxVotos = jogador.getVotos();
                jogadorMaisVotado = jogador;
            }
        }

        System.out.println("Segue os jogadores:");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + " - Votos: " + jogador.getVotos());
        }

        if (jogadorMaisVotado != null) {
            System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir \n" +
                    "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu \n" +
                    "conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu \n" +
                    "vou conseguir te eliminar com alegria. \nCom " + jogadorMaisVotado.getVotos() + " votos, é você quem sai " +
                    jogadorMaisVotado.getNome() + ".");
        }
    }
}