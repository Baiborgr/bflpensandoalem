package com.fabricio.bflprototipo.repository;
import org.springframework.data.repository.CrudRepository;
import com.fabricio.bflprototipo.models.Usuario;
public interface BflRepository extends CrudRepository<Usuario, Long> {

}
