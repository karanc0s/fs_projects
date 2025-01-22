package com.karan.notes.audit;

import jakarta.persistence.Column;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditIMPL")
public class AuditIMPL implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("USER_R_MS");
    }
}
