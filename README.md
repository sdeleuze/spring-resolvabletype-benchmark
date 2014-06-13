Spring Autowire Benchmark
=========================

Benchmark (using the excellent [JMH](http://openjdk.java.net/projects/code-tools/jmh/) harness) showing autowire performance regression between Spring 3.1.4 and 3.2.0:

#### Spring 3.1.4
```
Benchmark                                               Mode   Samples        Score  Score error    Units
c.g.t.AutowireBenchmark.autowireBean                    avgt         5        1.750        0.037    us/op
c.g.t.AutowireBenchmark.autowireBeanAppContextAware     avgt         5        1.712        0.085    us/op
```

#### Spring 3.2.0
```
Benchmark                                               Mode   Samples        Score  Score error    Units
c.g.t.AutowireBenchmark.autowireBean                    avgt         5       45.817        2.787    us/op
c.g.t.AutowireBenchmark.autowireBeanAppContextAware     avgt         5      394.698       12.102    us/op
```

#### Spring 4.0.5
```
Benchmark                                               Mode   Samples        Score  Score error    Units
c.g.t.AutowireBenchmark.autowireBean                    avgt         5       41.374        1.034    us/op
c.g.t.AutowireBenchmark.autowireBeanAppContextAware     avgt         5      425.888       16.470    us/op
```
