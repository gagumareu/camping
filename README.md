## 개발 목표
캠핑 커뮤티니 웹 
**개발 기여도 100% [개인 프로젝트] | 기간 2023.07.03 - 현재** 
- 캠핑 모임시 회원들간 소유하고 있는 캠핑 장비를 공유
- 유저가 등록한 캠핑 장비를 리스트업
- 리스트업한 장비들에서 선택하여 중고 거래 작성
- 캠핑 모임 장소 및 날짜를 공유 할 수 있는 게시물 작성
- list.html 한 페이지에서 카테고리 별로 리스트 출력 함으로써 최소한의 코드로 원하는 리스트와 검색기능
- 검색기능 '카테고리 내에서 원하는 키워드 검색가능'
- Spring Security를 이용하여 권한이 주어진 회원만 게시물 등록, 수정 및 삭제
- text edition 'summernote edition' 적용

## 사용기술
- Spring boot 3.1.3
- JPA
- Querydsl
- Spring security
- thymeleaf
- Ajax 
- summernote editor
- Google OAuth2
- AWS EC2, RDS, S3

사용 언어 : Java, HTML, CSS, Jquery, SQL

버전 관리 : Git 

------
### 로그인 유저가 등록한 캠핑 리스트 및 중고거래 게시판 작성 ###

##### 로그인 유저[spring security authentication 권한을 가진 사용자] 본인의 캠핑 장비 목록을 리스트업 할 수 있음 #####
##### 캠핑 장비 등록 DTO와 이미지 List를 함께 등록 -> 등록된 장비들은 getJSON을 통해 리스트업 [페이징] -> 등록된 장비들을 수정 및 삭제 가능 #####
##### 원하는 장비를 중고거래로 등록하기 클릭시 -> 해당 장비의 id값을 전달 -> 게시물 등록 페이지에서 spring security authentication 권한을 이용하여 사용자의 foregin key를 참고하여 등록한 장비 리스트업 (ajax) 또한 전달 받은 id값을 통해 summernoteEditor에 해당 장비 값 및 이미지 자동 업로드 #####
##### 원하는 장비를 바꾸고 싶으면 캠핑 장비 리스트에서 원하는 장비를 클릭시 자동으로 summernoteEditor로 해당 자료 업데이트 #####

![마이기어리스트 중고거래-min](https://github.com/gagumareu/springboot_campboard/assets/98436199/a2bbd943-460e-4f9a-ab7d-0b5fdab6f762)



### summernote editor ###

##### summernotEditor에서 이미지 선택 -> [ajax] 로컬 서버 파일 저장 -> AWS S3 bucket 저장 및 로컬 서버 파일 삭제 -> summernoteEditor 이미지 보여주기 -> 게시물 등록 버튼 클릭 -> 게시물 DTO 및 다중 이미지 파일 List와 함께 controller -> service -> repository -> AWS RDS DB 저장 #####

![게실물등록-min](https://github.com/gagumareu/springboot_campboard/assets/98436199/3e6ceb36-2144-4806-8c78-244be9701cbd)

 
###### 게시물 등록 클릭 이벤트 Jquery ######
  
    


### 게시물 리스트, 페이징 및 검색기능 ###

##### 전체리스트 및 카테고리 별로 리스트 및 페이지 네이션 [ querydsl을 이용한 검색 기능] ##### 

![리스트및검색기능](https://github.com/gagumareu/springboot_campboard/assets/98436199/a2939043-4126-43d4-95d8-9bffb0ac26e5)

