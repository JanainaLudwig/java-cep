package br.edu.utfpr.dv.cep.service;

import java.sql.SQLException;

import javax.jws.WebService;

import br.edu.utfpr.dv.cep.dao.CidadeDAO;
import br.edu.utfpr.dv.cep.dao.EstadoDAO;
import br.edu.utfpr.dv.cep.model.Cidade;
import br.edu.utfpr.dv.cep.model.Estado;

@WebService(endpointInterface = "br.edu.utfpr.dv.cep.service.CepService")
public class CepServiceImpl implements CepService {

	public Estado[] listarEstados() {
		try {
			return new EstadoDAO().listar().toArray(new Estado[] {});
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Estado[] listarPorPopulacao() {
		try {
			return new EstadoDAO().listarPorPopulacao().toArray(new Estado[] {});
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Cidade[] listarCidadesPorEstado(String sigla) {
		try {
			return new CidadeDAO().listarPorEstado(sigla).toArray(new Cidade[] {});
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Cidade[] listarPorPopulacaoNoEstado(String sigla) {
		try {
			return new CidadeDAO().listarPorPopulacaoNoEstado(sigla).toArray(new Cidade[] {});
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Cidade[] buscarCidade(String nome) {
		try {
			return new CidadeDAO().buscarCidade(nome).toArray(new Cidade[] {});
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
