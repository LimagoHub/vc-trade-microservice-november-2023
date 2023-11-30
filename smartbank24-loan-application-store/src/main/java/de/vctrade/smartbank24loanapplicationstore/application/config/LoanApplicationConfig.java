package de.vctrade.smartbank24loanapplicationstore.application.config;


import de.vctrade.smartbank24loanapplicationstore.domain.event.LocalEventPublisher;
import de.vctrade.smartbank24loanapplicationstore.domain.repository.LoanApplicationRepository;
import de.vctrade.smartbank24loanapplicationstore.domain.service.LoanApplicationService;
import de.vctrade.smartbank24loanapplicationstore.domain.service.internal.LoanApplicationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanApplicationConfig {

    @Bean
    public LoanApplicationService createKreditantragService(LoanApplicationRepository repo, LocalEventPublisher publisher) {
        return new LoanApplicationServiceImpl(repo, publisher);
    }
}
