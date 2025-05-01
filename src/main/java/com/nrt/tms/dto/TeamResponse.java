package com.nrt.tms.dto;

import java.util.List;

public record TeamResponse(Long id, String name, String description, List<MemberResponse> members) {
    public record MemberResponse(String employeeCode, String name, String email, String role) {
    }
}
