package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: src/main/java/com/nugrohosamiyono/springregion/ThirdParty/Authenticate/Protos/UserPermissionService.proto")
public final class UserPermissionServiceGrpc {

  private UserPermissionServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.UserPermissionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.UserPermissionServiceOuterClass.GetUserPermissionRequest,
      proto.UserPermissionServiceOuterClass.GetUserPermissionResponse> getValidateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Validate",
      requestType = proto.UserPermissionServiceOuterClass.GetUserPermissionRequest.class,
      responseType = proto.UserPermissionServiceOuterClass.GetUserPermissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.UserPermissionServiceOuterClass.GetUserPermissionRequest,
      proto.UserPermissionServiceOuterClass.GetUserPermissionResponse> getValidateMethod() {
    io.grpc.MethodDescriptor<proto.UserPermissionServiceOuterClass.GetUserPermissionRequest, proto.UserPermissionServiceOuterClass.GetUserPermissionResponse> getValidateMethod;
    if ((getValidateMethod = UserPermissionServiceGrpc.getValidateMethod) == null) {
      synchronized (UserPermissionServiceGrpc.class) {
        if ((getValidateMethod = UserPermissionServiceGrpc.getValidateMethod) == null) {
          UserPermissionServiceGrpc.getValidateMethod = getValidateMethod =
              io.grpc.MethodDescriptor.<proto.UserPermissionServiceOuterClass.GetUserPermissionRequest, proto.UserPermissionServiceOuterClass.GetUserPermissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Validate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.UserPermissionServiceOuterClass.GetUserPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.UserPermissionServiceOuterClass.GetUserPermissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserPermissionServiceMethodDescriptorSupplier("Validate"))
              .build();
        }
      }
    }
    return getValidateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserPermissionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserPermissionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserPermissionServiceStub>() {
        @java.lang.Override
        public UserPermissionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserPermissionServiceStub(channel, callOptions);
        }
      };
    return UserPermissionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserPermissionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserPermissionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserPermissionServiceBlockingStub>() {
        @java.lang.Override
        public UserPermissionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserPermissionServiceBlockingStub(channel, callOptions);
        }
      };
    return UserPermissionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserPermissionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserPermissionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserPermissionServiceFutureStub>() {
        @java.lang.Override
        public UserPermissionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserPermissionServiceFutureStub(channel, callOptions);
        }
      };
    return UserPermissionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserPermissionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void validate(proto.UserPermissionServiceOuterClass.GetUserPermissionRequest request,
        io.grpc.stub.StreamObserver<proto.UserPermissionServiceOuterClass.GetUserPermissionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getValidateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.UserPermissionServiceOuterClass.GetUserPermissionRequest,
                proto.UserPermissionServiceOuterClass.GetUserPermissionResponse>(
                  this, METHODID_VALIDATE)))
          .build();
    }
  }

  /**
   */
  public static final class UserPermissionServiceStub extends io.grpc.stub.AbstractAsyncStub<UserPermissionServiceStub> {
    private UserPermissionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPermissionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserPermissionServiceStub(channel, callOptions);
    }

    /**
     */
    public void validate(proto.UserPermissionServiceOuterClass.GetUserPermissionRequest request,
        io.grpc.stub.StreamObserver<proto.UserPermissionServiceOuterClass.GetUserPermissionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserPermissionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserPermissionServiceBlockingStub> {
    private UserPermissionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPermissionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserPermissionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.UserPermissionServiceOuterClass.GetUserPermissionResponse validate(proto.UserPermissionServiceOuterClass.GetUserPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserPermissionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserPermissionServiceFutureStub> {
    private UserPermissionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPermissionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserPermissionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.UserPermissionServiceOuterClass.GetUserPermissionResponse> validate(
        proto.UserPermissionServiceOuterClass.GetUserPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VALIDATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserPermissionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserPermissionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VALIDATE:
          serviceImpl.validate((proto.UserPermissionServiceOuterClass.GetUserPermissionRequest) request,
              (io.grpc.stub.StreamObserver<proto.UserPermissionServiceOuterClass.GetUserPermissionResponse>) responseObserver);
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

  private static abstract class UserPermissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserPermissionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.UserPermissionServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserPermissionService");
    }
  }

  private static final class UserPermissionServiceFileDescriptorSupplier
      extends UserPermissionServiceBaseDescriptorSupplier {
    UserPermissionServiceFileDescriptorSupplier() {}
  }

  private static final class UserPermissionServiceMethodDescriptorSupplier
      extends UserPermissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserPermissionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserPermissionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserPermissionServiceFileDescriptorSupplier())
              .addMethod(getValidateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
