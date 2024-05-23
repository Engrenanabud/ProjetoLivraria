import java.util.ArrayList;
import java.util.List;

public class Acervo {



    static List<Livro> listaLivros = new ArrayList<>();


    public static void salvarLivro(Livro livro) {
        listaLivros.add(livro);
    }

    public static List<Livro> buscarLivros() {
        return listaLivros;

    }
}
