---
layout: page
title: Citation
---

## Using the HMT data in the CITE environment #

### How to use URNs for citable data ##

-   [Cite Environment](http://cite-architecture.github.io/about/):
    -   the [OHCO2 model](http://cite-architecture.github.io/ohco2/) and [CTS URNs](http://cite-architecture.github.io/ctsurn/)
    -   the [CITE2 model](http://cite-architecture.github.io/cite2/) of data collections, and [CITE2 URNS](http://cite-architecture.github.io/cite2urn/)

### What do our text URNs Mean...##
             
1. `urn:cts` :text urn
2. `urn:cts:greekLit` :text urn for Greek literature
3. `urn:cts:greekLit:tlg0012` :text urn for Homeric poetry
4. `urn:cts:greekLit:tlg0012.tlg001` :text urn for the *Iliad*
5. `urn:cts:greekLit:tlg0012.tlg001.msA` :text urn for the Venetus A version of the *Iliad*
6. `urn:cts:greekLit:tlg0012.tlg001.msA:1.1` :text urn for Book 1 line 1 of the Venetus A *Iliad*

*note you will also see tlg5026 to refer to the Homeric scholia today*

**URNs let you refer to notional works as well as specific versions**

### URNs for Objects

We also use URNs for citable objects and images, completing our text,image,artifact triangle

e.g. urn:cite2:hmt:msA.12r (folio 12r of the Venetus as a notional object, can be linked to multiple images and contains multiple texts)

### What can you do with our data?

Because all these relationships are defined in our data, you can input text and object urns and get associated items (e.g. all the scholia that are on 12r or the image where line 1.1 appears)

### Let's Explore in Our Cite Environment

[Cite Environment](
http://folio.furman.edu/cite-1.3.4.html)

1. **Browse text** will let you explore content we have preloaded into the tool for you (Book 1 of the Venetus, Iliad and Scholia)
2. **Explore texts** has some fun tools to help you further explore the corpus (we recommend avoiding breathings and accents in string search because unicode can be problematic)
