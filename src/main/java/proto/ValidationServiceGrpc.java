package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: src/main/java/com/nugrohosamiyono/springregion/ThirdParty/Authenticate/Protos/AuthService.proto")
public final class ValidationServiceGrpc {

  private ValidationServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ValidationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest,
      proto.AuthService.ValidationResponse> getValidateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Validate",
      requestType = proto.AuthService.GetAuthRequest.class,
      responseType = proto.AuthService.ValidationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest,
      proto.AuthService.ValidationResponse> getValidateMethod() {
    io.grpc.MethodDescriptor<proto.AuthService.GetAuthRequest, proto.AuthService.ValidationResponse> getValidateMethod;
    if ((getValidateMethod = ValidationServiceGrpc.getValidateMethod) == null) {
      synchronized (ValidationServiceGrpc.class) {
        if ((getValidateMethod = ValidationServiceGrpc.getValidateMethod) == null) {
          ValidationServiceGrpc.getValidateMethod = getValidateMethod =
              io.grpc.MethodDescriptor.<proto.AuthService.GetAuthRequest, proto.AuthService.ValidationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Validate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AuthService.GetAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AuthService.ValidationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ValidationServiceMethodDescriptorSupplier("Validate"))
              .build();
        }
      }
    }
    return getValidateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ValidationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ValidationServiceStub>() {
        @java.lang.Override
        public ValidationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ValidationServiceStub(channel, callOptions);
        }
      };
    return ValidationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ValidationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ValidationServiceBlockingStub>() {
        @java.lang.Override
        public ValidationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ValidationServiceBlockingStub(channel, callOptions);
        }
      };
    return ValidationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ValidationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ValidationServiceFutureStub>() {
        @java.lang.Override
        public ValidationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ValidationServiceFutureStub(channel, callOptions);
        }
      };
    return ValidationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ValidationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void validate(proto.AuthService.GetAuthRequest request,
        io.grpc.stub.StreamObserver<proto.AuthService.ValidationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getValidateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto.AuthService.GetAuthRequest,
                proto.AuthService.ValidationResponse>(
                  this, METHODID_VALIDATE)))
          .build();
    }
  }

  /**
   */
  public static final class ValidationServiceStub extends io.grpc.stub.AbstractAsyncStub<ValidationServiceStub> {
    private ValidationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationServiceStub(channel, callOptions);
    }

    /**
     */
    public void validate(proto.AuthService.GetAuthRequest request,
        io.grpc.stub.StreamObserver<proto.AuthService.ValidationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ValidationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ValidationServiceBlockingStub> {
    private ValidationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.AuthService.ValidationResponse validate(proto.AuthService.GetAuthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ValidationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ValidationServiceFutureStub> {
    private ValidationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AuthService.ValidationResponse> validate(
        proto.AuthService.GetAuthRequest request) {
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
    private final ValidationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ValidationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VALIDATE:
          serviceImpl.validate((proto.AuthService.GetAuthRequest) request,
              (io.grpc.stub.StreamObserver<proto.AuthService.ValidationResponse>) responseObserver);
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

  private static abstract class ValidationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ValidationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.AuthService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ValidationService");
    }
  }

  private static final class ValidationServiceFileDescriptorSupplier
      extends ValidationServiceBaseDescriptorSupplier {
    ValidationServiceFileDescriptorSupplier() {}
  }

  private static final class ValidationServiceMethodDescriptorSupplier
      extends ValidationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ValidationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ValidationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ValidationServiceFileDescriptorSupplier())
              .addMethod(getValidateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
