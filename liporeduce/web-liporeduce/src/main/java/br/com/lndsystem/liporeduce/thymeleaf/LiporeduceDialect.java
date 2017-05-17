package br.com.lndsystem.liporeduce.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.lndsystem.liporeduce.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.com.lndsystem.liporeduce.thymeleaf.processor.MessageElementTagProcessor;

public class LiporeduceDialect extends AbstractProcessorDialect {

	public LiporeduceDialect() {
		super("LNDSystem Liporeduce", "lipo", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processors = new HashSet<>();

		processors.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processors.add(new MessageElementTagProcessor(dialectPrefix));

		return processors;
	}
}
