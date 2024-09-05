package by.moiseenko.ecommerce.repository;

import by.moiseenko.ecommerce.domain.Country;

import java.util.Optional;

public interface CountryRepository extends BaseRepository<Country, Long> {

    Optional<Country> findByName(String name);
}
