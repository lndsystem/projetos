package com.metasolucoes.prodkit.inspire.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.metasolucoes.prodkit.inspire.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.metasolucoes.prodkit.inspire.thymeleaf.processor.MessageElementTagProcessor;

public class MetaDialect extends AbstractProcessorDialect {

	public MetaDialect() {
		super("MetaSolucoes", "meta", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}
}
