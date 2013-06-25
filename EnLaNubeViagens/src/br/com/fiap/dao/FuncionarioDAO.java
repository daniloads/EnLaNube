package br.com.fiap.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.Endereco;

public class FuncionarioDAO extends Dao{

	private final String INSERT_QUERY = "INSERT INTO enlanube.funcionario(user,senha,cpf,nome,dtNascimento,email,telefone,endereco," +
			 															 "numero,estado,cep,complemento,cargo)" +
			 												      "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT_ALL_QUERY = "SELECT * FROM enlalube.funcionario";
	private final String SELECT_BY_ID = "SELECT * FROM enlalube.funcionario where idcliente = ?";
	private final String SELECT_BY_USER_SENHA = "SELECT * FROM enlalube.funcionario where user = ? AND senha = ?";
	
	public String save(Cliente cliente) throws Exception{
		String msg = null;
		
		try{
			abreConexao();
			st = cn.prepareStatement(INSERT_QUERY);
			st.setString(1,cliente.getUser()); 
			st.setString(2,cliente.getSenha());
			st.setInt(3,cliente.getCpf());
			st.setString(4,cliente.getNome());
			st.setDate(5,(Date)cliente.getDtNascto().getTime());
			st.setString(6,cliente.getEmail());
			st.setInt(7,cliente.getTelefone());
			st.setString(8,cliente.getEndereco().getEndereco());
			st.setInt(9,cliente.getEndereco().getNumero());
			st.setString(10,cliente.getEndereco().getEstado());
			st.setString(11,cliente.getEndereco().getEstado());
			st.setInt(12,cliente.getEndereco().getCep());
			st.setString(13,cliente.getEndereco().getComplemento());
			
			int cont =  st.executeUpdate();
            
            if(cont==0){
            	msg = "Erro ao cadastrar o Cliente!";
            }else
            {
            	msg = "Produto cadastrado com sucesso!";
            }
            
		}catch(Exception e){

			e.printStackTrace();
		}finally{
			
			super.fechaConexao();
		}
		
		return msg;		
	}
	
	public List<Cliente> getTodosClientes() throws Exception{
		
		ResultSet rs = null;
		
		List<Cliente> listaUsuario = new ArrayList<Cliente>();
		
		try{
			abreConexao();
			st = cn.prepareStatement(SELECT_ALL_QUERY);
			rs = st.executeQuery();
			
			while(rs.next()){
				listaUsuario.add(populaCliente());				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			super.fechaConexao();
		}
		
		
		return listaUsuario;
	}
	
	
	public Cliente getClienteById(int id) throws Exception{
		
		Cliente cliente = null;
		
		try{
			abreConexao();
			st = cn.prepareStatement(SELECT_BY_ID);
			rs = st.executeQuery();
			st.setInt(3,id);
			rs = st.executeQuery();
			
			cliente =  populaCliente();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{		
			super.fechaConexao();
		}
			
		return cliente;
	}
	
	public Cliente validaCliente(String user, String senha) throws Exception{
		
		Cliente cliente = null;
		
		try{
			abreConexao();
			st = cn.prepareStatement(SELECT_BY_USER_SENHA);
			rs = st.executeQuery();
			st.setString(1,user);
			st.setString(2,senha);
			rs = st.executeQuery();
			
			cliente =  populaCliente();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{		
			super.fechaConexao();
		}
			
		return cliente;

	}
	
	
	public Cliente get(int id) throws Exception{
		
		Cliente cliente = null;
		
		try{
			abreConexao();
			st = cn.prepareStatement(SELECT_BY_ID);
			rs = st.executeQuery();
			st.setInt(3,id);
			rs = st.executeQuery();
			
			cliente =  populaCliente();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{		
			super.fechaConexao();
		}
			

		return cliente;


	}
	
	
	protected Cliente populaCliente() throws SQLException{
		
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		cliente.setId(rs.getInt("id"));
		cliente.setUser(rs.getString("user"));
		cliente.setSenha(rs.getString("senha"));
		cliente.setCpf(rs.getInt("cpf"));
		cliente.setNome(rs.getString("nome"));
		cliente.setDtNascto(rs.getDate("dtNascmento"));		
		cliente.setEmail(rs.getString("email"));
		cliente.setTelefone(rs.getInt("telefone"));
		
		endereco.setEndereco(rs.getString("endereco"));
		endereco.setNumero(rs.getInt("numero"));
		endereco.setCep(rs.getInt("cep"));	
		endereco.setComplemento(rs.getString("complemento"));
		endereco.setEstado(rs.getString("estado"));
		
		cliente.setEndereco(endereco);
		
		return cliente;
		
	}
	
	
}
