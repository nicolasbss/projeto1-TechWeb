package br.edu.insper.techweb.projeto1;

import java.util.Calendar;

public class Notas {
	
	private int id;
	private String conteudo;
	private String tipo;
	private String datetime;
	private int pessoa_id;
	private String data_atualizada;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDateTime() {
		return this.datetime;
	}
	
	public void setDateTime() {
		Calendar c = Calendar.getInstance();
		 String dateTime = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
		this.datetime = dateTime;
	}
	
	public String getDataAtualizada() {
		return this.data_atualizada;
	}
	
	public void setDataAtualizada(String data_atualizada) {
		this.data_atualizada = data_atualizada;
	}
	
	public String getConteudo() {
		return this.conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public Integer getPessoa_id() {
		return this.pessoa_id;
	}
	
	public void setPessoa_id(Integer pessoa_id) {
		this.pessoa_id = pessoa_id; 
	}
	
	
}
