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

## Obstáculos na criação deste app
A implementação de Coroutines e seus desdobramentos para utilização no código foi a principal dificuldade encontrada.

## Visualização do NTT Beca Films
https://user-images.githubusercontent.com/67793128/167762241-0661c9ba-1c38-4996-ba3a-79a8d6102a65.mp4
