package net.sw.restApplication.reposetry;

import net.sw.restApplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Customer} class.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
