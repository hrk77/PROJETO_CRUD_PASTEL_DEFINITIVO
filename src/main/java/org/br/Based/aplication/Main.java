package org.br.Based.aplication;

import org.br.Based.dao.PastelDAO;
import org.br.Based.model.Pastel;

public class Main {
    public static void main(String[] args) throws Exception {

        PastelDAO pastelDAO = new PastelDAO();
        // INSERINDO INFORMAÇOES NO BANCO
        Pastel pastel = new Pastel();
        //SETANDO NOME:
        pastel.setNome("AAAA");
        //SETANDO ID: "no importa o numero que eu setar pois no mysql esta auto increment e ele
        // coloca em ordem automaticamente"
        pastel.setId(25);
        //SETANDO PRECO:
        pastel.setPreco(24);
        //CHAMANDO A PARA REALIZAR A EXECUÇÃO DA CONEXAO COM O BANCO E REALIZAR A INSERÇÃO
        pastelDAO.save(pastel);
//==================================================================================================
        //VISUALIZAÇÃO DE DADOS
        for (Pastel p : pastelDAO.getPastels()){
            System.out.println("Pastel: " + p.getNome());
        }
//==================================================================================================
        //ATUALIZANDO OS DADOS
        //Criando o obj p1
        Pastel p1 = new Pastel();
        //setando nome
        p1.setNome("TESTE9999");
        //setando preco
        p1.setPreco(90);
        //setando o id onde ele vai substituir no bd
        p1.setId(1);
        //chamando a dao q faz a conexao com o bd e com metodo ".update" que foi criado
        // para realizar essa operação de atualizar os dados
        pastelDAO.update(p1);
//===============================================================================================
        //DELETANDO DADOS (pelo id)
        //chamando obj + funçao e setando a posiçao q qr q seja deletado
        pastelDAO.deleteById(4);

    }
}
