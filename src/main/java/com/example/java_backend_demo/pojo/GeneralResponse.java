package com.example.java_backend_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {
    private ApiMsg apiMsg;
    private Object Data;

    public GeneralResponse(ApiMsg apiMsg){
        this.apiMsg = apiMsg;
    }
}
