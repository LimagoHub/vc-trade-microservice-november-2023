package de.vctrade.smartbank24loanapplicationscoring.domain.aggregates;

import lombok.*;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class LoanApplication {
    private UUID creditApplicationId ;


    private double monthlyIncome;

    private double monthlyExpenditure;

    private double creditSum;

    public boolean isSolvent() {
        return creditSum < (monthlyIncome-monthlyExpenditure) * 10.0;
    }
}
