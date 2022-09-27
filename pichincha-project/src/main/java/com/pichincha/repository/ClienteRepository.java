package com.pichincha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pichincha.entity.Cliente;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
