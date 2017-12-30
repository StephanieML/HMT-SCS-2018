# HMT-SCS-2018


Homer Multitext project Digital Maker Spaces Website for SCS 2018

[https://stephanieml.github.io/HMT-SCS-2018/](https://stephanieml.github.io/HMT-SCS-2018/)


## Data and scripts

### Data sets

Data sets are in CEX format in the `data` directory.  See the README there for details.


### Scripts: prerequisites

-   Version 2.11 or higher of the [Scala language](https://www.scala-lang.org/)
-   The simple build tool [sbt](https://www.scala-sbt.org/)


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

**Identify all scholia on a page**:  from the sbt console,

TBA

## For repository managers

Information about how to build the workshop web site is in the [project wiki](https://github.com/StephanieML/HMT-SCS-2018/wiki).
