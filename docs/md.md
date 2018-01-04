---
layout: page
title: Using markdown to display data
---


## what is markdown

- plain text format
- simple to write, just like an email
- simple, clean, no fancy styling

## how are we using it
- documentation
- displaying data we generate from scripts

## Some things you'll need to play with markdown ##
- clone our [repository](https://github.com/StephanieML/HMT-SCS-2018)
- [Scala](https://www.scala-lang.org/download/)
- [SBT console](http://www.scala-sbt.org/download.html)
- [Atom](https://atom.io) (our favorite free editor for markdown and more that has a convenient markdown preview option)

## where you can find the scripts


This repository includes a `scripts` directory with some scripts you can load run from the sbt console.  To do that, start the console:

    sbt console

Then, at the console prompt, use the sbt `:load` utility to load a  script.  (Note the preceding colon!)  Example:

    :load scripts/SCRIPT.sc


## To learn more

The scripts are just plain text files written in Scala.  If you want to learn more about how they work, see this brief [guide to the included scripts](../scripting)
