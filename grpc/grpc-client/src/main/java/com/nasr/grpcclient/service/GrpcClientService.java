package com.nasr.grpcclient.service;

import com.nasr.grpcclient.GetUserRequest;
import com.nasr.grpcclient.GetUserResponse;
import com.nasr.grpcclient.UserServiceGrpc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrpcClientService {


    private final UserServiceGrpc.UserServiceBlockingStub stub;


    public GetUserResponse getUserById(Long id) {


        GetUserRequest.Builder builder = GetUserRequest.newBuilder();
        builder.setId(id);
        GetUserRequest request = builder.build();

        return stub.getUserById(request);

    }
}
