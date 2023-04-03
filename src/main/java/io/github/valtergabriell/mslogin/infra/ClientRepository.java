package io.github.valtergabriell.mslogin.infra;

import io.github.valtergabriell.mslogin.application.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByUsername(String username);

}
