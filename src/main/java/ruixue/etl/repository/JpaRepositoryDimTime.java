package ruixue.etl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ruixue.etl.entity.DimTime;

@Repository
public interface JpaRepositoryDimTime extends JpaRepository<DimTime,Integer> {

	public DimTime findByYearAndMonthAndDay(int year, int month, int day);
}
