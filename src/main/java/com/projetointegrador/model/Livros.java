package com.projetointegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_livros", uniqueConstraints={@UniqueConstraint(columnNames={"isbn"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_livros;
	
	@NotNull
	@URL
	private String capa;

	@NotNull
	private String titulo;
	
	@Size(max=5000)
	private String descricao;
	
	private String autor;
	
	@NotNull
	private int qtdeEstoque;
	
	@NotNull
	private int isbn;
	
	@NotNull
	private Double valorUnitario;
	
	private int qtdePedidoLivro;
	
	/*@ManyToMany(cascade = CascadeType.MERGE)
	
	@JoinTable(
			name = "etiqueta_livros", 
			uniqueConstraints = @UniqueConstraint(columnNames = {"etiqueta_fk", "livros_fk"}),
			joinColumns = {@JoinColumn(name = "etiqueta_fk")}, 
			inverseJoinColumns = {@JoinColumn(name = "livros_fk")})
			*/
	@ManyToOne
	@JsonIgnoreProperties({"livros"})
	private Etiqueta etiqueta;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"livros", "cliente"})
	@JoinTable(
			name = "pedido_livros",
			joinColumns = {@JoinColumn(name = "livros_fk")}, 
			inverseJoinColumns = {@JoinColumn(name = "pedido_fk")})
	private List<Pedido> pedido;
	
	@ManyToOne
	@JsonIgnoreProperties({"livros", "senha", "codf"})
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	public Long getId_livros() {
		return id_livros;
	}

	public void setId_livros(Long id_livros) {
		this.id_livros = id_livros;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public int getQtdePedidoLivro() {
		return qtdePedidoLivro;
	}

	public void setQtdePedidoLivro(int qtdePedidoLivro) {
		this.qtdePedidoLivro = qtdePedidoLivro;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	
}
