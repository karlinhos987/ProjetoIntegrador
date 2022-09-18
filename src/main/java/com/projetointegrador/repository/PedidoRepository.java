package com.projetointegrador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	public List<Pedido>findByValorTotal(float valorTotal);
	
	public Optional<Pedido>findById(Long id_pedido);

}