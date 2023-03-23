import model.Cidade;
import model.Estado;
import model.Pais;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ExemploComOptional {
    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        cidade.setNome("Recife");

        Cidade cidade2 = new Cidade();
        cidade2.setNome("Olinda");

        Estado estado = new Estado();
        estado.setNome("Pernambuco");
        estado.setSigla("PE");
        cidade.setEstado(estado);

        Pais pais = new Pais();
        pais.setNome("Brasil");
        estado.setPais(pais);

        var estadoDaCidade2 = criaOptionalDoEstado(cidade2);
        estadoDaCidade2.ifPresent(e -> {
            System.out.println(mensagemDeBoasVindasACidade(cidade2, e));
        });

        var estadoDaCidade1 = criaOptionalDoEstado(cidade);
        estadoDaCidade1.ifPresent(e -> {
            System.out.println(mensagemDeBoasVindasACidade(cidade, e));
        });

    }

    public static Optional<Estado> criaOptionalDoEstado(Cidade cidade) {
        return Optional.ofNullable(cidade.getEstado());
    }

    public static String mensagemDeBoasVindasACidade(Cidade cidade, Estado estado) {
        AtomicReference<String> mensagemBoasVindas = new AtomicReference<>(String.format(
                "Bem vindo a %s - %s", cidade.getNome(), estado.getSigla())
        );

        var paisOptional = Optional.ofNullable(estado.getPais());

        paisOptional.ifPresent(pais -> mensagemBoasVindas.set(mensagemBoasVindas.get()
                .concat(String.format(", %s", pais.getNome()))));

        return mensagemBoasVindas.get();
    }
}
