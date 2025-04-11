package com.nasr.grpcclient.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.nasr.grpcclient.GetUserResponse;
import com.nasr.grpcclient.service.GrpcClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GrpcClientController {

    private final GrpcClientService grpcClientService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) throws InvalidProtocolBufferException {
        GetUserResponse getUserResponse = grpcClientService.getUserById(id);

        String result = JsonFormat.printer().print(getUserResponse);
        return ResponseEntity.ok(result);
    }
}
