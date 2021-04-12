package com.javatechie.aws.lambda;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;


//aws lambda function always seacrch for Request handler class
// So we have to implemet that
//(object) -- type generic
public class OrderHandler extends SpringBootRequestHandler<String,Object> {


}
