package de.vctrade.smartbank24loanapplicationstore.domain.service.internal;

import de.vctrade.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;
import de.vctrade.smartbank24loanapplicationstore.domain.aggregate.StatusChange;
import de.vctrade.smartbank24loanapplicationstore.domain.event.LoanApplicationAcceptedLocalEvent;
import de.vctrade.smartbank24loanapplicationstore.domain.event.LoanApplicationDeniedLocalEvent;
import de.vctrade.smartbank24loanapplicationstore.domain.event.LoanApplicationPersistiertLocalEvent;
import de.vctrade.smartbank24loanapplicationstore.domain.event.LocalEventPublisher;
import de.vctrade.smartbank24loanapplicationstore.domain.repository.LoanApplicationRepository;
import de.vctrade.smartbank24loanapplicationstore.domain.service.LoanApplicationService;
import de.vctrade.smartbank24loanapplicationstore.domain.service.LoanApplicationServiceException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService {
    private final LoanApplicationRepository repo;
    private final LocalEventPublisher publisher;

    @Override
    public void speichereKreditantrag(LoanApplication antrag) throws LoanApplicationServiceException {
        try {
            this.speichereOderAendereKreditantrag(antrag);
            publisher.sende(LoanApplicationPersistiertLocalEvent.builder().loanApplication(antrag).build());
        } catch (RuntimeException e) {
            throw new LoanApplicationServiceException(e);
        }
    }

    private void speichereOderAendereKreditantrag(LoanApplication antrag) throws LoanApplicationServiceException {
        try {
            repo.anlegen(antrag);
        } catch (RuntimeException e) {
            throw new LoanApplicationServiceException(e);
        }
    }

    @Override
    public void verarbeitePositivesScoring(UUID id) throws LoanApplicationServiceException {
        LoanApplication antrag = findeKreditantragMitId(id);
        final StatusChange statuswechsel = antrag.behandlePositivesScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == StatusChange.FINAL) {
            publisher.sende(LoanApplicationAcceptedLocalEvent.builder().loanApplication(antrag).build());
        }
    }

    @Override
    public void verarbeitePositivesCityScoring(UUID id) throws LoanApplicationServiceException {
        LoanApplication antrag = findeKreditantragMitId(id);
        final StatusChange statuswechsel = antrag.behandlePositivesCityScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == StatusChange.FINAL) {
            publisher.sende(LoanApplicationAcceptedLocalEvent.builder().loanApplication(antrag).build());
        }
    }

    @Override
    public void verarbeiteNegativesScoring(UUID id) throws LoanApplicationServiceException {
        LoanApplication antrag = findeKreditantragMitId(id);
        final StatusChange statuswechsel = antrag.behandleNegativesScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == StatusChange.FINAL) {
            publisher.sende(LoanApplicationDeniedLocalEvent.builder().loanApplication(antrag).build());
        }
    }

    @Override
    public void verarbeiteNegativesCityScoring(UUID id) throws LoanApplicationServiceException {
        LoanApplication antrag = findeKreditantragMitId(id);
        final StatusChange statuswechsel = antrag.behandleNegativesCityScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == StatusChange.FINAL) {
            publisher.sende(LoanApplicationDeniedLocalEvent.builder().loanApplication(antrag).build());
        }
    }

    @Override
    public LoanApplication findeKreditantragMitId(UUID id) throws LoanApplicationServiceException {
        return repo.findeAntragNachId(id).orElseThrow(()->new LoanApplicationServiceException("Huh?"));
    }
}
