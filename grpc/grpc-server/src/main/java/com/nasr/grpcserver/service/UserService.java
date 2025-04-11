package com.nasr.grpcserver.service;

import com.nasr.grpcserver.GetUserRequest;
import com.nasr.grpcserver.GetUserResponse;
import com.nasr.grpcserver.UserServiceGrpc;
import com.nasr.grpcserver.domain.User;
import com.nasr.grpcserver.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UserService  extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository repository;

    @Override
    public void getUserById(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
        long id = request.getId();
        User user = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("dont find user with id : "+id)
        );
        GetUserResponse.Builder builder = GetUserResponse.newBuilder();
        builder.setFirstName(user.getFirstName());
        builder.setLastName(user.getLastName());
        builder.setNationalCode(user.getNationalCode());
        builder.setId(user.getId());
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}

