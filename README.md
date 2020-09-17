# 👩‍💻 BITFLIX 🎬
비트캠프 자바 과정 1차 미니 해커톤에서 진행한 프로젝트입니다. (김하연, 최희진) 

## 주요 기능

- 멤버의 취향 장르에 따라 달라지는 화면 제공
- 추천 시스템
- 인기순, 장르별 영화 필터링

# 일지
## 2020-09-18

### 기능 추가
- `loadMembers()` 작성: Member 데이터를 파일에서 불러오는 메서드를 작성하였다.


### Tree-shaking
전혀 사용하지 않은 필드와 메서드가 남아있어서 삭제하였다.
- `Member.AllMovieHandler` 필드 삭제
- `MovieHandler.add(String title)` 메서드 삭제

### Bug

- 한 회원이 본 영화가 다른 회원의 본 영화에도 반영이 되고, 보고싶은 영화가 두 번 출력된다.
- 문제가 되는 `CommandProcessor.saveMembers()` 메서드를 수정해야 한다.

```
// data/member.csv
김하연,eungeun,1111,로맨스,다크나이트,라라랜드:캐롤:미드소마
최희진,eungeun2,1111,액션,다크나이트다크나이트,라라랜드:캐롤:미드소마
```

### 느낀점
희진: 일주일만 지나도 자신이 작성한 코드가 기억나지 않는다는 게 실감이 되었다.
하연: 문제가 되는 메서드가 어디서 어떻게 사용되고 있는 지 파악이 바로 안 되어서 찾느라 소비되는 시간이 많았다. 코드에 대한 이해가 더 필요하다.
