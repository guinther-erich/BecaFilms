# NTT Beca Films
Repositório do aplicativo de filmes para avaliação da Beca de Android Developer da NTT DATA EMEAL.

## Features & build
Aplicativo construído em Kotlin que lista os filmes mais populares da semana de acordo com a API do [TheMovieDB.org](https://www.themoviedb.org/) com arquitetura MVVM.
Para isso, foi utilizado:
- Retrofit (para requisições via HTTP da API);
- ViewBinding (para acesso as views da lista de filmes e dos detalhes de cada um destes itens);
- ViewModel (para armazenamento dos dados);
- Coroutines (para auxiliar nas tarefas assíncronas); e
- Glide (para utilização de imagens dentro do aplicativo).

## Prováveis features
Pensando em dar continuidade ao projeto, seguem as próximas possíveis atualizações:
- Botão de retornar da visualização dos detalhes para a tela inicial;
- Modo dark do aplicativo;
- Descrição do elenco do filme;
- Possibilidade de criação de lista de favoritos;
- Visualização por outros filtros (melhores pontuações, data de lançamento, etc.);
- Ajustes na visualização no modo horizontal;
- Versão em português.

## Alterações na arquitetura

### MVVM + Clean Architeture
O app NTT Beca Films foi construído sob arquitetura MVVM (Model View ViewModel), o que ajuda a separar com maior precisão a lógica de negócios e apresentação do aplicativo de sua interface do usuário. Isso também facilita a resolução de problemas, manutenção, evolução e até mesmo testes dentro dele.

Porém, há a possibilidade de modificação de suas camadas para que cada um de seus componentes possam possuir suas próprias responsabilidades, ou seja, adaptá-lo ao Clean Architeture, o que acarretaria em uma série de outros benefícios, tais como:
- Ganho exponencial na amplitude dos testes;
- Desacoplação dos componentes, onde a estrutura de pacotes poderá navegar mais rápido entre eles;
- Rapidez no desenvolvimento de novas features.

As principais alterações estarão presentes justamente nas camadas a serem vistas na estruturação do projeto, que seriam:
- Camada de Apresentação (ou Presentation Layer): que inclue as Activities e as Views, uma vez que a comunicação entre elas deve ser mais direta e possuem o lado voltado à interação com o cliente;
- Camada de Domínio (ou Domain Layer): que serve como ponte entre as ViewModels e os Repositories, sendo esta camada a recomendada para inclusão de novas features; e
- Camada de Dados (ou Data Layer): camada esta onde se encontram os repositórios e os DataSources, ou seja, os responsáveis pela decisão de qual fonte os dados virão.

Desta forma, conclui-se que para a adaptação deste aplicativo ao Clean Architeture desprenderia de alterações no código para que este fosse melhor desacoplado entre seus componentes e melhor dividido dentro das camadas acima apresentadas.

### Android JetPack
O aplicativo pode ser melhor construído utilizando-se as bibliotecas unificadas do Android JetPack, tais como:
- Activity;
- Databinding;
- Hilt (pata injeção de dependências);
- Lifecycle (para melhor delimitação do ciclo de vida de cada acticity);
- Entre outras libs que diminuiriam o consumo de memória da aplicação, tendo em vista a sua consistência centralizada em uma só ferramenta, além de permitir um código escrito de forma mais limpa e dentro de práticas recomendadas.

## Obstáculos na criação deste app
A implementação de Coroutines e seus desdobramentos para utilização no código foi a principal dificuldade encontrada.

## Visualização do NTT Beca Films
https://user-images.githubusercontent.com/67793128/167762241-0661c9ba-1c38-4996-ba3a-79a8d6102a65.mp4
