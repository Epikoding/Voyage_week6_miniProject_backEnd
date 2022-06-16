- [****🎡**** 짤태식이 돌아왔구나 - ****프로젝트 소개****](#---------------------------------------)
  * [🎑 만들게 된 배경 설명 &  목적](#--------------------)
    + [배경 설명](#-----)
    + [목적](#--)
  * [👥 **1. 제작 기간 & 팀원 소개**](#-----1----------------)
  * [****🧰**** **2. 사용 기술 및 툴**](#-------------2------------)
    + [**🌱 Back-end 🌱**](#-----back-end-----)
    + [**🌱 Front-end 🌱**](#-----front-end-----)
    + [**🌱** 배포 **🌱**](#----------------)
  * [🖇️ **3. Wireframe -** 짤태식이 돌아왔구나 **링크**](#------3-wireframe----------------------)
  * [메인화면](#----)
  * [**회원가입**](#--------)
  * [**로그인**](#-------)
  * [**짤 게시물 작성**](#------------)
  * [**짤 게시물 수정**](#------------)
  * [🖇️ **4. S.A (Starting Assignment)**](#------4-sa--starting-assignment---)
  * [🖇️ **5. 실행화면 유튜브 링크**](#------5--------------)
  * [💯 **6. 핵심기능**](#-----6-------)
  * [🎮 **7. Trouble shooting**](#-----7-trouble-shooting--)
  * [Front-end](#front-end)
  * [Back-end](#back-end)
  * [⚙️ **8. 주목할 만한 코드**](#-----8------------)
  * [8-1. Front-end](#8-1-front-end)
    + [아이디 / 패스워드 인식 및 실행](#------------------)
    + [댓글 목록 불러오기 / 작성 / 삭제](#--------------------)
    + [태그 분류, 검색 기능](#------------)
    + [Form 을 활용한 태그 목록 만들기](#form----------------)
    + [파이어 베이스 이미지 저장](#--------------)
  * [8-2. Back-end](#8-2-back-end)
    + [코멘트 작성](#------)
    + [**JwtExceptionFilter**](#--jwtexceptionfilter--)
    + [**토큰 재발급 AOP**](#---------aop--)
    + [**QueryDSL Projection을 사용해 해당 게시물 댓글 조회 후, DTO 로 변환해 전달**](#--querydsl-projection----------------------dto-----------)
  * [📐 9**. API**](#---9---api--)
  * [로그인/회원가입](#--------)
  * [작성](#--)
  * [메인페이지](#-----)
  * [Detail 수정](#detail---)
  * [💏 **10조 한줄 회고**](#-----10---------)


# ****🎡**** 짤태식이 돌아왔구나 - ****프로젝트 소개****

![](https://lh3.googleusercontent.com/CTh9C0OcRTuUL7L_OMnzfv1Z44VVAkyo8Vz68jKHUCONnYaE_1jbI4_SeebjLrRzJivfN7zJ9uVOAxdyvH5Hbn2iZzAWY8jHHV30D_e-PDy7COpcXGBa6iXaQIf9ptf7V-f_neU0xWps6mOu6COit4jqy5Td9vbkQXnfqR7Q9TLDFCmQb7xFaYdLfksnm6Ug9ETLif5SdjR35Yi7nIbRQ4_OPQq8rTcqLasOOJ2-qIS8sCU6hn999qqZ2ZQrxr8F46Yh8ujHsqfHDarecyOqKqH6gitF579WDvxd2aNfcPnyP7jOYYK_FQNU5GQ5wjsiighhCRT4pru2NnHJb6Y51cKk1M91hhF_vGXQymv-Q3X4NMvHBJAvZK6_GBGus_cjHtuUGM2T5hvJ_fwsqSgyQZWxnFnpwIbXUQFhvF2W2hUFYUsmXiPbHErCDYGuw2PQnRt7kdGFuLrXFOqyqX7-bbrLMNYAlZTPQ16mXVUbYM1GfLE9jEYx3l1CEJOeEJ723XIiGkxrxTXCvBR3AgwDozM1JPNeqv3oXo42AmRYv2k835GybP5Sdq1CP1qsVhcMlUSz8YZlBNEt8-ngM2QuurndIGLcmv_vbZ3pDrhSG24Vddgsep_nlKewnmCIG-TRp-uWNlZf7NFSBHQ88Io66yaCkifjpNTE1VC6ULnHt-Z4pLcubRaqFSoZO2Ekwxx9DJQLB4_T9XHeE1daesCTHon075h1W4TC2l6hUpkYV8C-FMeviavtWHAjKoL6mzR-uZ9bAlda2CQfTJ7R10AlNGQCmuY0k3T7JA=w1552-h914-no?authuser=0)
---

## 🎑 만들게 된 배경 설명 &  목적

### 배경 설명

컴퓨터 앞에 앉아있는 시간이 많아서인지 개발자들은 유독 대화를 할 때 짤방을 많이 이용하는 것 같습니다. ‘구글링’이 하나의 필수 역량이기에 개발자들은 특히 본인이 원하는 짤방을 잘 찾는 것 같은데요. ‘짤태식이 돌왔구나’는 “짤방을 조금 더 재밌게 사용하자”란 목적으로 제작되었습니다. 해당 사이트는 아래의 기능들을 제공합니다.

1. 본인이 원하는 짤방 저장 및 짤방에 맞는 태그 선택 및 저장.
2. 짤방을 저장할 때 업로더가 원하는 문구와 함께 짤방 제공.
3. 업로더는 마이페이지에서 본인이 업로드한 짤방의 문구와 태그 수정 가능.

### 목적

React와 Spring을 통합하는 것을 1차 목적으로 설정했습니다. 프론트와 백엔드는 지난 3주동안 각자 프레임워크를 공부했고 서버가 없는 React는 Firebase를 통해, 클라이언트가 없는 Spring은 ARC를 이용해왔습니다. 그렇기에 이번 주의 미니 프로젝트는 서로 호출을 주고받은 것을 중점으로 두었습니다. 

1차 목적이 달성하면 2차로서 카카오톡으로 회원가입하기, 좋아요 버튼, 검색 기능을 목표로 잡았지만 주어진 시간 내에 얼마나 많은 기능을 구현하는 것이 이번주 목표가 아니라고 판단, 서로의 언어를 이해하는 것으로 우회했습니다. 결과적으로 이는 옳은 선택이었다 생각합니다. 왜냐하면 서로 호출을 하고 오류를 잡는 것이 각자의 언어로 기능을 구현하는 것 보다 더 큰 노력과 시간이 들었기 때문입니다. 

‘짤태식이 돌아왔구나’와 같은 사이트 혹은 플랫폼을 만들기 위해 서로가 서로를 필요로 했고 의지해야 했습니다. 이번주 프로젝트를 통해 항해99 7기 C조 10조는 양자간의 커뮤니케이션이 얼마나 중요한지와 원활한 프로젝트의 진행을 위해 api를 꼼꼼하게 설계해야 한다는 교훈을 얻었습니다.

---

## 👥 **1. 제작 기간 & 팀원 소개**

- 2022년 06월 09일 ~ 2022년 06월 16일

| 이름 | 개인 블로그 링크 | 깃허브 링크 | 프론트&백엔드 |
| --- | --- | --- | --- |
| 최성우 | https://tjddn8195.tistory.com/ | https://github.com/ChoiSungwoo1216 | 프론트엔드 |
| 한결 | https://ghan1012.tistory.com/ | https://github.com/GHan19 | 프론트엔드 |
| 이정찬 | https://biolkj28.tistory.com/ | https://github.com/biolkj28 | 백엔드 |
| 이동재 | https://velog.io/@djlesque | https://github.com/Epikoding | 백엔드 |

> **조원 역할 및 기능 개발 설명**
> 
> 
> > **최성우**
> > 
> > - 메인,  작성, 상세, 수정 페이지
> > - 서버와 연결
> > - 태그별로 게시글 분류
> > - 댓글 작성, 삭제 기능
> > - 게시글에 태그 추가, 삭제
> > - 이미지 업로드
> 
> > **한결**
> > 
> > - 로그인 & 회원가입
> 
> > **이정찬**
> > 
> > - 로그인 & 회원가입 기능 구현
> > - 댓글 작성, 게시글 조회, 댓글 조회 기능 구현
> 
> > **이동재**
> > 
> > - Api 설계
> > - MVC 패턴 설계

---

## ****🧰**** **2. 사용 기술 및 툴**

### **🌱 Back-end 🌱**

- Java 8
- SpringBoot
- Spring Security
- Gradle
- JPA
- MySQL 8.0

### **🌱 Front-end 🌱**

- React
- react-router-dom
- Axios
- Redux
- Styeld Component (for es6 and css)
- Fortawesome
- google font
- Bulma
- Testing Library
- Firebase

### **🌱** 배포 **🌱**

- AWS
- FileZilla

---

## 🖇️ **3. Wireframe -** 짤태식이 돌아왔구나 **링크**


🔗 [http://miniproject6.s3-website.ap-northeast-2.amazonaws.com/](http://miniproject6.s3-website.ap-northeast-2.amazonaws.com/)


## 메인화면

![](https://lh3.googleusercontent.com/dvE78tkS1W5kqSHczCAG4XiamZ8mAIOUpvPPuLroe9GDUuQmDAd-2Uy1bhlmJoDzW9jEt_rG0swxF3yrIYfWQj7rtwn5QC3gXm_tAuQYlMpFtIwRWTkggA3sMWKZM667b_34RY1Ycj-t55NRWfvOwRTMzCGoyx95itepmFvs8RYTqiOXH3ApjJNIvScmyaGpbHHNdjv1vDJj73Pf0JpqpB-KnbtzD-T75hX9cuYJPJKZlMi1lLh4h6kF9oXjqS1MaeQSW_drxZuh2h8SUq4srmv3M1UXNHcoPyVpga0jj0jEK69-3ZRRVD_PaYT8j1Ad9mZDcX3j0l9LXYpxS4M4fUF31VHV5QGWQQwA0Guz8uhe9FDchGgM-i5GM6EZALxT8jmzGUsGbVv9651OVhzptzU7QIOuXnzQzNDudsnoXNn8y8EvJ_Cg2A1CtZXsNh7NjHJnFsf9YLkq-Kt42Hl7T0aTObw5BlMYT1qbEhFBzX4riOLzpHYsb60fAwJOEH9YcHPXJvJ-10sTHiqjmw4hXAVJ7dU6RTTVXtuiBUqpmUpaMsEokoZfvmAu5tIxsK3cm10fcybnht-7lLNNegRGA80Vx8PVYApbaR5dG9eSogq60Q7t0ZvXr0QPhQczP7psvrd5xEAC0BkUf7hiUgCqvHqnxVjtP7ChOIc3tZV_f27KrcI_JgPwzPmpafki1C2jzEokMy-vCVFYc9sZ0faULYjgv8AbAAzXwXid_AKZlVkJ4pz9H4TFUU6i1QDVeKqJjtCDPBcsfHag36wP4OPVu8WDvX6Gfkw9Tg=w876-h859-no?authuser=0)

- 로그인/회원가입 NavBar 및 전체 메인화면
- 게시물 작성한 사용자만 수정 및 삭제 허용(타인이 다른 사람의 게시물에 댓글을 올릴시 본인 삭제 불가능 → 게시물 작성자만 게시물 관련 타인 댓글 삭제 가능)
- 로그인 시 게시물 작성 가능하도록 허용

## **회원가입**

![](https://lh3.googleusercontent.com/N1ALjVfPbQM8_DhaFKLzphw0l08K_rythVgN1spsUTjdPUYf7_JMQe4ksv6VD2vBnkuRzsvOUEuISfDVevjUsKBZ0GQqtMTK6srhWEZFU8Ajmoy_m9QCot-FsbqJyuySSSxoN4Rwg387lSbuUWmwKzURULRMc37-a06SYBpzCam8ed5eZkKaNOytwUwaTIwHj5pjuXqBR1FOQmL0dBpqPR8qwhpki3CuadK6qhNLc_rcodJgueBCeS6td5P8VjSenLWPPVtuf4WuP8-SBLd992Eyft0VFJgjSd1W3IUnYwFK5gN4XqZwEAGGDWkH5jfkk1ij2mDRFnS8HGjnORbvCZhILO9VhJr-LtkCDqgFPOGKfAcEf3xoIZJdlVEyqtsp_-dlbtOCyQkuOtp55WrT50QrRz2WEYH_Qg_aWXKToMIKfhMoWI166r1n_DqwgnMEmj2K5CnEGxbwPxzakSdzZgaKuXKxAP3fXMPQ2BgRKjCQ6CXX1hG2JOvAmWonHeVulG55emIX-XYw9HnkfIxPGGVl12DcSoVgC9frZH8iU3m7Uvo06BbCzeGvulP2V1AwuTlP4IQfvze4YNv8s5xhlyj8AZckg58UhUWw4OtpC_teKiKmMfz9xt_b1oCXMiCEhbVv9yGU6Q5Y7zp6Eoi04hy3eb3VvaXkESau4HyVusO91U3qQ-dZ8bv61UlhtzfwkA3FYK8YZhdOHGQ76zm9T9ZwxhQA-iHERjgDdPMW5rwVqTqOHxHYGiiFiZRzweSWLzxKVTvGVcULF6UUeYezs6Nb1aADWuLZHg=w940-h642-no?authuser=0)

![](https://lh3.googleusercontent.com/M2yB0F9ZQ3OUfW8_Vixz94CxPc20HseHCNAHCA_fzkmBlJEcs8qWtjPgAYVGZIFJlafngx89ZEqv1MGAC-6vY44cyTwgev6lvwZJGuP5Z79MgxZDZtz1_J2CRsNMSCWNh04-Abi9-eHrDW-_Cj5l6u99a4nv5SkpEyi61pXSZGtKHuIKUo2B8ztOWEnDTv3aIpY-DSfkmlv2PIpK7ETerMAj9X4OwBcBCQiY2wJ-UFrAon5A5C1T2j9q7YIagAOAzV8CYebbn6e4BYfW2olJutC7xDCvHxrCtex-ctXJibeliWFLHUsxG0XCluuNcBfdL1JOnpD3xXpzxcwWuYRaiYyy8cVHJQ3_qBa4cDrHXcFLla5ZlC7AGcAW-UPwSdyZVL_Bd26PAzoMhgCfK5I6_fRFh6RVO1Qf-dwNWkNb3iY8rIfPgEyAAn12rvEq6Y8dofP-xRPMchUrGyBECg0AIvBnDX-Y_A6fu_OMIcn_7kM4zshqZ3WL5vHOUGJW_rUDYhszr53J19DnomRpvhCPVW9bQTcVKfV1x7_5-6r_sa_WosdwYseqo5OnWgslCkUc_wMNITtuc64kLjj_4BszUDJTqXvMm4UwYj1B59xEWZk6GLvq2gmmLhTyqF5msvsdEWCX3bvIPVhHlOFFz24_Yrh-UqhktKVRVSuiFqYdYMTvXy-RPHxv8BiEP8wVZnARHR1EnE_JrFhzwgM8U-rR8MpbbjJTj1pSgjchLZBnUufHQB5dWZj9t2j-OvwHIGB5AkTJcfMYOOYouWXbLsX7in4Orfo5tMsO4A=w940-h733-no?authuser=0)

- 기입박스 안에 작성시 밑에 ‘가입하기’ 박스가 뜨도록 설정

## **로그인**

![](https://lh3.googleusercontent.com/fMnTzlkiVxgBZRZHLduxO0-uVBxc_3hTjesA5V4JrNkM4mc2L1gJ3qtHqR6xb3E3_4MSutAM1XcKOO520pig33UUXgZGCRqUSNRBKzLZKG3gMrLGSVzU1VM5EyVfJAUWw_EKbXx3B48w37QVjtMyc41AdcHM6SWGiPZHTTGupJtBkiV4ERGTR1N6lj7Be2exuZ3xp__mk9qYp4uz7jK6JeMRpN7gHkiNpotHpti_tsfiqTRNRvBK16VBFcVk-izV473GUKaWV6Le9e9NWIXRetmyTsNoTWJ-pTVA0uqvbxieX2aYwA0fyx7zvuiyhODtQcm8tS8tbHfAsWnCK95VW5m2uaZ-e7CCqlWaRMKNG6GjrnBFhUDHL50jIWzUYBsarN9B9Oha-H3t5etj8OOyGc_uRCMn1VFy2ZQ6p8Rv8tc6ZkGNHb6t54zkKP1UuUB6nXe4Mnzu23s5XXa3jxSJmuUhtRKVUFuH3Lug-Hw1-TbY2rWyTKpBcSgKfEfwkzYS3b5LRICCKBtwjp5S-3ZX3lav9pqkUmTTFdJ4C9Y165jlPfGlrh9BvDleaUWTosOVjXZgjKFbn8EZdC2p07elhLfbIC5Nb-0_xnrHVET7BIhtc7GHx5lYQppKUDy96jVpmrkUtBUVo7vAh_94DHmtdZxhD6EJoGrzisTj0fV227Q7r-3KDaZQcN2R9EjlCnSHjMkc9w5ny95NPggeMGaxkGSc_wMf2f0ucarwMK-0qV-ynFm3Gzqg69E0Ty-rW5Eoyah6yoHw2yT9-sCmv_JvfF8dFHQCLZICPg=w940-h818-no?authuser=0)

## **짤 게시물 작성**

![](https://lh3.googleusercontent.com/40m98ojqjj7PwoasqYtd7btMTu2WkcuN4s4g8p2Sq1qY3Zwyp-rdpB57MYv33a776sSXzLM6cApumWUGdv8EZD515qGmNOdi0uPCb3PmawLXsBoRxghLICP2v5HNoUxZ0NXG960tANn9WNOPPApCxm6vD9HDnkuR_ggFGLwWdqPIvcvUx0MB430A06W4DJYkEvJ1AFGpvp3OvE2YPrkVNTCJxeLTKP9m4lufM6y30DaMFoxPl6E54Dcz9SqKAEgNsU1cqnDFqr9L8lK6se6HDJZqkCHL3RQilcszssco86cXsbdoishVNtVwXBqVGFkKrc-cAUiZ_Yl2hah_VyPowHEDyX-9Dcxve2U1v8CnmnPBxRVNJCFa3PIcKieW-z6pqDZbfS1TbPxLqIVgACckvpDxiqOaEw47xR305BAPrCmknweLo7lS5uG4J_2mAbPEm1BYYsOjCX_vEGR_efjP_kQe3qgnGE65Fp7b8XefM8-62xkeTY1LBxxbruZwvemkao2Hn2RwoWVSmQOo37h1u0WKzcEA0auOgiXJb-JdyvxAKGUyLGIkRL69jrnt7bLkgaPOaAzqdI6eCOCIj-IMCfN2qWuarUF3mx6nRXyOaFLGS5lZbI5gpktRbzDgn6Yywo7TjRhxHoPcnh7Msq_eASqinq9gN2kPh684C-riw_EI4PkXUeVWjyiUuyRJwrqbI9yQDPsQaHijhQRdyvZLgA9tUnYJOpS-SR6Jkj5OE5ubRIUnHOEInfuT5uTLnERhIDqBaxU_3-lMSC3XUPabOmx_i_zbrILU8w=w1071-h664-no?authuser=0)
## **짤 게시물 수정**

![](https://lh3.googleusercontent.com/jb3oDxMaS-QohITuj4W47_MoQpRxlWRvfypOsOCJhk9kGYNit_Vp81l9A_r6r2Yq0ZWynBi-8ZW-_470echv1v_Za6k56whKjQsvEAq5kkcK0crE0veI85X1i-iWNSBUMgxqYn0L_VzltExUSBLzmseqhSodsgKPYi_vLBe5lGQnSOdmEcWmBL1W10v96Mh8bGaIu-UI64EZM1BH7hCYltRbsyYSyP6rmmtw0n8zm2xnqBiStM3GAt-uj4eFPji9QibpvknxlSTIYm-VwbsbYBd_n_eUwP4HG0VJ_cqMVXRJAVrgyVCUDezFi-XoyZi1xwJNgRJBfMVeIEJNAyZV94Ga1OdQd0N_fXwIHNBfYF9PFw-vX5nm9-iJ1FRZT8X6DOKO3yH0VF_Zdz6DzwP3RLVUUEUpu6tSD2xawyUgf0ojMNzcKcZhuNASyBGwKFn16PukJIfAYaGsXZuM7S0bEUSZiIr3_FbjKcMvEhdjxYscMq_JVNjmwpXHNNPofq2XHZKH6XmC5Vzp0tdsAfDhTXB94c2EOyIDLy8NsOZiXKCZLDY8t5mk6Xwri5w0Rh07uhEf0maH4jKL8UWAGH9EzAFweQ8JXTWdHuwkEy-nE4AFE6o0zsRl3cK-6hGrJpi0xz1imipkMD2fdlTqEEbtGP_Xc4GInK_KrUdd1f_20GJJuiSvaVVfoKDX_YWCorDZ_CQ2WWk9l_QCAeTM1zJodmbPGXZu9MEmTr0rzZrmOpHSfgKgf7iRwzmLOAoMojJhurJaRBFUyF65lfU5kn2ihuxHMsyw4QDbqA=w1123-h738-no?authuser=0)

---

## 🖇️ **4. S.A (Starting Assignment)**


🔗 [https://velog.io/@djlesque/항해99-6주차-S.A](https://velog.io/@djlesque/%ED%95%AD%ED%95%B499-6%EC%A3%BC%EC%B0%A8-S.A)


---

## 🖇️ **5. 실행화면 유튜브 링크**


🔗 [https://youtu.be/QrBAcLhIFMM](https://youtu.be/QrBAcLhIFMM)


---

## 💯 **6. 핵심기능**

- 회원가입, 로그인 & 로그아웃
    - 아이디 이메일 양식 정규식으로 유효성 검사
    - 비밀번호 중복 확인
    - 작성 완료 전에 버튼 비활성화
    
- 메인 페이지
    - 태그 버튼 클릭 시, 해당 태그 보유 게시글만 표현
    - 로그인 되면 작성 버튼 활성화
    - 게시글 카드 클릭 시, 상세 페이지 이동
    - 이미지, 작성자, 댓글 개수 표현
    
- 상세 페이지
    - 해당 게시글의 댓글 조회
    - 댓글 작성 및 삭제
    - 작성자 한해서 게시글 수정 및 삭제 가능
    
- 업로드 페이지
    - 이미지를 업로드해 firebase store에 저장, 미리보기 기능
    - select를 통해 멀티 태그 추가 기능
    - 태그 버튼 클릭 시, 선택 취소
    - 체크박스를 통해 이미지 위, 아래에 글 추가 기능
    
- 게시글 수정 페이지
    - 이전 기록을 그대로 가진 상태에서 정보 수정
    - 이미지는 변경 불가능하게 만듬
    - Axios put 메서드를 통한 서버에 정보 수정 요청

---

## 🎮 **7. Trouble shooting**

## Front-end

> Spring과 React서버 연결
> 
> 
> > 이슈 내용 :  Spring과 React서버 연결불가, `Error 400` 발생, Payload에 내용은 들어있으나 서버에 값이 넘어가지 않았음
> > 
> 
> > 해결 방법 : `defaults.withCredentials = true` 추가, `baseURL` 따로 명시
> > 

> 로그인 불가 문제
> 
> 
> > 이슈 내용 : Header은 전송이 되었으나,  React에서 보낸 로그인 바디값이 백엔드로 안 보내지는 문제 발생
> > 
> 
> > 해결 방법 :
> > 

> Axios 헤더 작성 위치 오류
> 
> 
> > 이슈 내용 :  Upload Axios Error 403
> > 
> 
> > 해결 방법 : `axios ({url : “”, data: “”, baseurl:”” headers:{} })`   원래 headers가 `{…}, { headers: {}}` 이렇게 적혀있어서 헤더 전송불가
> > 

> [arr.map](http://arr.map) 활용문제
> 
> 
> > 이슈 내용 :  받아오는 객체 안에 배열이 하나 더 있어서 오류 발생
> > 
> 
> > 해결 방법 : 2중 map 사용을 통해서 객체안에 배열 안에 요소 사용.
> > 

> useEffect 내 무한루프 해결
> 
> 
> > 이슈 내용 :  useEffect, dispatch를 사용하게되면 무한 렌더링 루프에 걸림
> > 
> 
> > 해결 방법 : `{dispatch(function(type)}, [dispatch, type]);`을 써서 최초 렌더링 때 type 값이 변경될때만 리렌더링 작동
> > 

> Delete Axios가 무한으로 요청이 보내짐
> 
> 
> > 이슈 내용 :  삭제 요청이 계속 보내져서, 이미 삭제된 게시글에 요청이 보내지다보니 에러메세지가 계속 작동 됨
> > 
> 
> > 해결 방법 : axios에 async await를 추가.
> > 

## Back-end

> **QueryDSL을 사용하여 일대 다 연관 관계 두 개 컬럼 패치시 오류 발생**
> 
> 
> > **이슈 내용(에러코드)** :  `org.hibernate.loader.MultipleBagFetchException`
> > 
> 
> > **해결 방법** :  `List`는 복수 개의 fetch 가 안됨으로 컬럼 타입 `Set`으로 변경
> > 

> **LocalDateTime, json으로 변환 실패 오류**
> 
> 
> > **이슈 내용(에러코드)** :  `InvalidDefinitionException: Java 8 date/time type java.time.LocalDateTime...`
> > 
> 
> > **해결 방법** :  java 8 의 date/time은  POJO로 serialize가 될수 없기에 문자열로 변환 response
> > 

> **LocalDateTime, json으로 변환 실패 오류**
> 
> 
> > **이슈 내용(에러코드)** :  `InvalidDefinitionException: Java 8 date/time type java.time.LocalDateTime...`
> > 
> 
> > **해결 방법** :  java 8 의 date/time은  POJO로 serialize가 될수 없기에 문자열로 변환 response
> > 

> **Cors 에러**
> 
> 
> > **이슈 내용:** react 에서 ec2 서버로 요청 시 cors에러 발생
> > 
> 
> > **해결 방법** : spring security Cors 설정에 s3 엔드 포인드 `AllowedOrigin` 추가
> > 

> **DTO 형식의 반환형에 `fetchJoin()` 시 발생**
> 
> 
> > **이슈 내용(에러 코드): org.hibernate.QueryException: query specified join fetching, but the owner of the fetched association was not present in the select list**
> > 
> 
> > **해결 방법** : `fetchjoin()` 제거
> > 

> 유효하지 않은 토큰 시 강제 로그아웃 처리 시, “다시 로그인 해주세요” 메시지출력 안됨
> 
> 
> > **이슈 내용(에러 코드):** `java.lang.IllegalStateException: getWriter() has already been called for this response`
> > 
> 
> > **해결 방법** : exception을 다르게 해서 `response.getWriter()` 겹치지 않게 로직 변경
> > 

---

## ⚙️ **8. 주목할 만한 코드**

## 8-1. Front-end

### 아이디 / 패스워드 인식 및 실행

- `axion` 을 통한 아이디와 패스워스 api 연동성 확장
- `.then` 과 `.catch`  를 통한 구동방식 설정
    
    ```jsx
    const loginAxios = async () => {
        // login(id_check, pwd_check);
        axios.defaults.withCredentials = true;
        axios({
          url: "/user/login",
          method: "post",
          data: {
            email: id_check,
            password: pwd_check,
          },
          baseURL: "server_url",
        })
          .then((response) => {
            localStorage.setItem("user", response.config.data);
            localStorage.setItem("Authorization", response.headers.authorization);
            localStorage.setItem("RefreshToken", response.headers.refreshtoken);
    
            navigate("/");
          })
          .catch((response) => {
            console.log(response);
            window.alert(response.message);
          });
      };
    ```
    

### 댓글 목록 불러오기 / 작성 / 삭제

- `axion` 을 통한 댓글 목록을 열람, 작성, 삭제
- get 메서드와 params를 통해 원하는 게시물의 댓글 목록 불러오기
- post 메서드 활용과 보안을 위한 헤더에 토근 정보 추가
- async await를 사용한 비동기 작동
    
    ```jsx
    const LoadCmtAxios = () => {
            axios.defaults.withCredentials = true;
            return async function (dispatch) {
                await axios(
                    {
                        url: "/post/getCommentsByPostId",
                        method: "get",
                        params: {
                            "postId": post_id,
                        },
                        baseURL: "server_url",
                    }
                )
                    .then(response => {
                        console.log(response)
                        setCmtList(response.data)
                        dispatch(loadsingle(response.data))
    
                    })
                    .catch((response) => {
                        if (!response) {
                            window.alert("Error: Network Error");
                        } else {
                            window.alert(response.message)
                        }
                    });
            }
        }
    
    //댓글 삭제
        const DelCmtAxios = (id) => {
            return async function () {
                axios.defaults.withCredentials = true;
                console.log(id)
                await axios(
                    {
                        url: "/post/commentDelete",
                        method: "post",
                        data: {
                            "postId": post_id,
                            "commentId": id,
                        },
                        baseURL: "server_url",
                        headers: {
                            "Authorization": localStorage.getItem("Authorization"),
                            "Refreshtoken": localStorage.getItem("Refreshtoken")
                        }
                    }
                )
                    .then(response => {
                        console.log(response);
                        window.alert("삭제완료");
                        navigate("/");
                    })
                    .catch((response) => {
                        if (response.response.data.reLogin === true) {
                            window.alert("다시 로그인 해주세요")
                        } else {
                            window.alert(response.message)
                        }
                    })
            }
        };
    ```
    

### 태그 분류, 검색 기능

- useState 훅을 활용
- map을 이용해 태그를 활용해 원하는 키워드로 분류
    
    ```jsx
    // 태그로 분류
    const [tagvalue, setTag] = React.useState("")
    
        function searchTag(tagvalue, tagList) {
            for (let i = 0; i < tagList.length; i++) {
                if (tagvalue === tagList[i]) {
                    return true;
                }
            }
            if (tagvalue === "") {
                return true;
            } else {
                return false;
            }
        }
    
    ...
    const tl = post_lists[index].tagList.map((e, idx) => {
                            const tli = post_lists[index].tagList[idx].tag
                            return tli;
                        })
    	return (
    		{searchTag(tagvalue, tl) ? (
    				...
    		) : (null)}
    	)
    
    // 검색
    const [search, setSearch] = React.useState("");
        const onSearch = (e) => {
            e.preventDefault();
            if (search === null || search === "") {
    // axios로 서버에서 데이터를 불러올 경우
                // axios.get("url")
                // .then((response)=>{
                //     setLists(response.data.post)
                // })
                setLists(post_lists);
            } else {
                const filterData = lists.filter((lists) => lists.tag.includes(search))
                setLists(filterData);
            }
            setSearch("");
        }
        const onChangeSearch = (e) => {
            e.preventDefault();
            setSearch(e.target.value);
        }
    ```
    

### Form 을 활용한 태그 목록 만들기

- form,  button submit을 응용해 태그를 게시글에 추가
- select 를 활용한 태그 선택
    
    ```jsx
    const [newtag, setNewtag] = React.useState("");
    const [tags, setTags] = React.useState([]);
    
    const onTag = (e) => {
            e.preventDefault();
            if (newtag !== null && newtag !== "") {
                const taglist = [...tags, newtag];
                setTags(taglist);
            }
            setNewtag("")
        }
    
    const onChangeTag = (e) => {
            e.preventDefault();
            setNewtag(e.target.value);
    }
    
    ....
    
    <TagForm onSubmit={(e) => onTag(e)}>
         <TagSelect type="text" value={newtag} onChange={onChangeTag}>
              <option value="" disabled hidden> Select a Tag </option>
              {tag_lists.map((tags, idx) => {
                    return (
                        <option key={idx} value={tags}>{tags}</option>
                        );
                     })}
          </TagSelect>
           <TagAddBtn type="submit" >태그 추가</TagAddBtn>
     </TagForm>
    ```
    

### 파이어 베이스 이미지 저장

- 파이어스토어에 이미지 저장
- 저장된 장소의 url을 받아서 활용
    
    ```jsx
    const uploadFB = async (e) => {
    
            const uploaded_file = await uploadBytes(
                ref(storage, `images/${e.target.files[0].name}`),
                e.target.files[0]
            );
    
            const file_url = await getDownloadURL(uploaded_file.ref);
    
            file_link_ref.current = { url: file_url };
            setImg(file_link_ref.current.url);
            console.log(file_link_ref.current.url);
        };
    
    ...
    <InputImg type="file" onChange={uploadFB} />
    ```
    

---

## 8-2. Back-end

### 코멘트 작성

- `ResponseEntity<?>` 을 이용해 확장성 확보.
- `@Builder` 패턴을 활용한 가시적 코드 작성.
    
    ```java
    @Transactional
        public ResponseEntity<?> postComment(@AuthenticationPrincipal UserDetailsImpl userDetails, CommentDto commentDto) {
            Post postFound = postRepository.findById(commentDto.getPostId()).orElseThrow(
                    () -> new IllegalArgumentException("코멘트를 작성할 수 없는 게시글입니다.")
            );
            List<Comment> commentList = postFound.getCommentList();
    
            Comment comment = Comment.builder()
                    .userId(userDetails.getUser())
                    .content(commentDto.getComment())
                    .postId(commentDto.getPostId())
                    .build();
    
            commentList.add(commentRepository.save(comment));
            postFound.setCommentList(commentList);
    
            postRepository.save(postFound);
            return new ResponseEntity<>("등록 완료", HttpStatus.OK);
        }
    ```
    

### **JwtExceptionFilter**

- **요청이 들어왔을 때 다음 필터로 전달.**
- `JwtAuthenticationFilter`에서 Exception 발생 시, *`@RestControllerAdvice`*로 처리 할 수 없기 때문에 `JwtAuthenticationFilter` 익셉션 처리 filter 구현.
- 만료 기간이 지난, Access 토큰이 들어왔을 때, Redis에서 로그아웃 처리 및, Access토큰 무효화 처리 .
- `OncePerRequestFilter` 를 상속받아, 서블릿 필터 구현
    
    ```java
    @Slf4j
    @RequiredArgsConstructor
    public class JwtExceptionFilter extends OncePerRequestFilter {
    
        private final ObjectMapper objectMapper;
        private final RedisTemplate<String, Object> redisTemplate;
        private final JwtTokenProvider jwtTokenProvider;
    
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            try {
                filterChain.doFilter(request, response);
            } catch (IllegalArgumentException e) {
                forceLogout(request, response);
    
            }
        }
    
        public void forceLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
            try {
                String token = jwtTokenProvider.resolveToken(request);
                if (token == null) {
                    throw new IllegalStateException("다시 로그인 해주세요");
                }
                String email = jwtTokenProvider.getUserPk(token);
                if (redisTemplate.opsForValue().get("RT:" + email) != null) {
                    // Refresh Token 삭제
                    redisTemplate.delete("RT:" + email);
                }
                //4. logout accessToken manage
                Long expiration = jwtTokenProvider.getExpiration(token);
                redisTemplate.opsForValue()
                        .set(token, "logout", expiration, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                setErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, response, e);
            }
    
        }
    
        public void setErrorMessage(HttpStatus status, HttpServletResponse response, Throwable e) throws IOException {
            response.setCharacterEncoding("UTF-8");
            response.setStatus(status.value());
            response.setContentType("application/json");
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            objectMapper.writeValue(response.getWriter(), errorResponse);
        }
    }
    ```
    

### **토큰 재발급 AOP**

- 만료 시간 5분 이내에 CRUD 동작 시 AccessToken, Refresh 토큰 재발급.
- 로그인 상태 연장.
- *`@Pointcut`* Security 패키지 외에, 기능 코드가 모여져 있는 web 패키지 하위 controller만 적용, Custom Annotation으로 제외
    
    ```java
    @Aspect
    @RequiredArgsConstructor
    public class ReIssueAop {
    
        private final UserService service;
        private final JwtTokenProvider jwtTokenProvider;
        private final HttpServletResponse response;
        private final HttpServletRequest request;
        @Pointcut("execution(public * com.tenzo.mini_project2.web.controller..*.*(..))&& !@target(com.tenzo.mini_project2.web.controller.PermitAll)")
        public void webPackagePointcut() {
        }
    
        @Around("webPackagePointcut()")
        public Object reIssueAdaptor(ProceedingJoinPoint joinPoint) throws Throwable {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
                service.reIssuance(userDetails, request, response);
                return joinPoint.proceed();
        }
    
    }
    ```
    
    ```java
    //조회 부분 토큰 재발급 Aop 제외 어노테이션
    @Target({ ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PermitAll {
    }
    ```
    

### **QueryDSL Projection을 사용해 해당 게시물 댓글 조회 후, DTO 로 변환해 전달**

- *`@QueryProjection`* 를 사용해서 QDTO 반영, 생성자 Projection 사용.
    
    ```java
    @Override
        public List<CommentsResponseDto> getComments(Long postId) {
            return jpaQueryFactory
                    .select(new QCommentsResponseDto(
                            comment.id,
                            comment.userId,
                            comment.content,
                            comment.createdAt)
                    )
                    .from(comment)
                    .leftJoin(comment.userId, user)
                    .where(comment.postId.eq(postId))
                    .orderBy(comment.createdAt.desc())
                    .fetch();
    ```
    
    ```java
    @Data
    @NoArgsConstructor
    public class CommentsResponseDto {
        private Long id;
        private String nickname;
        private String content;
        private String createdAt;
    
        @QueryProjection
        public CommentsResponseDto(
                Long id,
                User user,
                String content,
                LocalDateTime createdAt
        ) {
            this.id = id;
            this.nickname = user.getNickname();
            this.content = content;
            this.createdAt = createdAt.toString();
        }
    }
    ```
    

---

## 📐 9**. API**

## 로그인/회원가입

| 데이터 | 기능 | METHOD | URL | request | response | 비고 |
| --- | --- | --- | --- | --- | --- | --- |
| 회원정보 | 회원가입 | POST | /api/signup | {<br>email: test@test.com, <br> password: 1234, <br> nickname: 별명<br>} | {<br>‘ok’: true, <br>message: ‘회원가입 성공’ <br>} <br>OR <br>{<br>‘ok’: false,<br> message:’회원가입 실패’<br>} |  |
|  | 로그인 | POST | /api/login | {<br>email: test@test.com, <br>password: 1234<br>} | {<br>‘ok’: true, <br>message: ‘로그인 성공’<br>}<br>OR<br>{<br>‘ok’: false,<br> message:’로그인 실패’<br>} |  |

## 작성

| 데이터 | 기능 | METHOD | URL | request | response | 비고 |
| --- | --- | --- | --- | --- | --- | --- |
| 게시글 | 게시글 작성 | POST | /posts/upload | {<br>user_id: 아이디, <br>title: 제목, <br>contents: 내용, <br>image_url: url, <br>position: ex)top, <br>tag_list: {}<br>} | {<br>‘ok’: true, <br>message: ‘게시글 작성 완료’<br>}<br>OR<br>{<br>‘ok’: false, <br>message:’게시글 작성 실패’<br>} |  |
|  | 코멘트 | POST | /comment | {<br>user_id, <br>post_id, <br>comment<br>} | {<br>user_id, <br>post_id, <br>comment<br>} |  |

## 메인페이지

| 데이터 | 기능 | METHOD | URL | request | response | 비고 |
| --- | --- | --- | --- | --- | --- | --- |
| 게시물 | 게시물 조회 | GET | /index |  | {<br>post_list = Array, <br>tag_list, <br>user_id<br>} | 로그인, 비로그인 차이없음 |
|  | 게시물 상세 조회 |  |  | {<br>postId: 게시물 고유 아이디<br>} | {<br>comments:[]<br>} |  |
| 프론트에서 설정 | 태그로 검색 | GET | /tag | {<br>tag: 태그 이름<br>} |  |  |
| 프론트에서 설정 (시간되면) | 검색 | GET | /search | {<br>search: 검색어<br>} |  |  |

## Detail 수정

| 데이터 | 기능 | MTHD | URL | request | response | 비고 |
| --- | --- | --- | --- | --- | --- | --- |
| 게시글 | 게시글 조회 | GET | /selectMyPage/{user_id} |  | {<br>user_id:, <br>title: 제목, <br>contents: 내용, <br>image_url: url, <br>pos:ex)top<br>} |  |
|  | 게시물 업데이트 | PUT | /updateMyPage/{user_id} | {<br>post_id:1, <br>title: test, <br>contents,<br> position, <br>tags<br>} | {<br>user_id, <br>post_id, <br>title, <br>position, <br>tags<br>} |  |
|  | 게시물 삭제 | DELETE | /deleteMyPage/{user_id} |  |  |  |
| 댓글 | 댓글 삭제 | DELETE |  |  |  |  |

---

## 💏 **10조 한줄 회고**

> 미니 프로젝트를 진행 하면서, 프론트 분들과 의사소통을 하면서 협업을 할 때 기초 설계가 얼마나 중요한지 알았고, 프론트 부분에서 해결하시는 방법을 보면서, 프론트에서 어떠한 형식으로 진행되는 지를 느낀 시간이었습니다. QueryDSL 을 사용해 보면서, SQL 공부를 더 해야겠다고 느꼈습니다. 
그리고, Cors 오류를 겪으면서 Cors 정책에 대해 알 수 있는 시간이여서 감사합니다. 
고생 하신 10조 화이팅! 화이팅!! 사랑합니다! **- *이정찬***
> 

> 프론트와 백엔드와 함께 협업하는 한 주 였습니다. React 주특기를 공부하면서 firestore를 사용해서 백엔드가 굳이? 혼자서도 페이지를 만들 수 있을 것 같다는 생각을 하고 있었습니다만… 와 같이하니까 확실히 다르다는 것을 느꼈습니다. 데이터를 받아올 때, 훨씬 사용하기 쉬운 데이터로 가공해주셨고, 다양한 기능을 편하게 구현할 수 있게 되는 경험을 하게 되었습니다!!!  백엔드와의 소통의 중요성이 얼마나 좋은지, 소통이 왜 중요하다하는지 알게 되었습니다. 정말 화목하게 소통하면서 잘 마무리해준 10조 여러분 너무 감사합니다!!! 부족한 조장따라 힘든 일주일 버텨주셔서 감사해요! 남은 기간 화이팅!!!! - ***최성우***
> 

> 누군가의 뒷모습이 보이기 시작하는 것이 사랑 때문이라는 것이 아니라는 것을 배운 한 주였습니다. 지난 삼 주 동안 스프링을 공부하면서  “아 내가 왜 이렇게 어려운 스프링을 선택해서 이렇게 고생하는 것일까?”란 생각이 들었습니다. 자바와 스프링은 가시적이지 않을 뿐더러 MVC과 역할과 책임을 분할하는 수 많은 클래스를 만들어야하고, 보안은 섣불리 손을 대기 어려운 수준이었으니까요.
> 
> 
> 하지만 리액트와 같이 협업을 하고나니 알았습니다. 리액트가 스프링보다 훨씬 더 많은 시간과 노력을 쏟아야 프로젝트가 끝날 수 있다는 것을 말이에요. 스프링이 구조 설계하고 여유가 있을 때도 리액트에서는 머리를 쥐어짜고 코드를 짜고 있는걸 보니 그들의 등이 보이기 시작했습니다. 백엔드의 구조 설계는 끝이 있지만 심미적 요소가 감미된 프론트에서는 그 끝을 정해야 하니까요.
> 
> 한 주 동안 잠을 아껴가며 프로젝트를 마무리 해주셨던 모든 분들에게 감사 인사를 돌립니다. 항해99의 남은 기간 동안 스트레스 없이 원하시는 결과 얻으시길 기도하겠습니다. - ***이동재***
> 

> 미니프로젝트를 배우면서 느낀점은 협업이라는 개념은 결국 자신이 먼저 스스로가 작성하고 구성하는 부분에 대해 확신이 있어야 한다는 생각이 들었다. 내가 배우고 느끼고 구현은 하고 있지만 결국 다른 사람에 의해 작성된 코드였기에 이것을 스스로가 표현하는게 정말 어려웠고, 백앤드는 둘째 치고 우선 같은 프론트 팀원에게 조차 코드를 공유하고 작성하는 이유에 대해 왜 그랬는지 표현하는게 정말 어려웠다. 아무리 공부를 많이 해도 결국 스스로의 표현이 가장 중요하다는 느끼는 한주였고, 마무리 부분으로 사진이나 디자인도 나중에는 전문가가 협업을 해주겠지만, 결국 이를 컴포넌트 안에 표현하는 부분에 대해서도 어느정도 공부가 필요하다고 느끼는 한주였다. 우선 내가 혼자 공부한것 보다도 진자 몇배나 더 공부한 한주를 보냈는데, 이게 다 팀원들이 기량이 넓고 배울점이 많았기 때문일지 모르겠다. 이번한주에 정말 좋은 팀에 배정이 되어서 감사한 마음이 든다.  
팀원님들, 정말 고생하셨습니다. 남은 주 잘 보내시고 취업 건승하세요~~!! *- **한결***
>
