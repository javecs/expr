# expr　[![Build Status](https://travis-ci.org/javecs/expr.svg?branch=master)](https://travis-ci.org/javecs/expr) [![codecov](https://codecov.io/gh/javecs/expr/branch/master/graph/badge.svg)](https://codecov.io/gh/javecs/expr) [![Download](https://api.bintray.com/packages/javecs/tools/expr/images/download.svg) ](https://bintray.com/javecs/tools/expr/_latestVersion)


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
	compile 'xyz.javecs.tools:expr:0.0.11'
}
```

- kotlin
```
val value = eval("3 + 4")
```

## サンプルアプリ
- このライブラリを使った電卓です。
    - https://github.com/javecs/calc
  
## 使うもの

- [ANTLR 4.7](http://www.antlr.org/)
- [Kotlin 1.1](https://kotlinlang.org/)
