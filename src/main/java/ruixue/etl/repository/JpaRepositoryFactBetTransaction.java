package ruixue.etl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ruixue.etl.entity.FactBetTransaction;
@Repository
public interface JpaRepositoryFactBetTransaction extends JpaRepository<FactBetTransaction,String> {

}
