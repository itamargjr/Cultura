package persistence;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import entity.Cult_matr_candidato;

public class Cult_matr_candidatoDao extends Dao {
	
	public List<String> findDias() throws Exception{
		List<String> lista = new ArrayList<String>();
		
		open();
		
		stmt = con.prepareStatement("select distinct dia_segmento as dias from cult_segmento");
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {			
			lista.add(rs.getString("dias"));			
		}
		
		close();
		
		return lista;
	}
	
	public boolean testaCandidatoJaExiste(Cult_matr_candidato cand) throws Exception{
		Boolean JaExiste = false;
		
		open();
		
		String statement = "select id_candidato " +
                "from cult_matr_candidato " +
                "where " +
                "  ano_candidato = " + cand.getAno_candidato() + " and " +
                "  cpf_candidato = '" + cand.getCpf_candidato() + "'";
		
		stmt = con.prepareStatement(statement);
		
		rs = stmt.executeQuery();
		
//		System.out.println(statement);
		
		if (rs.next()) {
			
			JaExiste = true;
			
		}
		
		return JaExiste;
	}
	
	public Integer gravar(Cult_matr_candidato cand) throws Exception{
		
		Integer idCandidato = 0; 
		
		open();	
		
		stmt = con.prepareStatement("select max(id_candidato) as id_candidato from cult_matr_candidato ");
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			idCandidato = rs.getInt("id_candidato") + 1;
		} else {
			idCandidato = 1;
		}
		
		String smtp = "insert into cult_matr_candidato (id_responsavel, nome_candidato, mae_candidato, " +
	                  "pai_candidato, nascimento_candidato,  " +
	                  "estciv_candidato, sexo_candidato, nacionalidade_candidato, email_candidato, " +
	                  "celular_candidato, fixo_candidato, bairro_candidato, " + 
	                  "id_segmento1, id_segmento2, id_segmento3, id_segmento4, id_segmento5, " +
	                  "id_segmento, ano_candidato, id_candidato, tipo_candidato, necespec_candidato, cid_candidato, cpf_candidato, datainscricao_candidato) " +
		              "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, DATE_FORMAT(sysdate(),'%d/%m/%Y'))";	
	
		
	
		stmt = con.prepareStatement(smtp);

		stmt.setInt(1, cand.getId_responsavel());
		stmt.setString(2, cand.getNome_candidato());
		stmt.setString(3, cand.getMae_candidato());
		stmt.setString(4, cand.getPai_candidato());
		stmt.setString(5, cand.getNascimento_candidato());
		stmt.setString(6, cand.getEstciv_candidato());
		stmt.setString(7, cand.getSexo_candidato());
		stmt.setString(8, cand.getNacionalidade_candidato());
		stmt.setString(9, cand.getEmail_candidato());
		stmt.setString(10, cand.getCelular_candidato());
		stmt.setString(11, cand.getFixo_candidato());
		stmt.setString(12, cand.getBairro_candidato());

		if ((cand.getId_segmento1()==null)||(cand.getId_segmento1()==0)) {
			stmt.setNull(13, Types.INTEGER);
		} else {
			stmt.setInt(13, cand.getId_segmento1());
		}
		
		if ((cand.getId_segmento2()==null)||(cand.getId_segmento2()==0)) {
			stmt.setNull(14, Types.INTEGER);
		} else {
			stmt.setInt(14, cand.getId_segmento2());
		}
		
		if ((cand.getId_segmento3()==null)||(cand.getId_segmento3()==0)) {
			stmt.setNull(15, Types.INTEGER);
		} else {
			stmt.setInt(15, cand.getId_segmento3());
		}
		
		if ((cand.getId_segmento4()==null)||(cand.getId_segmento4()==0)) {
			stmt.setNull(16, Types.INTEGER);
		} else {
			stmt.setInt(16, cand.getId_segmento4());
		}
		
		if ((cand.getId_segmento5()==null)||(cand.getId_segmento5()==0)) {
			stmt.setNull(17, Types.INTEGER);
		} else {
			stmt.setInt(17, cand.getId_segmento5());
		}
		
		if ((cand.getId_segmento()==null)||(cand.getId_segmento()==0)) {
			stmt.setNull(18, Types.INTEGER);
		} else {
			stmt.setInt(18, cand.getId_segmento());
		}
		
