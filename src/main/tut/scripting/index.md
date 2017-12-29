---
title:  How does that work?
layout: page
---

## HMT libraries

We'll use a library modelling the relationships of text, image and physical surfaces.  This `import` line makes it available in the console.

```tut:silent
import edu.holycross.shot.dse._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.citerelation._
import edu.holycross.shot.citeobj._
```


## Loading data from CEX files


```tut
val f = "data/hmt-sample.cex"
val objectRepo = CiteRepositorySource.fromFile(f)
```

## Manipulating data
