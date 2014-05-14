package ru.qwazer.jpa.one2one.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.qwazer.jpa.one2one.domain.simple.Address;

/**
 * @author ar
 * @since Date: 14.05.2014
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
