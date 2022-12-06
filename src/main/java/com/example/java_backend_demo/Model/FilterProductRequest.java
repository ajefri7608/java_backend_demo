package com.example.java_backend_demo.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterProductRequest {
    private Integer highestPrice;
    private Integer lowestPrice;


}
