numpy
=====
## 목차
1. [정의](#-정의)
2. [메소드](#-메소드-종류)

## 정의
numpy는 다차원배열의 연산이나,수학적인 계산을 해주는 라이브러리다.

## 메소드 종류
* numpy.array(): numpy 배열생성
* numpy.zeros((row,col)): 원소가 0인 row x col 행렬 생성
* numpy.ones((row,col)): 원소가 1인 row x col 행렬 생성
* numpy.diag((row,col)): main diagonal을 제외한 원소는 모두 0인 행렬 생성
* numpy.eye(n,dtype=type): main diagonal이 1인 n x n 행렬 생성
* mat1.dot(mat2): mat1과 mat2의 행렬곱 연산
* arr.trace(): main diagonal의 합 연산
* numpy.linalg.det(array): array의 행렬식(determinant) 계산
* numpy.linalg.inv(array): array의 역행렬(inverse matrix)을 구하는 메소드
* numpy.linalg.eig(mat): mat의 고유값(eigenvalue)과 고유벡터(eigenvector)를 구하는 메소드
* 
