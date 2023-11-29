package controleacesso;

class ProxyControleAcesso implements Servico {
    private ServicoReal servicoReal;
    private String usuario;

    /**
     * Construtor do ProxyControleAcesso.
     *
     * @param usuario Nome do usuário que está solicitando o acesso.
     */
    public ProxyControleAcesso(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void executar() {
        // Verifica se o usuário tem permissão para acessar o serviço.
        if (verificarPermissao()) {
            // Se tiver permissão, cria ou utiliza a instância do serviço real.
            if (servicoReal == null) {
                servicoReal = new ServicoReal();
            }
            // Executa o serviço real.
            servicoReal.executar();
        } else {
            System.out.println("Usuário " + usuario + " não tem permissão para acessar o serviço.");
        }
    }

    /**
     * Verifica se o usuário tem permissão para acessar o serviço.
     *
     * @return true se o usuário tem permissão, false caso contrário.
     */
    private boolean verificarPermissao() {
        // Lógica de verificação de permissão, por exemplo, baseada em roles de usuário.
        return usuario.equals("admin");
    }
}

