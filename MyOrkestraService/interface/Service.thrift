namespace java com.myorkestra.orkestraservice.thrift.gen
namespace js thrift
namespace * com.myorkestra.orkestraservice.thrift.gen


exception InvalidRequestException {
  1: i32 errorCode,
  2: string message
}


struct HiInput {
  1: string message
}

service OrkestraService
{
  string  sayHi(1: string input) throws(1: InvalidRequestException err1)
}

