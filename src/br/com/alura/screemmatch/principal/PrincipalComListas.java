package br.com.alura.screemmatch.principal;

import br.com.alura.screemmatch.modelos.Filme;
import br.com.alura.screemmatch.modelos.Serie;
import br.com.alura.screemmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2004);

        ArrayList<Titulo> lista =new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for(Titulo item: lista){
            System.out.println(item.getNome());
            System.out.println();
            if(item instanceof Filme filme) {
                System.out.println("Classifocação " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscarArtista = new ArrayList<>();
        buscarArtista.add("Adam Sandler");
        buscarArtista.add("Paulo");
        buscarArtista.add("João");
        buscarArtista.add("Emma Stone");
        System.out.println(buscarArtista);

        Collections.sort(buscarArtista);
        System.out.println("Depois da oredenação: ");
        System.out.println(buscarArtista);
        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: ");
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano de lançamento: ");
        System.out.println(lista);
    }
}
