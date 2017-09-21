package ruixue.etl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ruixue.etl.entity.DimPlayer;

@Repository
public interface JpaRepositoryDimPlayer extends JpaRepository<DimPlayer,Long> {
	public DimPlayer findByValidToIsNullAndPlayerID(long playerId);
}
