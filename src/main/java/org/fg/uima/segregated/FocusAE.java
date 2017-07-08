package org.fg.uima.segregated;

import cz.brmlab.yodaqa.model.Question.*;
import cz.brmlab.yodaqa.provider.OpenNlpNamedEntities;

import org.fg.uima.segregated.engine.*;
//import org.npc.solrparser.pagehandler.SolrCollectionReader;
import org.fg.uima.annotator.WikiKeywordAnnotator;

import de.tudarmstadt.ukp.dkpro.core.languagetool.LanguageToolLemmatizer;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AggregateBuilder;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.ResourceInitializationException;
//import org.apache.uima.fit.examples.experiment.pos.LineReader;
import org.fg.uima.segregated.engine.*;
import cz.brmlab.yodaqa.provider.OpenNlpNamedEntities;

import static org.apache.uima.fit.util.JCasUtil.select;

import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import org.fg.uima.annotator.WikiKeywordAnnotator;
import org.fg.uima.segregated.engine.FocusGenerator;

public class FocusAE{
	public static void main(String[] args) throws ResourceInitializationException, UIMAException, IOException {
		AggregateBuilder builder = new AggregateBuilder();
		//String samplePosFileName;
	  //  if (new File("src/main/resources").exists()) {
	  //      samplePosFileName = "src/main/resources/org/fg/uima/text/Sampletext.txt";
	    //} 
		
		CollectionReaderDescription newReader = createReaderDescription(TextReader.class,TextReader.PARAM_SOURCE_LOCATION,"src/main/resources",TextReader.PARAM_PATTERNS,"Sampletext.txt",TextReader.PARAM_LANGUAGE,"en");
	    // The lineReader simply copies the lines from the input file into the
	    // default view - one line per CAS
	    //CollectionReader  reader= CollectionReaderFactory.createReader(LineReader.class,samplePosFileName);
	//	CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
		//		);
		builder.add(AnalysisEngineFactory.createEngineDescription(OpenNlpSegmenter.class, 
																		OpenNlpSegmenter.PARAM_LANGUAGE, "en"));
		builder.add(AnalysisEngineFactory.createEngineDescription(StanfordParser.class, 
																		StanfordParser.PARAM_WRITE_POS, true, 
																		StanfordParser.PARAM_LANGUAGE, "en"));


		builder.add(AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class));
		builder.add(AnalysisEngineFactory.createEngineDescription(LanguageToolLemmatizer.class));
		builder.add(OpenNlpNamedEntities.createEngineDescription());
		builder.add(AnalysisEngineFactory.createEngineDescription(FocusGenerator.class));
		builder.add(AnalysisEngineFactory.createEngineDescription(WikiKeywordAnnotator.class));
		SimplePipeline.runPipeline(newReader, builder.createAggregateDescription());
	
		//WikiKeywordAnnotator wka = new WikiKeywordAnnotator();

	}
}
