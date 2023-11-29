package imagemcache;

/**
 * O padrão de design Proxy permite controlar o acesso ao serviço real sem modificar sua implementação.
 * Isso é útil em cenários nos quais é necessário adicionar lógica adicional, como controle de acesso,
 * logging ou caching, sem afetar diretamente o serviço real.
 *
 * O ImagemProxy realiza caching das imagens recentemente requisitadas ao serviço Imagem
 */

public class ExemploImagemCache {
    public static void main(String[] args) {
        ImagemInterface proxy;
        System.out.println();

        // Utilização da imagem rando1 pela primeira vez
        proxy = new ImagemProxy("imagens/rando1.jpg");
        proxy.mostrarImagem();

        // Utilização da imagem rando2 pela primeira vez
        proxy = new ImagemProxy("imagens/rando2.jpg");
        proxy.mostrarImagem();

        // Utilização da imagem verde pela primeira vez
        proxy = new ImagemProxy("imagens/verde.jpg");
        proxy.mostrarImagem();

        // Utilização da imagem rando1 pela segunda vez
        proxy = new ImagemProxy("imagens/rando1.jpg");
        proxy.mostrarImagem();

        // Utilização da imagem rando2 pela segunda vez
        proxy = new ImagemProxy("imagens/rando2.jpg");
        proxy.mostrarImagem();
    }

}