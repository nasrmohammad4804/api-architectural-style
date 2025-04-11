package com.nasr.grpcclient.config;

import com.nasr.grpcclient.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {


    @Bean
    public ManagedChannel managedChannel(GrpcServerConfig config) {
        return ManagedChannelBuilder.forAddress(config.getHost(),config.getPort())
                .usePlaintext()
                .build();
    }
    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub(ManagedChannel managedChannel) {
        return UserServiceGrpc.newBlockingStub(managedChannel);
    }
}
