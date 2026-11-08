package dev.sxardas.serviceweb.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record MeResponse(

        String subject,

        List<String> authorities

) {
}
