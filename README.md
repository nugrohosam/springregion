# SPRINGREGION

## Api Doc
- https://documenter.getpostman.com/view/4473147/TzJuAdWB

## Build protoc & gRPC service
- follow this repos step : https://github.com/grpc/grpc-java/tree/master/compiler
- run this : 
```
protoc --plugin=protoc-gen-grpc-java=./cmd/grpc-java/compiler/build/exe/java_plugin/protoc-gen-grpc-java --grpc-java_out=./src/main/java --proto_path=. ./src/main/java/com/nugrohosamiyono/springregion/ThirdParty/Authenticate/Protos/AuthService.proto
```
```
protoc --java_out=./src/main/java --proto_path=. ./src/main/java/com/nugrohosamiyono/springregion/ThirdParty/Authenticate/Protos/AuthService.proto 
```
- this gRPC service use authenticate in api.auth.nugrohosamiyono.com, api docs in https://documenter.getpostman.com/view/4473147/TVzXDFka 