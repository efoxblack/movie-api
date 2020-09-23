package org.yearup.moviecatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yearup.moviecatalog.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
