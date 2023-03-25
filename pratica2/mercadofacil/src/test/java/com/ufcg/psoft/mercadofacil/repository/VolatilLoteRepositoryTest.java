package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VolatilLoteRepositoryTest {

    @Autowired
    VolatilLoteRepository driver;

    Lote lote;
    Lote resultado;
    Produto produto;

    @BeforeEach
    void setup() {
        produto = Produto.builder()
                .id(1L)
                .nome("Produto Base")
                .codigoBarra("123456789")
                .fabricante("Fabricante Base")
                .preco(125.36)
                .build();
        lote = Lote.builder()
                .id(1L)
                .numeroDeItens(100)
                .produto(produto)
                .build();
    }

    @AfterEach
    void tearDown() {
        produto = null;
        driver.deleteAll();
    }

    @Test
    @DisplayName("Adicionar o primeiro Lote no repositorio de dados")
    void salvarPrimeiroLote() {
        resultado = driver.save(lote);

        assertEquals(driver.findAll().size(), 1);
        assertEquals(resultado.getId().longValue(), lote.getId().longValue());
        assertEquals(resultado.getProduto(), produto);
    }

    @Test
    @DisplayName("Adicionar o segundo Lote (ou posterior) no repositorio de dados")
    void salvarSegundoLoteOuPosterior() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(lote);

        resultado = driver.save(loteExtra);

        assertEquals(driver.findAll().size(), 2);
        assertEquals(resultado.getId().longValue(), loteExtra.getId().longValue());
        assertEquals(resultado.getProduto(), produtoExtra);

    }

    @Test
    @DisplayName("Encontra lote inexistente")
    void entrontraLoteNaoCadastrado() {
        driver.save(lote);
        assertEquals(driver.find((long) 452), null);
    }

    @Test
    @DisplayName("Procura um lote dentro do repositorio")
    void encontraLoteEmRepository() {
        driver.save(lote);
        assertEquals(lote.getId(), driver.find(lote.getId()));
    }

    @Test
    @DisplayName("Retorna todos os lotes existentes")
    void encontraTodosLotesCadastrados() {
        driver.save(lote);
        assertEquals(1, driver.findAll().size());
    }

    @Test
    @DisplayName("Tenta encontrar lotes mesmo sem ter cadastrado")
    void encontraTodosLotesEmVazio() {
        assertEquals(driver.findAll().size(), 0);
    }

    @Test
    @DisplayName("Atualiza lote já cadastrado")
    void atualizaLoteCadastrado() {
        driver.save(lote);
        lote.setNumeroDeItens(17);
        driver.update(lote);
        assertEquals(driver.find(lote.getId()).getNumeroDeItens(), 17);
    }

    @Test
    @DisplayName("Tenta atualizar lote que não existe")
    void atualizaLoteNaoCadastrado() {
        driver.save(lote);
        lote.setNumeroDeItens(17);
        lote.setId((long) 2);
        driver.update(lote);
        assertEquals(driver.find(lote.getId()).getNumeroDeItens(), 100);
    }

    @Test
    @DisplayName("Tenta deletar lote")
    void deletaLoteCadastrado() {
        driver.save(lote);
        driver.delete(lote);
        assertEquals(driver.findAll().size(), 0);
    }

    @Test
    @DisplayName("Tenta deletar lote não existente")
    void deletaLoteNaoCadastrado() {
        driver.save(lote);
        lote.setId((long) 2);
        driver.delete(lote);
        assertEquals(driver.findAll().size(), 1);
    }

    @Test
    @DisplayName("Deleta todos os lotes")
    void deletaTodosLotesCadastrados() {
        driver.save(lote);
        driver.deleteAll();
        assertEquals(driver.findAll().size(), 0);
    }

    @Test
    @DisplayName("Deleta todos os lotes sem nenhum cadastrado")
    void deletaTodosLotesEmVazio() {
        driver.deleteAll();
        assertEquals(driver.findAll().size(), 0);
    }

}
