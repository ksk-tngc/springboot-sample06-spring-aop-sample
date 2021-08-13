## 概要

Spring AOP のサンプルです。

使用したアドバイス：
* `@Before`, `@After`, `@AfterReturning`, `@Around`

## 画面

<img width="1200" src="https://user-images.githubusercontent.com/59589496/129371002-e054e0b7-c044-415e-b931-e858fb259138.png">  

## コンソール

<img width="1200" src="https://user-images.githubusercontent.com/59589496/129372282-80cf7ec2-af69-43d4-90d9-ab6eec132ea7.png">  

<small>トップページにアクセスすると、アドバイス（AOP のタイミング）と、ポイントカット（AOP で割り込まれるメソッド）の情報がログ出力されます。</small>

## フォルダ構成

<img width="300" src="https://user-images.githubusercontent.com/59589496/128973054-c838e43a-1d04-450a-aee9-8c146a032fd7.png">  

## 依存関係

* Spring Boot DevTools
* Thymeleaf
* Spring Web
* Spring Data JPA
* Lombok
* WebJars
  - Bootstrap
  - Bootstrap Icons
