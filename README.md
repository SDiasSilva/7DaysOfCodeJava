# 7DaysOfCodeJava
#7DaysOfCode
Reflexões Dia 3
- Faz sentido ter um construtor padrão que tem como parâmetro todos os atributos da classe Movie para garantir que todos os seus atributos estejam preenchidos
durante a criação de seus objetos;
- Não precisa de setters já que os valores serão sempre atualizados assim que uma nova chamada é feita na API
- Até o momento, não vejo necessidade da classe Movie ser interfaceada já que não existem métodos que obrigatoriamente precisem ser implementados ou classes que
precisam implementar a classe Movie em si;
- Sobre a Classe ser imutável, a resposta é não, já que apesar de que os atributos title e year serem final, os atributos rating e urlImage podem mudar.

Dia 4
- Foi adicionado a classe HttpGenerator e gerado um arquivo index.html;

Dia 5
- Foram adicionadas as classes ImdbApiClient e ImdbMovieJsonParser para encapsular, respectivamente, a chamada da API e o Parseamento do Json na Classe Main;

Dia 6
- Foram criadas as interfaces APIClient, JsonParser e Content e alteradas, respectivamente, as classes ImdbAPIClient, ImdbMovieJsonParser e Movie além das adições das classes MarvelAPIClient, MarvelComicJsonParser e MarvelComic que implementam as 3 interfaces supracitadas, refatoração de diversas classes para comportar o uso da biblioteca GSON.

Dia 7
- Adicionadas as classes MarvelSeriesJsonParser e MarvelSeries para acomodar a lista de séries da API.
- Nova classe abstrata AbstractMarvel criada para reutilizar atributos e implementações de métodos em MarvelComic e MarvelSeries.
- Refatoração da classe MarvelAPIClient para fazer outras chamadas utilizando as mesmas chaves, com adição do atributo "link".
- Refatoração de todas as classes que implementam Content, com adição do novo método "type()".
- Refatoração da classe HttpGenerator para acomodar a nova descrição do card que mostra o tipo de conteúdo.
- Exclusão das classes de teste main e criação de uma nova chamada Main para testar todas as classes.
- Gerada uma página HTML que contém uma lista mista de ImdbMovie, MarvelComic e MarvelSeries, ordenada pelo título de forma reversa, já que é o único atributo das três classes que nunca está vazio.
