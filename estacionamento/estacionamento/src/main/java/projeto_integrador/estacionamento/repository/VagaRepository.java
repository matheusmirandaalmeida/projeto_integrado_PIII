package projeto_integrador.estacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import projeto_integrador.estacionamento.entity.Vaga;

public interface VagaRepository extends CrudRepository<Vaga, Integer> {
}
