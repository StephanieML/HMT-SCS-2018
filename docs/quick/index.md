---
layout: page
title: Quick start
---


Import the package:

```scala
import edu.holycross.shot.cex._
```

```scala
scala> val x = 1 + 1
x: Int = 2
```

Parse CEX from a `String`:

```scala
scala> val str = "#!cexversion\n3.0\n\n"
str: String =
"#!cexversion
3.0

"

scala> val cex = CexParser(str)
cex: edu.holycross.shot.cex.CexParser =
CexParser(#!cexversion
3.0

)
```
