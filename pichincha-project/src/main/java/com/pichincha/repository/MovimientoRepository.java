package com.pichincha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pichincha.entity.Movimiento;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
import com.pichincha.response.EstadoCuentaDto;
@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

	@Query("select new com.pichincha.response.EstadoCuentaDto(p.nombre, c.clave, cc.numeroCuenta, cc.tipoCuenta, "
			+ "cc.saldo, m.fecha, m.tipoMovimiento, m.saldo)  "
			+ "from Persona p join Cliente c on p.id = c.personaId "
			+ "join Cuenta cc on cc.idCliente = c.id "
			+ "join Movimiento m on (m.idCuenta  = cc.id) ")
	List<EstadoCuentaDto> findByEstadoCuenta();
}