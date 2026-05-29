package com.example.nguyenvietnam_cntt4_010.model.dto;

import com.example.nguyenvietnam_cntt4_010.model.entity.statusEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostRequestDTO {
    @NotBlank(message = "Tên tài khoản không được để trống")
    private String username;

    @NotBlank(message = "Nội dung bài viết không được để trống")
    private String content;

    @NotNull(message = "Số lượt thích không được để trống")
    @Min(value = 0, message = "Số lượt thích phải lớn hơn hoặc bằng 0")
    private Integer likes;

    @NotNull(message = "Trạng thái bài viết không được để trống")
    private statusEnum status;


}
