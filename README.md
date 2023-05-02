# S914_SpringBoot_Trip_Kimsunhyung_Yooseungah

## EnjoyTrip API
![1  home](https://user-images.githubusercontent.com/68517303/235612570-ac34040c-7bcc-40dd-a6ee-8da3f80ffd46.PNG)

### 1. model
![4  model](https://user-images.githubusercontent.com/68517303/235612717-23077faf-7694-453c-8c0d-6f0ece8cf4a0.PNG)
##### Attraction : 관광지 model  
##### User : 사용자 model
<br>

### 2. Controller
![2  attraction](https://user-images.githubusercontent.com/68517303/235613025-7f8f7ebd-f823-48f7-8e3a-b9197615ed45.PNG)
##### GET /attraction/{sido_code} : 지역별 관광지 정보 조회
##### GET /attraction/search : 관광지 정보를 지역별 원하는 컨텐츠 별 조회
<br>

![3  user](https://user-images.githubusercontent.com/68517303/235613517-2b425011-c74c-4671-912d-7a18a32bef3c.PNG)
##### GET /user : 회원 정보 조회
##### DELETE /user : 회원  탈퇴
##### GET /user/findPw : 회원 비밀번호 변경
##### POST /user/join : 회원 가입
##### GET /user/login : 로그인
##### GET /user/logout : 로그아웃
##### PUT /user/modify : 회원 정보 수정
