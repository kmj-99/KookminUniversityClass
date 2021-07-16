Matplotlib
==========
## 목차
1. [Matplotlib이란?](#-Matplotlib이란?)
2. [기본 메소드](#-기본-메소드)
3. [그래프 종류](#-그래프-종류)

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
