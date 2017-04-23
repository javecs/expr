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
        compile 'xyz.javecs.tools:expr:0.2.+'
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

### Function
- ユーザー定義関数をプラグインとして実行できます。
- 0.2.+ 以上で使えます。
- `Function`を作成して、`plugin`で登録してください。

    ```
    val value = Calculator()
            .plugin(Function("f(x)", arrayOf("x + 1")))
            .plugin(Function("g(x,y)", arrayOf("f(x) * y")))
            .eval("x = 3")
            .eval("y = 4")
            .eval("g(x,y)")
            .value
    println(value)
    
    結果は、 16 です。
    ```

## 計算可能な数式

### 演算子

演算子 | 説明 | 例 | 結果 
--------| --------|--------|--------
  ^ | 累乗 | 2 ^ 3 ^ 2| 512 (`2^(3^2)`と処理されます）
  +（符号）| 正数 | +1 | 1
  -（符号）| 負数 | -1 | -1
  * | 掛け算 | 3 * 4 | 12
  / | 割り算 | 3 / 4 | 0.75
  % | 余り | 7 % 4 | 3
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

### 常数

常数名 | 説明 | 例 | 結果 
--------| --------|--------|--------
 [e](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#E) | 自然対数の底eにもっとも近いdouble値です。| e | 2.7182818284590452354
 [pi](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#PI) | 円周とその直径の比piにもっとも近いdouble値です。| pi | 3.14159265358979323846
  
- 常数名の文字は、大文字と小文字を区別しません。

### 関数

関数名 | 説明 | 例 | 結果 
--------| --------|--------|--------
 [sin](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#sin-double-) | 指定された角度の正弦(サイン)を返します。| sin(1) | 0.8414709848078965
 [cos](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#cos-double-) | 指定された角度の余弦(コサイン)を返します。| cos(1) | 0.5403023058681398
 [tan](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#tan-double-) | 指定された角度の正接(タンジェント)を返します。| tan(1) | 1.5574077246549023
 [asin](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#asin-double-) | 指定された値の逆正弦(アーク・サイン)を返します。| asin(1) | 1.5707963267948966
 [acos](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#acos-double-) | 指定された値の逆余弦(アーク・コサイン)を返します。| acos(0) | 1.5707963267948966
 [atan](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#atan-double-) | 指定された値の逆正接(アーク・タンジェント)を返します。| atan(1) | 0.7853981633974483
 [atan2](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#atan2-double-double-) | 直交座標(x, y)から極座標(r, theta)への変換から得られる角度thetaを返します。| atan2(90, 15) | 1.4056476493802699
 [sinh](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#sinh-double-) | double値の双曲線正弦を返します。| sinh(1) | 1.1752011936438014
 [cosh](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#cosh-double-) | double値の双曲線余弦を返します。| cosh(1) | 1.543080634815244
 [tanh](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#tanh-double-) | double値の双曲線正接を返します。| tanh(1) | 0.7615941559557649
 [exp](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#exp-double-) | オイラー数eをdouble値で累乗した値を返します。| exp(1) | 2.718281828459045
 [log](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#log-double-) | 指定されたdouble値の自然対数(底はe)を返します。| log(2) | 0.6931471805599453
 [log10](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#log10-double-) | double値の10を底とする対数を返します。| log10(2) | 0.3010299956639812
 [sqrt](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#sqrt-double-) | double値の正しく丸めた正の平方根を返します。| sqrt(2) | 0.3010299956639812
 [hypot](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#hypot-double-double-) | sqrt(x2 +y2)を返します(途中でオーバーフローやアンダーフローは発生しない)。| hypot(3, 4) | 5
 [rad](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#toRadians-double-) | 度で計測した角度を、相当するラジアンに変換します。| rad(1) | 0.017453292519943295
 [deg](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#toDegrees-double-) | ラジアンで計測した角度を、相当する度に変換します。| deg(1) | 57.29577951308232
 [max](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#max-double-double-) | 2つのdouble値のうち大きいほうを返します。| max(e, pi) | 3.141592653589793
 [min](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html#min-double-double-) | 2つのdouble値のうち小さいほうを返します。| min(e, pi) | 2.718281828459045
  
- 関数名の文字は、大文字と小文字を区別しません。


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


## 使われているところ...

- 電卓です。
    - https://github.com/javecs/calc
    
- テキストを数式に変換し、計算するライブラリです。
    - https://github.com/javecs/text2expr
    
## 使うもの

- [ANTLR 4.7](http://www.antlr.org/)
- [Kotlin 1.1](https://kotlinlang.org/)
