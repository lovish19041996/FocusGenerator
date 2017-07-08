package org.fg.uima.annotator;

import static org.apache.uima.fit.util.JCasUtil.select;

import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.constituent.ROOT;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.POS;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;

import cz.brmlab.yodaqa.model.Question.Focus;
import org.fg.uima.annotator.WikiKeywordAnnotator;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADV;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.constituent.Constituent;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.constituent.ROOT;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.ADVMOD;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.DEP;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.DET;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.DOBJ;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.NSUBJ;


public class WikiKeywordAnnotator extends JCasAnnotator_ImplBase {

	public  void process(JCas aJCas) throws AnalysisEngineProcessException {
	System.out.println("\n\n");
    String docText = aJCas.getDocumentText();
    System.out.println("Annotator Text : "+docText);
    System.out.println("\n\n");
    System.out.println("ROOT are: ");
    for (ROOT sentence : JCasUtil.select(aJCas, ROOT.class)) {
    	System.out.print(sentence.getCoveredText()+"\n");
	}
    System.out.println("\n\n");
    
    System.out.println("Focus are: ");
    for (Focus focus : select(aJCas, Focus.class)) {
	      System.out.print(focus.getCoveredText()+"\n");
    }
    System.out.println("\n\n");
    
    System.out.println("DET are: ");
    
    for (DET det : select(aJCas, DET.class)) {
	      System.out.print(det.getCoveredText()+"\n");
    }
    System.out.println("\n\n");
    
    
    System.out.println("ADVMOD are: ");
    for (ADVMOD advmod : JCasUtil.select(aJCas, ADVMOD.class)) {
    	System.out.print(advmod.getCoveredText()+"\n");
	}
    System.out.println("\n\n");
    
    System.out.println("DEP are: ");
    for (DEP dep : JCasUtil.select(aJCas, DEP.class)) {
    	System.out.print(dep.getCoveredText()+"\n");
	}
    System.out.println("\n\n");
    
    System.out.println("DOBJ are: ");
    for (DOBJ dobj : JCasUtil.select(aJCas, DOBJ.class)) {
    	System.out.print(dobj.getCoveredText()+"\n");
	}
    System.out.println("\n\n");
    
    System.out.println("NSUBJ are: ");
    for (NSUBJ nsubj : JCasUtil.select(aJCas, NSUBJ.class)) {
    	System.out.print(nsubj.getCoveredText()+"\n");
	}
    System.out.println("\n\n");



  }
}