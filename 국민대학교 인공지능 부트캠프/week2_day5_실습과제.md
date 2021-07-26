## dataSet이 있는데 그 안에 능력치라는 게 있고,2개의 팀(good,bad)이 있는데 각각 선수들이 있다. 그 팀별로 능력치를 비교하라는 게 이번 과제이다.

- 현재 dataSet에서 column별로 능력치가 나누어 져 있는데 그 능력치들을 한 col_list에 모아놨다
- 그리고 2개의 팀에 대해서 각 능력치마다 각 팀의 선수들의 평균을 구해서 2개의 list에 모아놨다  
- 문제는 지금부터다. 내가 하고싶은건 ```plt.scatter()```을 이용하여 각 능력치별로 팀별 선수들의 mean 점으로 찍어서 비교해서 보여주는 것이다.
- 하지만 scatter에서는 그게 불가능한 거 같다. 
- 현재 data는 다 가공을 했기 때문에 그래프만 잘 결정해서 보여주면 된다.....


- scatter을 통해 그래프를 보여주려다 countplot이 나을 거 같아서 countplot을 이용했다
#### 하지만 countplot은 float을 취급하지 않는다. 내가 취급할 y값은 float이다...
- 그렇지만 해결법이 있었다 바로 countplot과 비슷한 bareplot이다. bareplot은 float을 취급한다.
- ```sns.barplot(x='ability',y='value',data=res_bad_list)```는 bad팀의 능력치
- ```sns.barplot(x='ability',y='value',data=res_good_list)```눈 good팀의 능력치
- 각각 ```plt.show()```을 하면 각 능력치별로 두 팀의 차이를 쉽게 알 수 잇다

참조: http://localhost:8888/notebooks/Week2/week2_day5_coreMission.ipynb
