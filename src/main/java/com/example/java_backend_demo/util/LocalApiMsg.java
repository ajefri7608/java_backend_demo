package com.example.java_backend_demo.util;

import com.example.java_backend_demo.pojo.ApiMsg;

public class LocalApiMsg {
    public static final ApiMsg Success = new ApiMsg(1000, "Success", "Success");
    public static final ApiMsg UserAlreadyExist = new ApiMsg(1000, "User already exist", "Please select other user id");
    public static final ApiMsg SystemError = new ApiMsg(2000, "System Error", "SystemError, please try again Later");
    public static final ApiMsg SomeFieldEmpty = new ApiMsg(3000, "Empty field Error", "Please filled up the required field");
    public static final ApiMsg DataNotValid = new ApiMsg(3000, "Data Not Valid", "Input Data Not Valid");
}
