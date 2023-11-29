package imagemcache;

import java.util.HashMap;

public class ImagemProxy implements ImagemInterface {

    public static HashMap<String, Imagem> imagemCache = new HashMap<>();
    private Imagem imagem;
    private String localImagem;

    /**
     * Construtor do ImagemProxy.
     *
     * @param localImagem Localização do arquivo da imagem no computador.
     */
    public ImagemProxy(String localImagem) {
        this.localImagem = localImagem;
    }

    @Override
    public void mostrarImagem() {
        // Verifica se o objeto real foi instanciado
        if (imagem == null) {
            // Verifica se a imagem está no cache ou precisa ser adicionada
            if (imagemCache.containsKey(localImagem)) {
                imagem = imagemCache.get(localImagem);
                System.out.println("Imagem " + localImagem + " encontrada no cache");
            } else {
                imagem = new Imagem(localImagem);
                imagemCache.put(localImagem, imagem);
                System.out.println("Imagem " + localImagem + " adicionada ao cache");
            }
        }
        imagem.mostrarImagem();
    }

}
