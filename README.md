# Alba-man
Web Service for hiring & recruitment 



## Prerequisites

- Ubuntu 20.04.4 LTS
- Gradle 7.4
- JDK 18


### Project Settings

```
git clone ...
```

project directory added ~/AlbaMan

```
cd AlbaMan
~/AlbaMan$

```


### Build
Builds are run in "~/AlbaMan/" directory

make Gradle Wrapper

```
./gradlew

BUILD SUCCESSFUL in 2s

```

Build

```
./gradlew build

BUILD SUCCESSFUL in 3s

```


## Test Code

### AccountTest - IndividualModifyInfoSuccess()
#### DisplayName : UC6-1. 개인 정상

IndividualAccountDB 에 저장되어 있는 객체의 정보를 출력한다.
```
// print

id :
name :
Age :
```

비밀번호를 입력해 권한을 확인한다.
```
modifyIndividualInfo()
getIndividualAccounts()
readIndiDB()
verifyPassword()
permission()

// print
권한 성공
```

수정을 위한 정보를 입력 받고, 정보를 DB에 저장한다.
```
modifyIndividualAccountInfo()
saveIndiDB()

// print
개인회원 정보 수정 성공
종료
```

IndividualAccountDB에 수정 저장된 정보를 불러와 출력한다.
```
// print

id :
name :
Age :
```





### AccountTest - IndividualModifyInfoFail()
#### DisplayName : UC6-1. 개인 비밀번호 불일치

잘못된 비밀번호를 입력해서 권한에 실패하고, 종료 메시지를 출력한다.
```
modifyIndividualInfo()
getIndividualAccounts()
readIndiDB()
verifyPassword()
showResultMessage()

// print
비밀번호 불일치
권한 실패
종료
```





### AccountTest - EnterpirseModifyInfoSuccess()
#### DisplayName : UC6-2. 기업 정상

EnterpriseAccountDB 에 저장되어 있는 객체의 정보를 출력한다.
```
// print

id :
name :
Location :
```

비밀번호를 입력해 권한을 확인한다.
```
modifyEnterpriseInfo()
getEnterpriseAccounts()
readEnterDB()
verifyPassword()
permission()

// print
권한 성공
```

수정을 위한 정보를 입력 받고, 정보를 DB에 저장한다.
```
modifyEnterpriseAccountInfo()
saveEnterDB()

// print
기업계정 저장 성공
기업회원 정보 수정 성공
종료
```

EnterpriseAccountDB에 수정 저장된 정보를 불러와 출력한다.
```
// print

id :
name :
Location :
```





### AccountTest - EnterpirseModifyInfoFail()
#### DisplayName : UC6-2. 기업 비밀번호 불일치

잘못된 비밀번호를 입력해서 권한에 실패하고, 종료 메시지를 출력한다.
```
modifyEnterpriseInfo()
getEnterpriseAccounts()
readEnterDB()
verifyPassword()
showResultMessage()

// print
비밀번호 불일치
권한 실패
종료
```





### AccountTest - IndividualWithdraw()
#### DisplayName : UC7-1. 개인 정상

비밀번호를 입력해 권한을 확인한다.
```
withdrawAccount()
getIndividualAccounts()
readIndiDB()
verifyPassword()
```

탈퇴 약관을 출력하고, 계정을 삭제 후 결과를 DB에 저장한다.
```
showWithdrawalTerms()
deleteAccount()
saveIndiDB()

// print
탈퇴 약관
개인계정 저장 성공
개인회원 탈퇴 성공
```

결과 메시지를 출력하고, 종료한다.
```
showResultMessage()

// print
권한 성공
종료
```





### AccountTest - IndividualWithdrawalFail()
#### DisplayName : UC7-1. 개인 비밀번호 불일치

잘못된 비밀번호를 입력해서 권한에 실패하고, 종료 메시지를 출력한다.
```
withdrawAccount()
getIndividualAccounts()
readIndiDB()
verifyPassword()
showResultMessage

// print
비밀번호 불일치
권한 실패
종료
```





### AccountTest - EnterpriseWithdraw()
#### DisplayName : UC7-2. 기업 정상

비밀번호를 입력해 권한을 확인한다.
```
withdrawAccount()
getEnterpriseAccounts()
readEnterDB()
verifyPassword()
```

