package com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Services;

import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Models.AuthInfo;

import org.springframework.stereotype.Component;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import proto.GetAuthServiceGrpc;
import proto.ValidationServiceGrpc;
import proto.AuthService.GetAuthIdResponse;
import proto.AuthService.GetAuthRequest;
import proto.AuthService.GetAuthResponse;
import proto.AuthService.ValidationResponse;

@Component
public class AuthenticateServiceGrpc {

    private AuthInfo authInfo;

    public AuthInfo authInfo(String value) throws InterruptedException {
        authInfo = new AuthInfo();

        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        GetAuthServiceGrpc.GetAuthServiceBlockingStub stubAuthService = GetAuthServiceGrpc.newBlockingStub(channel);

        GetAuthRequest request = GetAuthRequest.newBuilder().setToken(value).build();

        GetAuthResponse response = stubAuthService.getAuth(request);

        this.authInfo.setId(response.getId());
        this.authInfo.setEmail(response.getEmail());

        return this.authInfo;
    }

    public double authId(String value) {
        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        GetAuthServiceGrpc.GetAuthServiceBlockingStub stubAuthService = GetAuthServiceGrpc.newBlockingStub(channel);

        GetAuthRequest request = GetAuthRequest.newBuilder().setToken(value).build();

        GetAuthIdResponse response = stubAuthService.getAuthID(request);

        return response.getId();
    }

    public boolean validateAuth(String value) {
        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        ValidationServiceGrpc.ValidationServiceBlockingStub stubAuthService = ValidationServiceGrpc.newBlockingStub(channel);

        GetAuthRequest request = GetAuthRequest.newBuilder().setToken(value).build();

        ValidationResponse response = stubAuthService.validate(request);

        return response.getValid();
    }
}