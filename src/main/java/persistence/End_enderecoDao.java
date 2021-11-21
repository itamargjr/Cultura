package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.End_endereco;
import util.Biblioteca;

public class End_enderecoDao extends Dao {
	
	public End_endereco findOne(Integer identidade, String tipo) throws Exception{
		End_endereco end =  new End_endereco();
		
		open();
		
		String statement = "select a.id_endereco, a.tipo_endereco, a.identidade_endereco, " +
		                   "a.cep_endereco, a.uf_endereco, a.logradouro_endereco, a.numero_endereco, " +
						   "a.complemento_endereco, a.codigo_municipio, a.bairro_endereco " +
						   "from end_endereco a " +
		                   "where " +
						   "  identidade_endereco = " + identidade + " and " +
		                   "  tipo_endereco = '" + tipo + "'";
		
		stmt = con.prepareStatement(statement);
		
		//System.out.println(statement);
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			
			//System.out.println("inserindo dados");
			
			end = new End_endereco(rs.getInt("id_endereco"), rs.getString("tipo_endereco"), rs.getInt("identidade_endereco"),
					                      rs.getString("cep_endereco"), rs.getString("uf_endereco"), rs.getString("logradouro_endereco"),
					                      rs.getString("numero_endereco"), rs.getString("complemento_endereco"), rs.getString("codigo_municipio"),
					                      rs.getString("bairro_endereco"));
		}
		
		close();
		
		return end;
	}
	
	public List<End_endereco> findAll(End_endereco end) throws Exception{
		List<End_endereco> lista =  new ArrayList<End_endereco>();
		
		open();
		
		String statement = "select a.id_endereco, a.tipo_endereco, a.identidade_endereco, " +
		                   "a.cep_endereco, a.uf_endereco, a.logradouro_endereco, a.numero_endereco, " +
						   "a.complemento_endereco, a.codigo_municipio, a.bairro_endereco " +
						   "from end_endereco a " +
		                   "where 1 = 1 ";
		
		if ((end.getId_endereco()!=null)&&(end.getId_endereco()!=0)) {
			statement = statement + " and id_endereco = '" + end.getId_endereco() + "'";
		}
		
		if ((end.getTipo_endereco()!=null)&&(!end.getTipo_endereco().equalsIgnoreCase(""))) {
			statement = statement + " and tipo_endereco = '" +end.getTipo_endereco() + "'";
		}
		
		if ((end.getBairro_endereco()!=null)&&(!end.getBairro_endereco().equalsIgnoreCase(""))) {
			statement = statement + " and bairro_endereco like '%" + end.getBairro_endereco() + "%'";
		}
		
		if ((end.getLogradouro_endereco()!=null)&&(!end.getLogradouro_endereco().equalsIgnoreCase(""))) {
			statement = statement + " and logradouro_endereco like '%" + end.getLogradouro_endereco() + "%'";
		}
		
		if ((end.getIdentidade_endereco()!=null)&&(end.getIdentidade_endereco()!=0)) {
			statement = statement + " and identidade_endereco = '" + end.getIdentidade_endereco() + "'";
		}
		
		stmt = con.prepareStatement(statement);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			End_endereco e = new End_endereco(rs.getInt("id_endereco"), rs.getString("tipo_endereco"), rs.getInt("identidade_endereco"),
					                      rs.getString("cep_endereco"), rs.getString("uf_endereco"), rs.getString("logradouro_endereco"),
					                      rs.getString("numero_endereco"), rs.getString("complemento_endereco"), rs.getString("codigo_municipio"),
					                      rs.getString("bairro_endereco"));
			lista.add(e);
		}
		
		close();
		
		return lista;
	}
	
	public Integer gravar(End_endereco end) throws Exception {
		
		final Integer linhasafetadas; 
			
		String smtp = "insert into end_endereco (id_endereco, tipo_endereco, identidade_endereco, " +
					  "cep_endereco, uf_endereco, logradouro_endereco, numero_endereco, " +
					  "complemento_endereco, codigo_municipio, bairro_endereco) " +
			          "values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
		
		open();	
		
		stmt = con.prepareStatement(smtp);
		
		//System.out.println(Biblioteca.LimpaStringCaracterSpecial(escola.getCnpj_escola()));

		stmt.setString(1, end.getTipo_endereco());
		stmt.setInt(2, end.getIdentidade_endereco());
		stmt.setString(3, Biblioteca.LimpaStringCaracterSpecial(end.getCep_endereco()));
		stmt.setString(4, end.getUf_endereco());
		stmt.setString(5, end.getLogradouro_endereco());
		stmt.setString(6, end.getNumero_endereco());
		stmt.setString(7, end.getComplemento_endereco());
		stmt.setString(8, end.getCodigo_municipio());
		stmt.setString(9, end.getBairro_endereco());
		
		linhasafetadas = stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}
	
	public Integer alterar(End_endereco end) throws Exception {
		
		final Integer linhasafetadas; 
	
		String smtp = "update end_endereco set tipo_endereco = ?, identidade_endereco = ?, cep_endereco = ?, " +
		              "uf_endereco = ?, logradouro_endereco = ?, numero_endereco = ?, " +
				      "complemento_endereco = ?, codigo_municipio = ?, bairro_endereco = ? " +
		              "where id_endereco = ?";	

		open();	
		
		stmt = con.prepareStatement(smtp);
		
		
		stmt.setString(1, end.getTipo_endereco());
		stmt.setInt(2, end.getIdentidade_endereco());
		stmt.setString(3, Biblioteca.LimpaStringCaracterSpecial(end.getCep_endereco()));
		stmt.setString(4, end.getUf_endereco());
		stmt.setString(5, end.getLogradouro_endereco());
		stmt.setString(6, end.getNumero_endereco());
		stmt.setString(7, end.getComplemento_endereco());
		stmt.setString(8, end.getCodigo_municipio());
		stmt.setString(9, end.getBairro_endereco());
		stmt.setInt(10, end.getId_endereco());
		
		linhasafetadas = stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}
	
	public Integer excluir(End_endereco end) throws Exception {
		
		final Integer linhasafetadas; 
		
		String smtp = "DELETE FROM end_endereco WHERE id_endereco = ?";	
		
		open();	
		
		stmt = con.prepareStatement(smtp);
		
		stmt.setInt(1, end.getId_endereco());
		
		linhasafetadas = stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}

}
