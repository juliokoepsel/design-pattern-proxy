package imagemcache;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Imagem implements ImagemInterface {

    private String localImagem;
    private byte[] conteudo;

    /**
     * Construtor do Imagem.
     *
     * @param localImagem Localização do arquivo da imagem no computador.
     */
    public Imagem(String localImagem) {
        this.localImagem = localImagem;
        carregarImagem();
    }

    // Carrega a imagem na memória
    private void carregarImagem() {
        System.out.println("Carregando a imagem: " + localImagem);
        try {
            conteudo = Files.readAllBytes(Paths.get(localImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mostra a imagem com swing
    @Override
    public void mostrarImagem() {
        System.out.println("Mostrando a imagem: " + localImagem + "\n");
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image from Byte Array");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(conteudo);
                ImageIcon icone = new ImageIcon(ImageIO.read(bis));
                JLabel nome = new JLabel(icone);
                frame.getContentPane().add(nome);
            } catch (IOException e) {
                e.printStackTrace();
            }

            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

}
