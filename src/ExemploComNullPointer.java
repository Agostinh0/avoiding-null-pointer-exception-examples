import model.Cidade;
import model.Estado;
import model.Pais;

public class ExemploComNullPointer {
    public static void main(String[] args) {

        Cidade cidade = new Cidade();
        cidade.setNome("Recife");

        Estado estado = new Estado();
        estado.setNome("Pernambuco");

        Pais pais = new Pais();
        pais.setNome("Brasil");

        cidade.getEstado().setPais(pais);

        System.out.printf("A cidade %s fica no estado de %s, no país %s%n", cidade,
                cidade.getEstado(), cidade.getEstado().getPais());
    }
}