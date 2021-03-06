namespace java thrift_generated

// 生成java代码方法：thrift --gen java src/thrift/data.thrift
typedef i32 int
typedef string String
typedef bool boolean

struct Person {
    1: optional String username,
    2: optional int age,
    3: optional boolean married
}

exception DataException {
    1: optional String message,
    2: optional String callStack,
    3: optional String date
}

service PersonService {
    Person getPersonByUsername(1: required String username) throws (1: DataException dataException),

    void savePerson(1: required Person person) throws (1: DataException dataException)
}