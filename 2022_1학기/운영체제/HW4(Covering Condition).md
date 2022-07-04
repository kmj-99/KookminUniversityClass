# HW4 - Covering Condition

## Condition Variable이란?
특정 조건을 만족하기를 기다리는 변수라는 의미이다. 에를 들어서 T1스레드가 critical section에 진입하려고 할 때 이미 T2스레드가 Lock을 걸어서 critical section을 
수행하고 있다면 T1은 Condition Variable을 통해서 T2스레드가 critical section을 다 수행하고 unlock을 할 때까지 기다리는 것이다. 

## 과제내용
Condition Variable을 사용해서 3개의 Thread(Consumer2개 , Producer 1개)의 흐름을 Trace로 나타낸 표가 있는데 빈칸을 채우는 게 과제이다.

## 빈칸을 채운 Trace표
![Condition Variable Trace](https://user-images.githubusercontent.com/76093968/177124703-67b46511-b836-4c5b-98c3-4f641c76e4fc.png)

