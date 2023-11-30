package de.vctrade.smartbank24loanapplicationstore.adapter.mapper;


import de.vctrade.smartbank24loanapplicationstore.adapter.event.LoanApplicationEvent;
import de.vctrade.smartbank24loanapplicationstore.domain.event.LoanApplicationAcceptedLocalEvent;
import de.vctrade.smartbank24loanapplicationstore.domain.event.LoanApplicationDeniedLocalEvent;
import de.vctrade.smartbank24loanapplicationstore.domain.event.LoanApplicationPersistiertLocalEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanApplicationLocalEventToDomainEventMapper {

    @Mapping(source="loanApplication", target="loanApplicationDTO")
    @Mapping(target = "eventID", ignore = true)
    @Mapping(target = "eventTimestamp", ignore = true)
    LoanApplicationEvent convert(LoanApplicationPersistiertLocalEvent loanApplicationPersistiertLocalEvent);
    @Mapping(source="loanApplication", target="loanApplicationDTO")
    @Mapping(target = "eventID", ignore = true)
    @Mapping(target = "eventTimestamp", ignore = true)
    LoanApplicationEvent convert(LoanApplicationAcceptedLocalEvent loanApplicationAcceptedLocalEvent);
    @Mapping(source="loanApplication", target="loanApplicationDTO")
    @Mapping(target = "eventID", ignore = true)
    @Mapping(target = "eventTimestamp", ignore = true)
    LoanApplicationEvent convert(LoanApplicationDeniedLocalEvent loanApplicationDeniedLocalEvent);
}
