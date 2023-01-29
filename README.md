# 7DaysOfCodeJava
#7DaysOfCode
Reflexões Dia 3
- Faz sentido ter um construtor padrão que tem como parâmetro todos os atributos da classe Movies para garantir que todos os seus atributos estejam preenchidos
durante a criação de seus objetos;
- Os únicos setters que fazem sentido são para os atributos rating(nota) e urlImage, já que qualquer usuário cadastrado no IMDB pode dar uma nota para os filmes, então existe a 
possibilidade de que a média dessa nota mude com o tempo, além disso existe a possibilidade do link da imagem deixar de funcionar por algum motivo;
- Até o momento, não vejo necessidade da classe Movie ser interfaceada já que não existem métodos que obrigatoriamente precisem ser implementados ou classes que
precisam implamentar a classe Movie em si;
- Sobre a Classe ser imutável, a resposta é não, já que apesar de que os atributos title e year serem final, os atributos rating e urlImage podem mudar.
