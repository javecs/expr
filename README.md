# expr　

[![Build Status](https://travis-ci.org/javecs/expr.svg?branch=master)](https://travis-ci.org/javecs/expr) 
[![codecov](https://codecov.io/gh/javecs/expr/branch/master/graph/badge.svg)](https://codecov.io/gh/javecs/expr) 
[![Download](https://api.bintray.com/packages/javecs/tools/expr/images/download.svg) ](https://bintray.com/javecs/tools/expr/_latestVersion)
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/javecs/expr/blob/master/LICENSE)

数式を計算します。

## 使い方

### Gradle
- 依存関係を設定してください。
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

### eval()
- 簡単に１つの数式を計算します。

    ```
    val value = eval("3 + 4")
    println(value)

    結果は、 7　です。
    ```

### Calculator
- 変数、関数など、複数の数式を計算します。
- 0.1.+ 以上で使えます。
- クラスを作るときに、数式を渡すことができます。

    ```
    val expr = arrayOf("x = 3 + 4", "y = 30 + 40", "x + y")
    val value = Calculator(expr).eval().value
    println(value)

    結果は、 77　です。
    ```

- あるいは、後から数式を１つずつ計算することも可能です。

    ```
    val calc = Calculator()
            .eval("x = 3 + 4")
            .eval("y = 30 + 40")
            .eval("x + y")
    println(calc.value)

    結果は、 77　です。
    ```
    
- 変数と計算結果を初期化するときには、Calculatorの`clear()`を実行してください。

## 計算可能な数式

### 演算

演算 | 説明 | 例 | 結果 
--------| --------|--------|--------
  * | 掛け算 | 3 * 4 | 12
  / | 割り算 | 3 / 4 | 0.75
  % | 余り | 7 % 4 | 3
  ^ | 累乗 | 2 ^ 8 | 256
  + | 足し算 | 3 + 4 | 7
  - | 引き算 | 3 - 4 | -1

- 演算の優先順位は、上記の表の上から下の順になります。括弧`( )`を使えば、括弧内を先に計算します。

    ```
    (3 + 4) * 5 

    この結果は、 35 になります。
    ```

### 変数

- 計算した結果を変数に代入することができます。
- 変数名は、英小文字から始まる１文字以上の文字列です。２文字目からは、英数字が使えます。
- 計算結果が代入された変数同士での演算も可能です。

    ```
    x = 3 + 4

    x には、7 が代入されます。
    ```

    ```
    x = 3
    y = 4
    z = x + y

    z には、7 が代入されます。
    ```

### 関数

演算 | 説明 | 例 | 結果 
--------| --------|--------|--------
  sin | サイン。三角関数の正弦。 | sin(1) | 0.8414709848078965
  cos | コサイン。三角関数の余弦。 | cos(1) | 0.5403023058681398
  tan | タンジェント。三角関数の正接。 | tan(1) | 1.5574077246549023
  

## Javaからの呼び出し方

- eval()は、スタティクメッソードで呼びます。

    ```
    Number value = Evaluator.eval("3 + 4");
    ```

- Calculatorは、通常のクラスとして使えます。

    ```
    Calculator calc = new Calculator();
    calc.eval("3 + 4");
    Number value = calc.getValue();
    ```


## サンプルアプリ

- 電卓です。
    - https://github.com/javecs/calc
    
- LINE Messaging APIと連携したBotです。
    - https://github.com/javecs/calc-bot
    
## 使うもの

- [ANTLR 4.7](http://www.antlr.org/)
- [Kotlin 1.1](https://kotlinlang.org/)
