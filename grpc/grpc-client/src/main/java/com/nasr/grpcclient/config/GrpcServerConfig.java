package com.nasr.grpcclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "grpc.user-service")
@Configuration
@Data
public class GrpcServerConfig {

    private String host;
    private int port;
}
