package persistence;

import entity.Edu_matr_responsavel;

public class Edu_matr_responsavelDao extends Dao {
	
	public Integer gravar(Edu_matr_responsavel resp) throws Exception{
		Integer idresp = 0;
		
		open();
		
		stmt = con.prepareStatement("select max(id_responsavel) as id_responsavel from edu_matr_responsavel ");
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			idresp = rs.getInt("id_responsavel") + 1;
		} else {
			idresp = 1;
		}
		
		String smtp = "insert into edu_matr_responsavel (id_responsavel, nome_responsavel, tipo_responsavel, " +
                	  "cpf_responsavel, email_responsavel, celular_responsavel, identidade_responsavel, " +
                	  "emissoridt_responsavel) " +
                	  "values (?, ?, ?, ?, ?, ?, ?, ?)";	

		stmt = con.prepareStatement(smtp);



		stmt.setInt(1, idresp);
		stmt.setString(2, resp.getNome_responsavel());
		stmt.setString(3, resp.getTipo_responsavel());
		stmt.setString(4, resp.getCpf_responsavel());
		stmt.setString(5, resp.getEmail_responsavel());
		stmt.setString(6, resp.getCelular_responsavel());
		stmt.setString(7, resp.getIdentidade_responsavel());
		stmt.setString(8, resp.getEmissoridt_responsavel());

		stmt.executeUpdate();
		
		return idresp;
		
	}

}
