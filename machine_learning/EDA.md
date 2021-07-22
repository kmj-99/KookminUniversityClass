EDA
=====
## 목차
1. [EDA란?](#-EDA란?)
2. [EDA에 필요한 기본 라이브러리](#-EDA에-필요한-기본-라이브러리)
3. [EDA 실습](#-EDA-실습)

## EDA란
그동안 ndarray라던가 dataframe이라던가 정제된 데이터를 가지고 다루었다면. EDA는 데이터 그 자체를 가지고 분석을 하는것이다  
Exploratory Data Analysis의 약자이다.


## EDA에 필요한 기본 라이브러리
```import numpy``` ```import pandas```  ```import matplotlib.pyplot``` ```import seaborn```가 디폴트로 세팅을 한다

## EDA 실습
### 1. 데이터를 대충 살펴본다 (df는 DataFrame이다)
- ```df.describe()```  ```df.corr() #수치데이터들 간의 상관계수``` 
- 이떄 ```df.isnull().sum()```을 통해서 결측치를 확인을 해봐야한다

### 2. 개별데이터들의 속성을 파악한다
- ```df["str_Column"].value_counts()```를 이용해 수치형이 아닌 범주형 column의 빈도를 확인
- ```df[['Column1','Column2']].groupby(['Column1 or Column2']).count()``` 을 통해 특정 Colums을 그룹으로 묶어서 count(),sum(),mean()등을 통해서 확인  
이때 ```df.groupby(['Column1','Column2']).count()```을 통해서 두개의 그룹으로도 묶기 가능!

### 3. 시각화
- seaborn,plot을 이용해서 적절한 그래프를 선택한 후 시각화
