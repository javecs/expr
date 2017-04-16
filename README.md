# expr　

[![Build Status](https://travis-ci.org/javecs/expr.svg?branch=master)](https://travis-ci.org/javecs/expr) 
[![codecov](https://codecov.io/gh/javecs/expr/branch/master/graph/badge.svg)](https://codecov.io/gh/javecs/expr) 
[![Download](https://api.bintray.com/packages/javecs/tools/expr/images/download.svg) ](https://bintray.com/javecs/tools/expr/_latestVersion)
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/javecs/expr/blob/master/LICENSE)

数式を計算します。

## 使い方

- gradle
    ```
    repositories {
        maven {
            url  "http://dl.bintray.com/javecs/tools"
        }
    }

    dependencies {
        compile 'xyz.javecs.tools:expr:0.1.+'
    }
    ```

- `eval()`: 簡単に１つの数式を計算します。
    ```
    val value = eval("3 + 4")
    ```
    
- `Calculator`: 変数、関数など、複数の数式を計算します。
    - 0.1.+ 以上で使えます。
    - クラスを作るときに、数式を渡すことができます。

    ```
    val expr = arrayOf("x = 3 + 4", "y = 30 + 40", "x + y")
    val value = Calculator(expr).eval().value
    println(value)
    ```

    - あるいは、後から数式を１つずつ計算することも可能です。

    ```
    val calc = Calculator()
            .eval("x = 3 + 4")
            .eval("y = 30 + 40")
            .eval("x + y")
    println(calc.value)
    ```

    - 結果は、同じです。

    ```
    77
    ```

## サンプルアプリ

- 電卓です。
    - https://github.com/javecs/calc
    
- LINE Messaging APIと連携したBotです。
    - https://github.com/javecs/calc-bot
    
## 使うもの

- [ANTLR 4.7](http://www.antlr.org/)
- [Kotlin 1.1](https://kotlinlang.org/)
