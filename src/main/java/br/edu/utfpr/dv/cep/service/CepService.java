package br.edu.utfpr.dv.cep.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.edu.utfpr.dv.cep.model.Cidade;
import br.edu.utfpr.dv.cep.model.Estado;

@WebService
@SOAPBinding(style = Style.RPC)
public interface CepService {

	@WebMethod
	public Estado[] listarEstados();
	
	@WebMethod
	public Estado[] listarPorPopulacao();
	
	@WebMethod
	public Cidade[] listarCidadesPorEstado(String sigla);

	@WebMethod
	public Cidade[] listarPorPopulacaoNoEstado(String sigla);
	
	@WebMethod
	public Cidade[] buscarCidade(String nome);
	
}
