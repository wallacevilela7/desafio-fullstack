# Projeto Produtos com Paginação

### Visão geral

Aplicação simples para listar produtos paginados via backend Spring Boot + banco Postgres (rodando em Docker) e frontend HTML/JS puro consumindo a API.

---

## Backend

* **Spring Boot** para API REST
* Entidade `Product` com campos: id, name, price, createdAt
* Paginação via parâmetros `page` e `pageSize` (default 0 e 100)
* CORS configurado para liberar acesso do frontend

---

## Banco de Dados

* **PostgreSQL** rodando via Docker Compose
* Configuração simples no `docker-compose.yml`
* Banco inicializado automaticamente pelo Spring JPA com tabela `tb_products`

---

## Frontend

* Página HTML simples que consome API `/api/v1/products`
* Navegação por páginas via botões “Anterior” e “Próxima”
* Exibe “Página X de Y” com base na resposta da API
* Código em JS puro (sem frameworks)

---

## Como rodar

### Banco com Docker

```bash
docker-compose up -d
```

### Backend

```bash
./mvnw spring-boot:run
```

### Frontend

Abrir `index.html` direto no navegador

---

## Uso

* Navegue pelas páginas de produtos usando os botões
* Visualize nome e preço dos produtos na lista
* O frontend atualiza a paginação conforme resposta da API.
