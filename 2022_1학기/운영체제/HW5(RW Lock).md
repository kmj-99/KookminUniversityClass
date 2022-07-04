# HW5 - RW Lock

### RW이란
Reader , Writer를 뜻하는 말이다. Reader와 Writer는 각자 Lock을 하는 방법이 다르고 RW Lock을 Condition Variable을 이용해 구현을 할 수 있다. 
Reader는 말그대로 읽는다. Writer는 말그대로 쓴다. 이때 동시에 읽을 순 있지만 동시에 쓸 수(수정)는 없게 해야한다.
따라서 Reader는 동시에 실행가능하지만 Writer는 동시에 실행불가능하다는 규칙이 있다.

### 과제내용
ConditionVariable을 이용하여 RW Lock을 구현하고 그걸 추적한 빈칸이 뚫려있는 Trace표가 주어진다. 해당 빈칸을 채우는 것이다.

### 빈칸을 채운 Trace 표
![RwLockTrace](https://user-images.githubusercontent.com/76093968/177127114-3e9c45a0-b193-45ae-8bbb-7d9b4869ff30.png)
