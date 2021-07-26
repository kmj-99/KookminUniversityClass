Pandas
======
1.[정의](#1.-정의-)  
2.[메소드](#2.-메소드)  
3.[새로알게 된 사실](#3.-새로알게-된-사실)

---
## 1. 정의
pandas는 데이터를 저장하고 관리하는 자료구조이다. 데이터프레임이라는 자료구조를 다룬다

## 2. 메소드
<code>
import pandas as pd
</code>

pd.Series(list): 데이터들을 인덱스 별로 보여주는 메소드  
pd.DataFrame(list or dic or....): 리스트나 딕셔녀리등등을 데이터 프레임으로 변환해주는 메소드  
.dtypes: DataFrame은 열마다 자료형이 다를 수도 있기에 뒤에 s 가 붙음  
pd.read_csv("filename.csv"): csv파일을 읽어와서 DataFrame으로 변환해주는 메소드  
pd.head(): 위에서부터 5개의 데이터를 보여줌  
pd.tell(): 밑에서부터 5개의 데이터를 보여줌  
df.loc[row,col]: row,col에 있는 데이터 추출  
df['colums'].groupby(by=df['group_colums']): group_colums을 기준으로 그룹화 하여서 colums에 해당하는 데이터 추출  
df['colums'].mean #평균  
df['colums].max #최대값  
df['colums].sum #합  
df['colums'].min #최소값  
## 3. 새로알게 된 사실
type(df['columns']): dataframe에 각 열은 series라는 걸 앎  
df[df['columns']>n]: 열에 특정 조건을 걸 수 있음  
df.iloc[num1,num2]: 각 행과 열을 인덱스로 접근함  


  
