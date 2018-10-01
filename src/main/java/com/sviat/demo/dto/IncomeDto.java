package com.sviat.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IncomeDto {
	java.time.LocalDateTime start;
	LocalDateTime end;
	Map<SessionPeriod, BigDecimal> periodMap;
	BigDecimal generalIncome;
}
