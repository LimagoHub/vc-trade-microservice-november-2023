package de.vctrade.smartbank24loanapplicationscoring.application.events.service;


import de.vctrade.smartbank24loanapplicationscoring.application.events.ScoringEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
    @RequiredArgsConstructor
    public class EventService{

        private static final String SCORING_POSITIV ="scoringpositive-out-0";
        private static final String SCORING_NEGATIV ="scoringnegative-out-0";
        private final StreamBridge bridge;

        public void publishScoringPositivEvent(UUID id) {
            ScoringEvent event = ScoringEvent.builder().creditApplicationId(id).build();
            bridge.send(SCORING_POSITIV, event);
        }


        public void publishScoringNegativEvent(UUID id) {
            ScoringEvent event = ScoringEvent.builder().creditApplicationId(id).build();
            bridge.send(SCORING_NEGATIV, event);
        }



}
