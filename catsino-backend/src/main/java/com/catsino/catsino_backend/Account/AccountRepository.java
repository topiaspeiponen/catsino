package com.catsino.catsino_backend.Account;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, UUID> {}