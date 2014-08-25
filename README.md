Spring ResolvableType Benchmark
===============================

Benchmark (using the excellent [JMH](http://openjdk.java.net/projects/code-tools/jmh/) harness) showing ResolvableType performance issue between Spring 3.1.x and later versions based on the same Spring Flex SpringPropertyProxy usage.

Go to [FLEX-234](https://jira.spring.io/browse/FLEX-234) for more details ...

#### Spring 3.1.4 and Spring Flex 1.5.2
```
Benchmark                                             Mode   Samples        Score  Score error    Units
o.s.b.ResolvableTypeBenchmark.resolvableTypeCache     avgt         5     1476,165       91,530    us/op
```

#### Spring 4.1.0.BUILD-SNAPSHOT and Spring Flex 1.6.0-BUILD-SNAPSHOT
```
Benchmark                                             Mode   Samples        Score  Score error    Units
o.s.b.ResolvableTypeBenchmark.resolvableTypeCache     avgt         5    47520,626     6376,711    us/op
```
