package com.example.java_backend_demo.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

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
