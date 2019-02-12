# tdd-refactoring-study

# Members

| ID | Languages | Branch_Suffix | Remarks |
|----------|:------:|------:|------:|
| eyotaku | Java | eunyoung | |
| pamiers | Java | hosik | |
| soeque | Python |jun | |


# Schedule

| No | Date   |      Place      |Branch_Prefix |  Contents | Remarks |
|----------|:-------------:|------:|------:|------:|------:|
| 1 | Tue, Jan 22 | Video Chat | calculator | 문자열 계산기 (1) | 백명석님 동영상 1,2강 |
| 2 | Thr, Feb 7 |  Video Chat | calculator |문자열 계산기 (2) |백명석님 동영상 3,4강 |
| | | | |

[In detail](https://github.com/orgs/tdd-master/projects/2)

# How to
1. 토이 프로젝으로 각자 테스트코드 및 프로덕션 코드 만들면서, tdd, refactoring 연습
2. Refactoring 후 코드 스멜 찾기
3. SOLID 원칙 위반 사항이 있는지 찾기
4. 2, 3 반복
5. 평가


## Environments

| Python Ver     | Build         | Codecov  |
| :-------------:|:-------------:|:--------:|
| 3.6 | [![CircleCI](https://circleci.com/gh/tdd-master/tdd-refactoring-study/tree/calculator%2Fjun.svg?style=svg)](https://circleci.com/gh/tdd-master/tdd-refactoring-study/tree/calculator%2Fjun) | [![codecov](https://codecov.io/gh/tdd-master/tdd-refactoring-study/branch/calculator%2Fjun/graph/badge.svg)](https://codecov.io/gh/tdd-master/tdd-refactoring-study) |

```
Python 3.6
```

### Example 2. 자판기

#### How to run

```
python main.py --coin=500 --itmes='milk'
```

#### How to test

```
python -m pytest tests/
```
