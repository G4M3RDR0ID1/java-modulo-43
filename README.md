Que tal praticar?
Desenvolva uma API REST simples utilizando Spring Boot que gerencie um cadastro de produtos. A API deve permitir:

Consultar produtos (GET)

Adicionar novos produtos (POST)

Atualizar informações de produtos (PUT)

Deletar produtos (DELETE)

O objetivo é praticar a criação de controladores, o mapeamento de endpoints, o recebimento de parâmetros na URL e no corpo da requisição, além do uso correto dos métodos HTTP.

Instruções:

Crie uma classe Produto com os seguintes atributos:

id (Integer)

nome (String)

preco (Double)

Crie um @RestController chamado ProdutoController e implemente os seguintes endpoints:

GET: /produtos, Retorna uma lista de produtos.

GET: /produtos/{id}, Retorna um produto específico pelo ID.

POST: /produtos, Adiciona um novo produto (dados enviados no corpo da requisição).

PATCH: /produtos/{id}, Atualiza os dados de um produto existente (dados enviados no corpo).

DELETE: /produtos/{id}, Remove um produto pelo ID.

Utilize as anotações:

@RequestMapping, @GetMapping, @PostMapping, @PatchMapping, @DeleteMapping

@PathVariable

@RequestBody

Guarde os produtos em uma lista estática ou em memória (não precisa banco de dados).