탈퇴 약관을 출력하고, 계정을 삭제 후 결과를 DB에 저장한다.
```
showWithdrawalTerms()
deleteAccount()
saveEnterDB()

// print
탈퇴 약관
기업계정 저장 성공
기업회원 탈퇴 성공
```

결과 메시지를 출력하고, 종료한다.
```
showResultMessage()

// print
권한 성공
종료
```





### AccountTest - EnterpriseWithdrawalFail()
#### DisplayName : UC7-2. 기업 비밀번호 불일치

잘못된 비밀번호를 입력해서 권한에 실패하고, 종료 메시지를 출력한다.
```
withdrawAccount()
getEnterpriseAccounts()
readEnterDB()
verifyPassword()
showResultMessage

// print
비밀번호 불일치
권한 실패
종료
```





### ReviewTest - createAReview()
#### DisplayName : UC8. 리뷰 작성 정상

개인 회원의 workhistoryDB를 조회해 리뷰 작성 권한을 확인한다.
```
makeAReview()
readIndiDB()
readWorkHistoryDB()
verifyWorkHistory()

// print
workhistory 확인 완료: 리뷰 권한 성공
```

리뷰 객체를 생성해 ReviewDB에 저장한 후, 성공 메시지를 출력한다.
```
addToReviewList()
saveReviewDB()

// print
리뷰 작성 성공
```





### ReviewTest - createAReviewFail()
#### DisplayName : UC8. 근무 이력 없음

잘못된 회원 id를 조회해 리뷰 작성에 실패하고, 결과를 메시지로 출력한다.
```
makeAReview()
readIndiDB()
readWorkHistoryDB()
verifyWorkHistory

// print
workhistory 확인 실패: 리뷰 권한 실패
리뷰 작성 실패: 권한 없음
```





### ReviewTest - searchReviews()
#### DisplayName : UC8. 리뷰 조회 정상

리뷰를 생성한다.
```
createAReview()

// print
workhistory 확인 완료: 리뷰 권한 성공
리뷰 작성 성공
```

기업 회원의 id로 ReviewDB에서 조회한 후 결과와 검색 결과를 출력한다.
```
searchAReview()
readReviewById()

// print
리뷰 검색 성공
기업 id:
리뷰 내용:
```





### ReviewTest - searchReviewFail()
#### DisplayName : UC8. 기업 id 일치 항목 없음

리뷰를 생성한다.
```
createAReview()

// print
workhistory 확인 완료: 리뷰 권한 성공
리뷰 작성 성공
```

저장되지 않은 기업 회원 id로 ReviewDB에서 조회 시도 후, 검색 결과를 출력한다.
```
searchAReview()
readReviewById()

// print
검색 결과 없음
```





### FAQTest - createFAQ()
#### DisplayName : UC9. FAQ 등록 정상

question, answer를 작성해 FAQ를 만들고 FAQDB에 저장한다.
```
makeFAQ()
addToFAQ()
FAQ()
saveFAQDB()

// print
FAQ 등록 성공
```





### FAQTest - searchFAQ()
#### DisplayName : UC9. FAQ 조회 정상

FAQ를 생성한다.
```
makeFAQ()
addToFAQ()
FAQ()
saveFAQDB()

// print
FAQ 등록 성공
```

FAQ 조회를 요청하고, FAQDB에 저장된 FAQ를 출력한다.
```
searchFAQ()
getFAQList()
readFAQDB()

// print
FAQ search 성공
1번 Q: / A:
```





### FAQTest - searchFAQFail()
#### DisplayName : UC9. FAQ 없음 조회 실패

FAQDB를 초기화 한다.
```
clearDB()
```

빈 FAQDB에 FAQ 조회를 요청하고, 실패 메시지를 출력한다.
```
searchFAQ()
getFAQList()
readFAQDB()

// print
FAQ search 실패: FAQ가 없음
```

### tree

```
├─.gradle
│  ├─7.4
│  │  ├─checksums
│  │  ├─dependencies-accessors
│  │  ├─executionHistory
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
│  └─libraries
├─build
│  ├─classes
│  │  └─java
│  │      └─main
│  │          ├─boundary
│  │          ├─controller
│  │          └─model
│  ├─libs
│  └─tmp
│      ├─compileJava
│      └─jar
├─gradle
│  └─wrapper
└─src
    ├─main
    │  └─java
    │      ├─boundary
    │      ├─controller
    │      └─model
    └─test
```


## Built With

* [Gradle](https://gradle.org/)
