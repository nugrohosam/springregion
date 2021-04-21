package com.nugrohosamiyono.springregion.ThirdParty.Authenticate.Services;

import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.ProtoService.GetAuthIdResponse;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.ProtoService.GetAuthRequest;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.ProtoService.GetAuthResponse;
import com.nugrohosamiyono.springregion.ThirdParty.Authenticate.ProtoService.GetAuthService;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

public class AuthenticateService {

    public static void authenticate(String value) {
        value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiY2RkODI5MDA2NWMzNWFiYjRmMDRmMzhmMjFmZGI0M2ZmMDJjMjRkOGUzNWM5NGQ4NTc1ZTVjMDVjYmIyYTc1MzkzNGM4YjU1ZmM5MzA4Njk5NzFjOWE4ODUxODQxZGVjNGJkZDFkNDZjY2MwNDYxMWM4NGE4NDE1OGJiYWQ1ZGEzYzFjMjE0OTNjMzZmOTE0ZDM5YTQwNzRhMTNkMWMzODU2NDY3YTQ1Y2FhZjQ4NDM4ZTBkZWVjZSIsImV4cGlyZWRUaW1lIjoiMjAyMS0wNC0yNFQwMjo0NDoxNi42MDg4MjcrMDc6MDAifQ.rc3OvOGWfbN4rWdT-LzIdq5zCrF57vzFQEq58YKxThM";

        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        GetAuthService.GetAuthServiceStub stubAuthService = GetAuthService.newStub(channel);

        GetAuthRequest request = GetAuthRequest.newBuilder().setToken(value).build();

        stubAuthService.getAuthID(request, new StreamObserver<GetAuthIdResponse>() {
            @Override
            public void onCompleted() {

                System.out.println("Completed");

                // You should not call any method on requestObserver.
            }

            @Override
            public void onError(Throwable error) {

                System.out.println(error);

                // You should not call any method on requestObserver.
            }

            @Override
            public void onNext(GetAuthIdResponse response) {
                System.out.println(response.getId());
            }

        });

        stubAuthService.getAuth(request, new StreamObserver<GetAuthResponse>() {
            @Override
            public void onNext(GetAuthResponse response) {

                System.out.println(response.getEmail());

                // Optionally you can call onCompleted() or onError() on
                // the requestObserver to terminate the call.
            }

            @Override
            public void onCompleted() {

                System.out.println("Completed");

                // You should not call any method on requestObserver.
            }

            @Override
            public void onError(Throwable error) {

                System.out.println(error);
                System.out.println("error");

                // You should not call any method on requestObserver.
            }
        });

        channel.shutdown();
    }
}