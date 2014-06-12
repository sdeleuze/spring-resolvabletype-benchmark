package com.github.trask;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class AutowireBenchmark {

	private final XmlWebApplicationContext applicationContext;
	private final ConfigurableListableBeanFactory beanFactory;
    private final LotsOfSetters lotsOfSetters;
    private final LotsOfSettersAppContextAware lotsOfSettersAppContextAware;

	public AutowireBenchmark() {
		applicationContext = new XmlWebApplicationContext();
		applicationContext.setServletContext(new MockServletContext());
		applicationContext.refresh();
		beanFactory = applicationContext.getBeanFactory();
		lotsOfSetters = new LotsOfSetters();
		lotsOfSettersAppContextAware = new LotsOfSettersAppContextAware();
	}
	
    @Benchmark
    public void autowireBean() {
        beanFactory.autowireBean(lotsOfSetters);
    }
    
    @Benchmark
    public void autowireBeanAppContextAware() {
        beanFactory.autowireBean(lotsOfSettersAppContextAware);
    }
}
