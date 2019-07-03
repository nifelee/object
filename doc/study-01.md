Object
======
6주차 스터디 : 회당 1~2장 정도

- 기본 소양
motivation - 모든 모티베이션은 돈에 있다. 

# Philosophy (철학)

## 토마스 쿤
캔트백 : 가치 + 원칙 반복되는 것 = 패턴
XOriented

과학적 원리가 상대적 - 종교와 비슷

`상대주의`와 `합리주의` - 과학사에만 있는건 아님
합리주의가 먼저 나왔고, 르네상스 시대 상대주의가 나오기 시작, Class 예시 (자식, 자손 등)

표준이나 기준을 만들 때 합리성 기반 (표준 체중, BMI)

## 캔트 백
Value (가치)
  커뮤니케이션 (Cummunication) - 잘 읽혀야 한다
  간단히 (Simplicity) - 간단하게 짜면 짤수록 좋다
  유연하게 (Flexibility) -
유연성을 얻으려면 간단하게 짜라

Principle (원칙)
다양한 그룹 속에서 레이어로 이루어 짐 - 각자의 회사, 팀, 개인 등
  Local consequences () - 중복을 제거하라
  Minimize repetition () - 
  Symmetry () - 짝을 맞춰라, getter 만들었으면 setter 만들어라
  Convention (컨벤션) - 팀내 컨벤션을 정하고 안지키면 버그로 픽스하자

XOriented ()
`OOP` - SOLID, DRY...
Reactive
Functional

미국 같은 경우 생산성 협회에서 생산성을 측정하고 있음 - 개발 시 50%를 디버깅에 사용하고 있음
사람 : 시간 = 돈, 100% 인건비 산업, 시작을 적게 쓰면 돈을 벌게 됨

# 역할 모델
객체지향 관련 엔터프라이즈 급에서 역할 모델 외 아직까지 찾지 못했음
빠르면 3년, 보통 5년 정도 익히는데 걸림

## Abstraction
Generalization (일반화) - 현상들에 대해 공통점이나 공식을 들어 설명할수 있는, modeling, function, algorithm)
Association (연관화) - reference, dependence
Aggregation (집단화) - group, category

Procedural abs
  : 절차적 추상화 - 메소드가 아닌 함수로 생각, 데이터의 처리 방법을 `함수`에게 위임하는 것, `순차적`이 아님
  Generalization - 일반화된 사항을 추려낼려면 일반화할 수 있어야 함, 가장 어렵고 가장 많이 씀
  Capsulization - 캡슐화, 데이터 은닉과 다름, (ATM 기에서 출금 - 인증, 금융사 연동 등), 어떤 행동의 복잡성을 감추고 일반화 된 사항만 노출

Data abs
  modeling - 특정 목표에 따라 기억해야 할 것만 추린 것, 학생-학생 테이블
  categorization - 아빠이자 사장 등 
  grouping - 그냥 모아두는 것, 의마가 없더라도 묶어두는 것, 

OOP abs
  UML에서 사용하는 기법 들...
  Generalization - 
  Realization - 
  Dependency - 
  Association - 
  Directed Association - 
  Aggregation - 
  Composition - 

# Timing
프로그래밍이 실행되는 순간이 언제냐?
프로그램 - 메모리에 로딩되서 실행될 때가 프로그램

  Language code - Lint time
  Machine Language - Compile time
  File
  Load
  RUN - run time, 런타임 에러는 거의 못 잡는다
  terminate

## Script Program
  Language code - Lint time
  File
  Load
  Machine Language - 문법 에러만 잡힘
  RUN - run time, 문법 에러 외 나머지 에러는 여기서 잡힘
  terminate

## Runtime
Memory - 명령, 값 셋
CPU - 외부 버스를 통해 제어유닛(디코더), 연산유닛(제어정보, 메모리 계수기), 데어터 유닛(메모리의 값을 가지고 오는 행위) 순으로 실행, 1+2 = 3, 노이만 머신(싱크적으로 명령이 싷행)

```
1. Loading
2. Instruction Fetch & Decoding
3. Execution
```
2, 3 무한 반복

java는 런타임 로딩을 업계 최초로 적용, jar 파일 2기가 짜리도 jvm에서 안 뻗음, 실행 시점에 클래스를 로딩하기 때문에

Run
  Declare base function - static time, jQuery 로딩
  Declare extended function, class - run time, jQuery 사용

## Pointer of Pointer
특정 포인터를 직접 가르치지 않고 포인터를 찾은 후 길이만큼 차지
```c
A = "test"
&A = 11

B = &A
*B = "test"

C = B, D = B

--이후 B = &K ("abc") 이지만 C, D는 A를 가르키고 있음
```

이게 직접 참조

```c
B = {value: &A, V:3}
C = B, D = B

B.value = &k
```

이러면 포인터 of 포인터를 가르키므로 문제 없음
런타임 시에 `참조의 참조`를 사용 - `동적 바인딩`, 객체 지향에서는 동적 바인딩을 사용 (B.value)

# OOP base system

## Value & Identifier
```kotlin
class ValueType(val name:String) {
  override operator fun equals(n:Any?) = n == name
}

VaLueType("abc") == ValueType("abc") //true - 값으로 비교
VaLueType("abc") === ValueType("abc") //false - 객체로 비교
```

자바스크립트에서는 값으로 비교, 자바는 객체로 보기때문에 객체의 메모리를 비교, 객체지향에서는 `식별자`를 비교

--------------
## Polymorphism (다형성)

### Substitution - 대체가능성

```kotlin
open class Worker:Runable {
    override fun run() = println('working')
}

var worker:Runable = Worker()
println(worker.run()) //working, 워커의 런너블을 지정했으니 run 메소드만 있음
```

```kotlin
open class Worker:Runable {
    override fun run() = println('working')
}

class HardWorker:Worker() {
    override fun run() = println('HardWorking')
}
var worker:Runable = Worker()
println(worker.run()) //working

worker = HardWorker()
println(worker.run()) //HardWorking

```

대체 가능성은 js의 경우 프로토타입 채인으로 실행

### Internal identity : 내적동질성
```kotlin
open class Worker:Runable {
    override fun run() = println('working')
    fun print() = println(run())
}

class HardWorker:Worker() {
    override fun run() = println('HardWorking')
}
var worker:Worker = Hardworker()
println(worker.print()) //?, HardWorking
```

## Object
Encapsulation of Functionality - ATM, 외부에 상세를 노출하지 않고 인터페이스를 노출
Maintenance of State (상태의 관리) - 은닉

### Isolation (격리)
요구사항의 해당 안건을 해결하기 위해 하나의 파일만 수정할 수 있을 경우 `격리`에 성공했다고 봄

---------------
Theater
보통 동영상이 수요일 정도에 올라옴

[P.24 그림 1.6]

