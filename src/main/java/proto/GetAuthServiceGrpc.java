package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: src/main/java/com/nugrohosamiyono/springregion/ThirdParty/Authenticate/Protos/AuthService.proto")
public final class GetAuthServiceGrpc {

  private GetAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.GetAuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest,
      proto.AuthService.GetAuthResponse> getGetAuthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuth",
      requestType = proto.AuthService.GetAuthRequest.class,
      responseType = proto.AuthService.GetAuthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest,
      proto.AuthService.GetAuthResponse> getGetAuthMethod() {
    io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest, proto.AuthService.GetAuthResponse> getGetAuthMethod;
    if ((getGetAuthMethod = GetAuthServiceGrpc.getGetAuthMethod) == null) {
      synchronized (GetAuthServiceGrpc.class) {
        if ((getGetAuthMethod = GetAuthServiceGrpc.getGetAuthMethod) == null) {
          GetAuthServiceGrpc.getGetAuthMethod = getGetAuthMethod =
              io.grpc.MethodDescriptor.<proto.AuthService.GetAuthRequest, proto.AuthService.GetAuthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AuthService.GetAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AuthService.GetAuthResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GetAuthServiceMethodDescriptorSupplier("GetAuth"))
              .build();
        }
      }
    }
    return getGetAuthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest,
      proto.AuthService.GetAuthIdResponse> getGetAuthIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthID",
      requestType = proto.AuthService.GetAuthRequest.class,
      responseType = proto.AuthService.GetAuthIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest,
      proto.AuthService.GetAuthIdResponse> getGetAuthIDMethod() {
    io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest, proto.AuthService.GetAuthIdResponse> getGetAuthIDMethod;
    if ((getGetAuthIDMethod = GetAuthServiceGrpc.getGetAuthIDMethod) == null) {
      synchronized (GetAuthServiceGrpc.class) {
        if ((getGetAuthIDMethod = GetAuthServiceGrpc.getGetAuthIDMethod) == null) {
          GetAuthServiceGrpc.getGetAuthIDMethod = getGetAuthIDMethod =
              io.grpc.MethodDescriptor.<proto.AuthService.GetAuthRequest, proto.AuthService.GetAuthIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AuthService.GetAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AuthService.GetAuthIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GetAuthServiceMethodDescriptorSupplier("GetAuthID"))
              .build();
        }
      }
    }
    return getGetAuthIDMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetAuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetAuthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetAuthServiceStub>() {
        @java.lang.Override
        public GetAuthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetAuthServiceStub(channel, callOptions);
        }
      };
    return GetAuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetAuthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetAuthServiceBlockingStub>() {
        @java.lang.Override
        public GetAuthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetAuthServiceBlockingStub(channel, callOptions);
        }
      };
    return GetAuthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetAuthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetAuthServiceFutureStub>() {
        @java.lang.Override
        public GetAuthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetAuthServiceFutureStub(channel, callOptions);
        }
      };
    return GetAuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GetAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAuth(proto.AuthService.GetAuthRequest request,
        io.grpc.stub.StreamObserver<proto.AuthService.GetAuthResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAuthMethod(), responseObserver);
    }

    /**
     */
    public void getAuthID(proto.AuthService.GetAuthRequest request,
        io.grpc.stub.StreamObserver<proto.AuthService.GetAuthIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAuthIDMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAuthMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.AuthService.GetAuthRequest,
                proto.AuthService.GetAuthResponse>(
                  this, METHODID_GET_AUTH)))
          .addMethod(
            getGetAuthIDMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.AuthService.GetAuthRequest,
                proto.AuthService.GetAuthIdResponse>(
                  this, METHODID_GET_AUTH_ID)))
          .build();
    }
  }

  /**
   */
  public static final class GetAuthServiceStub extends io.grpc.stub.AbstractAsyncStub<GetAuthServiceStub> {
    private GetAuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetAuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAuth(proto.AuthService.GetAuthRequest request,
        io.grpc.stub.StreamObserver<proto.AuthService.GetAuthResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAuthID(proto.AuthService.GetAuthRequest request,
        io.grpc.stub.StreamObserver<proto.AuthService.GetAuthIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthIDMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GetAuthServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GetAuthServiceBlockingStub> {
    private GetAuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetAuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.AuthService.GetAuthResponse getAuth(proto.AuthService.GetAuthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.AuthService.GetAuthIdResponse getAuthID(proto.AuthService.GetAuthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthIDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GetAuthServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GetAuthServiceFutureStub> {
    private GetAuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetAuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AuthService.GetAuthResponse> getAuth(
        proto.AuthService.GetAuthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AuthService.GetAuthIdResponse> getAuthID(
        proto.AuthService.GetAuthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthIDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AUTH = 0;
  private static final int METHODID_GET_AUTH_ID = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AUTH:
          serviceImpl.getAuth((proto.AuthService.GetAuthRequest) request,
              (io.grpc.stub.StreamObserver<proto.AuthService.GetAuthResponse>) responseObserver);
          break;
        case METHODID_GET_AUTH_ID:
          serviceImpl.getAuthID((proto.AuthService.GetAuthRequest) request,
              (io.grpc.stub.StreamObserver<proto.AuthService.GetAuthIdResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GetAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.AuthService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetAuthService");
    }
  }

  private static final class GetAuthServiceFileDescriptorSupplier
      extends GetAuthServiceBaseDescriptorSupplier {
    GetAuthServiceFileDescriptorSupplier() {}
  }

  private static final class GetAuthServiceMethodDescriptorSupplier
      extends GetAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetAuthServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GetAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetAuthServiceFileDescriptorSupplier())
              .addMethod(getGetAuthMethod())
              .addMethod(getGetAuthIDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
