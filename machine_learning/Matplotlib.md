Matplotlib
==========
## 목차
1. [Matplotlib이란?](#-Matplotlib이란?)
2. [기본 메소드](#-기본-메소드)
3. [그래프 종류](#-그래프-종류)
4. [searborn](#-searbon)

## 1.Matplotlib이란?
#### 데이터를 시각화 해주는 라이브러이다.
#### Matplotlib은 사이즈가 크기때문에 ```import matplotlib.pyplot as plt```로 사용

## 2.기본 메소드
```plt.plot()```: plot()에는 여러가지들이 들어갈 수 있음. 리스트,label='',x='',y=''등등  
            들어온 정보를 가지고 함수를 만듬  
```plt.show()```: plot()으로 만든 함수를 시각화 해서 보여줌  

```plt.figure(figsize=(x,y))```: ploting을 할 도면을 선언. figsize는 그래프의 크기를 조절  

```plt.xlabel("...")```: x좌표의 이름을 지정  
```plt.ylabel("...")```: y좌표의 이름을 지정  

```plt.axis([x_min,x_max,y_min,y_max])```: 지정한 범위의 값들만 그래프에 보여줌  

```plt.xticks("range")```: x축의 눈금을 설정  
```plt.yticks("range")```: y축의 눈금을 설정  

```plt.title("name")```: 그래프의 제목 지정  

```plt.legend()```: label을 보여줄 때 사용  

## 3.그래프 종류
***산점도(scatter plot)***-```plt.scatter(x,y)```: 점들의 분포를 나타냄  

***박스 그림(box plot)***-```plt.box((x,y))```: 수치형에 대한 정보를 Q1,Q2,Q3,Q4로 구분하여 나타냄  

***막대그래프(Bar Plot)***-```plt.bar(x,y)```: 범주형 데이터와 그 값의 크기를 직사각형으로 나타냄  

***원형그래프(Pie Chart)***-```plt.pie(z,labels=['name1','name2'....])```: 원형으로 데이터의 비율을 나타냄


## 4.serborn
#### 더 정교한 시각화를 위해 matplotlib를 기반으로 만들어진 라이브러리```import searborn as sns```
***커널밀도그림(Kernel Density Plot)***-```sns.kdeplot(y,shade=True or False)```: 연속적인 분포를 곡선화해서 보여줌  
***카운트그림(Count plot)***-```sns.countplot(x=data_df['columns_name'])```: 범주형 열의 빈도수를 시각화  
***캣그림(Cat Plot)***-```sns.catplot(x="",y="",data=)```: 수치형 변수화 하나이상의 범주형 변수의 관계를 보여줌  
***스트립그림(Strip Plot)***-```sns.stripplot(x="",y="",data=)```:데이터의 수치를 표현하는 그래프  
***히트맵(Heatmap)***-```sns.headmap(data.corr())```:데이터간의 상관관계를 수치화,data.corr()는 데이터 간의 상관관계를 수치로 보여줌  

