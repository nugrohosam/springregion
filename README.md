# SPRINGREGION

## Api Doc
- https://documenter.getpostman.com/view/4473147/TzJuAdWB

## Build protoc
- follow this repos step : https://github.com/grpc/grpc-java/tree/master/compiler
- run this : 
```
protoc --plugin=protoc-gen-grpc-java=./cmd/grpc-java/compiler/build/exe/java_plugin/protoc-gen-grpc-java --grpc-java_out=./src/main/java --proto_path=. ./src/main/java/com/nugrohosamiyono/springregion/ThirdParty/Authenticate/Protos/AuthService.proto
```
```
protoc --java_out=./src/main/java --proto_path=. ./src/main/java/com/nugrohosamiyono/springregion/ThirdParty/Authenticate/Protos/AuthService.proto 
```