package com.example.springaop1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring AOP のサンプルクラス。
 */
@Slf4j
@Aspect // このクラスがアスペクトであることを宣言
@Component // DIコンテナに登録
public class LoggingAspect {

    /**
     * 開始ログ出力。
     * 
     * <p>以下の場所・タイミングに割り込まれるメソッドです。
     * <ul>
     * <li>場所（ポイントカット）：{@code HomeController#index()}
     * <li>タイミング（アドバイス）：ポイントカット実行前
     * </ul>
     * 
     * @param jp ポイントカット式で指定したメソッドを表すジョインポイント
     */
    @Before("execution(String com.example.springaop1.controller.HomeController.index(..))")
    public void startLog(JoinPoint jp) {
        log.info("アドバイス = @Before（ポイントカット実行前）, ポイントカット = {}", jp.getSignature());
    }

    /**
     * 終了ログ出力。
     * 
     * <p>以下の場所・タイミングに割り込まれるメソッドです。
     * <ul>
     * <li>場所（ポイントカット）：{@code HomeController} クラスの全てのメソッド
     * <li>タイミング（アドバイス）：ポイントカット実行後
     * </ul>
     * 
     * @param jp ポイントカット式で指定したメソッドを表すジョインポイント
     */
    @After("execution(* com.example.springaop1.controller.HomeController.*(..))")
    public void endLog(JoinPoint jp) {
        log.info("アドバイス = @After（ポイントカット実行後）, ポイントカット = {}", jp.getSignature());
    }

    /**
     * 正常終了ログ出力。
     *
     * <p>以下の場所・タイミングに割り込まれるメソッドです。
     * <ul>
     * <li>場所（ポイントカット）：自パッケージ内の、末尾に Controller の付くクラスの全てのメソッド
     * <li>タイミング（アドバイス）：ポイントカット正常終了後
     * </ul>
     *
     * @param jp ポイントカット式で指定したメソッドを表すジョインポイント
     * @param result ポイントカット式で指定したメソッドの戻り値
     */
    @AfterReturning(pointcut = "within(com.example.springaop1.controller.*Controller)", returning = "result")
    public void afterReturningEndLog(JoinPoint jp, Object result) {
        log.info("アドバイス = @AfterReturning（ポイントカット正常終了後）, ポイントカット = {}, 戻り値 = {}", jp.getSignature(), result);
    }

    /**
     * 開始・終了ログ出力。
     * 
     * <p>以下の場所・タイミングに割り込まれるメソッドです。
     * <ul>
     * <li>場所（ポイントカット）：自パッケージ内の全てのクラスの全てのメソッド
     * <li>タイミング（アドバイス）：ポイントカット実行前後
     * </ul>
     * 
     * @param pjp ポイントカット式で指定したメソッドを表す実行可能なジョインポイント
     * @return ポイントカット式で指定したメソッドの戻り値
     * @throws Throwable ポイントカット式で指定したメソッドで発生した例外
     */
    @Around("execution(* com.example.springaop1..*(..))")
    public Object startAndEndLog(ProceedingJoinPoint pjp) throws Throwable {
        log.info("アドバイス = @Around（ポイントカット実行前）, ポイントカット = {}", pjp.getSignature());
        Object result = pjp.proceed(); // ポイントカット式のメソッドを実行
        log.info("アドバイス = @Around（ポイントカットド実行後）, ポイントカット = {}", pjp.getSignature());
        return result;
    }

}
