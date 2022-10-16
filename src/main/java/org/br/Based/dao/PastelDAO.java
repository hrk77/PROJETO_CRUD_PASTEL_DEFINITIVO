package org.br.Based.dao;

import org.br.Based.factory.Conexao;
import org.br.Based.model.Pastel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PastelDAO {
    //METODO PARA SALVAR:
    public void save(Pastel pastel) throws SQLException {
        String sql = "INSERT INTO pastel (nome, preco) VALUES (?, ?)";
        Connection con = null;
        PreparedStatement pstm = null;
        try{
            con = Conexao.createConnectionToMySQL();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, pastel.getNome());
            pstm.setInt(2, pastel.getPreco());

            pstm.execute();
            System.out.println("Salvo com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (con != null){
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    //METODO ATUALIZAR:
    public void update(Pastel pastel) throws SQLException {
        String sql = "UPDATE pastel SET nome = ?, preco = ?" + " WHERE id = ?";

        Connection con = null;
        PreparedStatement pstm = null;

        try{
            con = Conexao.createConnectionToMySQL();

            pstm = con.prepareStatement(sql);

            pstm.setString(1, pastel.getNome());
            pstm.setInt(2,pastel.getPreco());
            pstm.setInt(3,pastel.getId());

            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (pstm != null){
                pstm.close();
            }
            if (con != null){
                con.close();
            }
        }




    }
    //METODO LISTAR:
    public List<Pastel> getPastels(){

        String sql = "SELECT * FROM pastel";
        List<Pastel> pastels = new ArrayList<Pastel>();

        Connection con = null;
        PreparedStatement pstm = null;
        //classe q recupera os dados
        ResultSet rset =null;

        try {
            con = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) con.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Pastel pastel = new Pastel();
                //pegar os dados
                //recuperar id
                pastel.setId(rset.getInt("id"));
                //nome
                pastel.setNome(rset.getString("nome"));
                //preco
                pastel.setPreco(rset.getInt("preco"));

                pastels.add(pastel);


            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
          try {
              if (rset != null){
                  rset.close();
              }
              if (pstm != null){
                  pstm.close();
              }
              if (con != null){
                  con.close();
              }
          }catch (Exception e){
              e.printStackTrace();
          }
        }
        return pastels;
    }
    //METODO DELETAR:
    public void deleteById(int id){

        String sql = "DELETE FROM pastel WHERE id = ?";
        Connection con = null;
        PreparedStatement pstm = null;

        try{
            con = Conexao.createConnectionToMySQL();

            pstm = con.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (con != null){
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
