import model.Cidade;
import model.Estado;
import model.Pais;

public class ExemploComVerificacaoExplicita {

    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        cidade.setNome("Recife");

        Estado estado = new Estado();
        estado.setNome("Pernambuco");

        Pais pais = new Pais();
        pais.setNome("Brasil");

        if (cidade.getEstado() != null) {
            cidade.getEstado().setPais(pais);
        } else {
            cidade.setEstado(estado);
            cidade.getEstado().setPais(pais);
        }

        System.out.printf("A cidade %s fica no estado de %s, no país %s%n", cidade.getNome(),
                cidade.getEstado().getNome(), cidade.getEstado().getPais().getNome());
    }
}
