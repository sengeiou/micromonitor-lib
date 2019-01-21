package de.vispiron.carsync.microclient.rest;

import com.codahale.metrics.annotation.Timed;
import io.undertow.security.idm.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    private final Logger log = LoggerFactory.getLogger(ApiRestController.class);

    public ApiRestController() {
    }

    @GetMapping("/account/{id}/get")
    @Timed
    public ResponseEntity<Account> getAccount(@Valid @NotNull @PathVariable int id) {
        return null;
    }

    @PostMapping("/account")
    @Timed
    public ResponseEntity<Account> createAccount(@Valid @NotNull @RequestBody Account account) {
        return null;
    }

    @PutMapping("/account/{id}/delete")
    @Timed
    public ResponseEntity<Account> deleteAccount(@Valid @NotNull @PathVariable int id) {
        return null;
    }

}
