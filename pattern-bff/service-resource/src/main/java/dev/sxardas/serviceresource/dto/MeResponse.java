package dev.sxardas.serviceresource.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record MeResponse(

        String subject,

        List<String> authorities

) {
}
