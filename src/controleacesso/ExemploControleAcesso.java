package controleacesso;

/**
 * O padrão de design Proxy permite controlar o acesso ao serviço real sem modificar sua implementação.
 * Isso é útil em cenários nos quais é necessário adicionar lógica adicional, como controle de acesso,
 * logging ou caching, sem afetar diretamente o serviço real.
 *
 * O ProxyControleAcesso cria uma instância do ServicoReal apenas quando necessário
 */

public class ExemploControleAcesso {
    public static void main(String[] args) {
        // Usuário admin tem permissão para acessar o serviço.
        Servico proxyAdmin = new ProxyControleAcesso("admin");
        proxyAdmin.executar();

        // Usuário comum não tem permissão para acessar o serviço.
        Servico proxyUsuarioComum = new ProxyControleAcesso("usuario");
        proxyUsuarioComum.executar();
    }
}