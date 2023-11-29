package controleacesso;

class ServicoReal implements Servico {
    @Override
    public void executar() {
        System.out.println("Executando o serviço real.");
    }
}