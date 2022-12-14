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
---
## ApplyIndividualToEnterpriseTest

**공통 :** 취업공고를 입력하고, 취업공고를 등록한다
```
inputAnnouncement()
makeAnnouncement()
saveAnnouncementDB()
```
### **ApplyIndividualToEnterpriseTest** - **applyAnnouncements()**

#### DisplayName: UC4-정상

개인이 공고를 보고 지원하고 성공하는 기본 흐름

- 공고 목록을 보고, 특정 검색 조건으로 공고를 검색한다.

```
showAnnouncement()
getAnnouncementList()
readAnnouncementDB()
showAnnouncement()

readAnnouncementById() // 특정 공고 선택
readAnnouncementByWage() // 특정 시급 이상으로 검색
readAnnouncementByHours() // 최대 근무시간으로 검색
readAnnouncementByDays() // 최대 주당 근무날짜로 검색
readAnnouncementByName() // 공고 제목으로 검색

//print
-----AnnouncementList-----
announcement1
announcement2
..
```

- 공고 목록중 마음에 드는 공고를 스크랩

```
scrapAnnouncementId()
scrapAnnouncement()
saveScrapDB()
```

- 공고에 지원

```
inputApply()
makeApplytoEnterprise()
saveApplyDB()

//print
apply saved
```

- 기업이 지원내용을 승인하고, 그즉시 개인 근무이력에 추가

```
inputPassOrNot()
passOrNot()
saveApplyDB()
addWorkHistory()
saveWorkHistoryDB()

//print
Passed!
workhistory saved!
```

- 기업이 공고를 내린다

```
deleteAnnouncementId()
```


### **ApplyIndividualToEnterpriseTest - noResult()**

#### DisplayName: UC4-검색결과 없음

- 조건을 넣어 검색했을 때, 일치하는 결과가 없다.

```
readAnnouncementById()
getAnnouncementList()
readAnnouncementDB()

//print
No result has been found! Display all announcement //검색결과 없음

---AnnouncementList----
announcement1
announcement2
..

```

### **ApplyIndividualToEnterpriseTest - deadlinePassed()**

#### DisplayName: UC4-공고기한 만료

- 공고를 생성할때 정해놓은 기간이 지나갔을 때

```
deadlinePassed()
deleteAnnouncement()

//print
Today = yy/mm/dd Announcement’s deadline : yy/mm/dd
Delete announcement Id: //기간 만료시
```

### **ApplyIndividualToEnterpriseTest-failedResult()**

#### DisplayName: UC4-기업 지원 불합격

- 기업이 지원에 대해 불합격 처리한 경우

```
inputPassOrNot()
passOrNot()
saveApplyDB()

//print
result : false
Failed..
```

### **ApplyIndividualToEnterpriseTest - calculatedWage()**

#### DisplayName: UC11 - 공고 임금 계산기

- 특정 공고에 대해 한달 월급을 계산하여 보여준다

```
readAnnouncementById()
CalculateWage()
showAnnouncement()

//print
-----AnnouncementList-----
announcement1
announcement2
...

wage = …. wage per hour = …. working hours per week = …. //공고 월급 계산
```
---
### **QuestionTest - makeQuestion()**

#### DisplayName: UC9-질문 등록 정상

질문 등록과 답변의 정상 흐름

- 질문 등록

```
inputQuestion()
addQuestion()
saveQuestionDB()

//print
question saved!!
```

- 매니저가 질문에 답변

```
findQuestion()
showQuestionList()
inputAnswer()
addAnswer()
saveQuestionDB()

//print
questionInformation // before answer
questionInformation // after answer

```

### **QuestionTest - directAsk()**

#### DisplayName: UC9-관리자 직접연락 정보조회

- 관리자의 메일, 전화번호 정보를 가져온다

```
showMail()
showPhoneNumber()
showAdminInform()

//print
Contract Email : , Contract number :

```

### **ReportTest**

### **ReportTest - addReport()**

#### DisplayName: UC10-신고 정상

신고등록-신고 판단의 정상 흐름

- 신고 접수

```
inputReport()
addReport()
saveReportDB()

//print
report saved!!

```

- 매니저의 신고 판단

```
findReport()
makeJudgement()
findMemberInfo()
deactivateMember()
modifyIndividualAccountInfo()

//print
Judgement =                        //makeJudgement()
ReportedMember's Info =            //findMemberInfo()
memberId member has been blocked   //deactivateMember
개인회원 정보 수정 성공             //modifyIndividualAccountInfo
```

### **ReportTest - rejectReport()**

#### DisplayName: UC10-신고 반려

- 신고 내역에 대해 반려
```
findReport()
makeJudgement()
removeReport()

//print
Judgement =
Remove report Id :
```
---


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
