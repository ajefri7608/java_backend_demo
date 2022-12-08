package com.example.java_backend_demo.util;

import com.example.java_backend_demo.Model.ApiMsg;

public class LocalApiMsg {
    public static final ApiMsg Success = new ApiMsg(1000, "Success", "Success");
    public static final ApiMsg SomeFieldEmpty = new ApiMsg(2001, "Empty field Error", "Please filled up the required field");
    public static final ApiMsg UserAlreadyExist = new ApiMsg(4001, "User already exist", "Please select other user id");
    public static final ApiMsg UserNotFound = new ApiMsg(4002, "User not found", "User not found");
    public static final ApiMsg AuthorizationFail = new ApiMsg(4003, "Authorization fail", "Authorization fail");
    public static final ApiMsg SystemError = new ApiMsg(4004, "System Error", "SystemError, please try again Later");
    public static final ApiMsg DataNotValid = new ApiMsg(4005, "Data Not Valid", "Input Data Not Valid");
    public static final ApiMsg UserInfoNotValid = new ApiMsg(4005, "Data Not Valid", "User name or Password Not Valid");
    public static final ApiMsg SessionExpired = new ApiMsg(4006, "Session Expire", "Session Expired, please login again");
    public static final ApiMsg MissingParam = new ApiMsg(4009, "Missing Required Params", "Missing Required Params");
    public static final ApiMsg ProductNotFound = new ApiMsg(4010, "Product Not Found", "Product Not Found");
    public static final ApiMsg ProductListPageNotFound = new ApiMsg(4011, "The Page You Request Not Found", "The Page You Request Not Found");

    //Product
    public static final ApiMsg ProductCreateFail = new ApiMsg(4006, "Product Create Fail", "Product Create Fail");
}
