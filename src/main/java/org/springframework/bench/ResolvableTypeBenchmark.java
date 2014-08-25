package org.springframework.bench;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.bench.domain.LotOfProperties;
import org.springframework.bench.domain.LotOfProperties10;
import org.springframework.bench.domain.LotOfProperties11;
import org.springframework.bench.domain.LotOfProperties12;
import org.springframework.bench.domain.LotOfProperties13;
import org.springframework.bench.domain.LotOfProperties14;
import org.springframework.bench.domain.LotOfProperties15;
import org.springframework.bench.domain.LotOfProperties16;
import org.springframework.bench.domain.LotOfProperties17;
import org.springframework.bench.domain.LotOfProperties18;
import org.springframework.bench.domain.LotOfProperties19;
import org.springframework.bench.domain.LotOfProperties2;
import org.springframework.bench.domain.LotOfProperties20;
import org.springframework.bench.domain.LotOfProperties3;
import org.springframework.bench.domain.LotOfProperties4;
import org.springframework.bench.domain.LotOfProperties5;
import org.springframework.bench.domain.LotOfProperties6;
import org.springframework.bench.domain.LotOfProperties7;
import org.springframework.bench.domain.LotOfProperties8;
import org.springframework.bench.domain.LotOfProperties9;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.flex.core.io.SpringPropertyProxy;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class ResolvableTypeBenchmark {

	private final XmlWebApplicationContext applicationContext;
	private final SpringPropertyProxy lotProxy;


	public ResolvableTypeBenchmark() {
		applicationContext = new XmlWebApplicationContext();
		applicationContext.setServletContext(new MockServletContext());
		applicationContext.refresh();

		lotProxy = SpringPropertyProxy.proxyFor(LotOfProperties.class, false, new GenericConversionService());

		// Additional registration of proxies seems to slow down only Spring 3.2 and 4.x based implementation
		SpringPropertyProxy.proxyFor(LotOfProperties2.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties3.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties4.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties5.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties6.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties7.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties8.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties9.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties10.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties11.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties12.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties13.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties14.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties15.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties16.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties17.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties18.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties19.class, false, new GenericConversionService());
		SpringPropertyProxy.proxyFor(LotOfProperties20.class, false, new GenericConversionService());
	}

	@Benchmark
	@Test
	public void resolvableTypeCache() {

		LotOfProperties lot = new LotOfProperties();
		lotProxy.setDefaultInstance(lot);
		for(Integer i=1 ; i < 100; i++) {
			lotProxy.getValue("field" + i.toString());
		}

	}

}
