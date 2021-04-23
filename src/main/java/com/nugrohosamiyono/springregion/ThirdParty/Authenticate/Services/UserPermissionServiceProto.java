package com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Services;

import org.springframework.stereotype.Component;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import proto.UserPermissionServiceGrpc;
import proto.UserPermissionServiceOuterClass.GetUserPermissionRequest;
import proto.UserPermissionServiceOuterClass.GetUserPermissionResponse;

@Component
public class UserPermissionServiceProto extends BaseServiceGrpc {

    public boolean IsPermitted(String token, String permission) throws InterruptedException {
        ManagedChannel channel = NettyChannelBuilder.forAddress(this.host, this.port).usePlaintext().build();
        UserPermissionServiceGrpc.UserPermissionServiceBlockingStub stubAuthService = UserPermissionServiceGrpc
                .newBlockingStub(channel);

        GetUserPermissionRequest request = GetUserPermissionRequest.newBuilder().setToken(token)
                .setPermission(permission).build();

        GetUserPermissionResponse response = stubAuthService.validate(request);

        return response.getIsValid();
    }
}