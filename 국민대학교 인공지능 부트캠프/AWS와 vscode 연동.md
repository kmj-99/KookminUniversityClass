## 1. AWS에서 인스턴스를 생성을 한다.
## 2. vscode에서 extension검색창에서 remote를 검색하여 SSH,SSH:Editing Configuration Files,Development를 다운받는다
## 3. **F1**을 눌러서 configuration을 검색하고, Remote-SSH:Open Configuration을 클릭
## 4. config 파일에서 AWS에서 만든 인스턴스의 별명(host),Public IP(HostName),User(운영체제종류),idetiyFile(key 경로)를 입력한다
## 5. 다시 **F1**을 눌러서 Renote-SSH:Connect to Host..를 선택하면 연결된다

느낀점: key경로를 입력할 때 구분자를 '\'를 써야하는데 '/'를 써서 에러가 나서 삽질을 했다.. 윈도우에서 주소경로를 입력할 때는 '\'로 구분자를 쓰자
