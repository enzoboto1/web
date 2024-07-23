package com.rungroop.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.rungroop.web.models.UserEntity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDto {
    
    private Long id;
    @NotEmpty(message = "Título não pode ser vazio!")
    private String title;
    @Size(max = 255, message = "Quantidade máxima de caracteres ultrapassada!")
    @NotEmpty(message = "FotoUrl não pode ser vazio!")
    private String photoUrl;
    @NotEmpty(message = "Conteúdo não pode ser vazio!")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private UserEntity createdBy;
    private List<EventDto> events;
}
