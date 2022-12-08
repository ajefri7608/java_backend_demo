package com.example.java_backend_demo.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginateProductRequest {
    private Integer elementEachPage;
    private Integer page;

}
