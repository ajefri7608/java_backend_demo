package com.example.java_backend_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class GeneralResponse {
    private ApiMsg apiMsg;
    private Object data;

    public GeneralResponse(ApiMsg apiMsg){
        this.apiMsg = apiMsg;
    }
    public GeneralResponse(ApiMsg apiMsg, Object data){
        this.apiMsg = apiMsg;
        this.data = data;
    }
}
