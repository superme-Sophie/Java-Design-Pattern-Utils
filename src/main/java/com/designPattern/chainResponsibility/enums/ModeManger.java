package com.designPattern.chainResponsibility.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModeManger {

    private ExecutionMode executionMode;
    private SequenceMode sequenceMode;
    private WeightedMode weightedMode;
}
