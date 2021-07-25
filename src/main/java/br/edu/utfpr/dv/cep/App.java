package br.edu.utfpr.dv.cep;

import java.sql.SQLException;

import javax.xml.ws.Endpoint;

import br.edu.utfpr.dv.cep.dao.CidadeDAO;
import br.edu.utfpr.dv.cep.dao.EstadoDAO;
import br.edu.utfpr.dv.cep.model.Cidade;
import br.edu.utfpr.dv.cep.model.Estado;
import br.edu.utfpr.dv.cep.service.CepServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	try {
    		new EstadoDAO().listarPorPopulacao().toArray(new Estado[] {});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Endpoint.publish("http://localhost:8081/cep", new CepServiceImpl());
    }
}
