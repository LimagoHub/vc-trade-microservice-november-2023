package de.vctrade.smartbank24loanapplicationstore.adapter.event;


import de.vctrade.smartbank24loanapplicationstore.adapter.dto.LoanApplicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class LoanApplicationEvent extends BaseEvent{
    private LoanApplicationDTO loanApplicationDTO;
}
