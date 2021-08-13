## 概要

Spring AOP のサンプルです。

使用したアドバイスの種類：
* `@Before`, `@After`, `@AfterReturning`, `@Around`

## 画面

<img width="690" src="https://user-images.githubusercontent.com/59589496/129371002-e054e0b7-c044-415e-b931-e858fb259138.png">  

## コンソール

<small>トップページにアクセスすると、アドバイス（AOP されるタイミング）とポイントカット（AOP で割り込まれる対象メソッド）の情報がログ出力されます。</small>  

<img width="1200" src="https://user-images.githubusercontent.com/59589496/129372282-80cf7ec2-af69-43d4-90d9-ab6eec132ea7.png">  

## フォルダ構成

<img width="300" src="https://user-images.githubusercontent.com/59589496/129373070-1de21721-e6ad-4fc8-9f21-f54cf3950426.png">  

## 依存関係

* Spring Boot DevTools
* Thymeleaf
* Spring Web
* Spring Data JPA
* Lombok
* WebJars
  - Bootstrap
  - Bootstrap Icons
