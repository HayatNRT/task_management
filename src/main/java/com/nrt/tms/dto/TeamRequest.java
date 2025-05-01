package com.nrt.tms.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;
@NotBlank
public record TeamRequest(String name,
                          String description,
                          String leadId, Set<String> membersId) {
}
