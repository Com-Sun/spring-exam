![](./img/1.png)

![](./img/2.PNG)

### 요약

* [ ] 요구사항 1
* 제공하는 상수도 요금표를 메모리에 로드하고 사용자가 입력한 사용량에 따라 요금을 지자체별, 업종별로 표시하는 기능을 제공하세요. -DONE
* 가장 저렴한 가격(`billTotal`)을 가진 항목을 5개만 가격 오름차순으로 표시합니다. -DONE

* [ ] 요구사항2
* 다음의 역할을 하는 스프링빈을 각각 생성해야 합니다.
    * csv 파일을 파싱하는 스프링빈 (인터페이스 포함) -DONE
    * 결과를 화면에 표시하는 스프링빈 (인터페이스 포함) - DONE
    * 요금표 데이터를 저장하고 조회하는 역할을 하는 스프링빈 - DONE
    * 입력받은 사용량으로 요금표에서 구간을 찾아내고 요금을 계산해 주는 스프링빈 - DONE
    
* [ ] 요구사항3
* 실행하는 스프링 빈의 모든 메소드의 실행시간을 elapse.log 파일에 저장하세요. (AOP 를 이용해야 합니다.) - DONE

* [ ] 요구사항4
* TODO: 테스트코드 작성 -DONE
* SonarQube - DONE

* [ ] 요구사항5
* 원본 데이터가 CSV 형식에서 JSON 형식으로 변경되었습니다. -DONE
* JSON 포멧의 데이터를 읽어서 동일한 기능을 하도록 수정하세요. -DONE
* `TODO: 가능하면 확장자에 따라 자동으로 parser 를 선택하도록 구현하세요.`
* jackson 라이브러리를 사용하세요. -DONE

