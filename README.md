# ![](https://hackmd.io/_uploads/BkxxE1Du3.png) 유니크하면서 모던하고 대중적이지만 <br/>시크하고 유머러스한 닉네임 지어줘

<img src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white"> <img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black"> <img src="https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=Next.js&logoColor=white"> <img src ="https://img.shields.io/badge/SASS-cc6699.svg?&style=for-the-badge&logo=Sass&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">  <img src="https://img.shields.io/badge/eslint-4B32C3?style=for-the-badge&logo=eslint&logoColor=white">  <img src="https://img.shields.io/badge/prettier-F7B93E?style=for-the-badge&logo=prettier&logoColor=black">  <img src="https://img.shields.io/badge/axios-white?style=for-the-badge&logo=Axios&logoColor=black">

<br/><br/>

![](https://hackmd.io/_uploads/B1jg4yPun.png)

<br/>

🔗 **서비스 링크** : https://uniqname.monster/

### 프로젝트

게임을 새로 시작하거나, 서비스에 가입할 때 닉네임을 정해야하는 상황
멋지고 유니크한 닉네임을 정하고 싶지만 마땅한 아이디어가 없어서 고민만 몇십분째...
다들 한 번쯤 이런 경험 있지 않으셨나요?

![](https://hackmd.io/_uploads/B1l4n1v_h.png)

### 그래서 이런 서비스를 만들기로 했습니다.

![](https://hackmd.io/_uploads/BketUnyP_2.png)

_나 대신 고민해줄 친구를 구합니다!_

친구가 지어주는 닉네임, **유니크하면서 모던하고 대중적이지만 시크하고 유머러스한 닉네임 지어줘!**

### 저희 서비스는 이렇게 이용할 수 있어요.

- 지어줬으면 하는 **닉네임에 대한 요구와 태그**를 작성하고 친구에게 링크를 공유하면서 친구가 그에 맞는 닉네임을 적어줍니다.

- 닉네임을 받을 때 사용자에 대한 정보를 요구하지 않고 복잡하지 않아 사람들이 쉽게 이용할 수 있습니다.

### 프로젝트 어필포인트!

- 닉네임을 랜덤으로 추천해주는 서비스는 많지만 **'나'에 대해 아는 사람이 지어주는 닉네임은 더 특별**하지 않을까요?

## 화면 구성도
- 디자이너 - FE -BE 팀원이 각자의 관점에서 논의를 하며 페이지 구성

![](https://hackmd.io/_uploads/ryLRi1PO2.png)

## ERD


![](https://hackmd.io/_uploads/S1LCvkvO2.jpg)

* [DB설계에 대한 복기글(기록링크)](https://velog.io/@gkiwi/%ED%85%8C%EC%98%A4%EC%9D%98-%EC%8A%A4%ED%94%84%EB%A6%B0%ED%8A%B8-15%EA%B8%B0-%EC%B0%B8%EA%B0%80-%ED%9A%8C%EA%B3%A0%EB%A1%9D-Day4-Day5)

- 컬럼별 입력될 데이터의 크기를 고려하여 DB용량 설계
- DB에서 데이터의 완전한 삭제 대신 NICKNAMESTATUS컬럼의 값 변경으로 기능 수행 및 데이터 보존
- RESTFUl API 중심 설계, 변수명 및 반환형태, 데이터 크기 정의
- 추후 추가될 로그인 기능을 고려하며 테이블 설계
- Oracle DB에서 MySql DB로 수정하여 Ubuntu를 통해 배포
- (현재는 배포 중단)
  
 ### 리팩토링 내용

- 테이블 PK를 UUID에서 AUTOINCREMENT로 수정
    
     * [분산환경, 보안과 성능의 비교 및 결과(기록링크)](https://developerkiwi.tistory.com/entry/MySql-AutoINCREMENT-vs-UUID-%EC%9E%A5%EB%8B%A8%EC%A0%90-%EB%B9%84%EA%B5%90-%EB%B0%8F-%EA%B2%B0%EA%B3%BC)
    
- UUID와 대비되는 AUTOINCREMENT의 특징 비교 
    
    - AUTOINCREMENT의 단점 : 분산 환경에서 중복 데이터가 생길 가능성, 보안상 문제가 생길 여지가 있다.
    - AUTOINCREMENT의 장점 : 편의성과 성능면에서 UUID를 사용하는 방식보다 우위에 있다.
    
- AUTOINCREMENT 방식 채택이유 : 
    
    - 해당 프로젝트는 단일 DB를 사용하며 보안에 민감한 데이터를 다루지 않는 환경이다.
    - 편의성과 성능을 고려하여 기존의 UUID에서 AUTOINCREMENT로 수정하였다.
 
- Entitiy Class에서 @Setter 제거 및 @Builder 수정
    
    * [어노테이션 수정작업 기록1(@NoArgsConstructer 등 기록링크)](https://developerkiwi.tistory.com/entry/Java-fieldLombok-NoArgsConstructor-RequiredArgsConstructor-AllArgsConstructor-등-개념-정리)
    
    * [어노테이션 수정작업 기록2(@Builder 패턴 등 기록링크)](https://developerkiwi.tistory.com/entry/Java-빌더패턴-Builder-Pattern-Builder-사용권장-setter지양이유-Lombok)
    
    
- @Setter의 문제점    
    - Entity 클래스의 인스턴스가 수정될 수 있다.
    - 이러한 변경 가능성으로 인해 예측불가능성이 생겨 협업에서 어려움을 유발할 수 있다.
    - 클래스의 내부 구현이 외부에 노출될 수도 있다.
    
- 문제 수정 과정 : @Builder를 사용하면 클래스를 불변객체로 유지하며 필요한 기능을 구현할 수 있다.
  1. JPA를 사용할 때 기본생성자를 필요로 하는데 @Builder만 사용해서는 기본생성자를 만들 수 없다는 문제 발생.
  2. @NoArgsConstructor와 @AllArgsConstructor를 같이 사용하여 기본 생성자를 만들어줄 수 있음.
  3. 이를 그대로 사용하면 @Setter를 사용할 때처럼 외부에서 변경할 수 있어 일관성에 문제가 생길 수 있음.
  4. 각각의 뒤에 (access = AccessLevel.PROTECTED)를 붙이면 기본생성자를 제외한 모든 필드의 생성자가 외부에서 호출되지 않게 된다.

- 리팩토링 결론
    - @Setter 사용은 일관성 및 여러 문제점이 있기 때문에 사용을 지양한다.
    - 대신 @Builder를 사용하고 JPA 사용을 위하여 기본 생성자가 필요할 경우 @NoArgsConstructor(access = AccessLevel.PROTECTED)와 @AllArgsConstructor(access = AccessLevel.PROTECTED)를 같이 사용하여 외부에서 호출되지 않는 생성자를 만든다.
  

## 그라운드 룰

- 브랜치 전략 - git flow 🌳
- 변수명 - 카멜케이스 🐫
- 함수명 - 카멜케이스 🐪
- 파일명 - 케밥케이스 🥙
- 함수형태 - 화살표 ➡️
- 커밋가이드 - 유다시티 📚
- 이슈 생성 - 생략 🚫
- eslint - airbnb 🏠

## 팀원 역할 분담

| 이름 | 파트   | 담당 업무                                                            |
| ---- | ------ | -------------------------------------------------------------------- |
| 앨런 | PL/ FE | 1. 프로젝트 관리 <br/> 2. 닉네임 요청 페이지 <br/> 3. 배포 환경 구성 |
| 코코 | FE     | 1. 인트로 페이지 <br/> 2. 전송완료 페이지 <br/>                      |
| 안나 | FE     | 1. 닉네임 추천 응답 페이지 <br/> 2. 에러/로딩 페이지                 |
| 쿠쿠 | FE     | 1. 닉네임요청 생성 완료 페이지 <br/> 2. 카카오 공유 API              |
| 키위 | BE     | 1. DB테이블 설계 <br/> 2. 서버 데이터 저장 및 전송 <br/>             |
| 니주 | UI/UX  | 1. 디자인 설계 <br/> 2. UI디자인 결정 <br/>                          |

## 팀원

<table>

<tr>
<td align="center"><a href="[https://github.com/Mulgyeol](https://github.com/Mulgyeol)"><img src="https://avatars.githubusercontent.com/u/59464537?v=4" width="100px;" alt=""/><br /><sub><b>앨런(PL)</b></sub></a><br /></td>

<td align="center"><a href="[https://github.com/haeunchoi-dev](https://github.com/haeunchoi-dev)"><img src="https://avatars.githubusercontent.com/u/132250432?v=4" width="100px;" alt=""/><br /><sub><b>안나(FE)</b></sub></a><br /></td>
    
<td align="center"><a href="[https://github.com/y00eunji](https://github.com/y00eunji)"><img src="https://avatars.githubusercontent.com/u/27201591?v=4" width="100px;" alt=""/><br /><sub><b>코코(FE)</b></sub></a><br /></td>
<tr/>
    
<td align="center"><a href="[https://github.com/MAGHC](https://github.com/MAGHC)"><img src="https://avatars.githubusercontent.com/u/89845540?v=4" width="100px;" alt=""/><br /><sub><b>쿠쿠(FE)</b></sub></a><br /></td>
    
<td align="center"><a href="[https://github.com/HYEONGCHANCHO](https://github.com/HYEONGCHANCHO)"><img src="https://avatars.githubusercontent.com/u/118033064?v=4" width="100px;" alt=""/><br /><sub><b>키위(BE)</b></sub></a><br /></td>

<td align="center"><a href="[https://github.com/heejuee](https://github.com/heejuee)"><img src="https://avatars.githubusercontent.com/u/126047660?v=4" width="100px;" alt=""/><br /><sub><b>니주(UI/UX)</b></sub></a><br /></td>
<tr/>

</table>
