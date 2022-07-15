package com.example.java_backend_demo.util;

import com.example.java_backend_demo.Pojo.ApiMsg;

public class LocalApiMsg {
    public static final ApiMsg Success = new ApiMsg(1000, "Success", "Success");
    public static final ApiMsg UserAlreadyExist = new ApiMsg(2001, "User already exist", "Please select other user id");
    public static final ApiMsg UserNotFound = new ApiMsg(2002, "User not found", "User not found");
    public static final ApiMsg AuthorizationFail = new ApiMsg(2003, "Authorization fail", "Authorization fail");
    public static final ApiMsg SystemError = new ApiMsg(2000, "System Error", "SystemError, please try again Later");
    public static final ApiMsg SomeFieldEmpty = new ApiMsg(3000, "Empty field Error", "Please filled up the required field");
    public static final ApiMsg DataNotValid = new ApiMsg(3000, "Data Not Valid", "Input Data Not Valid");
    public static final ApiMsg SessionExpired = new ApiMsg(4000, "Session Expire", "Session Expired, please login again");
}
