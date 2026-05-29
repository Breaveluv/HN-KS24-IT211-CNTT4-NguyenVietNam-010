package com.example.nguyenvietnam_cntt4_010.dto;

import com.example.nguyenvietnam_cntt4_010.model.entity.statusEnum;
import lombok.Data;

@Data
public class PostResponseDTO {
    private Long id;
    private String username;
    private String content;
    private Integer likes;
    private statusEnum status;
    private Boolean is_deleted;
}
