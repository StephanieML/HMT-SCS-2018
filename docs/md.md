---
layout: page
title: Using markdown to display data
---


## What is markdown

- plain text format
- just like writing an email
- simple, clean, no fancy styling

## How are we using it
- documentation
- displaying data we generate from scripts

## Some things you'll need to play with markdown ##
- clone our [repository](https://github.com/StephanieML/HMT-SCS-2018)
- [Scala](https://www.scala-lang.org/download/)
- [SBT console](http://www.scala-sbt.org/download.html)
- [Atom](https://atom.io) (our favorite free editor for markdown and more that has a convenient markdown preview option)

## Where you can find the scripts


This repository includes a `scripts` directory with some scripts you can load run from the sbt console.  

### Loading and running scripts

The root directory of this repository has a build file that resolves HMT project code libraries with their dependencies, so from the root directory of the repository, you can:

1.  Start an interactive console:  `sbt console`
2.  From the console, load a script, e.g., `:load scripts/scholia.sc` (note the colon preceding the `load` command!)


### Examples of using included scripts

**Display scholia for an *Iliad* line**:  from the sbt console,

    :load scripts/scholia.sc
    scholia("urn:cts:greekLit:tlg0012.tlg001:1.1")

**Create a facsimile for a codex**:  from the sbt console,

    :load scripts/facsimile.sc
    facsimile("urn:cite2:hmt:msA:")
    facsimile("urn:cite2:hmt:msA:", 4) // formats display in 4 columns

**To load the preview, open the markdown file in Atom and then toggle Mardown Preview from the packages menu**

## To learn more

The scripts are just plain text files written in Scala.  If you want to learn more about how they work, see this brief [guide to the included scripts](../scripting)