		if ((cand.getAno_candidato()==null)||(cand.getAno_candidato()==0)) {
			stmt.setNull(19, Types.INTEGER);
		} else {
			stmt.setInt(19, cand.getAno_candidato());
		}
		
		stmt.setInt(20, idCandidato);
		stmt.setString(21, cand.getTipo_candidato());
		stmt.setString(22, cand.getNecespec_candidato());
		stmt.setString(23, cand.getCid_candidato());
		stmt.setString(24, cand.getCpf_candidato());

		Integer linhasafetadas = stmt.executeUpdate();
		
		if (linhasafetadas==0) {
			idCandidato = 0;			
		}
		
		return idCandidato;		
	}
	
	public Cult_matr_candidato findCandidatoConsulta(Cult_matr_candidato cand) throws Exception {
		Cult_matr_candidato c = new Cult_matr_candidato();
		
		open();
		
		String statement = "select " + 
						   "a.id_responsavel, a.nome_candidato, a.mae_candidato, " +
						   "a.pai_candidato, a.nascimento_candidato, a.cpf_candidato, " +
						   "a.estciv_candidato, a.sexo_candidato, a.nacionalidade_candidato, a.email_candidato, " +
						   "a.celular_candidato, a.fixo_candidato, a.bairro_candidato, a.datainscricao_candidato, " + 
						   "a.id_segmento1, a.id_segmento2, a.id_segmento3, a.id_segmento4, a.id_segmento5, " +
						   "a.id_segmento, a.ano_candidato, a.id_candidato, a.tipo_candidato, a.necespec_candidato, a.cid_candidato, " +
						   "g.nome_responsavel, g.tipo_responsavel, g.cpf_responsavel,  " +
						   "g.email_responsavel, g.celular_responsavel, g.identidade_responsavel,  " +
						   "g.emissoridt_responsavel, " +
						   "h.tipo_endereco, h.identidade_endereco, h.cep_endereco,  " +
						   "h.uf_endereco, h.logradouro_endereco, h.numero_endereco,  " +
						   "h.complemento_endereco, h.codigo_municipio, h.bairro_endereco, " +
						   "i.descricao_cid10, " +
						   "b.descricao_segmento as descricao_segmento1, b.dia_segmento as dia_segmento1, b.turno_segmento as turno_segmento1, " +
						   "c.descricao_segmento as descricao_segmento2, c.dia_segmento as dia_segmento2, c.turno_segmento as turno_segmento2, " +
						   "d.descricao_segmento as descricao_segmento3, d.dia_segmento as dia_segmento3, d.turno_segmento as turno_segmento3, " +
						   "e.descricao_segmento as descricao_segmento4, e.dia_segmento as dia_segmento4, e.turno_segmento as turno_segmento4, " +
						   "f.descricao_segmento as descricao_segmento5, f.dia_segmento as dia_segmento5, f.turno_segmento as turno_segmento5 " +
						   "from " +
						   "  cult_matr_candidato a " +
						   "    left outer join cult_segmento b on (a.id_segmento1 = b.id_segmento) " +
						   "    left outer join cult_segmento c on (a.id_segmento2 = c.id_segmento) " +
						   "    left outer join cult_segmento d on (a.id_segmento3 = d.id_segmento) " +
						   "    left outer join cult_segmento e on (a.id_segmento4 = e.id_segmento) " +
						   "    left outer join cult_segmento f on (a.id_segmento5 = f.id_segmento) " +
						   "    left outer join cid10 i on (a.cid_candidato = i.codigo_cid10),  " +
						   "  edu_matr_responsavel g, end_endereco h " +
						   "where " +
						   "  a.cpf_candidato = '" + cand.getCpf_candidato() + "' and " +
						   "  a.ano_candidato = '" + cand.getAno_candidato() + "' and " +
						   "  a.id_responsavel = g.id_responsavel AND " +
						   "  a.id_candidato = h.identidade_endereco AND " +
						   "  h.tipo_endereco = 'U' ";
		
		stmt = con.prepareStatement(statement);
		
		//System.out.println(statement);
		
		rs = stmt.executeQuery();
		
		
		
		if (rs.next()) {
			
			String turno1 = rs.getString("turno_segmento1");
			String turno2 = rs.getString("turno_segmento2");
			String turno3 = rs.getString("turno_segmento3");
			String turno4 = rs.getString("turno_segmento4");
			String turno5 = rs.getString("turno_segmento5");
			
			if (turno1==null) {
				
			} else if (turno1.equalsIgnoreCase("M")) {
				turno1 = "MANHÃ";
			} else if (turno1.equalsIgnoreCase("T")) {
				turno1 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno1 = "NOITE";
			}
			
			if (turno2==null) {
				
			} else if (turno2.equalsIgnoreCase("M")) {
				turno2 = "MANHÃ";
			} else if (turno2.equalsIgnoreCase("T")) {
				turno2 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno2 = "NOITE";
			}
			
			if (turno3==null) {
				
			} else if (turno3.equalsIgnoreCase("M")) {
				turno3 = "MANHÃ";
			} else if (turno3.equalsIgnoreCase("T")) {
				turno3 = "TARDE";				
			} else if (turno3.equalsIgnoreCase("N")) {
				turno3 = "NOITE";
			}
			
			if (turno4==null) {
				
			} else if (turno4.equalsIgnoreCase("M")) {
				turno4 = "MANHÃ";
			} else if (turno4.equalsIgnoreCase("T")) {
				turno4 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno4 = "NOITE";
			}
			
			if (turno5==null) {
				
			} else if (turno5.equalsIgnoreCase("M")) {
				turno5 = "MANHÃ";
			} else if (turno5.equalsIgnoreCase("T")) {
				turno5 = "TARDE";				
			} else if (turno5.equalsIgnoreCase("N")) {
				turno5 = "NOITE";
			}
			
			
			c = new Cult_matr_candidato(rs.getInt("id_candidato"),
					rs.getInt("id_responsavel"),
					rs.getString("nome_candidato"),
					rs.getString("mae_candidato"),
					rs.getString("pai_candidato"),
					rs.getString("nascimento_candidato"),
					rs.getString("estciv_candidato"),
					rs.getString("sexo_candidato"),
					rs.getString("nacionalidade_candidato"),
					rs.getString("email_candidato"),
					rs.getString("celular_candidato"),
					rs.getString("fixo_candidato"),
					rs.getString("bairro_candidato"),				
					rs.getInt("ano_candidato"),					
					rs.getString("nome_responsavel"),
					rs.getString("tipo_responsavel"),
					rs.getString("cpf_responsavel"),
					rs.getString("email_responsavel"),
					rs.getString("celular_responsavel"),
					rs.getString("identidade_responsavel"),
					rs.getString("emissoridt_responsavel"),
					rs.getString("tipo_endereco"), 
					rs.getString("identidade_endereco"), 
					rs.getString("cep_endereco"), 
					rs.getString("uf_endereco"), 
					rs.getString("logradouro_endereco"), 
					rs.getString("numero_endereco"), 
					rs.getString("complemento_endereco"), 
					rs.getString("codigo_municipio"), 
					rs.getString("bairro_endereco"), 
					rs.getString("tipo_candidato"), 
					rs.getString("necespec_candidato"), 
					rs.getString("cid_candidato"), 
					rs.getString("descricao_cid10"),
					rs.getInt("id_segmento1"),
					rs.getInt("id_segmento2"),
					rs.getInt("id_segmento3"),
					rs.getInt("id_segmento4"),
					rs.getInt("id_segmento5"),
					rs.getInt("id_segmento"),
					
					rs.getString("descricao_segmento1"),
					rs.getString("dia_segmento1"), turno1,
					
					rs.getString("descricao_segmento2"),
					rs.getString("dia_segmento2"), turno2,
					
					rs.getString("descricao_segmento3"),
					rs.getString("dia_segmento3"), turno3,
					
					rs.getString("descricao_segmento4"),
					rs.getString("dia_segmento4"), turno4,
					
					rs.getString("descricao_segmento5"),
					rs.getString("dia_segmento5"), turno5,
					rs.getString("cpf_candidato"),
					rs.getString("datainscricao_candidato"));

		}						  
		
		close();
		
		return c;
	}	
	

	
	public List<Cult_matr_candidato> buscarCandidatos(Cult_matr_candidato cand) throws Exception {
		List<Cult_matr_candidato> lista = new ArrayList<Cult_matr_candidato>();
		
		open();
		
		String statement = "select " + 
						   "a.id_responsavel, a.nome_candidato, a.mae_candidato, " +
						   "a.pai_candidato, a.nascimento_candidato, a.cpf_candidato, " +
						   "a.estciv_candidato, a.sexo_candidato, a.nacionalidade_candidato, a.email_candidato, " +
						   "a.celular_candidato, a.fixo_candidato, a.bairro_candidato, a.datainscricao_candidato, " + 
						   "a.id_segmento1, a.id_segmento2, a.id_segmento3, a.id_segmento4, a.id_segmento5, " +
						   "a.id_segmento, a.ano_candidato, a.id_candidato, a.tipo_candidato, a.necespec_candidato, a.cid_candidato, " +
						   "g.nome_responsavel, g.tipo_responsavel, g.cpf_responsavel,  " +
						   "g.email_responsavel, g.celular_responsavel, g.identidade_responsavel,  " +
						   "g.emissoridt_responsavel, " +
						   "h.tipo_endereco, h.identidade_endereco, h.cep_endereco,  " +
						   "h.uf_endereco, h.logradouro_endereco, h.numero_endereco,  " +
						   "h.complemento_endereco, h.codigo_municipio, h.bairro_endereco, " +
						   "i.descricao_cid10, " +
						   "b.descricao_segmento as descricao_segmento1, b.dia_segmento as dia_segmento1, b.turno_segmento as turno_segmento1, " +
						   "c.descricao_segmento as descricao_segmento2, c.dia_segmento as dia_segmento2, c.turno_segmento as turno_segmento2, " +
						   "d.descricao_segmento as descricao_segmento3, d.dia_segmento as dia_segmento3, d.turno_segmento as turno_segmento3, " +
						   "e.descricao_segmento as descricao_segmento4, e.dia_segmento as dia_segmento4, e.turno_segmento as turno_segmento4, " +
						   "f.descricao_segmento as descricao_segmento5, f.dia_segmento as dia_segmento5, f.turno_segmento as turno_segmento5 " +
						   "from " +
						   "  cult_matr_candidato a " +
						   "    left outer join cult_segmento b on (a.id_segmento1 = b.id_segmento) " +
						   "    left outer join cult_segmento c on (a.id_segmento2 = c.id_segmento) " +
						   "    left outer join cult_segmento d on (a.id_segmento3 = d.id_segmento) " +
						   "    left outer join cult_segmento e on (a.id_segmento4 = e.id_segmento) " +
						   "    left outer join cult_segmento f on (a.id_segmento5 = f.id_segmento) " +
						   "    left outer join cid10 i on (a.cid_candidato = i.codigo_cid10),  " +
						   "  edu_matr_responsavel g, end_endereco h " +
						   "where " +
						   "  a.id_responsavel = g.id_responsavel AND " +
						   "  a.id_candidato = h.identidade_endereco AND " +
						   "  h.tipo_endereco = 'U' ";
		

		
		if ((cand.getNome_candidato()!=null)&&(!cand.getNome_candidato().equalsIgnoreCase(""))) {
			statement = statement + " and nome_candidato like '%" + cand.getNome_candidato() + "%'";
		}
		
		if ((cand.getDescricao_segmento1()!=null)&&(!cand.getDescricao_segmento1().equalsIgnoreCase(""))) {
			statement = statement + " and descricao_segmento1 = '" + cand.getDescricao_segmento1() + "'";
		}
		
		if ((cand.getDia_segmento1()!=null)&&(!cand.getDia_segmento1().equalsIgnoreCase(""))) {
			statement = statement + " and dia_segmento1 = '" + cand.getDia_segmento1() + "'";
		}
		
		if ((cand.getCpf_candidato()!=null)&&(!cand.getCpf_candidato().equalsIgnoreCase(""))) {
			statement = statement + " and cpf_candidato = '" + cand.getCpf_candidato() + "'";
		}
		
		if ((cand.getTurno_segmento1()!=null)&&(!cand.getTurno_segmento1().equalsIgnoreCase(""))) {
			statement = statement + " and turno_segmento1 = '" + cand.getTurno_segmento1() + "'";
		}
		
		if ((cand.getAno_candidato()!=null)&&(cand.getAno_candidato()!=0)) {
			statement = statement + " and ano_candidato = " + cand.getAno_candidato();
		}		
		
		if ((!cand.getData_ini().equalsIgnoreCase("")) && (!cand.getData_fim().equalsIgnoreCase(""))) {
			statement = statement + " and STR_TO_DATE(a.datainscricao_candidato, '%d/%m/%Y') between STR_TO_DATE('" + cand.getData_ini() + "', '%d/%m/%Y') and STR_TO_DATE('" + cand.getData_fim() + "', '%d/%m/%Y')";					
		} else if (!cand.getData_ini().equalsIgnoreCase("")) {
			statement = statement + " and STR_TO_DATE(a.datainscricao_candidato, '%d/%m/%Y') = STR_TO_DATE('" + cand.getData_ini() + "', '%d/%m/%Y')";	
		}		

		stmt = con.prepareStatement(statement);

		rs = stmt.executeQuery();

		while (rs.next()) {
			
			String turno1 = rs.getString("turno_segmento1");
			String turno2 = rs.getString("turno_segmento2");
			String turno3 = rs.getString("turno_segmento3");
			String turno4 = rs.getString("turno_segmento4");
			String turno5 = rs.getString("turno_segmento5");
			
			if (turno1==null) {
				
			} else if (turno1.equalsIgnoreCase("M")) {
				turno1 = "MANHÃ";
			} else if (turno1.equalsIgnoreCase("T")) {
				turno1 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno1 = "NOITE";
			}
			
			if (turno2==null) {
				
			} else if (turno2.equalsIgnoreCase("M")) {
				turno2 = "MANHÃ";
			} else if (turno2.equalsIgnoreCase("T")) {
				turno2 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno2 = "NOITE";
			}
			
			if (turno3==null) {
				
			} else if (turno3.equalsIgnoreCase("M")) {
				turno3 = "MANHÃ";
			} else if (turno3.equalsIgnoreCase("T")) {
				turno3 = "TARDE";				
			} else if (turno3.equalsIgnoreCase("N")) {
				turno3 = "NOITE";
			}
			
			if (turno4==null) {
				
			} else if (turno4.equalsIgnoreCase("M")) {
				turno4 = "MANHÃ";
			} else if (turno4.equalsIgnoreCase("T")) {
				turno4 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno4 = "NOITE";
			}
			
			if (turno5==null) {
				
			} else if (turno5.equalsIgnoreCase("M")) {
				turno5 = "MANHÃ";
			} else if (turno5.equalsIgnoreCase("T")) {
				turno5 = "TARDE";				
			} else if (turno5.equalsIgnoreCase("N")) {
				turno5 = "NOITE";
			}			
			
			Cult_matr_candidato c = new Cult_matr_candidato(rs.getInt("id_candidato"),
					rs.getInt("id_responsavel"),
					rs.getString("nome_candidato"),
					rs.getString("mae_candidato"),
					rs.getString("pai_candidato"),
					rs.getString("nascimento_candidato"),
					rs.getString("estciv_candidato"),
					rs.getString("sexo_candidato"),
					rs.getString("nacionalidade_candidato"),
					rs.getString("email_candidato"),
					rs.getString("celular_candidato"),
					rs.getString("fixo_candidato"),
					rs.getString("bairro_candidato"),				
					rs.getInt("ano_candidato"),					
					rs.getString("nome_responsavel"),
					rs.getString("tipo_responsavel"),
					rs.getString("cpf_responsavel"),
					rs.getString("email_responsavel"),
					rs.getString("celular_responsavel"),
					rs.getString("identidade_responsavel"),
					rs.getString("emissoridt_responsavel"),
					rs.getString("tipo_endereco"), 
					rs.getString("identidade_endereco"), 
					rs.getString("cep_endereco"), 
					rs.getString("uf_endereco"), 
					rs.getString("logradouro_endereco"), 
					rs.getString("numero_endereco"), 
					rs.getString("complemento_endereco"), 
					rs.getString("codigo_municipio"), 
					rs.getString("bairro_endereco"), 
					rs.getString("tipo_candidato"), 
					rs.getString("necespec_candidato"), 
					rs.getString("cid_candidato"), 
					rs.getString("descricao_cid10"),
					rs.getInt("id_segmento1"),
					rs.getInt("id_segmento2"),
					rs.getInt("id_segmento3"),
					rs.getInt("id_segmento4"),
					rs.getInt("id_segmento5"),
					rs.getInt("id_segmento"),
					
					rs.getString("descricao_segmento1"),
					rs.getString("dia_segmento1"), turno1,
					
					rs.getString("descricao_segmento2"),
					rs.getString("dia_segmento2"), turno2,
					
					rs.getString("descricao_segmento3"),
					rs.getString("dia_segmento3"), turno3,
					
					rs.getString("descricao_segmento4"),
					rs.getString("dia_segmento4"), turno4,
					
					rs.getString("descricao_segmento5"),
					rs.getString("dia_segmento5"), turno5,
					rs.getString("cpf_candidato"),
					rs.getString("datainscricao_candidato"));
			
			lista.add(c);

		}						  
		
		close();
		
		return lista;
	}
	
	public List<Cult_matr_candidato> findCandidato(Integer Id) throws Exception {
		List<Cult_matr_candidato> lista = new ArrayList<Cult_matr_candidato>();
		
		open();
		
		String statement = "select " + 
						   "a.id_responsavel, a.nome_candidato, a.mae_candidato, " +
						   "a.pai_candidato, a.nascimento_candidato, a.cpf_candidato, " +
						   "a.estciv_candidato, a.sexo_candidato, a.nacionalidade_candidato, a.email_candidato, " +
						   "a.celular_candidato, a.fixo_candidato, a.bairro_candidato, a.datainscricao_candidato, " + 
						   "a.id_segmento1, a.id_segmento2, a.id_segmento3, a.id_segmento4, a.id_segmento5, " +
						   "a.id_segmento, a.ano_candidato, a.id_candidato, a.tipo_candidato, a.necespec_candidato, a.cid_candidato, " +
						   "g.nome_responsavel, g.tipo_responsavel, g.cpf_responsavel,  " +
						   "g.email_responsavel, g.celular_responsavel, g.identidade_responsavel,  " +
						   "g.emissoridt_responsavel, " +
						   "h.tipo_endereco, h.identidade_endereco, h.cep_endereco,  " +
						   "h.uf_endereco, h.logradouro_endereco, h.numero_endereco,  " +
						   "h.complemento_endereco, h.codigo_municipio, h.bairro_endereco, " +
						   "i.descricao_cid10, " +
						   "b.descricao_segmento as descricao_segmento1, b.dia_segmento as dia_segmento1, b.turno_segmento as turno_segmento1, " +
						   "c.descricao_segmento as descricao_segmento2, c.dia_segmento as dia_segmento2, c.turno_segmento as turno_segmento2, " +
						   "d.descricao_segmento as descricao_segmento3, d.dia_segmento as dia_segmento3, d.turno_segmento as turno_segmento3, " +
						   "e.descricao_segmento as descricao_segmento4, e.dia_segmento as dia_segmento4, e.turno_segmento as turno_segmento4, " +
						   "f.descricao_segmento as descricao_segmento5, f.dia_segmento as dia_segmento5, f.turno_segmento as turno_segmento5 " +
						   "from " +
						   "  cult_matr_candidato a " +
						   "    left outer join cult_segmento b on (a.id_segmento1 = b.id_segmento) " +
						   "    left outer join cult_segmento c on (a.id_segmento2 = c.id_segmento) " +
						   "    left outer join cult_segmento d on (a.id_segmento3 = d.id_segmento) " +
						   "    left outer join cult_segmento e on (a.id_segmento4 = e.id_segmento) " +
						   "    left outer join cult_segmento f on (a.id_segmento5 = f.id_segmento) " +
						   "    left outer join cid10 i on (a.cid_candidato = i.codigo_cid10),  " +
						   "  edu_matr_responsavel g, end_endereco h " +
						   "where " +
						   "  a.id_candidato = '" + Id + "' and " +
						   "  a.id_responsavel = g.id_responsavel AND " +
						   "  a.id_candidato = h.identidade_endereco AND " +
						   "  h.tipo_endereco = 'U' ";
		
		stmt = con.prepareStatement(statement);
		
		//System.out.println(statement);
		
		rs = stmt.executeQuery();
		
		
		
		if (rs.next()) {
			
			String turno1 = rs.getString("turno_segmento1");
			String turno2 = rs.getString("turno_segmento2");
			String turno3 = rs.getString("turno_segmento3");
			String turno4 = rs.getString("turno_segmento4");
			String turno5 = rs.getString("turno_segmento5");
			
			if (turno1==null) {
				
			} else if (turno1.equalsIgnoreCase("M")) {
				turno1 = "MANHÃ";
			} else if (turno1.equalsIgnoreCase("T")) {
				turno1 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno1 = "NOITE";
			}
			
			if (turno2==null) {
				
			} else if (turno2.equalsIgnoreCase("M")) {
				turno2 = "MANHÃ";
			} else if (turno2.equalsIgnoreCase("T")) {
				turno2 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno2 = "NOITE";
			}
			
			if (turno3==null) {
				
			} else if (turno3.equalsIgnoreCase("M")) {
				turno3 = "MANHÃ";
			} else if (turno3.equalsIgnoreCase("T")) {
				turno3 = "TARDE";				
			} else if (turno3.equalsIgnoreCase("N")) {
				turno3 = "NOITE";
			}
			
			if (turno4==null) {
				
			} else if (turno4.equalsIgnoreCase("M")) {
				turno4 = "MANHÃ";
			} else if (turno4.equalsIgnoreCase("T")) {
				turno4 = "TARDE";				
			} else if (turno1.equalsIgnoreCase("N")) {
				turno4 = "NOITE";
			}
			
			if (turno5==null) {
				
			} else if (turno5.equalsIgnoreCase("M")) {
				turno5 = "MANHÃ";
			} else if (turno5.equalsIgnoreCase("T")) {
				turno5 = "TARDE";				
			} else if (turno5.equalsIgnoreCase("N")) {
				turno5 = "NOITE";
			}
			
			
			Cult_matr_candidato c = new Cult_matr_candidato(rs.getInt("id_candidato"),
					rs.getInt("id_responsavel"),
					rs.getString("nome_candidato"),
					rs.getString("mae_candidato"),
					rs.getString("pai_candidato"),
					rs.getString("nascimento_candidato"),
					rs.getString("estciv_candidato"),
					rs.getString("sexo_candidato"),
					rs.getString("nacionalidade_candidato"),
					rs.getString("email_candidato"),
					rs.getString("celular_candidato"),
					rs.getString("fixo_candidato"),
					rs.getString("bairro_candidato"),				
					rs.getInt("ano_candidato"),					
					rs.getString("nome_responsavel"),
					rs.getString("tipo_responsavel"),
					rs.getString("cpf_responsavel"),
					rs.getString("email_responsavel"),
					rs.getString("celular_responsavel"),
					rs.getString("identidade_responsavel"),
					rs.getString("emissoridt_responsavel"),
					rs.getString("tipo_endereco"), 
					rs.getString("identidade_endereco"), 
					rs.getString("cep_endereco"), 
					rs.getString("uf_endereco"), 
					rs.getString("logradouro_endereco"), 
					rs.getString("numero_endereco"), 
					rs.getString("complemento_endereco"), 
					rs.getString("codigo_municipio"), 
					rs.getString("bairro_endereco"), 
					rs.getString("tipo_candidato"), 
					rs.getString("necespec_candidato"), 
					rs.getString("cid_candidato"), 
					rs.getString("descricao_cid10"),
					rs.getInt("id_segmento1"),
					rs.getInt("id_segmento2"),
					rs.getInt("id_segmento3"),
					rs.getInt("id_segmento4"),
					rs.getInt("id_segmento5"),
					rs.getInt("id_segmento"),
					
					rs.getString("descricao_segmento1"),
					rs.getString("dia_segmento1"), turno1,
					
					rs.getString("descricao_segmento2"),
					rs.getString("dia_segmento2"), turno2,
					
					rs.getString("descricao_segmento3"),
					rs.getString("dia_segmento3"), turno3,
					
					rs.getString("descricao_segmento4"),
					rs.getString("dia_segmento4"), turno4,
					
					rs.getString("descricao_segmento5"),
					rs.getString("dia_segmento5"), turno5,
					rs.getString("cpf_candidato"),
					rs.getString("datainscricao_candidato"));
			
			lista.add(c);

		}						  
		
		close();
		
		return lista;
	}	
	
	public void cancelaInscricao(Cult_matr_candidato cand) throws Exception {
		open();
		
		stmt = con.prepareStatement("delete from cult_matr_candidato where id_candidato = ?");
		
		stmt.setInt(1, cand.getId_candidato());
		
		Integer linhasafetadas = stmt.executeUpdate();
		
		if (linhasafetadas==0) {
			throw new Exception("Erro ao cancelar candidato");
		} else {
			stmt = con.prepareStatement("delete from end_endereco where identidade_endereco = ? and tipo_endereco = 'U'");
			
			stmt.setInt(1, cand.getId_candidato());
			
			stmt.executeUpdate();
		}
		
		close();
	}

}
